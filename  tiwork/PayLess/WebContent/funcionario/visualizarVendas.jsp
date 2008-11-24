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
		var nome = document.forms[0].remedio.value;
		var dataInicio = document.forms[0].dc1.value;
		var dataFim = document.forms[0].dc2.value;
		var mensagem = document.getElementById('erro');
		var msg = mensagem.innerHTML;
		msg = "";
		if ((nome=='')&&((dataInicio=='')&&(dataFim==''))){
			msg = msg+'* O campo Nome ou os campos Datas devem ser preenchidos.<br>';
		}else {
			if (nome==''){
				if (dataInicio==''){
					msg = msg+'* O campo Data Início deve ser preenchido.<br>';
				}
				if (dataFim==''){
					msg = msg+'* O campo Data Fim deve ser preenchido.<br>';
				}
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
<table width="500" align="center">
	<tr><td align="center">
		<font face="tahoma" size="2">
		<div id="msg"></div>
	</font></td></tr>
	<tr><td><h2><center>Pay Less</center></h2></td></tr>
	<tr><td><fieldset><legend>Visualizar Venda</legend>
	<fieldset><legend>Buscar por Remédio</legend>
	<form name="formulario" action="/PayLess/Controller?method=VisualizarVendas" method='post'>
		<table align="center">
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="remedio" value="${remedio}"/></td>
			</tr>
			<tr>
				<td>Data Início:</td>
				<td><input class="plain" name="dc1" value="${dataInicio}" size="12" onfocus="this.blur()" readonly><a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fStartPop(document.formulario.dc1,document.formulario.dc2);return false;" HIDEFOCUS><img class="PopcalTrigger" align="absmiddle" src="/PayLess/DateRange/calbtn.gif" width="34" height="22" border="0" alt=""></a></td>
			</tr>
			<tr>
				<td>Data Fim:</td>
				<td><input class="plain" name="dc2" value="${dataFim}" size="12" onfocus="this.blur()" readonly><a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fEndPop(document.formulario.dc1,document.formulario.dc2);return false;" HIDEFOCUS><img class="PopcalTrigger" align="absmiddle" src="/PayLess/DateRange/calbtn.gif" width="34" height="22" border="0" alt=""></a></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type='button' value='Buscar' onclick="validarCampos();"/></td>
			</tr>
		</table>

	</form>
	</fieldset>

	<c:if test="${!empty requestScope.vendas}">
		<fieldset><legend>Lista de Vendas</legend>
			<table align="center">
				<tr>
					<td align="center">Venda</td><td align="center">Funcionário</td><td align="center">Remédio</td><td align="center">Quantidade</td><td align="center">Valor</td><td align="center">Data</td>
				</tr>
				<c:forEach var="v" items="${requestScope.vendas}">
					<tr>
						<td align="center">${v.codVenda}</td><td align="center">${v.nomeFuncionario}</td><td align="center">${v.nomeRemedio}</td><td align="center">${v.quantidade}</td><td align="center">${v.valor}</td><td align="center">${v.dataString}</td>
					</tr>
				</c:forEach>
			</table>
	
		</fieldset>
	</c:if>
	</fieldset></td></tr>
	<tr><td><table style="width: 100%"><tr><td><form action='/PayLess/funcionario/funcionario.jsp'>
<input type='image' src='/PayLess/voltar.gif' value='ok'/>
</form>  </td><td align="right"> Login: ${login} <a style="align: right" href="/PayLess/Controller?method=Logout">(logout)</a></td></tr></table></td></tr>
	<tr><td><font face="tahoma" size="2" color="red">
		<div id="erro"></div>
	</font></td></tr>
</table>

<iframe width=132 height=142 name="gToday:contrast:agenda.js" id="gToday:contrast:agenda.js" src="/PayLess/DateRange/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
</iframe>

</body>
</html>