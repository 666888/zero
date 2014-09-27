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
<link type="text/css" rel="stylesheet"
	href="/static/css/player/account/tikuan2.css">

<style type="text/css">
&lt;!--
.STYLE2 {
	color: #000000
}

.on1 .current {
	color: #ff0000;
	font-weight: bold;
}

.on2 .current1 {
	color: #ff0000;
	font-weight: bold;
}

.on3 .current2 {
	color: #ff0000;
	font-weight: bold;
}

.on4 .current3 {
	color: #ff0000;
	font-weight: bold;
}

.on5 .current4 {
	color: #ff0000;
	font-weight: bold;
}

--&gt;
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
</script>

</head>
<body>
	<noscript>您的浏览器不支持JS，将无法看到通过JS实现的效果</noscript>
	<!--nav star-->
	<!--V2 star-->
	<!--top star-->

	<!--top end-->
	<div id="top_lishi" style="height:480px;overflow:auto;overflow-x:hidden;">
		<div class="waikuang00">
			<table cellspacing="1" cellpadding="0" width="100%" border="0"
				class="waikuang">
				<tbody>
				
					<tr height="20" class="sekuai_01">
						<td width="25%" align="center">转入金额</td>
						<td width="15%" align="center">转出金额</td>
						<td width="15%" align="center">转款时间</td>
						<td width="10%" align="center">备注</td>
					</tr>					
						<c:choose>
							<c:when test="${balanceList.size() == 0}">
								<tr height="20" bgcolor="#FFFFFF" align="center" onmouseout="this.style.background='#ffffff'" onmouseover="this.style.background='#EEEEEE'" style="background: none repeat scroll 0% 0% rgb(255, 255, 255);">
	  								<td height="30" colspan="4"><span class="STYLE2">暂无结果</span></td>
	 							</tr>
							</c:when>
						
							<c:otherwise>
								<c:forEach var = 'b' items='${balanceList}'>
								<tr>
									<td style = "text-align:center">${b.getRecharge()}</td>
									<td style = "text-align:center">${b.getRolloff()}</td>
									<td style = "text-align:center">${b.getTransferTime()}</td>
									<td style = "text-align:center">${b.getRemark()}</td>
								</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					
				</tbody>
			</table>
			<table cellspacing="0" cellpadding="0" width="100%" border="0"
				class="waikuang">
				<tbody>
					<tr class="sekuai_03">
						<td style="width: 100%" class="fanye" colspan="6"><span style="float: left;">主账户总金额：<font color="#FFFFFF"><% if(request.getAttribute("allAccount") == null){out.println(0);}else{out.print(request.getAttribute("allAccount"));} %></font>
								RMB
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!--footer star-->
	<!--footer end-->


</body>
</html>

