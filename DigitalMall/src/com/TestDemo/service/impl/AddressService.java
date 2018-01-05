package com.TestDemo.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.TestDemo.dao.IAddressDAO;
import com.TestDemo.entity.Address;
import com.TestDemo.service.IAddressService;
import com.TestDemo.util.MyBatisUtil;


public class AddressService implements IAddressService{
	SqlSession sqlSession = MyBatisUtil.getCurrentSession();
	IAddressDAO dao = sqlSession.getMapper(IAddressDAO.class);
	//通过userid查
	public List<Address> selectAddressByuserid(Integer userid) {
			List<Address> list = dao.selectAddressByuserid(userid);
			MyBatisUtil.close(sqlSession);
			return list;
	}
	//通过id查
	public Address selectAddressByid(Integer id) {
		Address address = dao.selectAddressByid(id);
		MyBatisUtil.close(sqlSession);
		return address;
	}
	//添加地址信息
	public void insertAddress(Address address) {
			dao.insertAddress(address);
			sqlSession.commit();
			MyBatisUtil.close(sqlSession);
	}
	//修改地址信息
	public void updateAddress(Address address) {
		dao.updateAddress(address);
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
	}
}
