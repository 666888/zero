<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>main</title>
<link rel="stylesheet" href="/cdn/player/css/format.css" />
<link rel="stylesheet" href="/cdn/player/css/index.css" />
<link rel="stylesheet" href="/cdn/player/css/regist.css" />
<script type="text/javascript" src="/cdn/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function() {  
		$('#kaptchaImage').click(  
			function() {  
				$(this).hide().attr('src','/pub/kaptcha?'+ Math.floor(Math.random()*100)).fadeIn();  	
			});  
	});  
	//前端验证
	function check(){
		return true;
		alert("uuuu");
		var isExist;
		var code = $("#code");
		$.ajax({
			type:"POST",
			url:"/p/verifyCode.ajax",
			data:{code:$("#code").val()},
			dataType:"json"
			success:function (data){
				alert(data);
			}
		});
		return false;
	}
</script>

</head>

<body>
	<div id="r_top">
		<div id="r_tp_cn" class="clear">
			<div id="r_lo"></div>
			<ul id="r_tp_r" class="clear">
				<li><a class="bz" href="javascript:;">使用帮助</a></li>
				<li><a class="btn" href="javascript:;"></a></li>
			</ul>
		</div>
	</div>
	<div id="r_bn"><img width="980" height="155" src="/cdn/player/images/ba_2.png" /></div>
	<ul id="r_tit">
		<li class="r_tit_1">注册SUBIC账户</li>
		<li class="r_tit_2">注册SUBIC账户，您将会领略到前所未有的博彩体验。如果您已拥有SUBIC账户，则可&nbsp;<a href="/">在此登录</a></li>
	</ul>
	<sf:form action="/p/signup" method="post" modelAttribute="player">
		<table class="r_tab">
			<tr>
				<td width="98" class="r_tab_f">用户账号：</td>
				<td width="338"><sf:input id="code" type="text" class="r_tab_inp" path="code"/></td>
				<td class="r_tab_m">注意：所有账号前面会加上『O8』。请填写4至8个英文字母和数字组合</td>
				<sf:errors path="code" />
			</tr>
			<tr>
				<td class="r_tab_f">账号密码：</td>
				<td><sf:input id="password" type="password" class="r_tab_inp" path="password"/></td>
				<td class="r_tab_m">由数字或者字母组成的6-16位</td>
				<sf:errors path="password"/>
			</tr>
			<tr>
				<td class="r_tab_f">确认密码：</td>
				<td><input id="passwd" type="password" class="r_tab_inp" /></td>
				<td class="r_tab_m">与上次密码输入一致</td>
			</tr>
			<tr>
				<td class="r_tab_f">真实姓名：</td>
				<td><sf:input id="name" type="text" class="r_tab_inp" path="name"/></td>
				<td class="r_tab_m">真实姓名必须与提款银行账号相同才能办理提款</td>
				<sf:errors path="name"/>
			</tr>
			<tr>
				<td class="r_tab_f">电子邮箱：</td>
				<td><sf:input id="mail" type="text" class="r_tab_inp" path="email"/></td>
				<td class="r_tab_m">电子邮箱是取回密码和接受优惠活动信息的最重要途径之一</td>
			</tr>
			<tr>
				<td class="r_tab_f">验证码：</td>
				<td>
					<input type="text" id="valicode" class="r_tab_inp val_inp" name="valiCode"/>
					<div class="r_tab_ig"><img src="/pub/kaptcha" id="kaptchaImage" /></div>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td colspan="2">
				<!-- 
					<input class="r_tab_sub" type="submit" value="" onSubmit="return ckeck();"/>
 -->
					<input class="r_tab_sub" type="submit" value=""/>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td colspan="2" class="r_tab_xy">
					点击“立即注册”，即表示您同意并愿意遵守苏比克<a href="javascript:;">用户协议</a>和<a href="javascript:;">隐私条款</a>
				</td>
			</tr>
		</table>
	</sf:form>
	<div id="lgs"></div>
	<div id="rls">
			<p>
				<a href="javascript:;">关于我们</a>
				<a href="javascript:;">备用网址</a>
				<a href="javascript:;">用户协议</a>
				<a href="javascript:;">隐私政策</a>
				<a href="javascript:;">游戏责任</a>
				<a href="javascript:;">常见问题</a>
				<a href="javascript:;">联系我们</a>
			</p>
	</div>
	<!--<div id="crt">版权说明</div>-->
</body>
</html>
