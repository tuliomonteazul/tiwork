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
	function validarCampos() {
		var sintomasDirLength = document.forms[0].sintomasDir.length;
		var mensagem = document.getElementById('erro');
		var msg = mensagem.innerHTML;
		msg = "";
		if (sintomasDirLength==0){
			msg = msg+'* Você deve clicar nos sintomas da coluna esquerda para selecioná-los.<br>';
		}
		mensagem.innerHTML = msg;
		if(msg.length<1){
			document.forms[0].submit();
		}
	}
	function passarDir() {
		var sintomasEsq = document.forms[0].sintomasEsq;
		var sintomasDir = document.forms[0].sintomasDir;
		var sintomasDirLength = sintomasDir.length;
        var sintoma = sintomasEsq.options[sintomasEsq.selectedIndex].value;
        sintomasDir.options[sintomasDirLength] = new Option(sintoma);
        sintomasEsq.options[sintomasEsq.selectedIndex] = null;
	}
	function passarEsq() {
		var sintomasEsq = document.forms[0].sintomasEsq;
		var sintomasDir = document.forms[0].sintomasDir;
		var sintomasEsqLength = sintomasEsq.length;
        var sintoma = sintomasDir.options[sintomasDir.selectedIndex].value;
        sintomasEsq.options[sintomasEsqLength] = new Option(sintoma);
        sintomasDir.options[sintomasDir.selectedIndex] = null;
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
			<tr><td align="center">Lista de Sintomas:</td><td align="center">Sintomas do Paciente:</td></tr>
			<tr>
				<td><select name="sintomasEsq" size="8" style="width: 150px"m ultiple="multiple" onchange="passarDir();">
						<c:forEach items="${sintomas}" var="s">
							<option value="${s}">${s}</option>
						</c:forEach>
					</select>
				</td>
				<td><select name="sintomasDir" size="8" style="width: 150px" multiple="multiple" onchange="passarEsq();">
					</select>
				</td>
			</tr>
			<tr><td colspan="2">
					<c:forEach items="${sintomas}" var="s">
						<input type="checkbox" name="sintomas" value="${s}"/>${s} 
					</c:forEach>
				</td></tr>
			<tr><td colspan="5" align="right"><input type="button" value="Buscar" onclick="validarCampos();"/></tr>
		</table>

	</form>
	</fieldset>
	<c:if test="${!empty requestScope.doencas}">
		<fieldset><legend>Lista de Doenças Prováveis</legend>
			<table align="center">
				<tr>
					<td align="center">Nome</td>
				</tr>
				<c:forEach var="d" items="${requestScope.doencas}">
					<tr>
						<td align="center">${d.descricao}</td>
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