<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery.js"></script>
  </head>
  
  <body>
    <form action="InstallAction.action" method="post">
    <p>
        数据库类型：<select name="database_type">
    		<option value="mysql" >Mysql 5.7</option>
    		<option value="sqlserver" >SQL Server</option>
    	</select>
    	</p>
    	<p>
 数据库地址:<input name="host" type="text"  value="localhost">
 </p>
 <p>
数据库端口:<input name="port" value="3306"  type="text">
</p>
<p>
数据库名称：<input name="database_name" type="text">
</p>
<p>
    登陆名：<input name="username" type="text" value="root"/>
    </p>
    <p>
 数据库密码：<input name="password" type="text" value="zhu980122"/>
 </p>
 <p><input type="submit" value="提交"/></p>
    </form>
    <div>
    <p>控制台输出</p>
    <a href="InstallAction.action?action=test">test databases</a>
    <div style="overflow :yes;overflow :auto;overflow-y :yes;overflow-y :auto;height:200px;background:#1E90FF;color:#ffffff">
    
  		<%if(request.getAttribute("msg")!=null){ %>
		<s:iterator value="#request.msg.split('\n')" status="st" var="as">
  		<p>---<s:property value="#as"/></p>		
		</s:iterator>
 		 <%} %>
  </div>
  </div>
  </body>
  <script>
  $(document).ready(function(){
  
 	});
 </script>
</html>
