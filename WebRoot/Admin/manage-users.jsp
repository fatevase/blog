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
			
		<div class="padded segment pusher dimmer">
			<div class=" ui padded segment">
				<h2 class="ui header">用户管理</h2>
				<a class="ui compact button" id="create-button">新增</a>	
				<div class="ui grid row">
					 <div class="nine wide column"></div>
						<div class="seven">
							<form class="ui action left icon input right" action="SearchUsers.action" method="post" id="search-form">
							<i class="search icon"></i>
							<input type="text" name="search_value" id="search-value" placeholder="搜索..." />
							<select class="ui dropdown label" id="search-type" name="search_type">
								<option value="username" class="item">用户名</option>
								<option value="mail" class="item">电子邮箱</option>
								<option value="groups" class="item">用户组</option>
							</select>
							<div class="ui teal button" onclick="SearchUser()">搜索</div>
							</form>
						</div>					
					</div>
			</div>
				
			<div class="ui grid row">
				<table class="ui bottom attached table">
						<thead>
							<tr><th>用户名</th>
							<th>电子邮箱</th>
							<th>用户组</th>
							<th>登录时间</th>
						</tr></thead>
						<tbody>
						    <s:iterator value="all_users"  var="m1">
							 <tr id="user_${m1.uid}" onclick="FillChangeForm(${m1.uid})">
								<td><a id="user-name">${m1.username}</a></td>
								<td id="mail">${m1.mail}</td>
								<td id="groups">${m1.groups}</td>
								<td id="activated">${m1.activated}</td>
							</tr>
							</s:iterator>
						</tbody>
				</table>		
			</div>
		</div>
		
		<div class="ui small modal" id="sign-windows">
		<i class="close icon"></i>
			<div class="header">
				用户注册
			</div>
			<div class="content">
				<form class="ui large form" id="sign-form" action="AddUser.action" method="post">
					<div class="ui stacked segment">		
						<div class="field">
							<div class="ui left icon input">
								<i class="user icon"></i>
								<input type="text" id="username" name="user.username" placeholder="用户名">
							</div>
						</div>
						<div class="field">
							<div class="ui left icon input">
								<i class="mail icon"></i>
								<input type="text" id="usermail" name="user.mail" placeholder="邮箱">
							</div>
						</div>
						<div class="field">
								<select class="" name="user.groups">
									<option value="visitor" class="item">访问者</option>
									<option value="editor" class="item">编辑</option>
									<option value="admin" class="item">管理员</option>
								</select>
						</div>
						<div class="field">
							<div class="ui left icon input">
								<i class="lock icon"></i>
								<input type="password" id="password1" name="user.password" placeholder="密码">
							</div>
						</div>
						<div class="field">
							<div class="ui left icon input">
								<i class="lock icon"></i>
								<input type="password" id="passowrd2" name="password2" placeholder="再次密码">
							</div>
						</div>
					</div>

					<div class="ui error message" id="sign-form-error"></div>

				</form>

			</div>
			<div class="actions">
				<div class="ui red cancel button">取消</div>
				<div class="ui green ok button">确认</div>
			</div>
		</div>
		
		<div class="ui small modal" id="change-windows">
		<i class="close icon"></i>
			<div class="header">
				 修改用户 
			</div>
			<div class="content">
				<form class="ui large form" action="ChangeUser.action" method="post" id="change-form">
					<input type="hidden" id="change-uid" name="user.uid" placeholder="用户名">
					<div class="ui stacked segment">		
						<div class="field">
							<div class="ui left icon input">
								<i class="user icon"></i>
								<input type="text" id="change-username" name="user.username" placeholder="用户名">
							</div>
						</div>
						<div class="field">
							<div class="ui left icon input">
								<i class="mail icon"></i>
								<input type="text" name="user.mail" placeholder="邮箱">
							</div>
						</div>
						<div class="field">
								<select class="" name="user.groups">
									<option value="" class="item">--用户权限--</option>
									<option value="visitor" class="item">访问者</option>
									<option value="editor" class="item">编辑</option>
									<option value="admin" class="item">管理员</option>
								</select>
						</div>
						<div class="field">
							<div class="ui left icon input">
								<i class="lock icon"></i>
								<input type="password" name="user.password" placeholder="修改密码，默认为空是不进行修改">
							</div>
						</div>
						<div class="field">
							<div class="ui left icon input">
								<i class="lock icon"></i>
								<input type="password" name="password2" placeholder="再次输入密码">
							</div>
						</div>
					</div>

					<div class="ui error message" id="change-form-error"></div>

				</form>

			</div>
			<div class="ui left icon actions ">
			<i class=" large red trash icon" onclick="ConfirmDeleteUser()"></i>
			
				<div class="ui red cancel button">取消</div>
				<div class="ui green ok button">修改</div>
			</div>
		</div>
		
	</div>

	</body>
	<script src="js/jquery.min.js" charset="utf-8"></script>
	<script src="js/semantic.min.js" charset="utf-8"></script>
	<script src="js/validate.js" charset="utf-8"></script>
	<script src="js/ajax.js" charset="utf-8"></script>
	<script>

		// using context
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
		
		
		$("#create-button").click(function(){
			$('#sign-windows')
				.modal({
					closable  : false,
					onDeny    : function(){
						return true;
					},
					onApprove : function() {
						$("#sign-form").submit();
						if(("#sign-form-error").attr.length>0) {
							return false;
						} else {
							 window.alert("尝试创建用户");
						}
					}
				})
				.modal('setting', 'transition', 'scale')
				.modal('toggle', '.ui .modal')
			;

		});
		
		$("tr[id^='user_']").click(function(){
			$('#change-windows')
				.modal({
					closable  : false,
					onDeny    : function(){
						return true;
					},
					onApprove : function() {
						$("#change-form").submit();
						if(("#change-form-error").attr.length>0) {
							return false;
						} else {
							 window.alert("尝试修改用户");
						}
					}
				})
				.modal('setting', 'transition', 'scale')
				.modal('toggle', '.ui .modal')
			;

		});

		
	</script>
	<script>
		function FillChangeForm(id) {
		    user_name = $("#user_"+id).find("#user-name").text();
		    user_mail = $("#user_"+id).find("#mail").text();
		    user_groups = $("#user_"+id).find("#groups").text();
		  	$("#change-form").find("input[name='user.username']").attr("value",user_name);     
		  	$("#change-form").find("input[name='user.mail']").attr("value",user_mail);
			$("#change-form").find("option[value="+user_groups+"]").attr("selected",true);
			$("#change-form").find("input[name='user.uid']").attr("value",id);
		}
		
		function AddUser() {
			
		}
		 
		 function ConfirmDeleteUser() {
			user_id = $("#change-form").find("#change-uid").val();
			user_name = $("#change-form").find("#change-username").val();
			if(confirm("您确定要删除用户名为'"+user_name+"'的用户吗?")) {
				DeleteUser(user_id);
			}	
		}
		function DeleteUser(uid) {
			$.ajax({
			  type: 'POST',
			  url: "DeleteUser.action",
			  data: {"user.uid":uid},
			  success:function(data){
		  	  window.location.href="GetAllUsers.action";
			  }
			});
		}
		
		function SearchUser() {
			search_value = $("#search-form").find("#search-value").val();
			search_type = $("#search-form").find("#search-type").val();
			$("#search-form").submit();
			/*$.ajax({
			  type: 'POST',
			  url: "SearchUsers.action",
			  data: {"search_type":search_type,"search_value":search_value},
			  success:function(data){
		  	  window.location.reload();
			  }
			});*/
		}
	</script>
</html>

