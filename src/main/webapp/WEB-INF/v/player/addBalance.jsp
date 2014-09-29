<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link href="/static/css/player/index.css" rel="stylesheet"
	type="text/css" />
<style type="text/css">

.body2 {
	background-color: #FFF;
	width: 737px;
	height: auto;
	padding: 10px 0 0 12px;
	font-size: 12px;
	margin: 20px auto 20px auto;

}

.tds {
	line-height: 25px;
}

.STYLE1 {
	font-weight: bold
}

.STYLE2 {
	color: #0000FF
}

.STYLE12 {
	color: #F00
}
</style>
<!--
<script language="JAVAScript">
		var $ = function(Id){
            return document.getElementById(Id);
        }
    
       
        //数字验证 过滤非法字符
        function clearNoNum(obj){
	        //先把非数字的都替换掉，除了数字和.
	        obj.value = obj.value.replace(/[^\d.]/g,"");
	        //必须保证第一个为数字而不是.
	        obj.value = obj.value.replace(/^\./g,"");
	        //保证只有出现一个.而没有多个.
	        obj.value = obj.value.replace(/\.{2,}/g,".");
	        //保证.只出现一次，而不能出现两次以上
	        obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
	        if(obj.value != ''){

	        var re=/^\d+\.{0,1}\d{0,2}$/;
                  if(!re.test(obj.value))   
                  {   
			          obj.value = obj.value.substring(0,obj.value.length-1);
			          return false;
                  } 
	        }
        }

//去掉空格
function check_null(string) { 
var i=string.length;
var j = 0; 
var k = 0; 
var flag = true;
while (k<i){ 
if (string.charAt(k)!= " ") 
j = j+1; 
k = k+1; 
} 
if (j==0){ 
flag = false;
} 
return flag; 
}
function VerifyData() {
if (document.form1.MOAmount.value == "") {
			alert("请输入存款金额！")
			document.form1.MOAmount.focus();
			return false;
}
if (document.form1.MOAmount.value < 100) {
			alert("最低冲值100元！")
			document.form1.MOAmount.focus();
			return false;
}
}

</script>
-->
<!--
<script language="JavaScript">

