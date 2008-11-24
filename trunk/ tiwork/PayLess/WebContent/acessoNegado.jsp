<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay Less</title>
<link rel=stylesheet href="padrao.css" type="text/css">
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
<body onload="VerificarMsg()">
<table width="300" align="center">
	<tr><td align="center">
		<font face="tahoma" size="2">
		<div id="msg"></div>
	</font></td></tr>
	<tr><td>Acesso Negado</td></tr>
	<tr><td><a style="align: right" href="/PayLess/Controller?method=Logout">Voltar</a></td></tr>
</table>
</body>
</html>