<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay Less</title>
<link rel=stylesheet href="padrao.css" type="text/css">
</head>
<body>
<table width="300" align="center">
	<tr><td><h2><center>Pay Less</center></h2></td></tr>
	<tr><td><fieldset><legend>Cadastrar Usuário</legend>
	<form action="Controller?method=CadastrarUsuario" method='post'>
		<table>
			<tr>
				<td>Nome:</td><td><input type='text' name='nome'/></td>
			</tr>
			<tr>
				<td>Login:</td><td><input type='text' name='login'/></td>
			</tr>	
			<tr>
				<td>Senha:</td><td><input type='password' name='senha'/></td>
			</tr>
			<tr>
				<td>Papel:</td>
				<td>
					<select name="papel">
						<option value="1">1 - Funcionário</option>
						<option value="2">2 - Farmacêutico</option>
					</select>
				</td>
			</tr>
			<tr><td>
			<input type='submit' value='Cadastrar'/>
			</td></tr>
		</table>

	</form>
	</fieldset></td></tr>
	<tr><td><table style="width: 100%"><tr><td><a href="/PayLess/funcionario/funcionario.jsp">Voltar</a>  </td><td align="right"> Login: ${login} <a style="align: right" href="/PayLess/Controller?method=Logout">(logout)</a></td></tr></table></td></tr>
	<tr><td><font face="tahoma" size="2" color="red">
	<div id="msg"></div>
	</font></td></tr>
</table>
</body>
</html>