<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<tr><td><fieldset><legend>Cadastrar Usu�rio</legend>
	<form action="Controller?method=CadastrarUsuario" method='post'>
		<table>
			<tr>
				<td>Medicamento:</td>
				<td>
					<select name="medicamento">
						<
					</select>
				</td>
			</tr>
			<tr>
				<td>Quantidade:</td><td><input type='text' name='login'/></td>
			</tr>	
			<tr>
				<td>Valor Unit�rio:</td><td><input type='password' name='senha'/></td>
			</tr>
			<tr>
				<td>Papel:</td>
				<td>
					<select name="papel">
						<option value="1">1 - Funcion�rio</option>
						<option value="2">2 - Farmac�utico</option>
					</select>
				</td>
			</tr>
			<tr><td>
			<input type='submit' value='Cadastrar'/>
			</td></tr>
		</table>

	</form>
	<tr><td>Login: ${login} (<a href="Controller?method=Logout">logout</a>)</td></tr>
	<tr><td><font face="tahoma" size="2" color="red">
	<div id="msg"></div>
	</font></td></tr>
</table>
</body>
</html>