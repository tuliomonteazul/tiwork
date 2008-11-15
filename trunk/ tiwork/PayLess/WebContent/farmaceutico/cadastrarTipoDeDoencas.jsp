<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel=stylesheet href="padrao.css" type="text/css">
</head>
<body>
<form action="Controller?method=CadastrarDoenca" method="post">
<table>
	<tr>
		<td>Nome: <input type='text' name='descricao'/></td>
	</tr>
	<tr>
		<td>Sintomas:
			<select multiple="multiple" name="sintomas">
			 <c:forEach items="${sintomas}" var="sintoma">
				<option value="${sintoma}">${sintoma}</option>
			   </c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>Medicamentos:
			<select multiple="multiple" name="medicamentos">
			 <c:forEach items="${medicamentos}" var="medicamentos">
				<option value="${medicamentos.nome}">${medicamentos.nome}</option>
			   </c:forEach>
			</select>
		</td>
	</tr>
	<tr><td><input type='submit' value='ok'/></td></tr>
</table>
</form>
</body>
</html>