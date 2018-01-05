package com.TestDemo.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.TestDemo.entity.Product;


public interface IProductService {
	//查所有的书
	public List<Product> getAll();
	//1.查所有的书，按上架时间排序
	public List<Product> getProductByaddtime();
	//2.查所有的书，按销量排序
	public List<Product> getProductBysale();
	//3.查所有的书，按上架时间排序，按销量排序(新书热卖)
	public List<Product> getProductByaddtimeAndsale();
	//4.根据编辑推荐查
	public List<Product> getProductByedit();
	//1.通过类别查,二级类别
	public Map<String,Object> getProductByCategory(Integer pid,Integer cid,Integer currentPage);
	//1.通过id查
	public Product getProductById(Integer id);
}
