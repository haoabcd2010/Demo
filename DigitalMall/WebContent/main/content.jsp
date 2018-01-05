<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri='/struts-tags' prefix='s'%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/main/css/content.css"
	type="text/css"></link>
<div class="content">
	<div class="content_left">
		<div class="category">
			<h2>分类浏览</h2>
			<div class="category_item">
				<s:action name="CategoryAction_showAll" namespace="/category" executeResult="false" var='ca'></s:action>
				<s:iterator value='#ca.list'>
					<s:set var='pid' value='id' scope='request' />
					<h3>
						<a
							href="<s:url value='/category/CategoryAction_showProductByCategory'/>?pid=<s:property value='id'/>&currentPage=1">[<s:property value='name' />]</a>
					</h3>
					<s:iterator value='children'>
					<ul>
						<a href="<s:url value='/category/CategoryAction_showProductByCategory'/>?pid=<s:property value='#request.pid'/>&cid=<s:property value='id'/>&currentPage=1"><s:property
										value='name' />
						</a>
					</ul>
					</s:iterator>
				</s:iterator>

				<div class="bottom_line"></div>
			</div>
		</div>
	</div>
	<div class="content_center">
		<div class="center_category">
			<h2>
				卖家推荐
			</h2>
			<s:action name="ProductAction_showProductByedit" namespace='/product' executeResult='false' var='edit'></s:action>
				<s:iterator value='#edit.list'>
				<div class="center_item_tj">
					<div class="center_item_tj_img">
						<img alt="" src="../images/computer/<s:property value='imagepath' />" />
					</div>
					<div class="center_item_tj_content">
						<h3>
							<a
								href="<s:url value='/product/ProductAction_showProductById'/>?proid=<s:property value='id'/>"
								target="_blank"><s:property value='name' />
							</a>
						</h3>
						<h4>
							<span><s:property value='soncategory' /></span> <br /> <span><s:property
									value='descp' />&nbsp;
							</span>
						</h4>
						<h6>
							<del>原价：￥<s:property value='price' /></del>&nbsp;&nbsp;优惠价：￥<s:property value='myprice' />
						</h6>
						<div class="bottom_line"></div>
					</div>
				</div>
			</s:iterator>
		</div>
		<div class="center_category">
			<h2>
				热销商品
			</h2>
			<s:action name="ProductAction_showProductBysale" namespace='/product' executeResult='false' var='sale'></s:action>
			<s:iterator value='#edit.list'>
				<div class="center_item_tj">
					<div class="center_item_tj_img">
						<img alt="" src="../images/computer/<s:property value='imagepath' />" />
					</div>
					<div class="center_item_tj_content">
						<h3>
							<a
								href="<s:url value='/product/ProductAction_showProductById'/>?proid=<s:property value='id'/>"
								target="_blank"><s:property value='name' />
							</a>
						</h3>
						<h4>
							<span><s:property value='soncategory' /></span> <br /> <span><s:property
									value='descp' />&nbsp;
							</span>
						</h4>
						<h6>
							<del>原价：￥<s:property value='price' /></del>&nbsp;&nbsp;优惠价：￥<s:property value='myprice' />
						</h6>
						<div class="bottom_line"></div>
					</div>
				</div>
			</s:iterator>
		</div>
		</div>
	
	</div>