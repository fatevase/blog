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
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
		<title>注册</title>
		<link rel="stylesheet" type="text/css" href="css/semantic.min.css">
		<style type="text/css">
			body {
				background-color: #DADADA;
				
			}
			body > .grid {
				height: 100%;
			}
			.image {
				margin-top: -100px;
			}
			.column {
			max-width: 450px;	
			}
		</style>
	</head>
	<body>
		<div class="ui middle aligned center aligned grid">
			<div class="column">

				<h1 class="ui header">
					<div class="content">
					　<s:if test="#request.ErrorCode == -1">用户名‘${user.username}’已存在    </s:if>
					<s:elseif test="#request.ErrorCode == -2">
						　　登陆失败，请重新尝试
					</s:elseif>
					<s:else>
						欢迎你~
　					 </s:else>
					</div>
					<div class="sub header">注册你的账号</div>
				</h1>
				<form class="ui large form" id="sign-form" action="SignUp.action" method="post">
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
							<div class="ui left icon input">
								<i class="lock icon"></i>
								<input type="password" id="password1" name="user.password" placeholder="密码">
							</div>
						</div>
						<div class="field">
							<div class="ui left icon input">
								<i class="lock icon"></i>
								<input type="password" id="password2" name="password2" placeholder="再次密码">
							</div>
						</div>
						<input type="submit" class="ui secondary fluid button" value="注册">
					</div>

					<div class="ui error message">
					</div>

				</form>

				<div class="ui message">
					已有账号？ <a href="Sign/sign-in.jsp">登录</a>
				</div>
			</div>
		</div>

	</body>
	<script src="js/jquery.min.js" charset="utf-8"></script>
	<script src="js/semantic.min.js" charset="utf-8"></script>
	<script src="js/validate.js" charset="utf-8"></script>
	<script src="js/util.js" charset="utf-8"></script>
</html>