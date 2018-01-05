<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix='s'%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/register/css/content.css" type="text/css"></link>
<script type="text/javascript" src='../js/jquery-1.8.3.js'></script>
<script type="text/javascript" src='../js/jquery.validate.js'></script>
<script type="text/javascript" src='../js/message_zh_CN.js'></script>
<script type='text/javascript'>
  		$(function(){
  			$("form").validate({
  				rules:{
  					"user.email":{required:true,email:true},
  					"user.name":{required:true,minlength:4,maxlength:20},
  					"user.password":{required:true,minlength:6,maxlength:20},
  					"password2":{required:true,minlength:6,maxlength:20,equalTo:pwd}
  				}
  			});
  		});
  	</script>
<div class="container">
	<div class="step">注册步骤: <span class="current">请认真填写以下内容</div>
	<div class="form">
		 <form action="<s:url value='/user/UserAction_userRegist'/>" method="post" name='zhuce'>
			<table >
				<caption>*以下均为必填项</caption>
				<tbody>
					<tr>
						<td class="td1">请填写您的Email地址：</td>
						<td class="td2"><input type="text" placeholder="请输入你的邮箱" name="user.email"/></td>
						<td class="td3">
							<span class="info">请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。</span>
							<span class="error"></span>
						</td>
					</tr>
					<tr>
						<td class="td1">昵称：</td>
						<td class="td2"><input type="text" placeholder="请输入你的昵称" name="user.name"/></td>
						<td class="td3">
							<span class="info">昵称可以由小写英文字母、中文、数字组成，
												长度4－20个字符，一个汉字为两个字符。
							</span>
							<span class="error"></span>
						</td>
					</tr>
					<tr>
						<td class="td1">设置密码：</td>
						<td class="td2"><input type="password" placeholder="请输入你的密码" name="user.password"/></td>
						<td class="td3">
							<span class="info">密码可以由大小写英文字母、数字组成，长度6－20位。</span>
							<span class="error"></span>
						</td>
					</tr>
					<tr>
						<td class="td1">再次输入密码：</td>
						<td class="td2"><input type="password" placeholder="再次输入密码" name="" id="pwd"/></td>
						<td class="td3">
							<span class="info">密码可以由大小写英文字母、数字组成，长度6－20位。</span>
							<span class="error"></span>
						</td>
					</tr>
					<tfoot>
						<tr>
							<td colspan="3">
								<input type="submit" value="提交"/>
							</td>
						</tr>
					</tfoot>
				</tbody>
			</table>
		</form>
	</div>
</div>
