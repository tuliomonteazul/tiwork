<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<form action="Controller?method=AquisicaoRemedioInserir" method='post'>
		<table>
			<tr>
				<td>Medicamento:</td>
				<td>
					<select name="medicamento">
						<c:forEach var="m" items="medicamentos">
							<option value="${m.cod}">${m.cod} - ${m.nome}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Quantidade:</td><td><input type='text' name='quantidade'/></td>
			</tr>	
			<tr>
				<td>Valor Unitário:</td><td><input type='text' name='valor'/></td>
			</tr>
			<tr><td>
			<input type='submit' value='Inserir'/>
			</td></tr>
		</table>

	</form>
	<tr><td><table><tr><td><a href="funcionario.jsp">Voltar</a></td><td align="right">Login: ${login} - <a href="Controller?method=Logout">(logout)</a></td></tr></table></td></tr>
	<tr><td><font face="tahoma" size="2" color="red">
	<div id="msg"></div>
	</font></td></tr>
</table>
</body>
</html>