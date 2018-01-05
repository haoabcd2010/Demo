package com.TestDemo.service;

import java.util.List;

import com.TestDemo.action.CategoryAction;
import com.TestDemo.entity.Category;

public interface ICategoryService {
	//查所有一级类别和二级类别
	public List<Category> getAll();
	//通过一级类别的id查二级类别
	public Category getCategoryByParent(Integer id);
}
