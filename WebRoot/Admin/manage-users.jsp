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
				<a class="item"  href="Admin/web-setting.jsp">
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
							<form class="ui action left icon input right" id="search">
							<i class="search icon"></i>
							<input type="text" name="search" placeholder="搜索..." />
							<select class="ui dropdown label" name="search_type">
								<option value="1" class="item">用户名</option>
								<option value="2" class="item">电子邮箱</option>
								<option value="3" class="item">用户组</option>
							</select>
							<div class="ui teal button" >搜索</div>
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
							<tr>
								<td><a id="user-name">{username}</a></td>
								<td>{usermail}</td>
								<td>{usergroup}</td>
								<td>{landtime}</td>
							</tr>
							<tr>
								<td><a >{username}</a></td>
								<td>{usermail}</td>
								<td>{usergroup}</td>
								<td>{landtime}</td>
							</tr>
						</tbody>
				</table>		
			</div>
		</div>
		
		<div class="ui small modal" id="sign-windows">
			<div class="header">
				用户注册
			</div>
			<div class="content">
				<form class="ui large form" id="sign-form">
					<div class="ui stacked segment">		
						<div class="field">
							<div class="ui left icon input">
								<i class="user icon"></i>
								<input type="text" name="username" placeholder="用户名">
							</div>
						</div>
						<div class="field">
							<div class="ui left icon input">
								<i class="mail icon"></i>
								<input type="text" name="usermail" placeholder="邮箱">
							</div>
						</div>

						<div class="field">
							<div class="ui left icon input">
								<i class="lock icon"></i>
								<input type="password" name="password1" placeholder="密码">
							</div>
						</div>
						<div class="field">
							<div class="ui left icon input">
								<i class="lock icon"></i>
								<input type="password" name="password2" placeholder="再次密码">
							</div>
						</div>
					</div>

					<div class="ui error message" id="sign-form-error"></div>

				</form>

			</div>
			<div class="actions">
				<div class="ui red cancel button">取消</div>
				<div class="ui green ok button">确定</div>
			</div>
		</div>
		
		<div class="ui small modal" id="change-windows">
			<div class="header">
				修改用户
			</div>
			<div class="content">
				<form class="ui large form" id="sign-form">
					<div class="ui stacked segment">		
						<div class="field">
							<div class="ui left icon input">
								<i class="user icon"></i>
								<input type="text" name="username" placeholder="用户名">
							</div>
						</div>
						<div class="field">
							<div class="ui left icon input">
								<i class="mail icon"></i>
								<input type="text" name="usermail" placeholder="邮箱">
							</div>
						</div>

						<div class="field">
							<div class="ui left icon input">
								<i class="lock icon"></i>
								<input type="password" name="password1" placeholder="密码">
							</div>
						</div>
						<div class="field">
							<div class="ui left icon input">
								<i class="lock icon"></i>
								<input type="password" name="password2" placeholder="再次密码">
							</div>
						</div>
					</div>

					<div class="ui error message" id="sign-form-error"></div>

				</form>

			</div>
			<div class="actions">
				<div class="ui red cancel button">取消</div>
				<div class="ui green ok button">确定</div>
			</div>
		</div>
		
	</div>

	</body>
	<script src="js/jquery.min.js" charset="utf-8"></script>
	<script src="js/semantic.min.js" charset="utf-8"></script>
	<script src="js/validate.js" charset="utf-8"></script>
	<script>

		// using context
		$(' .ui.sidebar')
			.sidebar({
				context: $('.labeled.segment')
			})
			.sidebar('attach events', '.menu .left');
		
		
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
		
		$("#user-name").click(function(){
			$('#change-windows')
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

		;
	</script>
</html>

