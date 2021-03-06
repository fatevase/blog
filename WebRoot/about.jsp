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
		<title>MyWeb index</title>
		<link rel="stylesheet" type="text/css" href="Css/semantic.min.css">
		<link rel="stylesheet" type="text/css" href="Css/index.css">
		<script src="Js/jquery.min.js" charset="utf-8"></script>

	</head>
	<body>


	<!-- Page Contents -->
	<div class="pusher">
		<div class="ui inverted vertical masthead center aligned segment">

			<div class="ui container">
				<div class="ui large secondary inverted pointing menu">
					<a class="active item">主页</a>
					<a href="#Introduced" class="item">介绍</a>
					<a href="#About" class="item">关于</a>
					<div class="right item">
						<a class="ui inverted button" href="Sign/sign-in.html">登录</a>
						<a class="ui inverted button" href="Sign/sign-up.html">注册</a>
					</div>
				</div>
			</div>

			<div class="ui text container">
				<h1 class="ui inverted header">
					假定一个公司
				</h1>
				<h2>你想做的时候就去做</h2>
				<div class="ui huge primary button">开始 <i class="right arrow icon"></i></div>
			</div>

		</div>

		<div id="Introduced" class="ui vertical stripe segment">
			<div class="ui middle aligned stackable grid container">
				<div class="row">
					<div class="eight wide column">
						<h3 class="ui header">We Help Companies and Companions</h3>
						<p>We can give your company superpowers to do things that they never thought possible. Let us delight your customers and empower your needs...through pure data analytics.</p>
						<h3 class="ui header">We Make Bananas That Can Dance</h3>
						<p>Yes that's right, you thought it was the stuff of dreams, but even bananas can be bioengineered.</p>
					</div>
					<div class="six wide right floated column">
						<img src="assets/images/wireframe/white-image.png" class="ui large bordered rounded image">
					</div>
				</div>
				<div class="row">
					<div class="center aligned column">
						<a class="ui huge button">Check Them Out</a>
					</div>
				</div>
			</div>
		</div>


		<div id="About" class="ui vertical stripe quote segment">
			<div class="ui equal width stackable internally celled grid">
				<div class="center aligned row">
					<div class="column">
						<h3>"What a Company"</h3>
						<p>That is what they all say about us</p>
					</div>
					<div class="column">
						<h3>"I shouldn't have gone with their competitor."</h3>
						<p>
							<img src="assets/images/avatar/nan.jpg" class="ui avatar image"> <b>Nan</b> Chief Fun Officer Acme Toys
						</p>
					</div>
				</div>
			</div>
		</div>

		<div class="ui vertical stripe segment">
			<div class="ui text container">
				<h3 class="ui header">Breaking The Grid, Grabs Your Attention</h3>
				<p>Instead of focusing on content creation and hard work, we have learned how to master the art of doing nothing by providing massive amounts of whitespace and generic content that can seem massive, monolithic and worth your attention.</p>
				<a class="ui large button">Read More</a>
				<h4 class="ui horizontal header divider">
					<a href="homepage.php#">Case Studies</a>
				</h4>
				<h3 class="ui header">Did We Tell You About Our Bananas?</h3>
				<p>Yes I know you probably disregarded the earlier boasts as non-sequitur filler content, but its really true. It took years of gene splicing and combinatory DNA research, but our bananas can really dance.</p>
				<a class="ui large button">I'm Still Quite Interested</a>
			</div>
		</div>


		<div class="ui inverted vertical footer segment">
			<div class="ui container">
				<div class="ui stackable inverted divided equal height stackable grid">
					<div class="three wide column">
						<h4 class="ui inverted header">关于</h4>
						<div class="ui inverted link list">
							<a href="homepage.php#" class="item">Sitemap</a>
							<a href="homepage.php#" class="item">Contact Us</a>
							<a href="homepage.php#" class="item">Religious Ceremonies</a>
							<a href="homepage.php#" class="item">Gazebo Plans</a>
						</div>
					</div>
					<div class="three wide column">
						<h4 class="ui inverted header">服务</h4>
						<div class="ui inverted link list">
							<a href="homepage.php#" class="item">Banana Pre-Order</a>
							<a href="homepage.php#" class="item">DNA FAQ</a>
							<a href="homepage.php#" class="item">How To Access</a>
							<a href="homepage.php#" class="item">Favorite X-Men</a>
						</div>
					</div>
					<div class="seven wide column">
						<h4 class="ui inverted header">页脚</h4>
						<p>Extra space for a call to action inside the footer that could help re-engage users.</p>
					</div>
				</div>
			</div>
		</div>
	</div>

	</body>
	</html>