<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel California</title>
<link rel=stylesheet href="padrao.css" type="text/css">
<script type="text/javascript">
	function VerificarMsg() {
		var msgReq = "<%=request.getAttribute("msg")%>";
		var erroReq = "<%=request.getAttribute("erro")%>";
		var msgElem = document.getElementById('msg');
		var erroElem = document.getElementById('erro');
		var msg = msgElem.innerHTML;
		var erro = erroElem.innerHTML;
		msg = "";
		erro = "";
		if(msgReq!="null"){
			msg = msgReq;
		}
		if(erroReq!="null"){
			erro = erroReq;
		}
		msgElem.innerHTML = msg;
		erroElem.innerHTML = erro;
	}
</script>
</head>
<body onload="VerificarMsg()">
	<c:url value="Controller" var="listar">  
		<c:param name="method" value="ListarReferencia"/>
	</c:url>
	<c:url value="Controller" var="sintomas">  
		<c:param name="method" value="ListarSintomas"/>
	</c:url>
<table width="300" align="center">
	<tr><td align="center">
		<font face="tahoma" size="2">
		<div id="msg"></div>
	</font></td></tr>
	<tr><td><h2><center>Pay Less</center></h2></td></tr>
	<tr><td><fieldset><legend>Farmaceutico</legend>
		<table>
			<tr><td><a href="${listar}">Cadastrar Medicamento</a></td></tr>
			<tr><td><a href="${sintomas}">Cadastrar Tipo de Doenças</a></td></tr>
			<tr><td><a href="/PayLess/farmaceutico/cadastrarSintomas.jsp">Cadastrar Sintomas</a></td></tr>
			<tr><td><a href="/PayLess/farmaceutico/cadastrarMedicacao.jsp">Cadastrar Medicação</a></td></tr>
			<tr><td><a href="/PayLess/farmaceutico/visualizarRemedios.jsp">Visualizar Remédios</a></td></tr>
		</table>

	</fieldset></td></tr>
	<tr><td>Login: ${sessionScope.login} - <a href="Controller?method=Logout">(Logout)</a></td></tr>
	<tr><td><font face="tahoma" size="2" color="red">
		<div id="erro"></div>
	</font></td></tr>
</table>
</body>
</html>