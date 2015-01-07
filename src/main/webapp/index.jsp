﻿<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/cdn/player/css/format.css" />
<link rel="stylesheet" href="/cdn/player/css/index.css" />
<link rel="stylesheet" href="/cdn/player/css/0a94a3be.css" />
<link rel="stylesheet" href="/cdn/player/css/reset.css" />
<!--  
<script src="http://libs.baidu.com/jquery/1.8.3/jquery.min.js"></script>
<script >
	// Fallback to loading jQuery from sina path if the baidu's CDN is unavailable
	(window.jQuery || document.write('<script src="http://lib.sinaapp.com/js/jquery/1.8.3/jquery.min.js"><\/script>'));
</script>
<script>
  // Fallback to loading jQuery from a local path if the CDN is unavailable
  (window.jQuery || document.write('<script src="/cdn/jquery-1.8.3.min.js"><\/script>'));
</script>
-->
<script type="text/javascript" src="/cdn/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/cdn/p/a.js"></script>
<script type="text/javascript" src="/cdn/player/js/main_banner.js"></script>
<title>Asia</title>


<script type="text/javascript">
	$(function(){
		$("#btn-s").click(function(){
			var code = $("#code").val();
			var password = $("#password").val();

			var cfg = {
					url: 'http://localhost:8080/p/signin0.ajax',
			        type: 'POST', 
			        data: JSON.stringify({code:code,password:password}), 
			        dataType: 'JSON',
			        contentType:'application/json;charset=UTF-8', 
			        error:function(XMLHttpRequest, textStatus, errorThrown) {
			        	//alert(XMLHttpRequest.status);
			        	//alert(XMLHttpRequest.readyState);
			        	//alert(textStatus);
			        	alert("请求失败!");
			        },
			        success: function(result) { 
			        	alert("已成功！");
			            alert(result.success); 
			        } 
			    };
			$.ajax(cfg);
		});
	});
	
	
	function chk(){		
		if($("#code").val()=="")
		{
			$("#tips").html("<font color='red'>用户名不能为空！</font>");
			return false;
		}
	
		if($("#password").val()=="")
		{
			$("#tips").html("<font color='red'>密码不能为空！</font>");
			return false;
		}
		$("#tips").html("");
		return true;
	}
	
</script>
</head>
<body>
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
							 <i class="user_p" onmouseover="onover()" onmouseout= "onout()"> 
							 	<img width="25" height="25" src="/cdn/img/q.jpg" />
							</i> 
							<div id="t_drop" class="tools_box" style="z-index: 999; display: none;">
								<ul>
									<li><a href="/p/message"
										target="_blank"> <i class="acc_infro"></i> 帐号资料
									</a></li>
									<li><a href="/p/message?flag=upd_flag" target="_blank"><i class="mode_code"></i>修改密码</a></li>
									
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
                        <a href="/p/signup" class="free_regist free_regist_focus--">免费注册</a>
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
	

	
	<div id="navigation">
		<div id="hd_cn">
			<ul>
				<li class="hd_sy"><a href="/index.html">首页</a></li>
				<li><a href="javascript:setIframeSrc('inc','live.html')">真人娱乐</a></li>
				<li><a href="javascript:setIframeSrc('inc','phone.html')">电话投注</a></li>
				<li><a href="javascript:setIframeSrc('inc','promote.html')">优惠活动</a></li>
				<li><a href="javascript:setIframeSrc('inc','franchise.html')">合作加盟</a></li>
				<li><a href="http://www.agg000.net" target="_blank">代理登陆</a></li>
				<li class="hd_zxkf"><a target="_blank" href="http://dkb.duokebo.com:8080/webchat/chat.aspx?siteid=898591">在线客服</a></li>
			</ul>
		</div>
	</div>
	
		<div id="content">
		<iframe id="inc" src="indx.html" width="100%" onload="Javascript:SetCwinHeight('inc')" frameBorder="0" scrolling="no">
			
		</iframe>
		</div>
	
	
	<div id="footer">
			<div id="lgs"></div>
			<div id="rls">
				<p>
					<a href="javascript:setIframeSrc('inc','/cdn/player/help_center/u_about.html')">关于我们</a>
					<a href="javascript:setIframeSrc('inc','/cdn/player/help_center/u_url.html')">备用网址</a>
					<a href="javascript:setIframeSrc('inc','/cdn/player/help_center/u_user.html')">用户协议</a>
					<a href="javascript:setIframeSrc('inc','/cdn/player/help_center/u_priv.html')">隐私政策</a>
					<a href="javascript:setIframeSrc('inc','/cdn/player/help_center/u_duty.html')">游戏责任</a>
					<a href="javascript:setIframeSrc('inc','/cdn/player/help_center/u_faq.html')">常见问题</a>
					<a href="javascript:setIframeSrc('inc','/cdn/player/help_center/u_rela.html')">联系我们</a>
				</p>
			</div>
	</div>
</body>
</html>