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
				<h3 class="ui header">撰写新文章</h3>
			</div>
			<div class="ui grid row">
			<div class="row"></div>
			<div class="ui input row">
				<div class="column"></div>
				<input id="title" type="text" placeholder="标题" />
				<select id="classify" class="ui dropdown label" name="classify">
					<option value="unclassified">未分类</option>
					<option value="随笔">随笔</option>
					<option value="编程">编程</option>
					<option value="资源共享">资源共享</option>
				</select>
				<div class="column"></div>
			</div>

			<div class="row">
			<div class="column"></div>
				<div class="ui fluid container field">
					<textarea id="text" style="height: 357px;width: 88%;heigth:500px;margin-left: 6%;background: #FAFFE2;"></textarea>
				</div>
			</div>
			<div class="row">
				<div class="column"></div>
				<!--  --><button class="ui compact button">重写</button>
				<button class="ui primary button" onclick="AddContent()">发布文章</button>
			</div>
			<div class="row"></div>
			</div>
	
		</div>
		
	</div>

	</body>
	<script src="js/jquery.min.js" charset="utf-8"></script>
	<script src="js/semantic.min.js" charset="utf-8"></script>
	<script src="js/ajax.js" charset="utf-8"></script>
	<script src="js/util.js" charset="utf-8"></script>
	<script type="text/javascript">
	$(document).ready(function() { 
		var cid = getUrlParam("cid");
		if(cid != null)
			$.ajax({
			  type: 'POST',
			  url: "WritePrepare.action",
			  data: {"contents.cid":cid},
			  success:function(data){
			  	if(data.cid > 0) {
					$("#title").attr("value",data.title);     
		  			$("#text").html(data.text);
					$("#text").find("option[value="+data.classify+"]").attr("selected",true);
				}
			  }
			});
	}); 
	</script>
	<script>
		$(' .ui.sidebar')
			.sidebar({
				context: $('.labeled.segment')
			})
			.sidebar('attach events', '.menu .left').sidebar('hide');
		//
		$('.ui.accordion')
			.accordion()
		;
		function AddContent() {
			var text = $("#text").val();
			var title = $("#title").val();
			var classify = $('#classify option:selected').val();
			if(text.length<1||title.length<1||classify.length<1) {
				alert("标题，内容不能为空哦");
			} else {
				var cid = getUrlParam("cid");
				if(cid==null) cid=0;
				$.ajax({
					  type: 'POST',
					  url: "PostContent.action",
					  data: {"contents.cid":cid,"contents.title":title,"contents.text":text,"contents.classify":classify},
					  success:function(data){
					  	if(data.addContentMsg == 1) {
					  		window.location.href="Admin/manage-text.jsp";
					  	} else {
					  		alert("发表失败！错误码"+data.addContentMsg);
					  	}
					  }
				});
			}
			
		}
	</script>
</html>



