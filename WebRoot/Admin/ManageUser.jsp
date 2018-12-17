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
    
    <title>My JSP 'ManageUser.jsp' starting page</title>
    
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
    <a href="ShowUser.action" >ShowUser</a>
		<table border="1">
		  <tr>
		    <th>用户名</th>
		    <th>密码</th>
		    <th>最近登录时间</th>
		    <th>登录状态</th>
		    <th colspan="2">操作</th>
		  </tr>
		<s:iterator value="all_user"  var="m1">
		  <tr id="user_${m1.user_id}">
		    <td id="user_name">${m1.user_name}</td>
		    <td id="user_password">${m1.user_password}</td>
		    <td id="user_land_time">${m1.user_land_time}</td>
		    <td id="user_land_state">${m1.user_land_state}</td>
		    <td><button onclick="del(${m1.user_id})">删除</button></td>
		    <td><button onclick="change()">修改</button></td>
		  </tr>
		</s:iterator>
		</table>

  </body>
  <script>
  
  function del(id) {
  /*
  alert("this id ="+id);
  alert ("now get all html text<br/>"+
  "user_name="+$("#user_"+id).find("#user_name").text()+
    "<br/>user_password="+$("#user_"+id).find("#user_password").text()+
      "<br/>user_land_time="+$("#user_"+id).find("#user_land_time").text()+
      "<br/>user_land_state="+$("#user_"+id).find("#user_land_state").text());
      */
      if(confirm("确定要删除用户："+$("#user_"+id).find("#user_name").text()+"?")) {
      	$.ajax({
		  type: 'POST',
		  url: "DelUser.action",
		  data: {"user_id":id},
		  success: DelDisplay(id)
		});
      } else {
      	return false;
      }
      
  }
  
  function DelDisplay(id) {
  	alert("尝试删除"+id);
  }
  
  
  </script>
  
</html>
