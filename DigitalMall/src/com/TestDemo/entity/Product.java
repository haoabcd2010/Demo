package com.TestDemo.entity;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("Product")
public class Product implements Serializable{
	private Integer id; //序号
	private String name; //名字
	private String imagepath; //图片路径
	private String soncategory; //子分类
	private Integer cid; //品牌 
	private Double price; //价格
	private Double myprice; //优惠价
	private Integer amount; //数量
	private Date publishtime; //发布日期
	private String descp; //描述 
	private String professor; //处理器
	private String memory; //内存
	private String disk; //硬盘
	private String Graphics; //显卡
	private String monitor; //显示屏
	private Category category;
	
	public Product() {}

	public Product(Integer id, String name, String imagepath,
			String soncategory, Integer cid, Double price, Double myprice,
			Integer amount, Date publishtime, String descp, String professor,
			String memory, String disk, String graphics, String monitor,
			Category category) {
		super();
		this.id = id;
		this.name = name;
		this.imagepath = imagepath;
		this.soncategory = soncategory;
		this.cid = cid;
		this.price = price;
		this.myprice = myprice;
		this.amount = amount;
		this.publishtime = publishtime;
		this.descp = descp;
		this.professor = professor;
		this.memory = memory;
		this.disk = disk;
		Graphics = graphics;
		this.monitor = monitor;
		this.category = category;
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

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getSoncategory() {
		return soncategory;
	}

	public void setSoncategory(String soncategory) {
		this.soncategory = soncategory;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
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

	public Date getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}

	public String getDescp() {
		return descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getDisk() {
		return disk;
	}

	public void setDisk(String disk) {
		this.disk = disk;
	}

	public String getGraphics() {
		return Graphics;
	}

	public void setGraphics(String graphics) {
		Graphics = graphics;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
