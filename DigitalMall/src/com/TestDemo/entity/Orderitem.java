package com.TestDemo.entity;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
@Alias("Orderitem")
public class Orderitem implements Serializable{
	private Integer id;
	private Integer amount;
	private Double subtotal;
	private Integer orderid;//订单
	private Integer productid;//商品
	public Orderitem(){}
	public Orderitem(Integer id, Integer amount, Double subtotal,
			Integer orderid, Integer productid) {
		super();
		this.id = id;
		this.amount = amount;
		this.subtotal = subtotal;
		this.orderid = orderid;
		this.productid = productid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	@Override
	public String toString() {
		return "Orderitem [id=" + id + ", amount=" + amount + ", subtotal="
				+ subtotal + ", orderid=" + orderid + ", productid="
				+ productid + "]";
	}
	
	
}
