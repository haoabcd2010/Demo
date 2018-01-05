<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/login/css/common.css" type="text/css"></link></head>
  	
  <body>
     <div class="containner" >
        <!-- 显示头 -->
     	<jsp:include page="header.jsp"/>
        <!-- 设置显示内容 -->
        <jsp:include page="content.jsp" />
        <!-- 设置 foot -->
        <jsp:include page="foot.jsp" />
     </div>
  </body>
</html>
