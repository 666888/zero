<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<!-- saved from url=(0032)http://u.subic888.com/account/index -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户中心</title>
<link rel="stylesheet" type="text/css"
	href="/static/css/player/account/style.css">
<script type="text/javascript" src="/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="crypto.aes.js"></script>
<script type="text/javascript"
	src="/static/js/player/account/swfobject.js"></script>
<script type="text/javascript" src="/static/js/player/account/jquery.js"></script>
<script type="text/javascript" src="/static/js/player/account/common.js"></script>
<script type="text/javascript">
	$(function() {
		if ($("#upd_flag").val() == "upd") {
			$("#psw").show();
			$(window).scrollTop($(document).height() - $(window).height());
		}
	});
</script>
<!--[if IE 6]>
<script src="http://s1.yx-s.com/js/iepng.js" type="text/javascript"></script>
<script type="text/javascript">
EvPNG.fix('.icon1,.icon2,.icon3,.icon4,.icon5,.manage a i.duihao,.manage a i,.h-l-t,.h-r-t,.h-l-b,.h-r-b,.xg-box,.jd-img1,.jd-img2,.jd-img3,.jiao1,.jiao2,.sjiao,.btn-jian,.btn-jian-on,.footer img,.small-zao,.big-zao'); 
</script>
        <![endif]-->
</head>

