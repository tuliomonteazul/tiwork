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
	<form  action="Controller" method="post">
		<input type='hidden' name='method' value='CadastrarMedicamento'/>
		<table>
			<tr>
				<td>Nome: <input type='text' name='nome' size="30"/></td>
			</tr>
			<tr>
				<td>Principio Ativo: <input type='text' name='principio' size="30"/></td>
			</tr>
			<tr>
				<td>Tipo Medicamento: 
					<select  name='tipo' >
						<option value='dragea'>Drágea</option>
						<option value='suspensao'>Suspensão</option>
					</select>	
				</td>
			</tr>
			<tr>
				<td>Peso: <input type='text' name='peso'/> </td>
			</tr>
			<tr>
				<td>Medida: <select name='medida'>
						 		<c:forEach var="item" items="${medidas}">
									<option value='${item}'>${item}</option>		 
								 </c:forEach>
							</select>
				</td>
			</tr>
			<tr>
				<td>Quantidade: <input type='text' name='quantidade'/></td>
			</tr>
			<tr>
				<td>
					<input type='submit' value='OK'/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>