package com.TestDemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.TestDemo.entity.Product;


public interface IProductDAO {
	//查所有的书
	public List<Product> selectAll();
	//1.查所有的书，按上架时间排序(新书)
	public List<Product> selectProductByaddtime();
	//2.查所有的书，按销量排序(热卖)
	public List<Product> selectProductBysale();
	//3.查所有的书，按上架时间排序，按销量排序(新书热卖)
	public List<Product> selectProductByaddtimeAndsale();
	//4.根据编辑推荐查(编辑推荐)
	public List<Product> selectProductByedit();
	//1.通过类别查,二级类别
	public List<Product> selectProductByCategory(@Param("cids")List<Integer> cid,@Param("currentPage")Integer currentPage,@Param("pageSize")Integer pageSize);
	public List<Integer> selectProductCount(@Param("cids")List<Integer> cid);
	//1.通过id查
	public Product selectProductById(Integer id);
}
