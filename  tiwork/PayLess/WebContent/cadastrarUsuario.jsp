<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel California</title>
<link rel=stylesheet href="padrao.css" type="text/css">
</head>
<body>
<table width="300" align="center">
	<tr><td><h2><center>Pay Less</center></h2></td></tr>
	<tr><td><fieldset><legend>Login</legend>
	<form action="Controller?method=EfetuarAluguel" method='post'>
		<input type='hidden' name="method" value='CadastroQuarto'/>
		<table>
			<tr>
				<td>Cpf:</td><td><input type='text' name='cpf'/></td>
			</tr>
			<tr>
				<td>Quarto:</td><td><input type='text' name='numero'/></td>
			</tr>	
			<tr>
				<td>Data Saída:</td><td><input type='text' name='dataSaida' maxlength="10" onkeypress="mascara(this,dataValidacao)"/></td>
			</tr>
			<tr>
				<td>Quantidade:</td><td><input type='text' name='hospedados'/></td>
			</tr>
			<tr>
			<input type='submit' value='ok'/>
			</tr>
		</table>

	</form>
	<tr><td>Login: ${login} (<a href="Controller?method=Logout">logout</a>)</td></tr>
	<tr><td><font face="tahoma" size="2" color="red">
	<div id="msg"></div>
	</font></td></tr>
</table>
</body>
</html>