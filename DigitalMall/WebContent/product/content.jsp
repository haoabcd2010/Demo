<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/product/css/content.css" type="text/css"></link>
<%@ taglib uri='/struts-tags' prefix='s'%>
<div class="content_header">
	<span>购物</span>
	<div class="bottom_line"></div>
	<div class="book_content">
	<div class="image">
			<img alt="" src="../images/computer/<s:property value='product.imagepath'/>"/>
		</div>
		<div class="book_right">
			<div class="name"><s:property value="product.name"/></div>
			<div class="author"><s:property value='product.soncategory'/></div>
			<div class="publisher"><s:property value='product.descp'/></div>
			<div class="price">
				优惠价:￥<s:property value='product.myprice'/>
			</div>
			<ul>
			  <li>处理器： <s:property value='product.professor'/> </li>
			  <li>内存： <s:property value='product.memory'/> </li>
			  <li>硬盘： <s:property value='product.disk'/> </li>
			  <li>显卡： <s:property value='product.Graphics'/> </li>
			  <li>显示器： <s:property value='product.monitor'/> </li>
			  <li>发布时间： <s:property value='product.publishtime'/> </li>
			</ul>
		</div>
		<b>
			<img  src="${pageContext.request.contextPath}/product/images/booksale.gif" class='go'>
			<span style='display:none'><s:property value="product.id"/></span>
		</b>
	</div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.min.js"></script> 
 <script type="text/javascript">
	$(document).ready(function(){
		 var imag=$(".go");
		 for(var i=0;i<imag.length;i++){
			$(imag.get(i)).click(function(){
				var j=$(this);
				var xhr=new XMLHttpRequest();
				xhr.open("post","${pageContext.request.contextPath}/cart/CartAction_addCart");
				xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
				xhr.send("productid="+$(this).next().text());
				$(this).attr("src","${pageContext.request.contextPath}/category/images/load.gif");
				xhr.onreadystatechange=function(){
					if(xhr.readyState==4&&xhr.status==200){
						var ret=xhr.responseText;
						window.setTimeout(function(){
							j.attr("src","${pageContext.request.contextPath}/category/images/label3.gif");
						}, 500);
						
						window.setTimeout(function(){
							j.attr("src","${pageContext.request.contextPath}/category/images/gouwu.gif");
						
						}, 2000);
					}
				}
			});
		}
	});
</script>
