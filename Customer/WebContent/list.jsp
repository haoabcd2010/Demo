<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" style="solid; text-align: center; border-collapse: collapse;">
	<tr>
		<td>姓名</td>
		<td>性别</td>
		<td>生日</td>
		<td>电话</td>
		<td>邮箱</td>
		<td>描述</td>
		<td>操作</td>
	</tr>
<c:forEach items="${pb.beanList}" var="cstm">
	<tr>
		<td>${cstm.cname}</td>
		<td>${cstm.gender}</td>
		<td>${cstm.birthday}</td>
		<td>${cstm.cellphone}</td>
		<td>${cstm.email}</td>
		<td>${cstm.description}</td>
		<td>
			<a href="<c:url value='/CustomerServlet?method=preEdit&cid=${cstm.cid}'/>">编辑</a>
			<a href="<c:url value='/CustomerServlet?method=delete&cid=${cstm.cid}'/>">删除</a>
		</td>
	</tr>
</c:forEach>
</table>

<a>第${pb.pc}页/共${pb.tp}页</a>
<a href="${pb.url}&pc=1">首页</a>
<c:if test="${pb.pc > 1}">
<a href="${pb.url}&pc=${pb.pc-1}">上一页</a>
</c:if>
<!-- 可选页面 -->
<c:choose>
	<c:when test="${pb.tp < 10}">
		<c:set var="begin" value="1"/>
		<c:set var="end" value="${pb.tp}"/>
	</c:when>
	<c:otherwise>
		<c:set var="begin" value="${pb.pc - 5}"/>
		<c:set var="end" value="${pb.pc + 4}"/>
		<c:if test="${begin < 1}">
			<c:set var="begin" value="1"/>
			<c:set var="end" value="10"/>
		</c:if>
		<c:if test="${end > pb.tp}">
			<c:set var="begin" value="${pb.tp -9}"/>
			<c:set var="end" value="${pb.tp}"/>
		</c:if>
	</c:otherwise>
</c:choose>

<c:forEach var="i" begin="${begin}" end="${end}">
	<c:choose>
		<c:when test="${i == pb.pc}">
			<a>[${i}]</a>
		</c:when>
		<c:otherwise>
			<a href="${pb.url}&pc=${i}">[${i}]</a>
		</c:otherwise>
	</c:choose>
</c:forEach>

<c:if test="${pb.pc < pb.tp}">
<a href="${pb.url}&pc=${pb.pc+1}">下一页</a>
</c:if>
<a href="${pb.url}&pc=${pb.tp}">尾页</a>

</body>
</html>