<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset title="DOENCAS POR SINTOMAS">
<table>
		<tr>

			<td>Doencas: 
	<c:if test="${!empty requestScope.doencas}">
			<select name='doencas'multiple="multiple">
				<c:forEach var="sintomas" items="${doencas}">
					<option value="${sintomas.nome}">${sintomas.nome}</option>
				</c:forEach>
			</select>
</c:if>
		</td>
		</tr>

		<tr>
			<td><input type='submit' value='ok'/> </td>
		</tr>
	</table> 
</fieldset>
</body>
</html>