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
			
		<div class="padded segment pusher">			
			<div class=" ui padded segment">
					<h2 class="ui header">管理文章	<a class="ui compact button" href="Admin/write.jsp">新增</a>	</h2>
					<div class="ui grid row">
						 <div class="nine wide column"></div>
							<div class="seven">
								<form class="ui action left icon input right" id="search-form">
								<i class="search icon"></i>
								<input type="text" id="search-value" name="search" placeholder="搜索..." />
								<select class="ui dropdown label" id="search-type" name="search_type">
									<option value="title" class="item">标题</option>
									<option value="classify" class="item">分类</option>
								</select>
								<div class="ui teal button" onclick="SearchContent('search_form')">搜索</div>
								</form>
							</div>	
						</div>
						
								<div class="ui grid row" >
									<div class="mini ui compact buttons" >
									  <button id="show-all-content" class="ui button active" onclick="SearchContent('search_form')">所有</button>
									  <button id="show-my-content" class="ui button " onclick="SearchContent('search_switch_myself')">我的</button>
									</div>
								</div>
						
				</div>
			
				
		<div class="ui grid row">
			<table class="ui bottom attached table">
				<thead>
					<tr><th>标题</th>
					<th>作者</th>
					<th>分类</th>
					<th>时间</th>
					<th>操作</th>
				</tr></thead>
				<tbody id="show-content">

				</tbody>
		  </table>
	</div>
	</div>
	
		<div class="ui small basic modal"  id="change-windows">
	    <div class="ui icon header" id="change-windows-head">
	      <i class="archive icon"></i>
	      	删除文章:
	    </div>
	    <div class="content">
	      <p>你确认要删除这篇文章吗？这可能导致该文章和该文章下的评论无法找回</p>
	    </div>
	    <div class="actions">
	      <div class="ui red basic cancel inverted button">
	        <i class="remove icon"></i>
	        	否
	      </div>
	      <div class="ui green ok inverted button">
	        <i class="checkmark icon"></i>
	       		 是
	      </div>
	    </div>
	  </div>
		
	</div>

</body>
	<script src="./js/jquery.min.js" charset="utf-8"></script>
	<script src="./js/semantic.min.js" charset="utf-8"></script>
		<script src="js/ajax.js" charset="utf-8"></script>
	<script>
		$(document).ready(function() { 
			$.ajax({
			  type: 'POST',
			  url: "ShowContents.action",
			  data: {},
			  success:function(data){
			  	  for(var i in data){
	  				FillContents(data[i]);
				  }
			  }
			});
	}); 

		$(' .ui.sidebar')
			.sidebar({
				context: $('.labeled.segment')
			}).sidebar('attach events', '.menu .left').sidebar('hide');
		$(' .ui.sidebar')
			.sidebar({
				context: $('.labeled.segment')
			})
			.sidebar('attach events', '.menu .left');
		//
		$('.ui.accordion')
			.accordion()
		;
		
		function DeleteConfirm(cid) {
		$('#change-windows-head').html('<i class="archive icon"></i>删除文章：');
		$('#change-windows-head').append($('#content_'+cid).find('td').eq(0).text());
			$('#change-windows')
				.modal({
					closable  : false,
					onDeny    : function(){
						return true;
					},
					onApprove : function() {
						DeleteContent(cid)
							return true;
					}
				})
				.modal('show');
		}
		
		function DeleteContent(cid) {
			$.ajax({
			  type: 'POST',
			  url: "DeleteContent.action",
			  data: {"contents.cid":cid},
			  success:function(data){
		  	  window.location.href="Admin/manage-text.jsp";
			  }
			});
		}
		
		function SearchContent(seek) {
			 search_json = {};
			if(seek=='search_form') {
				search_json.search_value = $("#search-form").find("#search-value").val();
				search_json.search_type = $("#search-form").find("#search-type").val();
				search_json.search_fuzzy = true;
			} else if(seek=='search_switch_myself') {
				$("#show-all-content").removeClass("active");
				search_json.search_value = $("#user-name").text().trim();
				search_json.search_type = 'username';
				search_json.search_fuzzy = false;
			}
			$("#search-form").find("#search-value").val("");
			$.ajax({
			  type: 'get',
			  url: "SearchContents.action",
			  data: search_json,
			  success:function(data){
			  	$("#show-content").html(" ");
			  	for(var i in data){
		  	  	FillContents(data[i]);
			  	}

			  }
			});
		}
		
		function FillContents(content){ 
			//alert(content.title+"  "+content.created);
			var divString = '<tr id="content_'+content.cid+'">'+
						'<td ><a href="Admin/write.jsp?cid='+content.cid +
						'">'+content.title+'</a></td>'+
						'<td >'+content.username+'</td>'+
						'<td >'+content.classify+'</td>'+
						'<td >'+content.created+'</td>'+
						'<td ><i onclick="DeleteConfirm('+content.cid+')" '+
						'class=" large red trash icon"></i></td></tr>';
						
			$("#show-content").append(divString);
		
		}
		
	</script>
</html>

