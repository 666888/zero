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
<title>苏比克注册</title>
<meta name="description" content="">
<meta content="" name="keywords">
<!--[if lt IE 9]><script>/*@cc_on'abbr article aside audio canvas details figcaption figure footer header hgroup mark meter nav output progress section summary time video'.replace(/\w+/g,function(n){document.createElement(n)})@*/</script><![endif]-->
<link href="/static/css/player/regist/reset.css" type="text/css" rel="stylesheet">
<link href="/static/css/player/regist/style.css" type="text/css" rel="stylesheet">
<link href="/static/css/player/regist/login.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/static/js/jquery-1.8.0.min.js"></script>
</head><body>
<noscript>您的浏览器不支持JS，将无法看到通过JS实现的效果</noscript>
<div class="wrap">
    <div style = "text-align: center"><a href="http://www.subic888.com"><img src = "/static/img/player/index/logo.png" style = ""></a></div>
    <div class="login_page">
        <i class="tr"></i><i class="lb"></i>
        <input type="hidden" name="reg_ref" value="" />
        <!--reg star-->
        <div class="yxreg_conn clearfix">
            <div id='user_reg'>
				
				<div id="y-reg" class="yxlogin_conn" style="">
				<sf:form method="post" action = "/signup" modelAttribute="player" onsubmit="return che();">
				<ul>
					<li>
						<div id="codetip" class="errtips"></div>
						<div class="yxform_in">
							<i class="iuser"></i>
							<sf:input class="ipt" maxlength="20" placeholder="登录码" path="code" />
							<div class="ipt_txt">登陆码</div>
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
							<sf:password id="ps" class="ipt" maxlength="20" placeholder="密码" path="password" />
							<div class="ipt_txt">密码</div>
							<i class="iclose" style="display:none;"></i>
						</div>
						<sf:errors path="password" />
						<i class="iright" style="display:none"></i>
					</li>
					
					<li>												
						<div class="yxform_in">
							<i class="ipwd"></i>
							<input type = "password" id = "pss" class="ipt" maxlength="20" placeholder="确认密码" onBlur="che();"/>														
						</div>						
					</li>
					<li>
						<div id="usernametip" class="errtips"></div>
						<div class="yxform_in">
							<i class="iuser"></i>
							<sf:input class="ipt" maxlength="20" placeholder="真实姓名" path="username" />
							<div class="ipt_txt">真实姓名</div>
							<i class="iclose" style=""></i>
						</div>
						<sf:errors path="username" />
						<i class="iright" style="display:none"></i>
					</li>
					<li>
						<div id="phonetip" class="errtips"></div>
						<div class="yxform_in">
							<i class="iuser"></i>
							<sf:input class="ipt" maxlength="20" placeholder="电话" path="phone" />
							<div class="ipt_txt">联系电话</div>
							<i class="iclose" style=""></i>
						</div>
						<sf:errors path="phone" />
						<i class="iright" style="display:none"></i>
					</li>
					<li>
						<div id="qqtip" class="errtips"></div>
						<div class="yxform_in">
							<i class="iuser"></i>
							<sf:input class="ipt" maxlength="20" placeholder="QQ" path="qq" />
							<div class="ipt_txt">QQ</div>
							<i class="iclose" style=""></i>
						</div>
						<sf:errors path="qq" />
						<i class="iright" style="display:none"></i>
					</li>
					<li>
						<div id="emailtip" class="errtips"></div>
						<div class="yxform_in">
							<i class="iuser"></i>
							<sf:input class="ipt" maxlength="20" placeholder="Email" path="email" />
							<div class="ipt_txt">Email</div>
							<i class="iclose" style=""></i>
						</div>
						<sf:errors path="email" />
						<i class="iright" style="display:none"></i>
					</li>
					<li>
						<div id="extendurltip" class="errtips"></div>
						<div class="yxform_in">
							<i class="iuser"></i>
							<sf:input class="ipt" maxlength="20" placeholder="推广网址" path="extendURL" />
							<div class="ipt_txt">推广网址</div>
							<i class="iclose" style=""></i>
						</div>
						<sf:errors path="extendURL" />
						<i class="iright" style="display:none"></i>
					</li>
					<!-- 
					<li>
						<div id="repasstip" class="errtips"></div>
						<div class="yxform_in">
							<i class="ipwd"></i>
							<input class="ipt" type="password" maxlength="20" name="repass" placeholder="确认密码">
							<div class="ipt_txt">确认密码</div>
							<i class="iclose" style="display:none;"></i>
						</div>
						<i class="iright" style="display:none"></i>
					</li>
					<li class="yzm">
						<div id="captchatip" class="errtips"></div>
						<div class="yxform_in">
							<i class="iyzm"></i>
							<input class="ipt" type="text" maxlength="4" name="captcha" placeholder="验证码">
							<div class="ipt_txt">验证码</div>
						</div>
						<div class="yzmimg">
							<img class="vcode" width="112" height="40" src="http://captcha.subic888.com/image.php?app=subic888&r=0.7083599675090095">
							<a class="f5" href="javascript:void(0);">
								<i class="if5">刷新</i>
							</a>
						</div>
					</li> -->
				</ul>
				
				<div id="checkreadtip" class="errtips"></div>
				<div class="yxlogin_read">
					<input id="checkread" class="ick" type="checkbox" checked="" name="checkread" value="">
						我已阅读并同意 subic888.com
					<a href="javascript:void(0)">《用户协议》</a>
				</div>
				<input type="submit" class="yxlogin_btn submit_reg yxreg_btn" value="注册">
				</sf:form>
				</div>
			</div>
        </div>
        <!--reg end-->
    </div>
</div>
<footer>
<p>Copyright 2014 subic888.com 版权所有 2014版权所有subic.com<br />在菲律宾注册并遵守菲律宾法律
</p>
</footer>
<script type="text/javascript">
    function che(){
    	if($("#ps").val() != $("#pss").val()){
    		alert("密码不一致，请重新输入！");
    		return false; 
    	}
    	else{
    		return true;
    	}
    }
    
    $("#code").blur(function(){
    	var code = $(this).val();
    	//$.post("/modiNickname.ajax",{nickname:nickname},function(data,textStatus){if(textStatus=="success"){alert("昵称存在！");}},"json");
    	$.post("/verifyCode.ajax",{code:code},function(data,textStatus){console.log(data);if(!data){alert("code存在！");}},"json");
    });  
</script>
</body>
</html>

