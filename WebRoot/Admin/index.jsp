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
				<a href="Admin/web-setting.jsp" class="item">
					<i class="setting icon"></i>
					设置
				</a>
			</div>
			
		<div class="pusher">
			<div class="ui padded segment">
				<h3 class="ui header">网站概述</h3>
				<p>总共文章有{text.count}.</p>
				<p>总共评论有{commit.count}.</p>
			</div>
			<div class="ui two column doubling stackable grid container">
				<div class="column ui basic segment">
					<h3 class="ui header">最近发布的文章</h3>
					<p>{time}<a>{title}</a></p>
					<p>{time}<a>{title}</a></p>
				</div>
				<div class="column ui basic segment">
					<h3 class="ui header">最近的评论</h3>
					<p>{time}<a>{commit}</a></p>
					<p>{time}<a>{commit}</a></p>
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
		//
		$('.ui.accordion')
			.accordion()
		;
	</script>
</html>

