package com.TestDemo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.TestDemo.dao.ICategoryDAO;
import com.TestDemo.dao.IProductDAO;
import com.TestDemo.entity.Category;
import com.TestDemo.entity.Product;
import com.TestDemo.service.IProductService;
import com.TestDemo.util.MyBatisUtil;



public class ProductService implements IProductService {
	SqlSession sqlSession = MyBatisUtil.getCurrentSession();
	IProductDAO dao = sqlSession.getMapper(IProductDAO.class);
	ICategoryDAO dao1 = sqlSession.getMapper(ICategoryDAO.class);

	// 查所有的书
	public List<Product> getAll() {
		List<Product> list = dao.selectAll();
		MyBatisUtil.close(sqlSession);
		return list;
	}

	// 1.查所有的书，按上架时间排序(新书)
	public List<Product> getProductByaddtime() {
		List<Product> list = dao.selectProductByaddtime();
		MyBatisUtil.close(sqlSession);
		return list;
	}

	// 2.查所有的书，按销量排序（热卖）
	public List<Product> getProductBysale() {
		List<Product> list = dao.selectProductBysale();
		MyBatisUtil.close(sqlSession);
		return list;
	}

	// 3.查所有的书，按上架时间排序，按销量排序(新书热卖)
	public List<Product> getProductByaddtimeAndsale() {
		List<Product> list = dao.selectProductByaddtimeAndsale();
		MyBatisUtil.close(sqlSession);
		return list;
	}

	// 4.根据编辑推荐查（编辑推荐）
	public List<Product> getProductByedit() {
		List<Product> list = dao.selectProductByedit();
		MyBatisUtil.close(sqlSession);
		return list;
	}

	// 1.通过类别查,二级类别
	public Map<String, Object> getProductByCategory(Integer pid, Integer cid,
			Integer currentPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Category category = dao1.selectByParent(pid);
			map.put("category", category);
			if (cid == null) {// 只有父类id
				// ①通过pid获得它的所有cid,并放入List集合中
				Category cat = dao1.selectByParent(pid);
				List<Category> cat1 = cat.getChildren();
				List<Integer> cids = new ArrayList<Integer>();
				for (Category i : cat1) {
					cids.add(i.getId());
				}
				// ②获得该pid下的所有cid下的所有书的数量
				List<Integer> count = dao.selectProductCount(cids);
				Integer productCount = 0;
				for (Integer i : count) {
					productCount += i;
				}
				// ③获得总页数
				Integer pageCount = productCount % 5 == 0 ? productCount / 5
						: (productCount / 5) + 1;
				// ④分页查询
				if (currentPage == 0)
					currentPage = 1;
				List<Product> product = dao.selectProductByCategory(cids,
						currentPage, 5);
				map.put("pageCount", pageCount);
				map.put("product", product);
			} else {// 父类id、子类id
					// ①获得该cid下所有书的数量
				List<Integer> count = dao
						.selectProductCount(Arrays.asList(cid));
				Integer productCount = count.get(0);
				// ②获得总页数
				Integer pageCount = productCount % 5 == 0 ? productCount / 5
						: (productCount / 5) + 1;
				// ③分页查询
				if (currentPage == 0)
					currentPage = 1;
				List<Product> product = dao.selectProductByCategory(
						Arrays.asList(cid), currentPage, 5);
				map.put("pageCount", pageCount);
				map.put("product", product);
			}
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			MyBatisUtil.close(sqlSession);
		}
		return map;
	}

	// 1.通过id查
	public Product getProductById(Integer id) {
		Product product = dao.selectProductById(id);
		MyBatisUtil.close(sqlSession);
		return product;
	}

}
