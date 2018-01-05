<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/main/css/header.css" type="text/css"></link>
<!-- 设置头 -->
<div class="header" >
   	<div class="top">
   		<div class="weclome_left">
   			<s:if test="#session.user==null"><span>[<a href="${pageContext.request.contextPath}/login/index.jsp">登录</a>|<a href="${pageContext.request.contextPath}/register/index.jsp">注册</a>]</span></s:if>
   			<s:else><span>您好<s:property value='#session.user.name'/>，欢迎光临乐购网[<a href="<s:url value='/user/UserAction_userExit'/>">退出</a>]</span></s:else>
   		</div>
   		<div class="weclome_right">
   			<div>
   				<a  href="<s:url value='/cart/CartAction_showCart'/>">我的购物车</a> | <a  href="">我的乐购</a> | <a href="">帮助</a>
   			</div>
   		</div>
   	</div>
   	<div class="logo">
   		<div >
   			<a href="">
   				<img  src="${pageContext.request.contextPath}/main/images/logo.png" alt="乐购网" />
   			</a>
   		</div>
   		<h1>快   乐   购 , 轻   松   购  !</h1>
   	</div>
</div> 
