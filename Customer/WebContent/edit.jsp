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

<form action="${pageContext.request.contextPath }/CustomerServlet" method="post">
	<input type="hidden" name="method" value="edit"/>
	<input type="hidden" name="cid" value="${cstm.cid}"/>
<table id="reg_table" >
	<tr>
		<td colspan="2" align="center"><b>编辑</b></td>
	</tr>
	<tr>
		<td align="right" class="elem1">姓名：</td>
		<td class="elem2"><input type="text" name="cname" value="${cstm.cname}"/></td>
	</tr>
	<tr>
		<td align="right" class="elem1">性别：</td>
		<td class="elem2">
			<input type="radio" name="gender" value="男" <c:if test="${cstm.gender eq '男'}">checked="checked"</c:if>/>男
			<input type="radio" name="gender" value="女" <c:if test="${cstm.gender eq '女'}">checked="checked"</c:if>/>女
		</td>
	</tr>
	<tr>
		<td align="right" class="elem1">生日:</td>
		<td class="elem2"><input type="text" name="birthday" value="${cstm.birthday}"/></td>
	</tr>
	<tr>
		<td align="right" class="elem1">手机：</td>
		<td class="elem2"><input type="text" name="cellphone" value="${cstm.cellphone}"/></td>
	</tr>
	<tr>
		<td align="right" class="elem1">邮箱：</td>
		<td class="elem2"><input type="text" name="email" value="${cstm.email}"/></td>
	</tr>
	<tr>
		<td align="right" class="elem1">个人描述:</td>
		<td class="elem2"><input type="text" name="description" value="${cstm.description}"/></td>
	</tr>
	<tr>
		<td align="right" class="elem1"></td>
		<td class="elem2"><input type="submit" value="submit"/></td>
	</tr>
</table>
</form>

</body>
</html>