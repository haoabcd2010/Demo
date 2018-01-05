package com.TestDemo.action;

import java.util.List;


import com.TestDemo.entity.Product;
import com.TestDemo.service.IProductService;
import com.TestDemo.service.impl.ProductService;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport{
	//首页显示商品的返回值，list<Product>集合
	private List<Product> list;
	//jsp传的商品id
	private Integer proid;
	//商品的返回值，Product对象
	private Product product;
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	public Integer getProid() {
		return proid;
	}
	public void setProid(Integer proid) {
		this.proid = proid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	IProductService service=new ProductService();
	//1.新书
	public String showProductByaddtime(){
		 list = service.getProductByaddtime();
		 return "content";//跳转到/main/content.jsp
	}
	//2.热卖
	public String showProductBysale(){
		list = service.getProductBysale();
		return "content";//跳转到/main/content.jsp
	}
	//3.新书热卖
	public String getProductByaddtimeAndsale(){
		list= service.getProductByaddtimeAndsale();
		return "content";//跳转到/main/content.jsp
	}
	//4.编辑推荐
	public String showProductByedit() {
		list = service.getProductByedit();
		return "content";//跳转到/main/content.jsp
	}
	//5.通过id查
	public String showProductById(){
		product = service.getProductById(proid);
		return "index";//跳转到/product/index.jsp
	}
}
