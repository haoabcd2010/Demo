package com.TestDemo.service;

import java.util.Collection;
import java.util.List;

import com.TestDemo.entity.Address;
import com.TestDemo.entity.Cartitem;


public interface IOrderService {
	//添加订单
	public Double insertOrder(Address address,Collection<Cartitem> cartitem,Integer userid);
	
}
