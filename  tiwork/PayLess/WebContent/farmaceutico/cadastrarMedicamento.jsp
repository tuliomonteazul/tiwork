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
	function testeDesabilita(){
	var tipo =  document.forms[0].tipo.selectedIndex;
	var qtd = document.getElementById("qtd");
	var quantidade = document.forms[0].quantidade;
	if(tipo == '0'){
		qtd.style.display='block';
		quantidade.style.display='block';
	}else{
		quantidade.value= '';
		quantidade.style.display='none';
		qtd.style.display='none';
		}
	}
	function validarCampos() {
		var nome = document.forms[0].nome.value;
		var tipo = document.forms[0].tipo.selectedIndex;
		var principio = document.forms[0].principio.value;
		var peso = document.forms[0].peso.value;
		var qtd = document.forms[0].quantidade.value;
		var mensagem = document.getElementById('erro');
		var msg = mensagem.innerHTML;
		msg = "";
		
		if (nome==''){
			msg = msg+'* O campo Nome deve ser preenchido<br>';
		}
		if (principio==''){
			msg = msg+'* O campo Princípio deve ser preenchido<br>';
		}
		if (peso==''){
			msg = msg+'* O campo Peso deve ser preenchido<br>';
		}
		if(tipo == '0'){
		if (qtd<0){
			msg = msg+'* O campo Quantidade deve ser positivo<br>';
		}
		if (qtd == ''){
			msg = msg+'* O campo Quantidade deve ser preenchido<br>';
		}
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
	<tr><td><h2><center>Pay Less</center></h2></td></tr>
	<tr><td align="center">
		<font face="tahoma" size="2">
		<div id="msg"></div>
	</font></td></tr>
	<tr><td><fieldset><legend>Cadastrar Medicamento</legend>
	<form action="/PayLess/Controller?method=CadastrarMedicamento" method='post'>
		
<table align="center">
			<tr>
				<td>Nome: </td><td> <input type='text' name='nome' size="20"/></td>
			</tr>
			<tr>
				<td>Principio Ativo: </td><td> <input type='text' name='principio' size="20"/></td>
			</tr>
			<tr>
				<td>Tipo Medicamento: </td><td>
					<select  name='tipo' onchange="testeDesabilita()" >
						<option value='drageas'>Drágea</option>
						<option value='suspensao'>Suspensão</option>
					</select>	
				</td>
			</tr>
			<tr>
				<td>Peso: </td><td> <input type='text' name='peso'/> </td>
			</tr>
			<tr>
				<td>Medida: </td><td> <select name='medida'>
						 		<c:forEach var="item" items="${medidas}">
									<option value='${item}'>${item}</option>		 
								 </c:forEach>
							</select>
				</td>
			</tr>
		
				<tr>
					<td><div id='qtd'>Quantidade:</div></td> <td><input type='text' name='quantidade'/></td>
				</tr>
		
			<tr><td colspan="2" align="center">
			<input type='button' value='Inserir' onclick="validarCampos();"/>
			</td></tr>
		</table>

	</form>
	<tr><td><table style="width: 100%"><tr><td><form action='/PayLess/farmaceutico/farmaceutico.jsp'>
<input type='image' src='/PayLess/voltar.gif' value='ok'/>
</form>  </td><td align="right"> <a style="align: right" href="/PayLess/Controller?method=Logout">(logout)</a></td></tr></table></td></tr>
	<tr><td><font face="tahoma" size="2" color="red">
		<div id="erro"></div>
	</font></td></tr>
</table>
	
</body>
</html>
