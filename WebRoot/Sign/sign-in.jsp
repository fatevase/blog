<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    	<base href="<%=basePath%>">
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
		<title>登录</title>
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
		<s:if  test="#session.username != null && #session.uid != null && #session.username != '' && #session.uid > 0" >
			<s:if test="#session.groups == 'admin'">
				<script>window.location.href="Admin/index.jsp";</script>
			</s:if>
			<s:else>
				<script>window.location.href="index.jsp";</script>
			</s:else>
        </s:if>
        
	<body>
	<div class="ui middle aligned center aligned grid">
	  <div class="column">
	    <h2 class="">
				<div class="content">
					<s:if test="#request.ErrorCode == -1">登陆失败！重新登陆 </s:if>
					<s:else>
						登录你的账号
　					 </s:else>
 				
				</div>
			</h2>
			
				<form class="ui large form" id="sign-form" action="SignIn.action" method="post">
					<div class="ui stacked segment">		
						<div class="field">
							<div class="ui left icon input">							
								<i class="user icon"></i>
								<input type="text" id="username" name="user.username" placeholder="用户名">
							</div>
						</div>
						<div class="field">
							<div class="ui left icon input">
								<i class="lock icon"></i>
								<input type="password" id="password" name="user.password" placeholder="密码">
							</div>
						</div>
						<div class="field">
							<input type="submit" class="ui secondary fluid button" value="登录">
						</div>
					</div>

					<div class="ui error message"></div>

				</form>

				<div class="ui message">
					还没有账号？ <a href="Sign/sign-up.jsp">注册</a> 
				</div>
			</div>
		</div>
	</body>
	
	<script src="js/jquery.min.js" charset="utf-8"></script>
	<script src="js/semantic.min.js" charset="utf-8"></script>
	<script src="js/validate.js" charset="utf-8"></script>
	<script src="js/util.js" charset="utf-8"></script>
</html>

