<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<!--[if lt IE 7 ]> <html class="ie6"> <![endif]-->
<!--[if IE 7 ]>    <html class="ie7"> <![endif]-->
<!--[if IE 8 ]>    <html class="ie8"> <![endif]-->
<!--[if IE 9 ]>    <html class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html>
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>苏比克登陆</title>
<meta name="description" content="苏比克" />
<meta name="keywords" content="苏比克" />
<!--[if lt IE 9]><script>/*@cc_on'abbr article aside audio canvas details figcaption figure footer header hgroup mark meter nav output progress section summary time video'.replace(/\w+/g,function(n){document.createElement(n)})@*/</script><![endif]-->
<link rel="stylesheet" href="/static/css/player/login/reset.css">
<link rel="stylesheet" href="/static/css/player/login/0a94a3be.css">
<link href="/static/css/player/index.css" rel="stylesheet" type="text/css" />
<script type= "text/javascript" src = "/static/js/jquery-1.10.2.min.js"></script>
<script type = "text/javascript">
    $(".triangle").hover(function(){alert("鼠标移入我啦");},function(){alert("鼠标移出我啦!");});
    $("#a").hover(function(){alert("鼠标移入我啦");},function(){alert("鼠标移出我啦!");});
    function onover(){
    	var a = document.getElementById("t_drop");
    	a.style.display = "block";
    }
    function hidden(){
    	var a = document.getElementById("t_drop");
    	a.style.display = "none";
    }
    function onout(){
    	   setTimeout('hidden()',2000);
    	}
</script>

</head>
<body>
	<noscript>您的浏览器不支持JS，将无法看到通过JS实现的效果</noscript>
	<!--nav star-->
	<!--V2 star-->
	<!--top star-->
	<div class="topcont">
		<div class="topbar">
			<div class="wrap_w clearfix">
				<div class="top_r">
					<div class="logined clearfix">
						<div id="change_drop" class="user_box" style="z-index: 999">
							<span> <i class="user_p"> <img width="25" height="25"
									src="http://p1.yx-s.com/detphoto.jpg">
							</i> <a class="username" href="/p/message"><%= request.getAttribute("pName")%></a>
								<span class="triangle" style="cursor: pointer" onmouseover="onover()" onmouseout= "onout()"></span>
							</span>
							<div id="t_drop" class="tools_box"
								style="z-index: 999; display: none;">
								<ul>
									<li><a href="/p/message"
										target="_blank"> <i class="acc_infro"></i> 帐号资料
									</a></li>
									<li><a href="/p/message?flag=upd_flag" target="_blank"><i class="mode_code"></i>修改密码</a></li>
									<!-- <li><a href="#" target="_blank"><i class="sec_set"></i>安全设置</a></li>  -->
								</ul>
							</div>
						</div>
						<div class="msg_box">
							<a target="_blank"
								href="http://bbs.youxi.com/home.php?mod=space&do=pm"> <i></i>
								消息
							</a> <a class="total_msg" style="display: none;"
								href="http://bbs.youxi.com/home.php?mod=space&do=pm"> <span></span>
							</a>
						</div>
						<div class="exit_box">
							<a href="logout"> <i></i> 退出
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--top end-->
	<div style="text-align: center">
		<img src="/static/img/player/login/a.png" style=""><br />
		<img src="/static/img/player/login/b.png" style=""><br />
		<img src="/static/img/player/login/c.png" style="">
	</div>
	<!--footer star-->

	<div id="foot">
		<ul>
			<li><a href="javascript:;">关于我们</a></li>
			<li>&nbsp;|&nbsp;</li>
			<li><a href="javascript:;">隐私条款</a></li>
			<li>&nbsp;|&nbsp;</li>
			<li><a href="javascript:;">条款与规则</a></li>
			<li>&nbsp;|&nbsp;</li>
			<li><a href="javascript:;">公平游戏</a></li>
			<li>&nbsp;|&nbsp;</li>
			<li><a href="javascript:;">游戏责任声明</a></li>
			<li>&nbsp;|&nbsp;</li>
			<li><a href="javascript:;">常见问题</a></li>
		</ul>
		<p style="margin-top: 160px;">我们支持责任游戏</p>
		<p>在赢发让客户满意是我们的终极目标，我们不断地把在线娱乐服务与会员奖励更好的融合在一起。赢发品牌开发提供世界一流的娱乐城，扑克，宾果，社交游戏，刮刮卡，现场和移动版娱乐城。我们的锦标赛优惠活动，忠诚奖励计划是业内首屈一指的。在行业领先软件平台Playtech的支持下，您每次都会获得绝佳体验。直观的设计，极具魅力的画面和音效，再加上易于上手的操作，一定会带给你身临其境的感觉。马上注册成为赢发的一员。我们将会使用特定的浏览器cookies优化您的客户享用体验。使用本网站，意味着您将自动接受。我们仅会使用优化您服务体验的cookies，而不是可侵犯您隐私的cookies。</p>
		<br />
		<p>*点击下载按键将在您的电脑上安装约为10MB的Windows兼容型娱乐软件，使您可在我们的subic888.com平台上注册并玩游戏。此应用程序可通过Windows平台上的删除程序选项完全卸载。卸载后，软件的功能不会保留。</p>
		<br />
		<p>
			2014版权所有<a href="javascript:;">subic888.com</a>
		</p>

		<p>在菲律宾注册并遵守菲律宾法律</p>
	</div>
	<!--footer end-->


</body>
</html>

