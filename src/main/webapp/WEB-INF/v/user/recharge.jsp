<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	
<head>
	<title></title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		* { margin: 0px; padding: 0px;}
		table, td { border-collapse: collapse; border-spacing: 0px; border: 1px solid #d7d7d7; text-align: center;}
		td, th { height: 40px;}
		th { background: #fffce1; font-weight: normal;}
		table.g-table { border: 1px solid #d7d7d7; table-layout: fixed; width: 100%;}	
	</style>
	<script type = "text/javascript" src="/cdn/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		$(function() {
			//查询单个用户
			$("#search").click(function() {
				var nickname = $("#nickname").val().trim();
				if (nickname != "") {
					$.post("/gm/rechargeSearch.ajax", {nickname:nickname}, function(data) {
						if (data.e) {
							$("#name").html(data.player.nickname);
							var amount = 0;
							if (data.allAccount) {
								amount = data.allAccount;
							}
							$("#amount").html(amount);
						} else {
							$("#name").html("");
							$("#amount").html("");
							alert("没有该用户！");
						}
					}, "json");
				}
			});
			
			//充值
			$("#recharge_form").submit(function() {
				var number = $("#number").val().trim();
				if (number != "" && number > 0 && $("#name").html() != "") {
					$.post("/gm/accountRecharge.ajax", {recharge:number,nickname:$("#name").html()}, function(data) {
						if (data.e) {
							alert(data.msg);
							$("#search").click();
						} else {
							alert(data.msg);
						}
					}, "json");
				}
				return false;
			});
		});
	</script>
</head>

<body>
	<div style="padding: 20px;">
		<input type="text" name="nickname" id="nickname" /><input type="button" id="search" value="查询" />
	</div>
	
	<table class="g-table">
		<tbody>
			<tr>
				<th>用户昵称</th>
				<th>总金额</th>
			</tr>
			<tr>
				<td id="name"></td>
				<td id="amount"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: left; padding-left: 20px;">
					<form id="recharge_form">
						<input type="text" required pattern="^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([1-9]*[1-9][0-9]*))$" id="number" /><input type="submit" id="recharge" value="充值" />
					</form>
				</td>
			</tr>
		</tbody>
	</table>
			
</body>
</html>
