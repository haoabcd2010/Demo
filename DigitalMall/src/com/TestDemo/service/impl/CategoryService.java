package com.TestDemo.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.TestDemo.dao.ICategoryDAO;
import com.TestDemo.entity.Category;
import com.TestDemo.service.ICategoryService;
import com.TestDemo.util.MyBatisUtil;

public class CategoryService implements ICategoryService{
	SqlSession sqlSession = MyBatisUtil.getCurrentSession();
	ICategoryDAO dao = sqlSession.getMapper(ICategoryDAO.class);
	//查所有一级类别和二级类别
	public List<Category> getAll() {
		List<Category> list = dao.selectAll();
		MyBatisUtil.close(sqlSession);
		return list;
	}
	//通过一级类别的id查二级类别
	public Category getCategoryByParent(Integer id) {
		Category category = dao.selectByParent(id);
		MyBatisUtil.close(sqlSession);
		return category;
	}
		
}
