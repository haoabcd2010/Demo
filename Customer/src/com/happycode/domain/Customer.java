package com.happycode.domain;

/*
 * 实体类
 * 与表单和数据表都对应
 */
public class Customer {
	
	private String cid;
	private String cname;
	private String gender;
	private String birthday;
	private String cellphone;
	private String email;
	private String description;
	
	public Customer() {
		super();
	}

	public Customer(String cid, String cname, String gender, String birthday, String cellphone, String email,
			String description) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.gender = gender;
		this.birthday = birthday;
		this.cellphone = cellphone;
		this.email = email;
		this.description = description;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", gender=" + gender + ", birthday=" + birthday
				+ ", cellphone=" + cellphone + ", email=" + email + ", description=" + description + "]";
	}
	
}
