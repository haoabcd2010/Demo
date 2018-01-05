package com.TestDemo.action;

import java.util.Date;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.TestDemo.entity.Address;
import com.TestDemo.entity.User;
import com.TestDemo.service.IAddressService;
import com.TestDemo.service.impl.AddressService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class AddressAction extends ActionSupport{
	private Integer id;//change事件传的地址id
	private Address address;//显示地址页面的返回值，通过已有地址的id获得地址信息，并修改地址
	private List<Address> list;//显示地址页面下拉列表的返回值，通过userid获得已有的多个地址
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Address> getList() {
		return list;
	}
	public void setList(List<Address> list) {
		this.list = list;
	}

	IAddressService addressService = new AddressService();
	//1.通过地址的id获得地址信息
	public String selectAddressByid(){
		address = addressService.selectAddressByid(id);
		return "showaddress";//跳转到/AddressAction_showAddress
	}
	//2.显示已有地址信息
	public String showAddress(){
		Map<String,Object> session= (Map<String, Object>) ActionContext.getContext().get("session");
		User user = (User) session.get("user");
		list = addressService.selectAddressByuserid(user.getId());
		return "address";//跳转到/order/addressForm1.jsp
	}
	//
}
