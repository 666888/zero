<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>monitor</title>
<style type="text/css">
	* { margin: 0px; padding: 0px;}
	li { list-style: none;}
	a { text-decoration: none; color: #000;}
	
	table { padding-left: 10px;}
	tr { height: 40px;}
</style>
</head>

<body>
	<table border="0" width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<td>Search by</td>
			<td>Time period</td>
			<td>
				<select>
					<option>Today</option>
				</select>
			</td>
			<td>Start date</td>
			<td><input type="text" /></td>
			<td>End date</td>
			<td><input type="text" /></td>
		</tr>
		<tr>
			<td>User search</td>
			<td>Username</td>
			<td><input type="text" /></td>
			<td>VIP level</td>
			<td><input type="text" /></td>
			<td colspan="2"><input type="checkbox" /><label>Internal accounts</label></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td colspan="6"><a href="javascript:;">Custom fields</a></td>
		</tr>
		<tr>
			<td>Game search</td>
			<td>Game type</td>
			<td>
				<select>
					<option>Click to select</option>
				</select>
			</td>
			<td>Game</td>
			<td>
				<select>
					<option>Click to select</option>
				</select>
			</td>
			<td>Game code</td>
			<td><input type="text" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>Client type</td>
			<td>
				<select>
					<option>Click to select</option>
				</select>
			</td>
			<td>Client platform</td>
			<td>
				<select>
					<option>Click to select</option>
				</select>
			</td>
			<td>Signup platform</td>
			<td>
				<select>
					<option>Click to select</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>Country</td>
			<td>
				<select>
					<option>Click to select</option>
				</select>
			</td>
			<td>Language</td>
			<td>
				<select>
					<option>Click to select</option>
				</select>
			</td>
			<td>Currency</td>
			<td>
				<select>
					<option>Click to select</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>Casino</td>
			<td>
				<select>
					<option>Click to select</option>
				</select>
			</td>
			<td>Total bet less than</td>
			<td><input type="text" /></td>
			<td>Total bet more than</td>
			<td><input type="text" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>Signup casino skin</td>
			<td>
				<select>
					<option>Click to select</option>
				</select>
			</td>
			<td>Total win less than</td>
			<td><input type="text" /></td>
			<td>Total win more than</td>
			<td><input type="text" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>Advertiser</td>
			<td><input type="text" /></td>
			<td>Channel ID</td>
			<td>
				<select>
					<option>Click to select</option>
				</select>
			</td>
			<td>Live game network</td>
			<td>
				<select>
					<option>Click to select</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Show</td>
			<td colspan="6">
				<input type="checkbox" /><label>Progressive columns</label>
				<input type="checkbox" /><label>Autoplay columns</label>
				<input type="checkbox" /><label>Refund columns</label>
				<input type="checkbox" /><label>Real money columns</label>
				<input type="checkbox" /><label>Live games tip</label>
			</td>
		</tr>
		<tr>
			<td>Report by</td>
			<td colspan="6">
				<input type="radio" /><label>Daily</label>
				<input type="radio" /><label>Monthly</label>
				<input type="radio" /><label>Username</label>
				<input type="radio" /><label>Game</label>
				<input type="radio" /><label>Game type</label>
				<input type="radio" /><label>Session</label>
				<input type="radio" /><label>Casino</label>
				<input type="radio" /><label>Skin</label>
				<input type="radio" /><label>Advertiser</label>
				<input type="radio" /><label>VIP level</label>
				<input type="radio" /><label>Currency</label>
				<input type="radio" /><label>Language</label>
				<input type="radio" /><label>Kiosk</label>
				<input type="radio" /><label>Gamegroup</label>
				<input type="radio" /><label>Country</label>
				<input type="radio" /><label>Channel ID</label>
				<input type="radio" /><label>Live Network</label>
			</td>
		</tr>
		<tr>
			<td>Sort by</td>
			<td colspan="6">
				<input type="radio" /><label>Games</label>
				<input type="radio" /><label>Wins</label>
				<input type="radio" /><label>Bets</label>
				<input type="radio" /><label>Income</label>
				<input type="radio" /><label>Key</label>
				<input type="radio" /><label>#players</label>
				<input type="checkbox" /><label>In descending order</label>
			</td>
		</tr>
		<tr>
			<td colspan="7">
				<input type="checkbox" />
				Include current hour data(slow)
				<input type="button" value="Show stats" />
				<input type="button" value="Export" />
			</td>
		</tr>
	</table>
	<h3>Total rows:444</h3>
	<table border="1" width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td>Game</td>
			<td>#players</td>
			<td>#games</td>
			<td>Total bets</td>
			<td>Total wins</td>
			<td>Game income share</td>
			<td>Game payout%</td>
			<td>Game income share%</td>
		</tr>
		<tr>
			<td>Marvel Jackpot</td>
			<td>16</td>
			<td>4204</td>
			<td>$-17.18</td>
			<td>$0.00</td>
			<td>$0.00</td>
			<td>0.0%</td>
			<td>0.0%</td>
		</tr>
		<tr>
			<td>Marvel Jackpot</td>
			<td>16</td>
			<td>4204</td>
			<td>$-17.18</td>
			<td>$0.00</td>
			<td>$0.00</td>
			<td>0.0%</td>
			<td>0.0%</td>
		</tr>
		<tr>
			<td>Marvel Jackpot</td>
			<td>16</td>
			<td>4204</td>
			<td>$-17.18</td>
			<td>$0.00</td>
			<td>$0.00</td>
			<td>0.0%</td>
			<td>0.0%</td>
		</tr>
		<tr>
			<td>Marvel Jackpot</td>
			<td>16</td>
			<td>4204</td>
			<td>$-17.18</td>
			<td>$0.00</td>
			<td>$0.00</td>
			<td>0.0%</td>
			<td>0.0%</td>
		</tr>
		<tr>
			<td>Marvel Jackpot</td>
			<td>16</td>
			<td>4204</td>
			<td>$-17.18</td>
			<td>$0.00</td>
			<td>$0.00</td>
			<td>0.0%</td>
			<td>0.0%</td>
		</tr>
	</table>
</body>
</html>
