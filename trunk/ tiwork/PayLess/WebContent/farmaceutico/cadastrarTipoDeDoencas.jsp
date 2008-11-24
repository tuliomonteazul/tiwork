<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay Less</title>
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
		var nome = document.forms[0].descricao.value;
		var sintomas = document.forms[0].sintomas.selectedIndex;
		var medicamentos = document.forms[0].medicamentos.selectedIndex;
		var mensagem = document.getElementById('erro');
		var msg = mensagem.innerHTML;
		msg = "";
		if (nome==''){
			msg = msg+'* O campo descrição deve ser preenchido<br>';
		}
		
		if (sintomas == -1){
			msg = msg + '* O campo sintomas deve ter pelo menos um sintoma selecionado<br>';
		}

		if (medicamentos == -1){
				msg = msg + '* O campo medicamentos deve ter pelo menos um medicamentos selecionado<br>';
			}

		
		mensagem.innerHTML = msg;
		if(msg.length<1){
			document.forms[0].submit();
		}
	}
	</script>

<link rel=stylesheet href="padrao.css" type="text/css">
</head>
<body onload="VerificarMsg()">
<form action="Controller?method=CadastrarDoenca" method="post">

<table width="300" align="center">
	<tr><td><h2><center>Pay Less</center></h2></td></tr>
	<tr><td align="center">
		<font face="tahoma" size="2">
		<div id="msg"></div>
	</font></td></tr>
	<tr><td><fieldset><legend>Cadastrar Medicamento</legend>
	<form action="/PayLess/Controller?method=CadastrarMedicamento" method='post'>
		
	<table align="center">
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
			<tr><td colspan="2" align="center">
			<input type='button' value='Inserir' onclick="validarCampos();"/>
			</td></tr>
		</table>

	</form>
	<tr><td><table style="width: 100%"><tr><td><a href="/PayLess/farmaceutico/farmaceutico.jsp">Voltar</a>  </td><td align="right"> Login: ${login} <a style="align: right" href="/PayLess/Controller?method=Logout">(logout)</a></td></tr></table></td></tr>
	<tr><td><font face="tahoma" size="2" color="red">
		<div id="erro"></div>
	</font></td></tr>
</table>























</form>
</body>
</html>