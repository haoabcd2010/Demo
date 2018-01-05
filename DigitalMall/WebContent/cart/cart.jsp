<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<title>乐购商城-购物车</title>
		<link href="<%=path %>/cart/css/book.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/cart/css/second.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/cart/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="<%=path %>/cart/css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src='../js/jquery-1.8.3.js'></script>
	<script type="text/javascript">
	$(function(){
		$(".change").live("click",function(){
			
			location.href="<s:url value='/cart/CartAction_updateCart'/>?productid=" + $(this).next("span").text()+"&"+"amount=" + $(this).prev("input").val();
		});
	})
</script>
	</head>
	<body>
		<br />
		<br />
		<div class="my_shopping">
			<img class="pic_shop" src="<%=path%>/cart/images/pic_myshopping.gif" />

		</div>
		
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">优惠价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>修改数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' >
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
					
                      <!-- 购物列表开始 -->
                      <s:iterator value='#session.cart.values()'>
                      <s:if test="status=='yes'">
						<tr class='td_no_bord'>
							<td style='display: none'>
								<s:property value='id'/>
							</td>
							<td class="buy_td_6">
								<span class="objhide"><img /> </span>
							</td>
							<td>
								<a href="<s:url value='/product/ProductAction_showProductById'/>?proid=<s:property value='id'/>" >
								<s:property value='name'/>
								</a>
							</td>
							<td class="buy_td_5">
								<span class="c_gray"><s:property value='price'/></span>
							</td>
							<td class="buy_td_4">
								&nbsp;&nbsp;
								<span><s:property value='dangdangprice'/>
								</span>
							</td>
							<td class="buy_td_1">
								&nbsp;&nbsp;<s:property value='amount'/>
							</td>

							<td >
								<input class="del_num" type="text" size="3" maxlength="4" id="num1" value=""/>
								<a href="javascript:;" class="change">变更</a><span style='display: none'><s:property value='id'/></span>
							</td>
							<td>
								<a href="<s:url value='/cart/CartAction_deleteCart'/>?productid=<s:property value='id'/>">删除</a>
							</td>
						</tr>
						</s:if>
						</s:iterator>
						
					
					<!-- 购物列表结束 -->
				</table>
				<div class="choice_balance">
					<div class="select_merch">
						<a href='<s:url value='/main/index.jsp'/>'> 继续挑选商品&gt;&gt;</a>
					</div>
					<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy"><s:property value='totaleconomy'/></span>
							</span>
							<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'><s:property value='totalaccount'/></span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='<s:url value='/order/OrderAction_showOrder'/>'> <img
									src="<%=path %>/cart/images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 用户删除恢复区 -->

 	
 		<s:if test="cartstatus2!='nothing'">
		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击“恢复”
			</div>
			 <s:iterator value='#session.cart.values()'>
			 <s:if test='status=="no"'>
			<table class=tabl_del id=del_table>
				<tbody>

				
					<tr>
						<td width="58" class=buy_td_6>
							
						</td>
						<td width="365" class=t2>
							<a href="<s:url value='/product/ProductAction_showProductById'/>?proid=<s:property value='id'/>"><s:property value='name'/></a>
						</td>
						<td width="106" class=buy_td_5>
							<s:property value='price'/>
						</td>
						<td width="134" class=buy_td_4>
							<span><s:property value='dangdangprice'/></span>
						</td>
						<td width="56" class=buy_td_1>
							<a href="<s:url value='/cart/CartAction_huifuCart'/>?productid=<s:property value='id'/>">恢复</a>
						</td>
						<td width="16" class=objhide>
							&nbsp;
						</td>
					</tr>
				


					<tr class=td_add_bord>
						<td colspan=8>
							&nbsp;
						</td>
					</tr>
					


				</tbody>
			</table>
			</s:if>
			</s:iterator>
		</div>
		</s:if>
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		
<link href="<%=path%>/cart/css/public_footer.css" rel="stylesheet" type="text/css" />
<div class="public_footer">
	<div class="public_footer_bottom">
		<div class="public_footer_icp" style="line-height: 48px;">
			Copyright (C) Happy_code, All Rights Reserved
		</div>
	</div>
</div>

		<!--页尾结束 -->
	</body>
</html>




