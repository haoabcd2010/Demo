package com.TestDemo.entity;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
@Alias("Address")
public class Address implements Serializable{
	private Integer id;
	private String receivename;
	private String fulladdress;
	private String postalcode;
	private String phone;
	private String mobile;
	private Integer userid;//用户
	public Address(){}
	public Address(Integer id, String receivename, String fulladdress,
			String postalcode, String phone, String mobile, Integer userid) {
		super();
		this.id = id;
		this.receivename = receivename;
		this.fulladdress = fulladdress;
		this.postalcode = postalcode;
		this.phone = phone;
		this.mobile = mobile;
		this.userid = userid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getReceivename() {
		return receivename;
	}
	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}
	public String getFulladdress() {
		return fulladdress;
	}
	public void setFulladdress(String fulladdress) {
		this.fulladdress = fulladdress;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", receivename=" + receivename
				+ ", fulladdress=" + fulladdress + ", postalcode=" + postalcode
				+ ", phone=" + phone + ", mobile=" + mobile + ", userid="
				+ userid + "]";
	}
	
}
