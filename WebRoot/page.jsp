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
				height: auto;
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
					<a class="active item" href="index.jsp">
						主页
					</a>
					<a class="item">
						归档
					</a>
					<a class="item">
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
         <div class="ui text container" style="width: 100%;">
	         <h1 class="ui center aligned container">Semantic UI Fixed Template</h1>
	         <p class="ui justified container">This is a basic fixed menu template using fixed size containers.</p>
	         <p class="ui justified container">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa strong. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede link mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi.</p>
  	     </div>
		<div class="ui justified container" style="margin-top: 50px;">
			<h3 class="ui head">评论</h3>
			<div class="">
			<p>{comments.author}<p>{comments.text}</p></p>
			</div>
			<div class="ui hidden divider"></div>
			<div class="">
				<p>{comments.author}<p>{comments.text}</p></p>
			</div>
		</div>
		<div class="ui justified container" style="margin-top: 50px;">
			<h3 class="ui head">添加评论</h3>
			<form class="ui form">
				<div class="field">
					<textarea></textarea>
				</div>
		<input class="fluid ui black button" value="添加" type="submit"/>
		</form>
      </div>	

	</div>

	</body>
	<script src="./Js/jquery.min.js" charset="utf-8"></script>
	<script src="./Js/semantic.min.js" charset="utf-8"></script>
</html>