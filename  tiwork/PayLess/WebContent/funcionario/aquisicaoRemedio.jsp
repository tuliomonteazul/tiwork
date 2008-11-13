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
		var qtd = document.forms[0].quantidade.value;
		var mensagem = document.getElementById('msg');
		var msg = mensagem.innerHTML;
		msg = "";
		if (qtd<0){
			msg = msg+'* O campo Quantidade deve ser positivo<br>';
		}
		mensagem.innerHTML = msg;
		if(msg.length<1){
			document.forms[0].submit();
		}
	}
</script>
</head>
<body onload="VerificarMsg()">
<table width="300" align="center">
	<tr><td align="center">
		<font face="tahoma" size="2">
		<div id="msg"></div>
	</font></td></tr>
	<tr><td><h2><center>Pay Less</center></h2></td></tr>
	<tr><td><fieldset><legend>Cadastrar Usuário</legend>
	<form action="Controller?method=AquisicaoRemedioInserir" method='post'>
		<table align="center">
			<tr>
				<td>Medicamento:</td>
				<td>
					<select name="medicamento">
						<c:forEach var="m" items="${medicamentos}">
							<option value="${m.nome}">${m.nome}</option>
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
			<input type='button' value='Inserir' onclick="validarCampos();"/>
			</td></tr>
		</table>

	</form>
	<tr><td><table style="width: 100%"><tr><td><a href="/PayLess/funcionario/funcionario.jsp">Voltar</a>  </td><td align="right"> Login: ${login} <a style="align: right" href="/PayLess/Controller?method=Logout">(logout)</a></td></tr></table></td></tr>
	<tr><td><font face="tahoma" size="2" color="red">
		<div id="erro"></div>
	</font></td></tr>
</table>
</body>
</html>