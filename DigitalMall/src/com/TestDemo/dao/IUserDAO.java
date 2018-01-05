package com.TestDemo.dao;

import com.TestDemo.entity.User;

public interface IUserDAO {
	//添加
	public void insert(User user);
	//查询
	public User selectByEmail(User user);
}
