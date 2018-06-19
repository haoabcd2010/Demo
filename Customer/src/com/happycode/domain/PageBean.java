package com.happycode.domain;

import java.util.List;

public class PageBean<T> {
	private int pc;		//当前页码 page code
//	private int tp;		//总页数	total page
	private int tr;		//总记录数 total record
	private int ps;		//每页记录数 page size
	private List<T> beanList;	//页面数据
	
	private String url;	//查询的条件
	
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	public int getTp() {
		return tr/ps + (tr%ps==0? 0:1);
	}
/*	public void setTp(int tp) {
		this.tp = tp;
	}*/
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
}
