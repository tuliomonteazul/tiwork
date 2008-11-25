<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	function limpar(){
		var sintomas = document.forms[0].sintomas;
		for (i = 0; i <= sintomas.length; i++){
			sintomas[i].checked = false;
		}
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
	<tr><td><fieldset><legend>Buscar Remédio</legend>
	<fieldset><legend>Lista de Sintomas</legend>
	<form action="/PayLess/Controller?method=BuscarRemedioDoenca" method='post'>
		<table align="center">
			<tr><td align="center">Sintomas do Paciente:</td></tr>
			<tr><td>
					<c:forEach items="${sintomas}" var="s">
						<c:set var="checado" value="false"/>
						<c:forEach items="${sintomasJsp}" var="s2">
							<c:if test="${pageScope.s2 eq pageScope.s}">
								<c:set var="checado" value="true"/>
							</c:if>
						</c:forEach>
							<c:if test="${pageScope.checado eq true}">
								<input type="checkbox" name="sintomas" value="${s}" checked="checked"/>${s} <br/>
							</c:if>
							<c:if test="${! (pageScope.checado eq true)}">
								<input type="checkbox" name="sintomas" value="${s}"/>${s} <br/>
							</c:if>
					</c:forEach>
				</td></tr>
			<tr><td colspan="5" align="right"><input type="button" value="Limpar" onclick="javascript: if (confirm('Tem certeza que deseja limpar os campos?')) limpar();"/><input type="submit" value="Buscar"/></tr>
		</table>

	</form>
	</fieldset>
	<c:if test="${!empty requestScope.doencas}">
		<fieldset><legend>Lista de Doenças Prováveis</legend>
			<table align="center" width="400">
				<tr>
					<td align="center">Nome</td><td align="center">Medicamento</td>
				</tr>
				<c:forEach var="d" items="${requestScope.doencas}">
					<tr>
						<td align="center">${d.nome}</td><td align="center">
						<c:if test="${empty d.medicamentos}">
								Não há medicamento para essa doença
						</c:if>
						<c:if test="${!empty d.medicamentos}">
							<c:forEach var="m" items="${d.medicamentos}">
								<a href="/PayLess/Controller?method=BuscarRemedioComprar&remedio=${m.nome}">${m.nome} <img style="border: none;" align="absmiddle" width="20" src="/PayLess/funcionario/carrinho.jpg" alt="comprar"/></a><br/>
							</c:forEach>
						</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
	
		</fieldset>
	</c:if>
	</fieldset></td></tr>
	<tr><td><table style="width: 100%"><tr><td>
<form action='/PayLess/funcionario/funcionario.jsp'>
<input type='image' src='/PayLess/voltar.gif' value='ok'/>
</form>
 </td><td align="right"><a style="align: right" href="/PayLess/Controller?method=Logout">(logout)</a></td></tr></table></td></tr>
	<tr><td><font face="tahoma" size="2" color="red">
		<div id="erro"></div>
	</font></td></tr>
</table>

<iframe width=132 height=142 name="gToday:contrast:agenda.js" id="gToday:contrast:agenda.js" src="/PayLess/funcionario/DateRange/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
</iframe>

</body>
</html>