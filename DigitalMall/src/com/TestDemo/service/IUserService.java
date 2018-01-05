package com.TestDemo.service;

import com.TestDemo.entity.User;


public interface IUserService {
	//登录
	public User login(User user);
	//注册
	public void regist(User user);
}
