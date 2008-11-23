<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay Less</title>
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
<table width="500" align="center">
	<tr><td align="center">
		<font face="tahoma" size="2">
		<div id="msg"></div>
	</font></td></tr>
	<tr><td><h2><center>Pay Less</center></h2></td></tr>
	<tr><td><fieldset><legend>Buscar Rem�dio</legend>
	<fieldset><legend>Lista de Sintomas</legend>
	<form action="/PayLess/Controller?method=BuscarRemedioDoenca" method='post'>
		<table align="center">
			<tr><td align="center">Sintomas do Paciente:</td></tr>
			<tr><td>
					<c:forEach items="${sintomas}" var="s">
						<c:forEach items="${sintomasJsp}" var="s2">
							<c:param name=""></c:param>
						</c:forEach>
							<input type="checkbox" name="sintomas" value="${s}" checked="checked"/>${s} <br/>
							<input type="checkbox" name="sintomas" value="${s}"/>${s} <br/>
					</c:forEach>
				</td></tr>
			<tr><td colspan="5" align="right"><input type="submit" value="Buscar"/></tr>
		</table>

	</form>
	</fieldset>
	<c:if test="${!empty requestScope.doencas}">
		<fieldset><legend>Lista de Doen�as Prov�veis</legend>
			<table align="center" width="400">
				<tr>
					<td align="center">Nome</td><td align="center">Medicamento</td>
				</tr>
				<c:forEach var="d" items="${requestScope.doencas}">
					<tr>
						<td align="center">${d.nome}</td><td align="center">nomeDoMedicamento<img align="absmiddle" src="/PayLess/funcionario/carrinho.jpg" alt="comprar"/></td>
					</tr>
				</c:forEach>
			</table>
	
		</fieldset>
	</c:if>
	</fieldset></td></tr>
	<tr><td><table style="width: 100%"><tr><td><a href="/PayLess/funcionario/funcionario.jsp">Voltar</a>  </td><td align="right"> Login: ${login} <a style="align: right" href="/PayLess/Controller?method=Logout">(logout)</a></td></tr></table></td></tr>
	<tr><td><font face="tahoma" size="2" color="red">
		<div id="erro"></div>
	</font></td></tr>
</table>

<iframe width=132 height=142 name="gToday:contrast:agenda.js" id="gToday:contrast:agenda.js" src="/PayLess/funcionario/DateRange/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
</iframe>

</body>
</html>