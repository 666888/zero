<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Balance</title>
</head>
<body>
<table align="center">
<c:forEach var="balance"  items="${balances}" >

     <tr><td>${balance.balance }</td>
     <td>${balance.amount }</td>
     <td>${balance.remark }</td>
     <td>${balance.io }</td>
     <td>${balance.opp }</td></tr>

</c:forEach>
</table>
<sf:form method="post" action="addBalance" modelAttribute="balance">
  	
    <table align="center">
    	<tr>
   		  <td height="23"><sf:input path="playerId" type="hidden" /><sf:errors path="playerId" /></td>
    	</tr>
    	<tr>
    		<td height="23"><span >转款时间：</span></td>
   		  <td height="23"><sf:input path="transferTime" /><sf:errors path="transferTime" /></td>
    	</tr>
   
    	<tr>
    		<td height="23"><span >充值：</span></td>
   		  <td height="23"><sf:input path="add" /><sf:errors path="add" /></td>
    	</tr>
    	<tr>
    		<td height="23"><span >转出：</span></td>
   		  <td height="23"><sf:input path="rolloff" /><sf:errors path="rolloff" /></td>
    	</tr>
    	<tr>
    		<td height="23"><span >备注：</span></td>
   		  <td height="23"><sf:input path="remark" /><sf:errors path="remark" /></td>
    	</tr>
    	<tr>
    		<td height="23" colspan="2" align="center">
    			<input type="submit" value="转账">
    			
   		    </td>
    	</tr>
    	
    </table>
    </sf:form>
</body>
</html>