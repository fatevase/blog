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
		<title>主页</title>
		<link rel="stylesheet" type="text/css" href="./css/semantic.min.css">
		<style type="text/css">
			body {
				background-color: #F5F7F9;
				border-top: 3px solid #000000;			
				}
			body > .grid {
				height: 100%;
				margin:0px;
				padding: 0px;
			}
			.column {
			background-color: #ffffff;
			max-width: 85%;	
			}
			.leftcontent {
				margin-right: 20px;
				max-height: 480px;
				
				
			}
			.segment > p {
				padding-left: 30px;
				padding-right: 30px;
			}
			.ui.segment {
				border-radius: 0px;
			}
			.column {
					margin-top: 14px;
					padding-top: 0px;	
			}

		</style>
	</head>
	<body>
	<div class="ui aligned center aligned grid allcontent" >
		
		<div class="three wide column leftcontent" style="padding-left: 0px;padding-top: 0px;padding-right: 0px;">
			<div class="ui inverted segment">
				<h1 class="ui center aligned header">
					论坛主页
					<p class="sub header" style="color: #A5A5A5;">my web</p>
				</h1>
			</div>
			<div>
				<div class="ui vertical fluid tabular menu" >
					<a class=" item" href="index.jsp">
						主页
					</a>
					<a href="archive.jsp" class="active item">
						归档
					</a>
					<a href="tags.jsp" class="item">
						分类
					</a>
				</div>
			<div class="ui transparent icon left input right">
			<i class="search icon"></i>
				<input type="text" placeholder="搜索...">		
			</div>
			</div>
				<div class="ui inverted card" style="border-radius: 0px;margin-top: 50px;">
								<div class="content">
									<div class="header">fate vase</div>
								</div>
								<div class="content">
									<h4 class="ui sub header">怪唉</h4>
									<div class="ui small feed">
										<div class="event">
											<div class="content">
												<div class="summary">
													 some introduction
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="extra content">
									admin
								</div>
			</div>
		</div>
	
		<div class="eight wide column" >
			<div class="ui vertical segment">
				<p class="ui center aligned container"><a href="page.jsp" class="ui header">{text.title}</a><p>
				<p class="ui center aligned container"><a class="ui sub header">{text.time}</a><p>
				<p class="ui left aligned container">{text.content}<p>
			</div>
			
			<div class="ui vertical segment pagecard">
				<p class="ui center aligned container"><a href="page.jsp" class="ui header">{text.title}</a><p>
				<p class="ui center aligned container"><a class="ui sub header">{text.time}</a><p>
				<p class="ui left aligned container">{text.content}<p>
			</div>

			
		</div>
		
		
		
	</div>

	</body>
	<script src="./Js/jquery.min.js" charset="utf-8"></script>
	<script src="./Js/semantic.min.js" charset="utf-8"></script>
</html>