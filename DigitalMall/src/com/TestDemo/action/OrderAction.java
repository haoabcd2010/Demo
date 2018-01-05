package com.TestDemo.action;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.TestDemo.entity.Address;
import com.TestDemo.entity.Cartitem;
import com.TestDemo.entity.User;
import com.TestDemo.service.IOrderService;
import com.TestDemo.service.impl.OrderService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	private Integer index;// 订单页面的返回值,显示序号
	private Double totalaccount = 0.0;// 订单页面、订单成功页面的返回值,显示总金额
	private String orderid;
	private Address address;// 地址页面form表单提交的地址信息

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Double getTotalaccount() {
		return totalaccount;
	}

	public void setTotalaccount(Double totalaccount) {
		this.totalaccount = totalaccount;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	IOrderService orderService = new OrderService();
	Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().get("session");

	// 1.结算，确认订单，显示订单页面
	public String showOrder() {
		index = 0;
		Map<Integer, Cartitem> cart = (Map<Integer, Cartitem>) session.get("cart");
		Collection<Cartitem> cartitem = cart.values();
		for (Cartitem i : cartitem) {
			if (i.getStatus() == "yes") {
				totalaccount += i.getMyprice() * i.getAmount();
			}
		}
		//往session中放一个标志位，判断登录跳转
		String log1="log1";
		session.put("log1", log1);
		return "order";// 跳转到/order/orderInfo.jsp
	}

	// 2.添加地址信息，添加订单、订单项，删除购物车，并跳转到订单成功页面
	public String createOrder() {
		User user = (User) session.get("user");
		Integer userid = user.getId();// userid
		Map<Integer, Cartitem> cart = (Map<Integer, Cartitem>) session.get("cart");
		Collection<Cartitem> cartitem = cart.values();
		orderid = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
		totalaccount = orderService.insertOrder(address, cartitem, userid);
		// 删除购物车
		session.remove("cart");
		session.remove("log1");
		return "orderok";// 跳转到/order/orderOk.jsp
	}
}
