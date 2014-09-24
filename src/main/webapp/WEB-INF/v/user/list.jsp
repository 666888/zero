<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
<meta charset="utf-8">
<title>list</title>
<script type = "text/javascript" src="/static/js/jquery-1.8.0.min.js"></script>
</head>

<body>

<div id="model_20249" align=center>

<table style='border-collapse:collapse;table-layout:fixed;width:755pt' border="1">
	<tr height=75 style='height:56.25pt'>
		<td colspan=8 height=75 width=1007 style='height:56.25pt; width:755pt'>用户列表</td>
	</tr>
	<tr height=36 style='mso-height-source:userset;height:27.0pt'>
		
		<td colspan=8><a href="/gm/add">添加</a></td>
	</tr>
	<tr height=24 style='height:18.0pt'>
		<td height=24 style='height:18.0pt'>序号</td>
		<td style='border-left:none'>编号</td>
		<td style='border-left:none'>名称</td>
		<td style='border-left:none'> 角色</td>
		<td colspan=3 style='border-right:1.0pt solid black; border-left:none'>功能</td>
		<td style='border-left:none'>备注</td>
	</tr>
	
 	<c:forEach items="${users}" var="um">	
	<tr height=22 style='height:16.5pt'>
  		<td height=22 style='height:16.5pt;border-top:none'>${um.id}</td>
  		<td style='border-top:none;border-left:none'>${um.code}</td>
  		<td style='border-top:none;border-left:none'><a href="#">${um.userName}</a></td>
  		<td style='border-top:none;border-left:none'><c:forEach items="${um.roles}" var="ro">${ro.name}&nbsp;</c:forEach></td>
  		<td class=xl3520249 style='border-top:none;border-left:none'><a href="/gm/${um.id }/update">编辑</a></td>
  		<td style='border-top:none'><select id = "sel_${um.id}" onchange=modifyRole(${um.id})><option value="">授权</option><c:forEach items="${roles}" var="ro"><option value="${ro.id}">${ro.name}</option></c:forEach></select></td>
  		<td style='border-top:none'><a href="#">删除</a></td>
  		<td style='border-top:none;border-left:none'><a href="#">${um.remark}</a></td>
	</tr>
	</c:forEach>
	<tr height=25 style='height:18.75pt'>
		<td height=25 style='height:18.75pt;border-top:none'>　</td>
		<td style='border-top:none;border-left:none'>　</td>
		<td style='border-top:none;border-left:none'>　</td>
		<td style='border-top:none;border-left:none'>　</td>
		<td style='border-top:none;border-left:none'>　</td>
		<td style='border-top:none'>　</td>
		<td style='border-top:none'>　</td>
		<td style='border-top:none'>　</td>
	</tr>
	
</table>

</div>
<script type="text/javascript">

	function modifyRole(id){
		var id = id;
		var role = $("#sel_" + id).val();
		$.post("/gm/modifyRole.ajax",{id:id,role:role},function(data,textStatus){if(textStatus=="success"){alert("授权成功");window.location.reload();}},"json");
				
	}
	


</script>
</body>

</html>
