package com.TestDemo.entity;
 
import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;
@Alias("Order")
public class Order implements Serializable{
	private Integer id;
	private String orderid;
	private Date ordertime;
	private Double totalprice;
	private Integer userid;//用户
	private Integer addressid;//地址
	public Order(){}
	public Order(Integer id, String orderid, Date ordertime, Double totalprice,
			Integer userid, Integer addressid) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.ordertime = ordertime;
		this.totalprice = totalprice;
		this.userid = userid;
		this.addressid = addressid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getAddressid() {
		return addressid;
	}
	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderid=" + orderid + ", ordertime="
				+ ordertime + ", totalprice=" + totalprice + ", userid="
				+ userid + ", addressid=" + addressid + "]";
	}
	
}
