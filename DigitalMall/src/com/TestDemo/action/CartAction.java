package com.TestDemo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.TestDemo.entity.Cartitem;
import com.TestDemo.entity.Product;
import com.TestDemo.service.IProductService;
import com.TestDemo.service.impl.ProductService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class CartAction extends ActionSupport {
	private Integer productid;// 页面传的商品id
	private Integer amount;// 页面传的原有商品数量
	private String cartstatus1;// 显示购物车的返回值，购物车列表区状态
	private String cartstatus2;// 显示购物车的返回值，购物车删除区状态
	private Double totaleconomy;// 显示购物车的返回值，节省的钱数
	private Double totalaccount;// 显示购物车的返回值，商品金额总计

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCartstatus1() {
		return cartstatus1;
	}

	public void setCartstatus1(String cartstatus1) {
		this.cartstatus1 = cartstatus1;
	}

	public String getCartstatus2() {
		return cartstatus2;
	}

	public void setCartstatus2(String cartstatus2) {
		this.cartstatus2 = cartstatus2;
	}

	public Double getTotaleconomy() {
		return totaleconomy;
	}

	public void setTotaleconomy(Double totaleconomy) {
		this.totaleconomy = totaleconomy;
	}

	public Double getTotalaccount() {
		return totalaccount;
	}

	public void setTotalaccount(Double totalaccount) {
		this.totalaccount = totalaccount;
	}

	ValueStack valueStack = ActionContext.getContext().getValueStack();
	IProductService service = new ProductService();

	// 1.显示购物车
	public String showCart() {
		Map<Integer, Cartitem> cart = (Map<Integer, Cartitem>) valueStack.findValue("#session.cart");
		totaleconomy = 0.0;
		totalaccount = 0.0;
		if (cart == null || cart.size() == 0) {
			cartstatus1 = "nothing";
			cartstatus2 = "nothing";
			Map<Integer, Cartitem> cart1 = new HashMap<Integer, Cartitem>();
			valueStack.setValue("#session.cart", cart1);
		} else {
			// 购物车存在
			Collection<Cartitem> cartitem = cart.values();
			Integer s1 = 0;// 判断购物车是否为空
			Integer s2 = 0;// 判断删除区是否为空
			for (Cartitem c : cartitem) {
				if ("yes".equals(c.getStatus())) {
					s1 += 1;
					totaleconomy += (c.getPrice() - c.getMyprice())
							* c.getAmount();
					totalaccount += c.getMyprice() * c.getAmount();
				}
				if ("no".equals(c.getStatus())) {
					s2 += 1;
				}
			}
			if (s1 == 0)
				cartstatus1 = "nothing";
			if (s2 == 0)
				cartstatus2 = "nothing";
		}
		return "cart";// 跳转到/cart/cart.jsp
	}

	// 2.添加购物车
	public String addCart() throws Exception {
		Map<Integer, Cartitem> cart = (Map<Integer, Cartitem>) valueStack.findValue("#session.cart");
		if (cart == null) {
			// 创建购物车
			Map<Integer, Cartitem> cart1 = new HashMap<Integer, Cartitem>();
			Cartitem cartitem = new Cartitem();
			Product product = service.getProductById(productid);
			// 设置购物车参数
			cartitem.setId(productid);
			cartitem.setName(product.getName());
			cartitem.setPrice(product.getPrice());
			cartitem.setMyprice(product.getMyprice());
			cartitem.setAmount(1);
			cartitem.setStatus("yes");
			// 放入session
			cart1.put(productid, cartitem);
			valueStack.setValue("#session.cart", cart1);
		} else if (!cart.containsKey(productid)) {
			// 购物车存在，商品不存在
			Cartitem cartitem = new Cartitem();
			Product product = service.getProductById(productid);
			// 设置购物车参数
			cartitem.setId(productid);
			cartitem.setName(product.getName());
			cartitem.setPrice(product.getPrice());
			cartitem.setMyprice(product.getMyprice());
			cartitem.setAmount(1);
			cartitem.setStatus("yes");
			// 放入session
			cart.put(productid, cartitem);
			valueStack.setValue("#session.cart", cart);
		} else {
			// 购物车存在，商品存在,在购物车区
			Cartitem cartitem = cart.get(productid);
			// 设置购物车参数
			cartitem.setAmount(cartitem.getAmount() + 1);
			cartitem.setStatus("yes");
			// 放入session
			cart.put(productid, cartitem);
			valueStack.setValue("#session.cart", cart);

		}
		/*
		return "showcart";// 跳转到添加成功页面/CartAction_showCart
		
		Thread.sleep(3000);
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter writer = response.getWriter();
		writer.print("ok");
		writer.flush();
		writer.close();*/
		return null;
	}

	// 3.删除购物车
	public String deleteCart() {
		Map<Integer, Cartitem> cart = (Map<Integer, Cartitem>) valueStack.findValue("#session.cart");
		Cartitem cartitem = cart.get(productid);
		// 设置购物车状态
		cartitem.setStatus("no");
		cart.put(productid, cartitem);
		valueStack.set("#session.cart", cart);
		return "showcart";
	}

	// 4.恢复购物车
	public String huifuCart() {
		Map<Integer, Cartitem> cart = (Map<Integer, Cartitem>) valueStack.findValue("#session.cart");
		Cartitem cartitem = cart.get(productid);
		// 设置购物车状态
		cartitem.setStatus("yes");
		// 放入session
		cart.put(productid, cartitem);
		valueStack.setValue("#session.cart", cart);
		return "showcart";
	}

	// 5.修改购物车
	public String updateCart() {
		Map<Integer, Cartitem> cart = (Map<Integer, Cartitem>) valueStack.findValue("#session.cart");
		Cartitem cartitem = cart.get(productid);
		// 设置购物车参数
		cartitem.setAmount(amount);
		// 放入session
		cart.put(productid, cartitem);
		valueStack.set("#session.cart", cart);
		return "showcart";// 跳转到/CartAction_showCart
	}
}
