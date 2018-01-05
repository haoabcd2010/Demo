package com.TestDemo.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.TestDemo.dao.IOrderitemDAO;
import com.TestDemo.entity.Orderitem;
import com.TestDemo.service.IOrderitemService;
import com.TestDemo.util.MyBatisUtil;


public class OrderitemService implements IOrderitemService{
	SqlSession sqlSession = MyBatisUtil.getCurrentSession();
	IOrderitemDAO dao= sqlSession.getMapper(IOrderitemDAO.class);
	public void insertOrderitem(Orderitem orderitem) {
		try {
			dao.insertOrderitem(orderitem);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			MyBatisUtil.close(sqlSession);
		}
	}

}
