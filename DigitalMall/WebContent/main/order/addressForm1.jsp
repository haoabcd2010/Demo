<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.min.js"></script>
		<script type="text/javascript" src="../js/verify.js"></script>
		<script type="text/javascript">
			function getJsonAddress() {
			var jsonAdd="";
			jsonAdd=jsonAdd+"{";
			jsonAdd+='<s:iterator value="list" var="add">';
			
			jsonAdd=jsonAdd+'id${add.id}:';
			jsonAdd=jsonAdd+"{";
			
			jsonAdd=jsonAdd+'receivename:'+'"${add.receivename }",';
				
			jsonAdd=jsonAdd+'fulladdress:'+'"${add.fulladdress }",';
			jsonAdd=jsonAdd+'postalcode:'+'"${add.postalcode}",';
			jsonAdd=jsonAdd+'mobile:'+'"${add.mobile}",';
			jsonAdd=jsonAdd+'phone:'+'"${add.phone}",';
			jsonAdd=jsonAdd+"k:0},"
			
			jsonAdd=jsonAdd+'</s:iterator>'
			jsonAdd+="k:{k:0}}";
			jsonAdd=eval("("+jsonAdd+")");
			return jsonAdd;
		}
			$(function(){
				$("#chooseaddress").live("change",function(){
					//if($("#chooseaddress option:selected").prop("selected")==true){
						//alert($("#chooseaddress option:selected").val());
						location.href="<s:url value='/address/AddressAction_selectAddressByid'/>?id="+$("#chooseaddress option:selected").val();
					//}
				});
				
				
				
				//change(function(){
					//if($('select option:selected').prop(selected)==true){
						//alert($('select option:selected').val());
						//location.href="<s:url value='/address/AddressAction_selectAddressByid'/>?id="+$('select option:selected').val();
					//}
				//});
				
			});
		</script>
		<script type="text/javascript" src="../js/addressForm.js"></script>
		
	</head>
	<body>	
		<%@include file="head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 &gt;
			<span class="red_bold"> 2.填写送货地址</span>  &gt; 3.订单成功
		</div>
		<div class="fill_message">
			<p>选择地址：<select id='chooseaddress'>
				<option>新建地址</option>
				<s:iterator value="list" >
				<option value='<s:property value='id'/>'><s:property value='receivename'/></option>
				</s:iterator>
			</select>
			</p>
			<s:form name="ctl00" method="post" action="/order/OrderAction_createOrder" id="f" theme="simple">
				<s:token></s:token>
				<s:hidden name="address.id" value='' id="addressId"></s:hidden>
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<s:textfield name="address.receivename"  id="receiveName" cssClass="text_input"></s:textfield>
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名<br/>
									<span id="errName" class="infoError"><s:property value="errors['address.receivename']"/></span>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<s:textfield name="address.fulladdress" id="fullAddress" cssClass="text_input"></s:textfield>
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址<br/>
									<span id="errAddress" class="infoError"><s:property value="errors['address.fulladdress']"/></span>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
								<s:textfield name="address.postalcode" id="postalCode" cssClass="text_input"></s:textfield>
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码<br/>
									<span id="errPost" class="infoError"><s:property value="errors['address.postalcode']"/></span>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<s:textfield name="address.phone" id="phone" cssClass="text_input"></s:textfield>
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话<br/>
									<span id="errPhone" class="infoError"><s:property value="errors['address.phone']"/></span>
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机
						</td>
						<td>
							<s:textfield name="address.mobile" id="mobile" cssClass="text_input"></s:textfield>
							<div class="text_left" id="mobileValidMsg">
								<p>
									请填写有效的收件人的手机<br/>
									<span id="errMobile" class="infoError"><s:property value="errors['address.mobile']"/></span>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"
						type="button" value="取消"  onclick="location='${pageContext.request.contextPath}/cart/CartAction_showCart'"/>
					<s:submit id="btnClientRegister" cssClass="button_1" name="submit" value="下一步"></s:submit>
				</div>
			</s:form>
		</div>
		<%@include file="foot1.jsp"%>
	</body>
</html>