<body>
	<input type="hidden" id="upd_flag" value="${upd_flag}" />
	<div class="top-box">
		<div class="wraper">
			<div class="reg-h-box">
				<p class="zhu f-right">
					<a href="/p/signout" class="dis">[注销]</a>
				</p>
				<!--<em class="user-name f-right">您好,CG-24</em>-->
				<em class="user-name f-right">您好,<%=request.getAttribute("pName")%></em>
			</div>

		</div>
	</div>
	<script type="text/javascript"
		src="/static/js/player/account/account.common.js"></script>
	<script type="text/javascript"
		src="/static/js/player/account/default/account.index.js"></script>
	<div>
		<h1>跟我玩,游戏平台</h1>
	</div>
	<div class="wraper header-box">
		<div class="f-right manage">
			<div class="ma-1 ma">
				<i class="paint"></i>
				<div class="tips tips3" style="display: none">
					<div class="sjiao"></div>
					<ul class="clearfix">
						<li class="txt-red">未绑定</li>
					</ul>
				</div>
			</div>
			<div class="ma-2 ma">
				<i class="paint"></i>
				<div class="tips tips4" style="display: none">
					<div class="sjiao"></div>
					<ul class="clearfix">
						<li class="txt-red">未绑定</li>
					</ul>
				</div>
			</div>

		</div>
		<div class="head f-left">
			<div class="h-l-t">左上</div>
			<div class="h-r-t">右上</div>
			<div class="h-l-b">左下</div>
			<div class="h-r-b">右下</div>
			<img src="http://p1.yx-s.com/detphoto.jpg" width="142px"
				height="142px" />
			<div class="xg-box" style="display: none;">透明层，无内容</div>
			<a href="/#" class="tm-a" style="display: none;">修改</a>
		</div>
		<div class="f-left ren-m">
			<h4 class="name dis"><%=request.getAttribute("pName")%></h4>
			<a href="javascript:void(0)">修改</a>
			<div class="myyhq">
				<a href="javascript:void(0)" target="_blank">我的优惠券<i></i></a>
			</div>
			<div>
				<em class="txt-hui">个人信息完整度:</em>
				<div class="jindu1 dis">
					<div class="jd-1">
						<div class="jd-img1" style="left: -331px"></div>
					</div>
					<div class="jiao1"></div>
					<div class="tips tips1" style="display: none">
						<div class="sjiao"></div>
						<ul class="clearfix">
						</ul>
					</div>
				</div>
				<a href="javascript:void(0)" class="m-r-10">完善个人资料</a>
			</div>
		</div>
	</div>
	<div class="wraper bg-white clearfix">
		<div class="title">
			<h2 class="manage-h2">
				<i class="dis"></i>帐号管理
			</h2>
		</div>
		<div class="main f-left">
			<!--密保邮箱-->
			<div class="m-list" style="z-index: 5">
				<a name="email" class="a_email"></a>

				<div class="clearfix box-title">
					<div class="f-right shm r-content" id="setEmail">
						<a href="javascript:void(0)" onclick="openMail();">设置保密邮箱</a>
					</div>
					<div class="f-right shm r-step">
						<em class="txt-orange m-r-10 mail-step1">①填写邮箱</em><em
							class="txt-hui mail-step2">②前往邮箱并激活</em>
					</div>
					<div class="f-left">
						<div class="icon1 dis">邮箱</div>
						<h3 class="dis list-name">密保邮箱</h3>
						<i class="txt-fen bangding-status" id="bindEmail">未绑定</i>
					</div>
				</div>
				<div class="clearfix box-con" style="display: none;" id="mail">
					<div class="clearfix mail-panel1">

						<p class="txt-fen txt-center">请设置一个您的常用邮箱作为密保邮箱，当您忘记密码时，可通过密保邮箱快速重置密码。</p>
						<ul class="mail-ul">
							<li class="form-item"><label class="dis">邮箱地址：</label> <input
								name="email" type="text" class="input w-244" /></li>
							<!-- 
                            <li class="form-item"><label class="dis">验证码：</label>
                            <input name="captcha" id="captcha" type="text" class="input w-122">
                            <img src="http://captcha.subic888.com/image.php?app=subic888" width="112" height="40" class="yan" id="imgcaptcha">
                            <a href="javascript:void(0);" onclick="$('#imgcaptcha').attr('src', 'http://captcha.subic888.com/image.php?app=subic888&r=' + Math.random());">换一张</a>
                            </li>-->
							<li><label class="dis"></label> <a
								href="javascript:void(0);" id="btn-email"
								class="btn btn-send dis">保存</a></li>
						</ul>
					</div>
					<div class="clearfix mail-panel2" style="display: none">
						<ul class="mail-ul">
							<li class="txt-fen">激活邮件已发送至您的邮箱：<span id="mail_addr"></span></li>
							<li><a href="http://u.subic888.com/account/index#"
								id="mail_addr_a" target="_blank" class="btn btn-send dis m-l-80">前去激活</a></li>
							<li class="txt-hui">
								<p>没收到邮件怎么办：</p>
								<p>请检查您的垃圾邮件和广告邮件</p>
								<p>
									<a href="javascript:void(0)" onclick="mailStepBack();">点击这里</a>重新发送
								</p>
								<p>如果您依然收不到验证邮件，请联系客服</p>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!--密保手机-->
			<div class="m-list" style="z-index: 4">
				<a name="mobile" class="a_mobile"></a> <a href="javascript:;"
					class="c-btn">收缩按钮</a>
				<div class="clearfix box-title">
					<div class="f-right shm r-content" id="setPhone">
						<a href="javascript:void(0)" onclick="openPhone();">设置保密手机</a>
					</div>
					<div class="f-right shm r-step">
						<em class="txt-orange m-r-10 sms-step1">①填写手机</em><em
							class="txt-hui sms-step2">②填写短信验证码</em>
					</div>
					<div class="f-left">
						<div class="icon2 dis">手机</div>
						<h3 class="dis list-name">密保手机</h3>
						<i class="txt-fen bangding-status" id="bindPhone">未绑定</i>
					</div>
				</div>
				<div class="clearfix box-con" style="display: none;" id="phone">
					<div class="clearfix sms-panel1">

						<p class="txt-fen txt-center">请输入您的手机号,验证成功后,可通过此手机号找回密码。</p>
						<ul class="mail-ul">
							<li class="form-item"><label class="dis">手机号码：</label><input
								name="phone" type="text" class="input w-244"></li>
							<li><label class="dis"></label><a href="javascript:void(0)"
								class="btn btn-send dis" id="btn-phone">保存</a></li>
						</ul>

					</div>
					<div class="clearfix sms-panel2" style="display: none" id="phone">
						<form method="post" id="form-bindsms" action="/bindsms.php">
							<p class="txt-fen txt-center">请输入您的手机号,验证成功后,可通过此手机号找回密码。</p>
							<ul class="mail-ul">
								<li class="form-item"><label class="dis">手机号码：</label><input
									type="text" class="input w-244" value="" name="bindsms_mobile"
									id="checksms_mobile" readonly="true"></li>
								<li class="form-item"><label class="dis">手机验证码：</label> <input
									name="bindsms_vcode" type="text" class="input w-122 m-r-10">
									<em class="txt-hui" id="resend">119后重新发送</em></li>
								<li><label class="dis"></label><a
									href="javascript:void(0);" id="btn-bindsms"
									class="btn btn-send dis">完成认证</a></li>
							</ul>
						</form>
					</div>
				</div>
			</div>

			<!--修改密码-->
			<div class="m-list" style="z-index: 2">
				<a name="pswd" class="a_pswd"></a> <a href="javascript:;"
					onclick="pasw()" class="c-btn">收缩按钮</a>
				<div class="clearfix box-title">
					<div class="f-right shm r-content">
						<a href="javascript:void(0)" onclick="openPsw(this);">修改</a>
					</div>
					<div class="f-left">
						<div class="icon4 dis">修改密码</div>
						<h3 class="dis list-name">修改密码</h3>
					</div>
				</div>
				<div class="clearfix box-con" id="psw" style="display: none;">
					<div class="clearfix">
						<ul class="mail-ul">

							<li class="form-item"><label class="dis">原密码：</label><input
								name="repass_old" type="password" value="" class="input w-244" /></li>
							<li class="form-item"><label class="dis">新密码：</label><input
								name="repass_new" type="password" value="" class="input w-244" /></li>
							<li class="form-item"><label class="dis">重复密码：</label><input
								name="repass_check" type="password" value="" class="input w-244" /></li>
							<li><label class="dis"></label><a href="javascript:void(0)"
								class="btn btn-send dis" id="btn-repass">确认修改</a></li>

						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="sidebar f-right">
			<h2>账号安全等级</h2>
			<div>
				<div class="jindu2 dis">
					<div class="jd-2">
						<div class="jd-img2" style="left: -239px"></div>
					</div>
					<div class="jiao2"></div>
					<div class="tips tips2" style="display: none">
						<div class="sjiao"></div>
						<ul class="clearfix">
							<li class="txt-red">密保邮箱 !</li>
							<li class="txt-red">密保手机 !</li>
							<li class="txt-red">防沉迷 !</li>
						</ul>
					</div>
				</div>
				<!--            <p class="txt-hui">完成所有安全设置可获得<em class="txt-zong">35银</em> (已获得<em class="txt-zong">0银</em>)</p>-->
			</div>

		</div>
	</div>
	<div class="footer">
		<div class="wraper" style="text-align: center;">
			<p class="dis">苏比克有限公司</p>
		</div>
	</div>
	<script src="/static/js/player/account/analyse.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		//初始化页面
		$(document).ready(function() {
			//var nickname = $(".name.dis").text();
			$.get("/p/onload.ajax", function(data, status) {
				if (data.e && data.p) {
					$("#setEmail").css("display", "none");
					$("#mail").css("display", "none");
					$("#bindEmail").html(data.eMsg);
					$("#bindEmail").css("color", "#13a252");

					$("#setPhone").css("display", "none");
					$("#phone").css("display", "none");
					$("#bindPhone").html(data.pMsg);
					$("#bindPhone").css("color", "#13a252");
				} else if (data.p) {
					$("#setPhone").css("display", "none");
					$("#phone").css("display", "none");
					$("#bindPhone").html(data.pMsg);
					$("#bindPhone").css("color", "#13a252");
				} else if (data.e) {
					$("#setEmail").css("display", "none");
					$("#mail").css("display", "none");
					$("#bindEmail").html(data.eMsg);
					$("#bindEmail").css("color", "#13a252");
				}

				else {
					return false;
				}
			});
		});
		//修改密码
		$("#btn-repass").click(function() {
			var old = $("input[name='repass_old']").val();
			var nww = $("input[name='repass_check']").val();
			var nw = $("input[name='repass_new']").val();
			if (nww != nw) {
				alert("密码不一致，请重新输入！");
			} else {
				$.ajax({
					type : "post",
					url : "/p/modiPswd.ajax",
					dataType : "json",
					data : {
						old : old,
						nw : nw
					},
					success : function(data, textStatus) {
						alert(data.a);
						window.location.reload();
					}
				});
			}
		});
		//绑定邮箱
		$("#btn-email")
				.click(
						function() {
							var email = $("input[name='email']").val();
							if (email == "") {
								alert("邮箱不能为空");
								return false;
							}
							var myreg_email = /^[0-9a-zA-Z_\-\.]*[0-9a-zA-Z_\-]@[0-9a-zA-Z_\-]+(\.[0-9a-zA-Z_\-]+)*$/;
							if (!myreg_email.test(email)) {
								alert("邮箱格式有误");
								return false;
							}
							$.ajax({
									type : "post",
									url : "/p/secureMail.ajax",
									dataType : "json",
									data : {email : email},
									success : function(data, textStatus) {
										if (data.e) {
											alert("保存成功！");
											$("#setEmail").css("display","none");
											$("#mail").css("display","none");
											$("#bindEmail").html(data.msg);
											$("#bindEmail").css("color","#13a252");
											} else {
												alert("请重新输入！");
											}
										}
							});
						});
		//绑定电话
		$("#btn-phone").click(function() {
			var phone = $("input[name='phone']").val();
			if (phone == "") {
				alert("请填写手机号码！");
				return false;
			}
			if (isNaN(phone) || (phone.length != 11)) {
				alert("手机号码为11位数字！请正确填写！");
				return false;
			}
			var reg = /^0{0,1}(1[358][0-9]|15[0-9])[0-9]{8}$/;
			if (!reg.test(phone)) {
				alert("您的手机号码不正确，请重新输入");
				return false;
			}

			$.ajax({
				type : "post",
				url : "/p/securePhone.ajax",
				dataType : "json",
				data : {
					phone : phone
				},
				//contentType: "application/json; charset=utf-8",
				success : function(data, textStatus) {
					if (data.p) {
						alert("保存成功！");
						$("#setPhone").css("display", "none");
						$("#phone").css("display", "none");
						$("#bindPhone").html(data.msg);
						$("#bindPhone").css("color", "#13a252");
					} else {
						alert("请重新输入！");
					}
				}
			});
		});
		//控制密码、邮箱、电话是否显示
		function openPsw() {
			if ($("#psw").css("display") == "none") {

				$("#psw").css("display", "block");
			} else {
				$("#psw").css("display", "none")
			}
		}
		function openMail() {
			if ($("#mail").css("display") == "none") {

				$("#mail").css("display", "block");
			} else {
				$("#mail").css("display", "none")
			}
		}
		function openPhone() {
			if ($("#phone").css("display") == "none") {

				$("#phone").css("display", "block");
			} else {
				$("#phone").css("display", "none")
			}
		}
		//验证密码是否一致
		$("input[name='repass_check']").blur(function() {
			if ($("input[name='repass_new']").val() == $(this).val()) {
				return;
			} else {
				alert("密码不一致！");
			}
		});
	</script>
</body>
</html>
