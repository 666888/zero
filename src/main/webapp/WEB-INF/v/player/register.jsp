<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<meta charset="utf-8">
		<title>注册</title>
	</head>
  
  <body>
  <center>
    <span >注册</span>
  </center>
  	<sf:form method="post" action = "/signup" modelAttribute="player">
  	
    <table align="center">
    	<tr>
    		<td height="23"><span >用户名：</span></td>
   		  <td height="23"><sf:input path="nickname" /><sf:errors path="nickname" /></td>
    	</tr>
    	<tr>
    		<td height="23"><span >密码：</span></td>
   		  <td height="23"><sf:input path="password" /><sf:errors path="password" /></td>
    	</tr>
    	<tr>
    		<td height="23" colspan="2" align="center">
    			<input type="submit" value="注册">
    			
   		    </td>
    	</tr>
    </table>
    </sf:form>
  </body>
</html>
