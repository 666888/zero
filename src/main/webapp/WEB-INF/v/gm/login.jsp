<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="zh"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="zh"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="zh"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="zh">
<!--<![endif]-->


<head>
<!-- General Metas -->
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="Web App Interface">
<meta name="author" content="Kevin">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Force Latest IE rendering engine -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">


<title>subic</title>
<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>			
		<![endif]-->

<!-- Mobile Specific Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1,maximum-scale=1" />

<!-- Stylesheets -->
<link rel="stylesheet" href="/cdn/gm/base.css">
<link rel="stylesheet" href="/cdn/gm/skeleton.css">
<link rel="stylesheet" href="/cdn/gm/layout.css">

</head>
<body>
	<div class="notice">
		<!--a href="" class="close">close</a-->
		<p class="warn">Web App Entry</p>
	</div>

	<!-- Primary Page Layout -->
	<section class="container" style="margin-top: 0px;">

		<div>
			<p><font color="red"></font></p>
			<p><font color="red"></font></p>	
		</div>
		<div class="form-bg">
			<sf:form id="login" action="/gm/signin" method="post"
				commandName="loginDetails">
				<h2>Login</h2>
				<p><sf:input type="text" path="code" placeholder="登录号" /></p>
				<p><sf:password path="password" placeholder="密码" /></p>
				<p style="margin:0px; padding-left: 30px;">
					<font color="red"><sf:errors path="code" /><sf:errors path="password" /><sf:errors />
					</font>
				</p>	
				<label for="remember">
					<input type="checkbox" id="remember" name="remember_me" value="remember" />
					<span>在此设备上记住我</span>
				</label> 
				<button type="submit"></button>
			</sf:form>

		</div>
		<p class="forgot">
			忘记密码? &nbsp<a href="">联系Subic.</a>
		</p>

	</section>
	<!-- container -->

	<section class="about">
		<p class="about-links">
		</p>
		<p>运营管理中心</p>
		<p class="about-author">
			&copy; 2014&ndash;2015 <a href="http://www.xxx.com"
				target="_blank">Asia Play Tech有限公司</a>
			<br> Original Dev by <a href="" target="_blank">Kevin</a>
		</p>
	</section>

	<!-- JS -->
	<script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
	<script type="text/javascript">
		//Fallback to loading jQuery from ajax CDN if the CDN is unavailable
		//http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js	
		(window.jQuery || document.write('<script src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.min.js"><\/script>'));
	</script>
	
	<script type="text/javascript">
	// Fallback to loading jQuery from a local path if the CDN is unavailable
	  (window.jQuery || document.write('<script src="/cdn/jquery-1.10.2.min.js"><\/script>'));
	</script>

	<!-- End Document -->
</body>
</html>
