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
    
		<meta charset="UTF-8">
		<title>后台管理</title>
		<link rel="stylesheet" type="text/css" href="css/semantic.min.css">
	</head>
	<body>
	<div class="ui top stackable attached inverted menu">
		<a class="item left">
			<i class="sidebar icon"></i>
			菜单
		</a>
		<a class="item right">
			{username}
		</a>
		<a class="item">
			<i class="sign out icon"></i>
			登出
		</a>
		<a class="item" href="index.jsp"  target="blank">
			<i class="home icon" ></i>
			主站
		</a>
	</div>
	
		<div class="ui attached labeled icon segment pushable">
			<div class="ui visible inverted left vertical sidebar accordion menu">
				<a href="Admin/index.jsp" class="item">
					<i class="browser icon"></i>
					控制台
				</a>
				<a class="item" href="Admin/write.jsp">
					<i class="write icon"></i>
					文章撰写
				</a>
				<div class="item">
					<i class="tasks icon"></i>
					<a  class="active title">	
					 管理 </a>
					<div class="active content">
					<a href="Admin/manage-users.jsp" class=" item">
						用户管理
					</a>
					<a href="Admin/manage-text.jsp" class="item">
						文章管理
					</a>
					</div>
				</div>
				<a class="item">
					<i class="setting icon"></i>
					设置
				</a>
			</div>
			
		<div class="padded segment pusher">
			<div class=" ui padded segment">
					<h2 class="ui header">网站设置</h2>	
					<div class="ui grid row">
					 <div class="nine wide column"></div>
					</div>
		</div>
			

	
		<div class="ui grid row">
		<form style="margin-left:50px" class="ui form" action="InstallAction.action" method="post">
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
		 <p ><input  class="ui green button" type="submit" value="提交"/></p>
		    </form>
		    <div>
		    
		    <a href="InstallAction.action?action=test">test databases</a>
		    <p>控制台输出</p>
		    <div style="overflow :yes;overflow :auto;overflow-y :yes;overflow-y :auto;height:200px;width:400px;background:#1E90FF;color:#ffffff">
		    
		  		<%if(request.getAttribute("msg")!=null){ %>
				<s:iterator value="#request.msg.split('\n')" status="st" var="as">
		  		<p>---<s:property value="#as"/></p>		
				</s:iterator>
		 		 <%} %>
		  </div>
		  </div>
		</div>
		</div>
		
	</div>

	</body>
	<script src="js/jquery.min.js" charset="utf-8"></script>
	<script src="js/semantic.min.js" charset="utf-8"></script>
	<script>
	/*
	// showing multiple
	$('.visible .ui.sidebar')
		.sidebar({
			context: '.visible .bottom.segment'
		})
		.sidebar('hide');
		*/
		// using context
		$(' .ui.sidebar')
			.sidebar({
				context: $('.labeled.segment')
			})
			.sidebar('attach events', '.menu .left');
		
	</script>
</html>

