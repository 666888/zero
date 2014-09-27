<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>player_online</title>
<style type="text/css">
	* { margin: 0px; padding: 0px;}
	li { list-style: none;}
	a { text-decoration: none; color: #000;}

	table { padding-left: 10px;}
	tr { height: 40px;}
</style>
</head>

<body>
<form action = "/gm/rechargeHistory" method = "post">
	nickname:<input name = "nickname" type = "text"/>
	<input type = "submit" value = "查询">
</form>
		
</body>
</html>
