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
<h1>注册</h1>
<p style="color:red;">${requestScope.msg}</p>
<form action="${pageContext.request.contextPath }/RegistServlet" method="post">
用户名：<input type="text" name="username" value="${user.username}"/><a>${errors.username_error }</a><br/>
密啊码：<input type="password" name="password" value="${user.password}"/><a>${errors.password_error }</a><br/>
验证码：<input type="text" name="verifycode" size="5"/>
<img id="verifyImg" border=1 src="${pageContext.request.contextPath }/VerifyCodeServlet" onclick="javascript:updateVerifyCode();"/>
<a>${errors.verifycode_error }</a><br />
<input type="submit" value="注册"/>
</form>
	<!-- 更新验证码 -->
	<script type="text/javascript">
		function updateVerifyCode() {
			/*
				获取图片id
				然后提交时间参数
			 */
			var x = document.getElementById("verifyImg");
			x.src = "${pageContext.request.contextPath }/VerifyCodeServlet?a=" + new Date().getTime();
		}
	</script>
</body>
</html>