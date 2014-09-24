<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="deep.web.OnlineListener"%> 
<%@ page import ="java.util.Map" %>
<%@ page import ="java.util.HashMap" %>
<%@ page import ="deep.zero.bean.Player" %>
<% 
Map<String,Player> map=new HashMap<String,Player>(); 
map=new OnlineListener().getOnlinePlayer(); 
out.println(""+ 
"目前系统总共有 "+(OnlineListener.getOnlineGuest()+map.size())+" 人在线,其中注册用户 "+map.size()+" 人,游客 "+ 
OnlineListener.getOnlineGuest()+" 人"); 

out.println("<br />");
for(String key : map.keySet())   {   
	out.println(key);           
}
%> 
</body>
</html>