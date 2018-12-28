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
		<s:if  test="#session.username==null || #session.uid == null || #session.username == '' 
					|| #session.uid < 1 || #session.groups != 'admin'" >
			<script>window.location.href="404.html";</script>
        </s:if>
	<body>
	<div class="ui top stackable attached inverted menu">        
		<a class="item left">
			<i class="sidebar icon"></i>
			菜单
		</a>
		<a class="item right" id="user-name">
			<s:property value="#session.username" />
		</a>
		<a class="item" onclick="SignOut()">
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
					<a href="GetAllUsers.action" class=" item">
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
				<div class="ui green  statistic">
				  <div id="essay-count" class="value">
				    
				  </div>
				  <div class="label">
				 	   总共文章
				  </div>
				</div>
				<div class="ui  blue statistic">
				  <div id="comment-count" class="value">
				    
				  </div>
				  <div class="label">
				 	   总共评论
				  </div>
				</div>
				
			</div>
			<div class="ui two column doubling stackable grid container">
				<div class="column ui basic segment">
					<h3 class="ui header">最近发布的文章</h3>
				<div id="lately-contents">
				</div>
				</div>
				<div class="column ui basic segment">
					<h3 class="ui header">最近的评论</h3>
				<div id="lately-commtents">
				</div>
				</div>
			</div>		
		</div>
		
	</div>

	</body>
	<script src="js/jquery.min.js" charset="utf-8"></script>
	<script src="js/semantic.min.js" charset="utf-8"></script>
	<script src="js/ajax.js" charset="utf-8"></script>
	<script type="text/javascript">
	$(document).ready(function() { 
			$.ajax({
			  type: 'POST',
			  url: "ShowBackendIndex.action",
			  data: {"action":'getCountIndex'},
			  success:function(data){
			  	  FillCounts(data);
			  }
			});
						
		  $.ajax({
			  type: 'POST',
			  url: "ShowBackendIndex.action",
			  data: {"action":'getContentsIndex'},
			  success:function(ContentsIndex){
			  	  for(var i in ContentsIndex){	  	
	  				FillLatelyContents(ContentsIndex[i]);
				  }
			  }
			});
				
		
		   $.ajax({
			  type: 'POST',
			  url: "ShowBackendIndex.action",
			  data: {"action":'getCommentsIndex'},
			  success:function(CommentsIndex){
				for(var i in CommentsIndex){
	  				FillLatelyComments(CommentsIndex[i]);
				  }
			  }
			});

	}); 
	</script>
	
	<script>
		function FillCounts(content){ 		
				
				magic_number("#essay-count",content.TotalContents);
				magic_number("#comment-count",content.TotalComments);
				//$("#essay-count").html(content.TotalContents);
				//$("#comment-count").html(content.TotalComments);
			
		}
		function FillLatelyComments(content){ 
			var divString = '<p>'+content.created+'<a>'+content.text+'</a></p>';				
			$("#lately-commtents").append(divString);
		
		}
		function FillLatelyContents(content){ 
			var divString = '<p>'+content.created+'<a>'+content.title+'</a></p>';			
			$("#lately-contents").append(divString);
		
		}
		
		function magic_number(id,value) {   
			var num = $(id);   num.animate({count: value}, {     duration: 1000,     
			step: function() {       num.text(Math.round(this.count));       }  
			}); 
		};
	</script>
	<script>
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

