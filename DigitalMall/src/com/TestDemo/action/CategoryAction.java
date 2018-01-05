package com.TestDemo.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.TestDemo.entity.Category;
import com.TestDemo.entity.Product;
import com.TestDemo.service.ICategoryService;
import com.TestDemo.service.IProductService;
import com.TestDemo.service.impl.CategoryService;
import com.TestDemo.service.impl.ProductService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport{
	//1.首页通过超链接传给二级分类页面的父类id
	private Integer pid;
	//2.首页通过超链接传给二级分类页面的子类id,在二级页面判断
	private Integer cid;
	//3.分页查询，传的当前页数
	private Integer currentPage;
	//1.分页查询，返回值，总页数
	private Integer pageCount;
	//2.首页显示类别的返回值（查所有）
	private List<Category> list;
	//3.二级页面显示类别的返回值（通过父类id查二级类别）
	private Category category;
	//4.二级页面显示所有书的返回值（通过一级类别或二级类别查）
	private List<Product> books;
	
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<Category> getList() {
		return list;
	}

	public void setList(List<Category> list) {
		this.list = list;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Product> getBooks() {
		return books;
	}

	public void setBooks(List<Product> books) {
		this.books = books;
	}
	
	private ICategoryService service=new CategoryService();
	private IProductService productService=new ProductService();
	//1.首页显示类别
	public String showAll(){
		list = service.getAll();
		return "content";//跳转到/main/content.jsp页面，并在这个页面上添加<s:action>标签
	}
	
	//2.二级页面显示相应类别、类别下的所有书
	public String showProductByCategory(){
		Map<String, Object> map = productService.getProductByCategory(pid, cid,currentPage);
		category= (Category) map.get("category");
		books= (List<Product>) map.get("product");
		pageCount=(Integer) map.get("pageCount");
		return "index";//跳转到/category/index.jsp页面
	}
	
}
