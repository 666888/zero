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
</head>
<body >
<noscript>您的浏览器不支持JS，将无法看到通过JS实现的效果</noscript>
<!--nav star-->
<!--V2 star-->
   
<!--top star-->
<div class="topcont">
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
										<sf:input class="ipt" path="nickname" placeholder="登录名" maxlength="20"/><sf:errors path="nickname" />
									</div>
								</li>
								<li>
									<div class="yxform_in">
										<i class="ipwd"></i>
										<sf:password  path="password" placeholder="密码" maxlength="20" class="ipt"/><sf:errors path="nickname" />
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
                        <a target="_blank" href="http://cbtx.youxi.com/list/zone.html">
                        <img width="58" height="58" src="http://p5.yx-s.com/t01667c9574fee1527c.png" />
                        <span class="yx_tit">称霸天下</span>
                        </a>
                    </dd>
                                        <dd>
                        <a target="_blank" href="http://fkys.youxi.com/list/zone.html">
                        <img width="58" height="58" src="http://p6.qhimg.com/t01795d19e8d2d315db.jpg" />
                        <span class="yx_tit">疯狂勇士</span>
                        </a>
                    </dd>
                                        <dd>
                        <a target="_blank" href="http://hg.youxi.com/gamezone.html">
                        <img width="58" height="58" src="http://p9.yx-s.com/t01f54874986fd690da.png" />
                        <span class="yx_tit">黑暗之光</span>
                        </a>
                    </dd>
                                        <dd>
                        <a target="_blank" href="http://xy.youxi.com/">
                        <img width="58" height="58" src="http://p7.yx-s.com/t018be3c79365ea304f.png" />
                        <span class="yx_tit">血饮传说</span>
                        </a>
                    </dd>
                                        <dd>
                        <a target="_blank" href="http://sglw.youxi.com/list/zone.html">
                        <img width="58" height="58" src="http://p6.qhimg.com/t01f7f1245cecd853ec.png" />
                        <span class="yx_tit">真三国乱舞</span>
                        </a>
                    </dd>
                                        <dd>
                        <a target="_blank" href="http://qtol.youxi.com/list/zone.html">
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
<div style = "text-align: center"><img src = "/static/img/player/login/a.png" style = ""><br/><img src = "/static/img/player/login/b.png" style = ""><br/><img src = "/static/img/player/login/c.png" style = ""></div>
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
<!--footer end-->


</body>
</html>

