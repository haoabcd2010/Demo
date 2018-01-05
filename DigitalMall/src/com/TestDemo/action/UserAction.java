package com.TestDemo.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;

import org.apache.struts2.ServletActionContext;
/*
import com.baizhi.dangdang.entity.User;
import com.baizhi.dangdang.service.IUserService;
import com.baizhi.dangdang.service.impl.UserService;
import com.baizhi.dangdang.util.Captcha;
*/
import com.TestDemo.entity.User;
import com.TestDemo.service.IUserService;
import com.TestDemo.service.impl.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	//获得请求参数user
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//获得提交的验证码
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	IUserService service=new UserService();
	//登录的Action
	public String userLogin(){
		try {
			User user1= service.login(user);
			//session 存放数据用户的登陆
			Map<String,Object> map= (Map<String, Object>) ActionContext.getContext().get("session");
			map.put("user",user1);
			String log1= (String) map.get("log1");
			
			//判断是否有登陆信息
			if(log1==null){return "shouye";}//登录成功跳到首页，在首页显示用户名
			else{return "showaddress";}//跳转到AddressAction_showAddress
			
		} catch (Exception e) {
			e.printStackTrace();
			return "denglu";//登录失败，跳回登录页面
		}
	}
	//退出
	public String userExit(){
		Map<String,Object> session= (Map<String, Object>) ActionContext.getContext().get("session");
		session.remove("user");
		session.remove("log1");
		return "shouye";//跳转到/main/index.jsp
	}
	//注册的Action
	public String userRegist(){
		try {
			service.regist(user);
			//Map<String,Object> map=(Map<String, Object>) ActionContext.getContext().get("session");
			//String realCode= (String) map.get("checkcode");
			//if(!code.equals(realCode)) throw new RuntimeException("验证码错误");
			return "denglu";//注册成功跳到首页，在首页显示用户名
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "zhuce";//注册失败，跳回注册页面
		}
	}
	/*
	//生成验证码的Action
	public String captcha() throws Exception{
		//1.获得验证码数
		Captcha cp = Captcha.getInstance();
		cp.set(100,40);//设置宽高
		String checkcode = cp.generateCheckcode();//获得随机数
		System.out.println(checkcode+"..............");
		//2.将验证码放到session中
		Map<String,Object> map=(Map<String, Object>) ActionContext.getContext().get("session");
		map.put("checkcode", checkcode);
		//3.获得验证码图片
		BufferedImage img = cp.generateCheckImg(checkcode);
		//4.获得响应输出流
		ServletOutputStream os= ServletActionContext.getResponse().getOutputStream();
		//5.将验证码图片通过响应输出流，输出到浏览器
		ImageIO.write(img,"JPG",os);
		return "null";
	}
	*/
}
