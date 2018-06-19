package com.happycode.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.happycode.domain.Customer;
import com.happycode.domain.PageBean;
import com.happycode.utils.TxQueryRunner;

public class CustomerDao {
	private TxQueryRunner txqr = new TxQueryRunner();
	
	/*
	 * 添加用户
	 */
	public void add(Customer user) {
		String sql = "insert into t_customer values(?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {user.getCid(), user.getCname(), user.getGender(), user.getBirthday(),
						user.getCellphone(), user.getEmail(), user.getDescription()};
		try {
			txqr.update(sql,params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 查询所有
	 */
	public PageBean<Customer> findAll(int pc, int ps) {
		/*
		 * 组装一个pageBean
		 */
		PageBean<Customer> pageBean = new PageBean<Customer>();
		pageBean.setPc(pc);
		pageBean.setPs(ps);
		
		String sql1 = "select count(*) from t_customer";
		try {
			Number tr = txqr.query(sql1, new ScalarHandler<Number>());
			pageBean.setTr(tr.intValue());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		String sql2 = "select * from t_customer order by cname limit ?, ?";
		try {
			List<Customer> list = txqr.query(sql2,
					new BeanListHandler<Customer>(Customer.class),
					(pc-1)*ps, ps);
			pageBean.setBeanList(list);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return pageBean;
	}

	/*
	 * 编辑用户
	 * 通过cid
	 */
	public int edit(Customer user) {
		String sql = "update t_customer set cname = ?, gender = ?, birthday = ?, "
				+ "cellphone = ?, email = ?, description = ? where cid = ?";
		Object[] params = {user.getCname(), user.getGender(), user.getBirthday(),
				user.getCellphone(), user.getEmail(), user.getDescription(), user.getCid()};
		try {
			return txqr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 保存用户
	 */
	public Customer findByCid(String cid) {
		String sql = "select * from t_customer where cid = ?";
		Object param = cid;
		try {
			return txqr.query(sql, new BeanHandler<Customer>(Customer.class), param);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * 删除用户
	 * 通过cid
	 */
	public void deleteByCid(String cid) {
		String sql = "delete from t_customer where cid = ?";
		try {
			txqr.update(sql, cid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 多条件查询
	 * 1.创建pageBean
	 * 2.填充pc,ps
	 * 3.根据条件获取tr
	 * 4.根据条件获取beanList<Customer>
	 * 5.返回BeanList
	 */
	public PageBean<Customer> query(Customer criteria, int pc, int ps) {
		
		PageBean<Customer> pageBean = new PageBean<Customer>();
		pageBean.setPc(pc);
		pageBean.setPs(ps);
		
		StringBuilder cntSql = new StringBuilder("select count(*) from t_customer");
		StringBuilder whereSql = new StringBuilder(" where 1=1");
		List<Object> params = new ArrayList<Object>();
		// 拼接sql语句
		String cname = criteria.getCname();
		if (cname !=null && !cname.trim().isEmpty()) {
			whereSql.append(" and cname like ?");
			params.add("%" + cname + "%");
		}
		
		String gender = criteria.getGender();
		if (gender !=null && !gender.trim().isEmpty()) {
			whereSql.append(" and gender = ?");
			params.add(gender);
		}
		
		String birthday = criteria.getBirthday();
		if (birthday !=null && !birthday.trim().isEmpty()) {
			whereSql.append(" and birthday like ?");
			params.add("%" + birthday + "%");
		}
		
		String cellphone = criteria.getCellphone();
		if (cellphone !=null && !cellphone.trim().isEmpty()) {
			whereSql.append(" and cellphone like ?");
			params.add("%" + cellphone + "%");
		}
		
		try {
			Number num = txqr.query(cntSql.append(whereSql).toString(),
					new ScalarHandler<Number>(),
					params.toArray());
			pageBean.setTr(num.intValue());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		StringBuilder listSql = new StringBuilder("select * from t_customer");
		StringBuilder limitSql = new StringBuilder(" limit ?, ?");
		params.add((pc-1)*ps);
		params.add(ps);
		
		try {
			List<Customer> list = txqr.query(listSql.append(whereSql).append(limitSql).toString(),
					new BeanListHandler<Customer>(Customer.class),
					params.toArray());
			pageBean.setBeanList(list);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return pageBean;
	}

}
