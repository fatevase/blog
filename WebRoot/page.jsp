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
			@media screen and (max-width:991px){#main-page{width:100%;height:100%;margin-top:-10px;}}/*宽度小于px时*/
			@media screen and (min-width:991px){#main-page{width:50%;margin-top: 15px;}}
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
		
		<div class="computer only three wide column leftcontent" style="padding-left: 0px;padding-top: 0px;padding-right: 0px;">
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
					<a href="archive.jsp" class="item">
						归档
					</a>
					<a href="tags.jsp" class="item">
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

		<div class="ui segment" style="background:#ffffff;" id="main-page">
         <div class="ui text container" style="width: 100%;">
       		 <s:iterator value="all_page"  var="content">
	       		 <p hidden="hidden" id="cid">${content.cid}</p>
		         <h2 class="ui center aligned container header"">${content.title} </h2>
		         <p class="ui center aligned tiny sub header">作者:${content.username} | 时间:${content.created}</p>
		         <p class="ui justified container">${content.text} </p>
	         </s:iterator>
  	     </div>
		<div class="ui justified container comments" style="margin-top: 50px;">
			<h3 class="ui dividing header">评论</h3>
			
			<span id="username">
				<s:if  test="#session.username!=null && #session.uid!=null && #session.username!='' && #session.uid>0" >
					登陆身份：<s:property value="#session.username" />
		        </s:if>
	        </span>
				<s:else>
	        <a href="Sign/sign-in.jsp">登陆</a>
	        	</s:else>

			<s:iterator value="all_comments"  var="comment">
			<div class="comment">
				<a class="avatar" >
     				<img src="imgs/head.jpg" style="width:auto;height:auto;">
    			</a>
					  <div class="content">
					      <a class="author">${comment.username}</a>
					      <div class="metadata">
					        <span class="date">${comment.created}</span>
					      </div>
					      <div class="text">
					        ${comment.text}
					      </div>
					      <div class="actions">
					        <a class="reply" id="reply-${comment.coid}">Reply</a>
					      </div>
					  </div>
			</div>			
		    </s:iterator>
		</div>
		
  		<form class="ui reply form" id="comment-form" action="" method="post">
  			 
		    <div class="field">
		    <div class="ui error message"></div>
		      <textarea id="commentvalue" name="commentvalue"></textarea>
		    </div>
			<button class="fluid ui black submit button" onclick="PostComment()">评论</button>
		  </form>
</div>

</div>

	</body>
	<script src="./js/jquery.min.js" charset="utf-8"></script>
	<script src="./js/semantic.min.js" charset="utf-8"></script>
	<script src="./js/validate.js" charset="utf-8"></script>
		<script src="js/ajax.js" charset="utf-8"></script>
	<script>
		$('.ui.accordion').accordion();
	
	function PostComment() {
		var commentvalue = $('#comment-form').find('#commentvalue').val();
		var cid = $('#cid').html();
		var username = $('#username').text().trim();
			var ret = /^(([^\^\.<>%&',;=?$"':#@!~\]\[{}\\/`\|])*)$/;
		if(commentvalue.length>0 && ret.test(commentvalue)) {
			if(username.length>8) {
				$.ajax({
				  type: 'POST',
				  url: "PostComment.action",
				  data: {"cid":cid,"comment_text":commentvalue},
				  success:function(data){
					  if(data>0){
				  	  	window.location.reload();
				  	  }else {
				  	  	window.location.href="404.html";
				  	  	alert("评论失败,错误代码："+data);
				  	  }
					  }
			});
		} else {
			alert("你还未登陆，暂时不能评论哦~");
		}
		}
	}
	</script>
</html>