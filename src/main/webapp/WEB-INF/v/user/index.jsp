<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta charset="utf-8">
<title>manage</title>
<style type="text/css">
	* { margin: 0px; padding: 0px;}
	li { list-style: none;}
	a { text-decoration: none; color: #000; outline: none;}

	#head { height: 60px; background: #ccc;}
		#head_logo { float: left;}
		#head_ope { float: right; display: table; margin-right: 20px;}
			#head_ope li { float: left; margin: 5px;}
			#johndoe { cursor: pointer; position: relative;}
			#johndoe:hover { background: #999;}
				#john_menu { display: none; position: absolute; top: 20px; left: 0px; background: #fff;}
	#con { display: table; width: 100%; background: yellow;}
		#con_nav { height: 30px; border-bottom: solid 1px red;}
			#con_nav li { float: left; height: 29px; line-height: 29px; border: solid 1px red; border-bottom: solid 1px #ccc; 
				border-radius: 5px 5px 0px 0px; margin-left: 10px; overflow: hidden;
			}
				#con_nav li a { display: block; padding: 0px 10px;}
				#con_nav li:hover { background: #fff; border-bottom: solid 1px #fff;}

</style>
<script type="text/javascript" src="/cdn/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#con_nav li").eq(0).css({background:"#fff", "border-bottom":"solid 1px #fff"});
		$("#con_nav li").click(function() {
			$(this).siblings().removeAttr("style");
			$(this).css({background:"#fff", "border-bottom":"solid 1px #fff"});
		});
		
		function adaptHeight() {
			$("#con_iframe").height($(window).height() - $("#head").outerHeight() - $("#con_nav").outerHeight());
		}
		adaptHeight();
		$(window).resize(function() {
			adaptHeight();
		});
		
		$("#johndoe").click(function(e) {
			e.stopPropagation();
			$(this).css("background", "#666");
			var john_menu = $("#john_menu");
			if (john_menu.is(":visible")) {
				john_menu.hide();
				$("#johndoe").removeAttr("style");
			} else {
				john_menu.show();
			}
		});
		$("body").click(function() {
			closeJohnMenu();
		});
		$("iframe").load(function() {
			$(this).contents().click(function() {
				closeJohnMenu();
			});
		});
		function closeJohnMenu() {
			var john_menu = $("#john_menu");
			if (john_menu.is(":visible")) {
				john_menu.hide();
				$("#johndoe").removeAttr("style");
			}
		}
	});
</script>
</head>

<body>
	<div id="head">
		<div id="head_logo">Thin Admin</div>
		<ul id="head_ope">
			<li><input type="text" value="search" /></li>
			<li>icon1</li>
			<li>icon2</li>
			<li>icon3</li>
			<li id="johndoe">
				<span>John Doe</span>
				<ul id="john_menu">
					<li>Update password</li>
					<li>Login out</li>
				</ul>
			</li>
		</ul>
	</div>
	<div id="con">
		<ul id="con_nav">
			<li><a href="/gm/playerManager" target="win_bottom">Player Management</a></li>
			<li><a href="/gm/template_tools" target="win_bottom">Template Tools</a></li>
			<li><a href="/gm/system_manage" target="win_bottom">System Management</a></li>
			<li><a href="/gm/payments" target="win_bottom">Payments</a></li>
			<li><a href="/gm/products" target="win_bottom">Products</a></li>
			<li><a href="/gm/risk_manage" target="win_bottom">Risk Management</a></li>
			<shiro:hasPermission name="user:find">  			
			<li><a href="/gm/monitor_report" target="win_bottom">Monitoring & Reporting</a></li>
			</shiro:hasPermission>		
			<li><a href="/gm/userManager" target="win_bottom">User Management</a></li>
			
		</ul>
		<iframe id="con_iframe" src="/gm/playerManager" name="win_bottom" frameborder="0" style="width: 100%; background: #fff;"></iframe>
	</div>
</body>
</html>