function url(r){
    window.open(r,"mainFrame");  
}
-->
<script type="text/javascript" src="/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	function onover() {
		var a = document.getElementById("t_drop");
		a.style.display = "block";
	}
	function hidden() {
		var a = document.getElementById("t_drop");
		a.style.display = "none";
	}
	function onout() {
		setTimeout('hidden()', 2000);
	}
	function che(){
		if($("#MOAmount").val().trim() == ""){
			alert("不能为空!");
			return false;
			}
		else if($("#MOAmount").val() < 100){
			alert("不能小于100！");
			return false;
		}
		else{
			return true;
		}
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
							<span> <i class="user_p" onmouseover="onover()" onmouseout= "onout()"> <img width="25" height="25"
									src="http://p1.yx-s.com/detphoto.jpg" >
							</i> <a class="username" href="/p/message"><%= request.getAttribute("pName")%></a>
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
								href="http://bbs.subic888.com/"> <i></i>
								消息
							</a> <a class="total_msg" style="display: none;"
								href="http://bbs.subic888.com/"> <span></span>
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
	<div class="body2" style = "height:450px">
		<div style="margin-top: 10px; margin: 10px 0 10px 0;">
			<span class="STYLE1"><strong>在线冲值</strong></span>&gt;&nbsp;&nbsp;&nbsp;<a
				class="len"
				href="/p/rechargeHistory"
				style="color: #00F; text-decoration: underline;">冲值记录查看</a>
		</div>

		<sf:form id="form1" modelAttribute="balance" action="/p/addAccount" method="post" onsubmit="return che()">
			<table width="720"style="border-collapse: collapse; border: 1px solid #CCC;"border="0" cellpadding="1" cellspacing="1">
				<tbody>
					<tr>
						<td height="30" align="right"><span class="STYLE12">*</span>
							充值金额:</td>
						<td align="left">&nbsp;&nbsp;&nbsp;<sf:input name="MOAmount" path="recharge" id="MOAmount" style="border: 1px solid #CCCCCC; height: 18px; line-height: 20px; width: 118px;" onkeyup="clearNoNum(this);" size="15" /><sf:errors path="recharge" />&nbsp;&nbsp;最少冲值100元
						</td>
					</tr>
					<tr>
						<td height="30" align="right">选择银行:</td>
						<td align="elft">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tbody>
									<tr>
										<td height="20"></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="ABC">农业银行&nbsp;</td>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="ICBC">工商银行&nbsp;</td>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="CCB">建设银行&nbsp;</td>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="BCOM">交通银行&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td height="10"></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="BOC">中国银行&nbsp;<br></td>

										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="CMB">招商银行&nbsp;</td>
										<td>&nbsp;</td>

										<td><input type="radio" name="bank_name" value="CMBC">民生银行&nbsp;<br></td>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="CEBB">光大银行&nbsp;</td>

										<td>&nbsp;</td>

									</tr>
									<tr>
										<td height="10"></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="ECITIC">中信银行&nbsp;</td>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="SDB">深圳发展银行&nbsp;</td>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="BEA">东亚银行&nbsp;</td>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="SPABANK">平安银行&nbsp;</td>
										<td>&nbsp;</td>

									</tr>
									<tr>
										<td height="10"></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="CIB">兴业银行&nbsp;</td>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="PSBC">中国邮政&nbsp;</td>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="SPABANK">平安银行&nbsp;</td>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="ECITIC">中信银行&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td height="10"></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="GDB">广发银行&nbsp;</td>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="HXB">华夏银行&nbsp;</td>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="SPDB">浦发银行&nbsp;</td>
										<td>&nbsp;</td>
										<td><input type="radio" name="bank_name" value="BEA">东亚银行&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td height="20"></td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<td height="35" align="right">&nbsp;</td>
						<td height="40" align="left" valign="middle">&nbsp;&nbsp; <input
							name="SubTran" class="anniu_02" id="SubTran" type="submit"
							value="马上冲值"><% if(request.getAttribute("acc") == null){out.print("");}else{out.print(request.getAttribute("acc"));} %>
						</td>
					</tr>
				</tbody>
			</table>
			<div style="display: none">
				<br> <br>时间字段：<input type="text" name="MODate"
					value="2010-08-16 12:20:10"> <br>币 种：<input
					type="text" name="MOCurrency" value="1"> <br>语言选择：<input
					type="text" name="M_Language" value="1"> <br>消费者姓名：<input
					type="text" name="S_Name" value="boyfriend"> <br>消费者住址：<input
					type="text" name="S_Address" value="2308"> <br>消费者邮码：<input
					type="text" name="S_PostCode" value="518000"> <br>消费者电话：<input
					type="text" name="S_Telephone" value="0755-88833166"> <br>消费者邮件：<input
					type="text" name="S_Email" value="service@dinpay.com"> <br>收货人姓名：<input
					type="text" name="R_Name" value="wangl"> <br>收货人住址：<input
					type="text" name="R_Address" value="2308"> <br>收货人邮码：<input
					type="text" name="R_PostCode" value="100080"> <br>收货人电话：<input
					type="text" name="R_Telephone" value="0755-82384511"> <br>收货人邮件：<input
					type="text" name="R_Email" value="service@dinpay.com"> <br>商品名称：<input
					type="text" name="G_Name" value="aaa"> <br>商品编号：<input
					type="text" name="G_Number" value="B001"> <br>商品数量：<input
					type="text" name="G_Count" value="1"> <br>商品描述：<input
					type="text" name="G_Info" value="bbb"> <br>商品展示地址：<input
					type="text" name="G_Url" value="http://www.a.com"> <br>备
				注：<input type="text" name="MOComment" value="w"> <br>交易状态：<input
					type="text" name="State" value="0"> <br>
			</div>
		</sf:form>
		<table width="96%" border="0" cellpadding="0" cellspacing="5">
			<tbody>
				<tr>
					<td align="left" style="padding-top: 10px;"><strong
						class="STYLE1">在线冲值说明：</strong></td>
				</tr>
				<tr>

					<td align="left"><span class="font-hblack"><span>
								<div style="line-height: 22px; font-size: 12px;">
									(1).请按表格填写准确的在线冲值信息,确认提交后会进入选择的银行进行在线付款!</div>
								<div style="line-height: 22px; font-size: 12px;">
									(2).交易成功后请点击返回支付网站可以查看您的订单信息!</div>
								<div style="line-height: 22px; font-size: 12px;">
									(3).如有任何疑问,您可以联系 在线客服为您提供365天×24小时不间断的友善和专业客户咨询服务!</div>
						</span> </span></td>

				</tr>
			</tbody>
		</table>
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
		<p>*点击下载按键将在您的电脑上安装约为10MB的Windows兼容型娱乐软件，使您可在我们的subic.com平台上注册并玩游戏。此应用程序可通过Windows平台上的删除程序选项完全卸载。卸载后，软件的功能不会保留。</p>
		<br />
		<p>
			2014版权所有<a href="javascript:;">subic.com</a>
		</p>

		<p>在菲律宾注册并遵守菲律宾法律</p>
	</div>
	<!--footer end-->


</body>
</html>

