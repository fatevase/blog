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
				<a class="item" href="Admin/web-setting.jsp" >
					<i class="setting icon"></i>
					设置
				</a>
			</div>
			
		<div class="padded segment pusher">
			<div class=" ui padded segment">
					<h2 class="ui header">管理文章</h2>
					<a class="ui compact button" href="Admin/write.jsp">新增</a>	
					<div class="ui grid row">
					 <div class="nine wide column"></div>
					<div class="seven">
						<form class="ui action left icon input right" id="search">
						<i class="search icon"></i>
						<input type="text" name="search" placeholder="搜索..." />
						<select class="ui dropdown label" name="search_type">
							<option value="1" class="item">标题</option>
							<option value="2" class="item">作者</option>
							<option value="3" class="item">分类</option>
						</select>
						<div class="ui teal button" >搜索</div>
						</form>
					</div>
						
					</div>
		</div>
			

	
		<div class="ui grid row">
			<table class="ui bottom attached table">
					<thead>
						<tr><th>标题</th>
						<th>作业</th>
						<th>分类</th>
						<th>时间</th>
					</tr></thead>
					<tbody>
						<tr>
							<td><a>{text.title}</a></td>
							<td>{text.author}</td>
							<td>{text.kinds}</td>
							<td>{text.time}</td>
						</tr>
						<tr>
							<td><a>{text.title}</a></td>
							<td>{text.author}</td>
							<td>{text.kinds}</td>
							<td>{text.time}</td>
						</tr>
					</tbody>
				</table>
		
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

