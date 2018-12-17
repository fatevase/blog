<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'failure.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" >
	<script src="js/bootstrap.min.js"></script>
  </head>
  <body>

  <div class="alert alert-warning"> 用户名或密码输入错误！</div> 
    <div class="alert alert-warning"> 
    	您输入的用户名: <%=(String)session.getAttribute("username") %>
    	,密码:<%=(String)session.getAttribute("passwd") %>.</div>
    	<p>以上使用session方法</p>
  </body>
</html>
