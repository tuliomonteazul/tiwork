<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		var nome = document.forms[0].nome.value;
		var login = document.forms[0].login.value;
		var senha = document.forms[0].senha.value;
		var mensagem = document.getElementById('erro');
		var msg = mensagem.innerHTML;
		msg = "";
		if (nome==''){
			msg = msg+'* O campo Nome deve ser preenchido.<br>';
		}
		if (login==''){
			msg = msg+'* O campo Login deve ser preenchido.<br>';
		}
		if (senha==''){
			msg = msg+'* O campo Senha deve ser preenchido.<br>';
		}
		mensagem.innerHTML = msg;
		if(msg.length<1){
			document.forms[0].submit();
		}
	}
</script>
</head>
<body onload="VerificarMsg();">
<table width="300" align="center">
	<tr><td><h2><center>Pay Less</center></h2></td></tr>
	<tr><td align="center">
		<font face="tahoma" size="2">
		<div id="msg"></div>
	</font></td></tr>
	<tr><td><fieldset><legend>Cadastrar Usuário</legend>
	<form action="/PayLess/Controller?method=CadastrarUsuario" method='post'>
		<table>
			<tr>
				<td>Nome:</td><td><input type='text' name='nome'/></td>
			</tr>
			<tr>
				<td>Login:</td><td><input type='text' name='login'/></td>
			</tr>	
			<tr>
				<td>Senha:</td><td><input type='password' name='senha'/></td>
			</tr>
			<tr>
				<td>Papel:</td>
				<td>
					<select name="papel">
						<option value="1">1 - Funcionário</option>
						<option value="2">2 - Farmacêutico</option>
					</select>
				</td>
			</tr>
			<tr><td>
			<input type='button' value='Cadastrar' onclick="validarCampos();"/>
			</td></tr>
		</table>

	</form>
	</fieldset></td></tr>
	<tr><td><table style="width: 100%"><tr><td><form action='/PayLess/funcionario/funcionario.jsp'>
<input type='image' src='/PayLess/voltar.gif' value='ok'/>
</form> </td><td align="right"> Login: ${login} <a style="align: right" href="/PayLess/Controller?method=Logout">(logout)</a></td></tr></table></td></tr>
	<tr><td><font face="tahoma" size="2" color="red">
	<div id="erro"></div>
	</font></td></tr>
</table>
</body>
</html>