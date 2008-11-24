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
<form method='post' action="Controller?method=ListarDoencaPorSintomas">
	<fieldset><legend>Escolha os sintomas</legend>
	<table align="center">  
		<tr>
			<td>

			<select name='sintomas'multiple="multiple">
				<c:forEach var="sintoma" items="${sintomas}">
					<option value="${sintoma}">${sintoma}</option>
				</c:forEach>
			</select></td>
		</tr>

		<tr>
			<td><input type='submit' value='ok'/> </td>
		</tr>
	</table> 
</fieldset>

<c:if test="${!empty requestScope.doencas}">
	<fieldset ><legend>Doencas por Sintomas</legend>
		<table align="center">
			<tr>
				<td> 
				<select name='doencas'multiple="multiple">
					<c:forEach var="sintomas" items="${doencas}">
						<option value="${sintomas.nome}">${sintomas.nome}</option>
					</c:forEach>
				</select>
				</td>
			</tr>
		</table> 
	</fieldset>
</c:if>
<c:if test="${!empty requestScope.medicacao}">
		<fieldset><legend>Medicacao por Doenca</legend>
		<table align="center">
			<tr>
				<td> 
				<select name='medicacao'multiple="multiple">
					<c:forEach var="sintomas" items="${medicacao}">
						<option value="${sintomas}">${sintomas}</option>
					</c:forEach>
				</select>
				</td>
			</tr>
		</table> 
		</fieldset>
</c:if>
</form>
</body>
</html>