package com.happycode.service;

import com.happycode.dao.CustomerDao;
import com.happycode.domain.Customer;
import com.happycode.domain.PageBean;

/**
 * @author happy_code
 *
 */
public class CustomerService {
	private CustomerDao customerDao = new CustomerDao();
	
	/*
	 * 增加客户
	 */
	public void add(Customer user) {
		customerDao.add(user);
	}
	
	/*
	 * 查询所有
	 */
	public PageBean<Customer> findAll(int pc, int ps) {
		return customerDao.findAll(pc, ps);
	}

	/*
	 * 查找用户通过cid
	 */
	public Customer findByCid(String cid) {
		return customerDao.findByCid(cid);
	}

	/*
	 * 删除用户
	 */
	public void delete(String cid) {
		customerDao.deleteByCid(cid);
	}
	
	/*
	 * 保存修改用户
	 */
	public void edit(Customer form) {
		customerDao.edit(form);
	}
	
	public PageBean<Customer> query(Customer criteria, int pc, int ps) {
		return customerDao.query(criteria, pc, ps);
	}
}
