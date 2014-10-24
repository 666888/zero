<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html class="ie6"> <![endif]-->
<!--[if IE 7 ]>    <html class="ie7"> <![endif]-->
<!--[if IE 8 ]>    <html class="ie8"> <![endif]-->
<!--[if IE 9 ]>    <html class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html><!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>苏比克登陆</title>
<meta name="description" content="苏比克" />
<meta  name="keywords" content="苏比克" />
<!--[if lt IE 9]><script>/*@cc_on'abbr article aside audio canvas details figcaption figure footer header hgroup mark meter nav output progress section summary time video'.replace(/\w+/g,function(n){document.createElement(n)})@*/</script><![endif]-->
<link rel="stylesheet" href="/static/css/player/login/reset.css">
<link rel="stylesheet" href="/static/css/player/login/0a94a3be.css">
<link href="/static/css/player/index.css" rel="stylesheet" type="text/css" />
<link href="/static/css/player/login/nivo.slider.css" rel="stylesheet" type="text/css" />
<script type = "text/javascript" src = "/static/js/jquery-1.8.0.min.js"></script>
<script type = "text/javascript" src = "/static/js/jquery.nivo.slider.pack.js"></script>
<script type = "text/javascript">
$(document).ready(function(){
	$('#slider').nivoSlider({
		effect:'random',
		slices:15,
		animSpeed:500,
		pauseTime:3000,
		directionNav:true,
		controlNav:true,
		keyboardNav:true
	});
	
	if($("#flag").val() != ""){
		$("#hid").show();
		$("#hid2").hide();
	}	
});

function onover(){
	$("#t_drop").show();
}
function on(){
	$("#t_drop").hide();
}

function onout(){
	setTimeout("on()",2000);

}
</script>
</head>
<body >
<noscript>您的浏览器不支持JS，将无法看到通过JS实现的效果</noscript>
<!--nav star-->
<!--V2 star-->
<!--top star-->
	<div class="topcont" id = "hid" style = "display:none">
		<div class="topbar">
			<div class="wrap_w clearfix">
				<div class="top_r">
					<div class="logined clearfix">
						<div id="change_drop" class="user_box" style="z-index: 999">
							<span> 
							 <i class="user_p" onmouseover="onover()" onmouseout= "onout()"> <img width="25" height="25"
									src="http://p1.yx-s.com/detphoto.jpg" >
									
							</i> 
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
							</span>
							<a class="username" href="/p/message"><%= request.getAttribute("pName")%></a>
						</div>
						
						<div class="msg_box">
							<a 
								href="javascript:void(0)"> <i></i>
								消息
							</a> <a class="total_msg" style="display: none;"
								href="javascript:void(0)"> <span></span>
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
<!--top star-->
<div class="topcont" id = "hid2">
    <!--topbar star-->
    <div class="topbar">
        <div class="wrap_w clearfix">
        
            <div class="top_r">
                               <div id="no_log" class="nologin">
                    <div class="yxlogin_text">
                        <a href="signup" class="free_regist free_regist_focus--">免费注册</a>
                        <label class="auto_log" for="auto_log">
                            <input checked="checked" type="checkbox" name="" id="auto_log" value="" class="">自动登录
                        </label>
						</div>
						<div id="y-login" class="yxlogin_conn" style="display: block;">
						<sf:form method="post" action = "/signin" modelAttribute="player">
							<ul>
								<li>
									<div class="yxform_in">
										<i class="iuser"></i>
										<sf:input class="ipt" path="code" placeholder="登录名" maxlength="20"/><sf:errors path="code" />
									</div>
								</li>
								<li>
									<div class="yxform_in">
										<i class="ipwd"></i>
										<sf:password  path="password" placeholder="密码" maxlength="20" class="ipt"/><sf:errors path="password" />
									</div>
								</li>
								<li class="login_err" style="display:block">
									<div class="txt logintip" style="display: none;"></div>
								</li>
							</ul>
							<input type="submit" class="yxlogin_btn submit_login" value="登录">
							</sf:form>
							
							<div class="yxlogin_fgt">
								<a href="javascript:void(0)">忘记密码?</a>
							</div>
							 
						</div>
                    
                </div>
                            </div><!-- top_r end -->
        </div>
    </div>
    <!--topbar end-->
    <!--mygame star-->
    <div class="mygame" id="mygame" style="display:none">
        <div class="mygame_w">
                     <div class="myplay no_log" style="">
                <dl>
                    <dt>我正在玩</dt>
                </dl>
                <div class="nologbg">登录后游仔才知道<br />您在玩的游戏哟～</div>
            </div>
                        <div class="myrecom">
                <dl>
                    <dt>游仔推荐</dt>
                                                            <dd>
                        <a target="_blank" href="http://cbtx.subic888.com/list/zone.html">
                        <img width="58" height="58" src="http://p5.yx-s.com/t01667c9574fee1527c.png" />
                        <span class="yx_tit">称霸天下</span>
                        </a>
                    </dd>
                                        <dd>
                        <a target="_blank" href="http://fkys.subic888.com/list/zone.html">
                        <img width="58" height="58" src="http://p6.qhimg.com/t01795d19e8d2d315db.jpg" />
                        <span class="yx_tit">疯狂勇士</span>
                        </a>
                    </dd>
                                        <dd>
                        <a target="_blank" href="http://hg.subic888.com/gamezone.html">
                        <img width="58" height="58" src="http://p9.yx-s.com/t01f54874986fd690da.png" />
                        <span class="yx_tit">黑暗之光</span>
                        </a>
                    </dd>
                                        <dd>
                        <a target="_blank" href="http://xy.subic888.com/">
                        <img width="58" height="58" src="http://p7.yx-s.com/t018be3c79365ea304f.png" />
                        <span class="yx_tit">血饮传说</span>
                        </a>
                    </dd>
                                        <dd>
                        <a target="_blank" href="http://sglw.subic888.com/list/zone.html">
                        <img width="58" height="58" src="http://p6.qhimg.com/t01f7f1245cecd853ec.png" />
                        <span class="yx_tit">真三国乱舞</span>
                        </a>
                    </dd>
                                        <dd>
                        <a target="_blank" href="http://qtol.subic888.com/list/zone.html">
                        <img width="58" height="58" src="http://p3.qhimg.com/t01e059fb98449da8a7.jpg" />
                        <span class="yx_tit">奇天</span>
                        </a>
                    </dd>
                                    </dl>
            </div><!--myrecom end-->
        </div>
    </div>
    <!--mygame end-->
</div>
<!--top end-->
<div class="theme-default">
	<div id="slider" class="nivoSlider">
		<a href="javascript:;"><img src="/static/img/player/login/a_1.png" width="960" height="366" /></a>
		<a href="javascript:;"><img src="/static/img/player/login/b_1.png" width="960" height="366" /></a>
		<a href="javascript:;"><img src="/static/img/player/login/c_1.png" width="960" height="366" /></a>
	</div> 
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
		<p>*点击下载按键将在您的电脑上安装约为10MB的Windows兼容型娱乐软件，使您可在我们的Subic.com平台上注册并玩游戏。此应用程序可通过Windows平台上的删除程序选项完全卸载。卸载后，软件的功能不会保留。</p>
		<br />
		<p>2014版权所有<a href="javascript:;">Subic.com</a></p>
		
		<p>在菲律宾注册并遵守菲律宾法律</p>
	</div>
	<input type="hidden" id="flag" value="${pName}" />
<!--footer end-->


</body>
</html>

