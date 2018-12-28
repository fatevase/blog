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
			@media screen and (max-width:991px){#all-tags{width:100%;height:100%;margin-top:-10px;}}/*宽度小于px时*/
			@media screen and (min-width:991px){#all-tags{width:50%;margin-top: 15px;}}
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
		
		<div class="computer only three wide column leftcontent" style="padding-left: 0px;padding-top: 0px;padding-right: 0px;">
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
					<a href="archive.jsp" class="item">
						归档
					</a>
					<a href="tags.jsp" class="active item">
						分类
					</a>
				</div>
			<div class="ui transparent icon left input right">
			<i class="search icon"></i>
				<input type="text" name="search" placeholder="搜索...">		
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
													 一个简单的期末作业 ~O(∩_∩)O
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="extra content">
									<s:if  test="#session.username!=null && #session.uid!=null && #session.username!='' && #session.uid>0" >
										<s:property value="#session.username" />,<a onclick="SignOut()">注销</a>
							        </s:if><s:else>
							        	<a href="Sign/sign-in.jsp">登陆</a>
							        </s:else>
								</div>
			</div>
		</div>
		
		<div class="tablet only mobile only ui inverted segment row">
		  <div class="ui inverted accordion" style="width:100%">
		  
		    <div class="ui inverted center aligned header active title" style="">
		      	 主  菜 单
		    </div>
		      <div class="ui center aligned header vertical borderless inverted  menu content " style="font-size:1em;width:100%">
				  <a class="item" href="index.jsp">主页</a>
				  <a class="item" href="archive.jsp">归档</a>
				  <a class="item" href="tags.jsp">分类</a>
			 </div>
		  </div>
		</div>
	
		<div class="" style="background:#ffffff;" id="all-tags" >
			<div class="ui vertical segment" style="margin-left:20px">
				<div class="ui header">分类</div>
				<div class="ui horizontal statistic">
				  <div class="value" id="CotentTotal-1">
				    0
				  </div>
				  <div class="label">
				    <a href="index.jsp">随笔</a>
				  </div>
				</div>
				<div class="ui horizontal statistic">
				  <div class="value" id="CotentTotal-2">
				    0
				  </div>
				  <div class="label">
				    <a href="index.jsp">编程</a>
				  </div>
				</div>
				<div class="ui horizontal statistic">
				  <div class="value" id="CotentTotal-3">
				   	0
				  </div>
				  <div class="label">
				    <a href="index.jsp">资源共享</a>
				  </div>
				</div>
			</div>
		</div>
		
		
		
	</div>

	</body>
	<script src="js/jquery.min.js" charset="utf-8"></script>
	<script src="js/semantic.min.js" charset="utf-8"></script>
	<script src="js/ajax.js" charset="utf-8"></script>
	<script>
		$('.ui.accordion').accordion();
	
		$(document).ready(function() { 
			$.ajax({
			  type: 'POST',
			  url: "ShowTag.action",
			  data: {"action":"GetContentsTotal","ActionEntry.CotentTotal_1":'随笔'
			  ,"ActionEntry.CotentTotal_2":'编程',"ActionEntry.CotentTotal_3":'资源共享'},
			  success:function(data){
			  	  FillCounts(data);
			  }
			});
		});
		
		function FillCounts(content){ 		
			magic_number("#CotentTotal-1",content.CotentTotal_1);
			magic_number("#CotentTotal-2",content.CotentTotal_2);
			magic_number("#CotentTotal-3",content.CotentTotal_3);
		}
		
		function magic_number(id,value) {   
			var num = $(id);   num.animate({count: value}, {     duration: 2000,     
			step: function() {       num.text(Math.round(this.count));       }  
			}); 
		};
	</script>
</html>