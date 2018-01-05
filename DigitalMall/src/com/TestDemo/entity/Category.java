package com.TestDemo.entity;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("Category")
public class Category implements Serializable{
	private Integer id;
	private String name;
	private Integer parentid;
	private Integer amount;
	private List<Category> children;
	public Category(){}
	public Category(Integer id, String name, Integer parentid, Integer amount,
			List<Category> children) {
		super();
		this.id = id;
		this.name = name;
		this.parentid = parentid;
		this.amount = amount;
		this.children = children;
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
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public List<Category> getChildren() {
		return children;
	}
	public void setChildren(List<Category> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parentid="
				+ parentid + ", amount=" + amount + ", children=" + children
				+ "]";
	}
	
}