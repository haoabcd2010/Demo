<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<style type="text/css">
	#reg_table {
		border: 1px solid;
		width: 500px;
		height: 400px;
		margin-left: auto;
		margin-right: auto;
		margin-top: 20px;
	}
	
	.elem1 {
		width: 30%;
	}
	
	.elem2 {
		width: 70%;
	}
</style>
</head>
<body>
<p style="color:red;">${requestScope.msg}</p>
<form action="${pageContext.request.contextPath }/CustomerServlet" method="post">
	<input type="hidden" name="method" value="add"/>
<table id="reg_table" >
	<tr>
		<td colspan="2" align="center"><b>注册</b></td>
	</tr>
	<tr>
		<td align="right" class="elem1">姓名：</td>
		<td class="elem2"><input type="text" name="cname"/></td>
	</tr>
	<tr>
		<td align="right" class="elem1">性别：</td>
		<td class="elem2">
			<input type="radio" name="gender" value="男"/>男
			<input type="radio" name="gender" value="女"/>女
		</td>
	</tr>
	<tr>
		<td align="right" class="elem1">生日:</td>
		<td class="elem2"><input type="text" name="birthday"/></td>
	</tr>
	<tr>
		<td align="right" class="elem1">手机：</td>
		<td class="elem2"><input type="text" name="cellphone"/></td>
	</tr>
	<tr>
		<td align="right" class="elem1">邮箱：</td>
		<td class="elem2"><input type="text" name="email"/></td>
	</tr>
	<tr>
		<td align="right" class="elem1">个人描述:</td>
		<td class="elem2"><textarea cols="30" rows="3" name="description"></textarea></td>
	</tr>
	<tr>
		<td class="elem1"></td>
		<td class="elem2"><input type="submit" value="submit"/></td>
	</tr>
</table>
</form>
</body>
</html>