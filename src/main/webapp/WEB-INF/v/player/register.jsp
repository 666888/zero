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
  	<sf:form method="post" action="regist" modelAttribute="user">
  	
    <table align="center">
    	<tr>
    		<td height="23"><span >用户名：</span></td>
   		  <td height="23"><sf:input path="userName" /><sf:errors path="password" /></td>
    	</tr>
    	<tr>
    		<td height="23"><span >密码：</span></td>
   		  <td height="23"><sf:input path="userPwd" /><sf:errors path="password" /></td>
    	</tr>
		<tr>
    		<td height="23"><span >确认密码：</span></td>
   		  <td height="23"><sf:input path="userPwd" /><sf:errors path="password" /></td>
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