<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 输出到main界面去 -->
<base target="main"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
	<h1>客户管理系统</h1>
	<a href="<c:url value='/add.jsp'/>">添加用户</a>
	<a href="<c:url value='/CustomerServlet?method=findAll'/>">查询客户</a>
	<a href="<c:url value='/query.jsp'/>">高级搜索</a>
</body>
</html>