<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/login/css/content.css" type="text/css"></link>
<div class="left">		
	<div class="introduce">
		<font size="5" color="black">欢迎来到乐购电脑网(◕ᴗ◕)</font>
		<ul>
			<li class="bg">
				更多选择
			</li>
			<li class="n_bg">
				各种品牌电脑，共计百万种商品。
			</li>
			<li class="bg">
				更低价格
			</li>
			<li class="n_bg">
				网上购物的3-5折，传统数码店的5-7折，其他网站的7-9折。
			</li>
			<li class="bg">
				更方便、更安全
			</li>
			<li class="n_bg">
				全国超过300个城市送货上门、货到付款。零风险购物，便捷到家。
			</li>
		</ul>
	</div>
</div>
<div class="right">
	<div class="form">
	   <div class="bottom_clear"></div>
	   <h4>登录:</h4>
	   <form action="<s:url value='/user/UserAction_userLogin'/>" method="post">
	        <table>
		   		<tbody>
			   		<tr>
			   			<td>请输入邮箱:</td>
			   			<td><input type="text" placeholder="email" name="user.email"/></td>
			   		</tr>
			   		<tr>
			   			<td>密码:</td>
			   			<td><input type="password" placeholder="password" name="user.password"/></td>
			   		</tr>
			   		<tr>
			   			<td><td><input type="submit"/></td>
			   		</tr>
		   		</tbody>
	   		</table>
	   </form>
	   <div class="bottom_clear"></div>
	   <h4>您还不是乐购用户？</h4>
	   <a href="<s:url value='/register/index.jsp'/>">创建一个账户>></a>
	</div>
</div>
  
