<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="deep.web.OnlineListener"%> 
<%@ page import ="java.util.Map" %>
<%@ page import ="java.util.HashMap" %>
<%@ page import ="deep.zero.bean.Player" %>
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
	<h2>Player Online</h2>
	<table border="1" width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td>Client Platform</td>
			<td>Real Player</td>
			<td>Status</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" /><label>Web</label>
				<input type="checkbox" /><label>Telebet</label>
				<input type="checkbox" /><label>System</label>
				<input type="checkbox" /><label>Retail BIP</label>
				<input type="checkbox" /><label>Mobile</label>
				<input type="checkbox" /><label>IVR</label>
				<input type="checkbox" /><label>Flash</label>
				<input type="checkbox" /><label>Download</label>
				<input type="checkbox" /><label>Admin</label>
				<input type="checkbox" /><label>All/None</label>
			</td>
			<td>
				<input type="radio" /><label>Yes</label>
				<input type="radio" /><label>No</label>
				<input type="radio" /><label>Both</label>
			</td>
			<td>
				<input type="radio" /><label>Online</label>
				<input type="radio" /><label>Pending Kickout</label>
				<input type="radio" /><label>Both</label>
				<br />
				<input type="checkbox" /><label>Poker</label>
				<input type="checkbox" /><label>Live Casino</label>
				<input type="checkbox" /><label>Landbased casino</label>
				<input type="checkbox" /><label>Games</label>
				<input type="checkbox" /><label>Fun Poker</label>
				<input type="checkbox" /><label>Cross product</label>
				<input type="checkbox" /><label>Casino Tournaments</label>
				<input type="checkbox" /><label>Casino</label>
				<input type="checkbox" /><label>Blackjack Tournaments</label>
				<input type="checkbox" /><label>Bingo</label>
				<input type="checkbox" /><label>Binary Options</label>
				<input type="checkbox" /><label>Admin</label>
				<input type="checkbox" /><label>All/None</label>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				View
				<select>
					<option>Players</option>
				</select>
				<select>
					<option>Pick refresh mode</option>
				</select>
				<input type="botton" value="Show" />
			</td>
		</tr>
	</table>
	<p>Add/Remove Columns  Hide row numbers</p>
	<p>Search resuts:206.Showing 1-25</p>
	<table border="1" width="100%" cellpadding="0" cellspacing="0">
	<tr>
			<td><input type="checkbox" /></td>
			<td>&nbsp;</td>
			<td>Username</td>
			<td>Login Time</td>
			<td>Status</td>
			<td>VIP level</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Type</td>
			<td>Casino</td>
			<td>Server Name</td>
			<td>Remote lp</td>
			<td>Client Type</td>
			<td>Client Platform</td>
			<td>Location</td>
			<td>Currency Code</td>
			<td>Language Code</td>
			<td>Intemal</td>
			<td>Serial</td>
			<td>&nbsp;</td>
		</tr>
		<%Map<String,Player> mapp =new HashMap<String,Player>(); 
		mapp =(Map)request.getAttribute("map"); 
		for (Player value : mapp.values()) {
			out.println("<tr><td><input type='checkbox' /></td><td>1</td><td>"+value.getNickname()+"</td><td>2014-05-21 03:14:59</td><td>Online</td><td>20</td><td>Teresa</td><td>Philpot</td><td>Real</td><td>winner casino</td><td>real5.casino.winner.com</td><td>96.54.69.149</td><td>casino</td><td>download</td><td>Dragon Kindom,lobby</td><td>CAD</td><td>EN</td><td>No</td><td>WNW804E0I3912756</td><td><a href='kick?nickname="+value.getNickname()+"'> Kick</a></td></tr>");
			
			}		
		%>
		<!--
		<tr>
			<td><input type="checkbox" /></td>
			<td>1</td>
			<td>WNR135105942</td>
			<td>2014-05-21 03:14:59</td>
			<td>Online</td>
			<td>20</td>
			<td>Teresa</td>
			<td>Philpot</td>
			<td>Real</td>
			<td>winner casino</td>
			<td>real5.casino.winner.com</td>
			<td>96.54.69.149</td>
			<td>casino</td>
			<td>download</td>
			<td>Dragon Kindom,lobby</td>
			<td>CAD</td>
			<td>EN</td>
			<td>No</td>
			<td>WNW804E0I3912756</td>
			<td><input type="button" value="Kick" /></td>
		</tr>
		<tr>
			<td><input type="checkbox" /></td>
			<td>1</td>
			<td>WNR135105942</td>
			<td>2014-05-21 03:14:59</td>
			<td>Online</td>
			<td>20</td>
			<td>Teresa</td>
			<td>Philpot</td>
			<td>Real</td>
			<td>winner casino</td>
			<td>real5.casino.winner.com</td>
			<td>96.54.69.149</td>
			<td>casino</td>
			<td>download</td>
			<td>Dragon Kindom,lobby</td>
			<td>CAD</td>
			<td>EN</td>
			<td>No</td>
			<td>WNW804E0I3912756</td>
			<td><input type="button" value="Kick" /></td>
		</tr>
		<tr>
			<td><input type="checkbox" /></td>
			<td>1</td>
			<td>WNR135105942</td>
			<td>2014-05-21 03:14:59</td>
			<td>Online</td>
			<td>20</td>
			<td>Teresa</td>
			<td>Philpot</td>
			<td>Real</td>
			<td>winner casino</td>
			<td>real5.casino.winner.com</td>
			<td>96.54.69.149</td>
			<td>casino</td>
			<td>download</td>
			<td>Dragon Kindom,lobby</td>
			<td>CAD</td>
			<td>EN</td>
			<td>No</td>
			<td>WNW804E0I3912756</td>
			<td><input type="button" value="Kick" /></td>
		</tr>
		<tr>
			<td><input type="checkbox" /></td>
			<td>1</td>
			<td>WNR135105942</td>
			<td>2014-05-21 03:14:59</td>
			<td>Online</td>
			<td>20</td>
			<td>Teresa</td>
			<td>Philpot</td>
			<td>Real</td>
			<td>winner casino</td>
			<td>real5.casino.winner.com</td>
			<td>96.54.69.149</td>
			<td>casino</td>
			<td>download</td>
			<td>Dragon Kindom,lobby</td>
			<td>CAD</td>
			<td>EN</td>
			<td>No</td>
			<td>WNW804E0I3912756</td>
			<td><input type="button" value="Kick" /></td>
		</tr>
		<tr>
			<td><input type="checkbox" /></td>
			<td>1</td>
			<td>WNR135105942</td>
			<td>2014-05-21 03:14:59</td>
			<td>Online</td>
			<td>20</td>
			<td>Teresa</td>
			<td>Philpot</td>
			<td>Real</td>
			<td>winner casino</td>
			<td>real5.casino.winner.com</td>
			<td>96.54.69.149</td>
			<td>casino</td>
			<td>download</td>
			<td>Dragon Kindom,lobby</td>
			<td>CAD</td>
			<td>EN</td>
			<td>No</td>
			<td>WNW804E0I3912756</td>
			<td><input type="button" value="Kick" /></td>
		</tr>-->
	</table>
</body>
</html>
