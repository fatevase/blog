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
		<a class="item" href="index.jsp"  target="blank"">
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
				<a class="item" href="Admin/web-setting.jsp">
					<i class="setting icon"></i>
					设置
				</a>
			</div>
			
		<div class="pusher">
			<div class="ui padded segment">
				<h3 class="ui header">撰写新文章</h3>
			</div>
			<div class="ui grid row">
			<div class="row"></div>
			<div class="ui input row">
				<div class="column"></div>
				<input type="text" placeholder="标题" />
				<div class="column"></div>
			</div>

			<div class="row">
			<div class="column"></div>
				<div class="field">
					<textarea rows="30" cols="160" style="background: #FAFFE2;"></textarea>
				</div>
			</div>
			<div class="row">
				<div class="column"></div>
				<button class="ui compact button">保存草稿</button>
				<button class="ui primary button">发布文章</button>
			</div>
			<div class="row"></div>
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
		//
		$('.ui.accordion')
			.accordion()
		;
	</script>
</html>



