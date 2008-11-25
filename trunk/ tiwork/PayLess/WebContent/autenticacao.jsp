<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay Less</title>
<style type="text/css">
a {
font: 10pt "Tahoma";
color: black;
font-weight: none;
text-decoration: none
}
table {
font: 10pt "Tahoma";
color: black;
font-weight: none;
text-decoration: none
}
td {
font: 10pt "Tahoma";
color: black;
font-weight: none;
text-decoration: none
}
body {
font: 10pt "Tahoma";
color: black;
font-weight: none;
text-decoration: none
}
fieldset {
font: 10pt "Tahoma";
color: black;
font-weight: none;
text-decoration: none
}
</style>
</head>
<body>
<table width="300" align="center">
	<tr><td align="center">
		<font face="tahoma" size="2">
		<div id="msg"></div>
	</font></td></tr>
	<tr><td><h2><center>Pay Less</center></h2></td></tr>
	<tr><td><fieldset><legend>Autenticação</legend>
	<form action="j_security_check" method='post'>
		<table align="center">
			<tr>
				<td>Login:</td><td><input type='text' name='j_username'/></td>
			</tr>
			<tr>
				<td>Senha:</td><td><input type='password' name='j_password'/></td>
			</tr>	
			<tr>
				<td></td><td><input type='submit' value='OK'/></td>
			</tr>
		</table>

	</form>
	<tr><td><font face="tahoma" size="2" color="red">
		<div id="erro"></div>
	</font></td></tr>
	<tr><td><form action='/PayLess/index.jsp'>
<input type='image' src='/PayLess/voltar.gif' value='ok'/>
</form></td></tr>
</table>
</body>
</html>