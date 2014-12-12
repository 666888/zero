<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<!--[if lt IE 7 ]> <html class="ie6"> <![endif]-->
<!--[if IE 7 ]>    <html class="ie7"> <![endif]-->
<!--[if IE 8 ]>    <html class="ie8"> <![endif]-->
<!--[if IE 9 ]>    <html class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html><!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>苏比克</title>
<meta name="description" content="">
<meta content="" name="keywords">
<!--[if lt IE 9]><script>/*@cc_on'abbr article aside audio canvas details figcaption figure footer header hgroup mark meter nav output progress section summary time video'.replace(/\w+/g,function(n){document.createElement(n)})@*/</script><![endif]-->
<link href="/cdn/player/signin/reset.css" type="text/css" rel="stylesheet">
<link href="/cdn/player/signin/style.css" type="text/css" rel="stylesheet">
<link href="/cdn/player/signin/login.css" type="text/css" rel="stylesheet">
</head><body>

<div class="wrap">
    <div style = "text-align: center"><a href="/index.html"><img src = "/static/img/player/index/logo.png" style = ""></a></div>
    <div class="login_page">
        <i class="tr"></i><i class="lb"></i>
        <input type="hidden" name="reg_ref" value="" />
        <!--reg star-->
        <div class="yxreg_conn clearfix">
            <div id='user_reg'>
				
				<div id="y-reg" class="yxlogin_conn" style="">
				<sf:form method="post" action = "/p/signin" modelAttribute="player">
				<ul>
					<li>
						<div id="usernametip" class="errtips"></div>
						<div class="yxform_in">
							<i class="iuser"></i>
							<sf:input class="ipt" maxlength="20" placeholder="登录名" path="code" />
							<div class="ipt_txt">登录名</div>
							<i class="iclose" style=""></i>
						</div>
						<sf:errors path="code" />
						<i class="iright" style="display:none"></i>
					</li>
					<li>
						<i class="ipwd"></i>
						<div id="passtip" class="errtips"></div>
						<div class="yxform_in">
							<i class="ipwd"></i>
							<sf:password class="ipt" maxlength="20" placeholder="密码" path="password" />
							<div class="ipt_txt">密码</div>
							<i class="iclose" style="display:none;"></i>
						</div>
						<sf:errors path="password" />
						<i class="iright" style="display:none"></i>
						<sf:errors />
					</li>
				</ul>
				
				<div id="checkreadtip" class="errtips"></div>
				<div class="yxlogin_read">
					<input id="checkread" class="ick" type="checkbox" checked="" name="checkread" value="">
						我已阅读并同意 subic888.com
					<a target="" href="javascript:void(0)">《用户协议》</a>
				</div>
				<input type="submit" class="yxlogin_btn submit_reg yxreg_btn" value="登陆">
				</sf:form>
				</div>
			</div>
        </div>
        <!--reg end-->
    </div>
</div>
<footer>
<p>Copyright 2014 subic.com 版权所有 2014版权所有subic888.com<br />在菲律宾注册并遵守菲律宾法律
</p>
</footer>
</body>
</html>

