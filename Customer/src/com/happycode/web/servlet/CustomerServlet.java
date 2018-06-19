package com.happycode.web.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happycode.domain.Customer;
import com.happycode.domain.PageBean;
import com.happycode.service.CustomerService;
import com.happycode.utils.CommonUtils;

/**
 * web 层
 * @author happy_code
 */

@WebServlet("/CustomerServlet")
public class CustomerServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	private CustomerService customerService = new CustomerService();
	
	/*
	 * 添加客户
	 * 1.封装对象
	 * 2.补全id
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//前端属性名，要严格对应
		Customer form = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		form.setCid(CommonUtils.uuid());
		customerService.add(form);
		request.setAttribute("msg", "恭喜！注册成功！");
		return "/msg.jsp";
	}
	
	
	/*
	 * 查找所有用户
	 * 获取请求的 pc 参数,没有为1
	 * 决定页面数据数量
	 * 请求service，获取pageBean
	 * 转发到list.jsp
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int pc = getPc(request);
		int ps = 10;
		PageBean<Customer> list =  customerService.findAll(pc, ps);
		list.setUrl(getUrl(request));
		request.setAttribute("pb", list);
		
		return "/list.jsp";
	}
	
	/*
	 * 专门写个来获取pc的
	 */
	public int getPc(HttpServletRequest request) {
		String pc = request.getParameter("pc");
		int ipc;
		if (pc == null || pc.trim().isEmpty()) {
			return 1;
		} else {
			ipc= Integer.parseInt(pc);
			if (ipc <=0 ) ipc = 1;
		}
		return ipc;
	}
	
	
	/*
	 * 修改用户的请求
	 * 1.接收前端请求
	 * 2.通过cid搜索到Customer
	 * 3.转发到edit页面
	 */
	public String preEdit(HttpServletRequest request, HttpServletResponse response) {
		String cid = (String) request.getParameter("cid");
		Customer cstm = customerService.findByCid(cid);
		request.setAttribute("cstm", cstm);
		return "/edit.jsp";
	}
	
	
	/*
	 * 编辑用户后保存的请求
	 * 1.通过获取到的cid
	 * 2.保存新表单
	 * 3.转发到msg.jsp
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response) {
		Customer form = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		customerService.edit(form);
		request.setAttribute("msg", "恭喜！保存成功！");
		return "/msg.jsp";
	}
	
	
	/*
	 * 删除用户的请求
	 * 1.通过获取到的cid删除用户
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		String cid = (String) request.getParameter("cid");
		customerService.delete(cid);
		request.setAttribute("msg", "恭喜！删除成功！");
		return "/msg.jsp";
	}
	
	
	/*
	 * 按条件查找
	 * 1.将表单封装成条件对象
	 * 2.填充pc，决定ps
	 * 3.转发给service
	 * 4.得到pageBean
	 * 5.保存url
	 * 6.转发到list.jsp
	 */
	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		// get请求，编码问题必须解决
		criteria = enconding(criteria);
		
		int pc = getPc(request);
		int ps = 10;
		PageBean<Customer> pageBean = customerService.query(criteria, pc, ps);
		pageBean.setUrl(getUrl(request));
		request.setAttribute("pb", pageBean);
		return "/list.jsp";
	}

	/*
	 * 将所有属性转变为utf-8的编码
	 */
	private Customer enconding(Customer criteria) throws UnsupportedEncodingException {
		String cname = criteria.getCname();
		String gender = criteria.getGender();
		String birthday = criteria.getBirthday();
		String cellphone = criteria.getCellphone();
		
		if (cname != null && !cname.trim().isEmpty()) {
			cname = new String(cname.getBytes("ISO-8859-1"), "UTF-8");
			criteria.setCname(cname);
		}
		
		if (gender != null && !gender.trim().isEmpty()) {
			gender = new String(gender.getBytes("ISO-8859-1"), "UTF-8");
			criteria.setGender(gender);
		}
		
		if (birthday != null && !birthday.trim().isEmpty()) {
			birthday = new String(birthday.getBytes("ISO-8859-1"), "UTF-8");
			criteria.setBirthday(birthday);
		}
		
		if (cellphone != null && !cellphone.trim().isEmpty()) {
			cellphone = new String(cellphone.getBytes("ISO-8859-1"), "UTF-8");
			criteria.setCellphone(cellphone);
		}
		return criteria;
	}


	// 为了获取request的?后面的内容
	private String getUrl(HttpServletRequest request) {
		String contextPath = request.getContextPath();	//项目名
		String servletPath = request.getServletPath();	//Servlet名
		String queryString = request.getQueryString();	//get的参数
		
		String url = contextPath + servletPath + "?" + queryString;
		if (queryString != null && queryString.contains("&pc=")) {
			int index = queryString.lastIndexOf("&pc=");
			queryString = queryString.substring(0, index);
		}
		return contextPath + servletPath + "?" + queryString;
	}
}
