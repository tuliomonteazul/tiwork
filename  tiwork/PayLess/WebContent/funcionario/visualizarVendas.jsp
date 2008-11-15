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
	<form action="/PayLess/Controller?method=VisualizarVendas" method='post'>
		<table align="center">
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="remedio"/></td>
				<td><input type='submit' value='Buscar'/></td>
			</tr>
		</table>

	</form>
	</fieldset>
	<fieldset><legend>Buscar por período</legend>
	<form name="formulario" action="/PayLess/Controller?method=VisualizarVendas" method='post'>
		<table align="center">
			<tr>
				<td>Data Início:</td>
				<td><input class="plain" name="dc1" value="${dataInicio}" size="12" onfocus="this.blur()" readonly><a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fStartPop(document.formulario.dc1,document.formulario.dc2);return false;" HIDEFOCUS><img class="PopcalTrigger" align="absmiddle" src="/PayLess/funcionario/DateRange/calbtn.gif" width="34" height="22" border="0" alt=""></a></td>
			</tr>
			<tr>
				<td>Data Fim:</td>
				<td><input class="plain" name="dc2" value="${dataFim}" size="12" onfocus="this.blur()" readonly><a href="javascript:void(0)" onclick="if(self.gfPop)gfPop.fEndPop(document.formulario.dc1,document.formulario.dc2);return false;" HIDEFOCUS><img class="PopcalTrigger" align="absmiddle" src="/PayLess/funcionario/DateRange/calbtn.gif" width="34" height="22" border="0" alt=""></a></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type='submit' value='Buscar'/></td>
			</tr>
		</table>

	</form>
	</fieldset>

	<c:if test="${!empty requestScope.vendas}">
		<fieldset><legend>Lista de Vendas</legend>
			<table align="center">
				<tr>
					<td>Código da Venda</td><td>Código do Funcionário</td><td>Código do Remédio</td><td>Quantidade</td><td>Valor</td><td>Data</td>
				</tr>
				<c:forEach var="v" items="${requestScope.vendas}">
					<tr>
						<td>${v.codVenda}</td><td>${v.codFuncionario}</td><td>${v.codRemedio}</td><td>${v.quantidade}</td><td>${v.valor}</td><td>${v.data}</td>
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