package com.TestDemo.entity;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
@Alias("Cartitem")
public class Cartitem implements Serializable{
	private Integer id;
	private String name;
	private Double price;
	private Double myprice;
	private Integer amount;
	private String status;
	
	public Cartitem(){}
	
	public Cartitem(Integer id, String name, Double price, Double myprice,
			Integer amount, String status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.myprice = myprice;
		this.amount = amount;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getMyprice() {
		return myprice;
	}

	public void setMyprice(Double myprice) {
		this.myprice = myprice;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cartitem [id=" + id + ", name=" + name + ", price=" + price
				+ ", dangdangprice=" + myprice + ", amount=" + amount
				+ ", status=" + status + "]";
	}
	
}
