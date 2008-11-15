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
<table width="300" align="center">
	<tr><td align="center">
		<font face="tahoma" size="2">
		<div id="msg"></div>
	</font></td></tr>
	<tr><td><h2><center>Pay Less</center></h2></td></tr>
	<tr><td><fieldset><legend>Efetuar Venda</legend>
	<fieldset><legend>Buscar por nome</legend>
	<form action="Controller?method=EfetuarVendaDetalhes" method='post'>
		<table align="center">
			<tr>
				<td>Remédio:</td>
				<td><input type="text" name="remedio"/></td>
				<td><input type='submit' value='Buscar'/></td>
			</tr>
		</table>

	</form>
	</fieldset>
	<fieldset><legend>Buscar pela lista</legend>
	<form action="Controller?method=EfetuarVendaDetalhes" method='post'>
		<table align="center">
			<tr>
				<td>Remédio:</td>
				<td>
					<select name="remedio">
						<c:forEach var="r" items="${estoques}">
							<option value="${r.nome}">${r.nome}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<input type='submit' value='Buscar'/>	
				</td>
			</tr>
		</table>

	</form>
	</fieldset>
	<c:if test="${!empty requestScope.estoque}">
	<fieldset><legend>Detalhes do Remédio</legend>
	<form action="Controller?method=EfetuarVendaCarrinho" method='post'>
		<input type="hidden" name="nome" value="${estoque.nome}"/>
		<input type="hidden" name="valor" value="${estoque.valor}"/>
		<input type="hidden" name="cod" value="${estoque.cod}"/>
		<table align="center">
			<tr>
				<td>Nome:</td><td>${estoque.nome}</td>
			</tr>
			<tr>
				<td>Valor:</td><td>${estoque.valor}</td>
			</tr>
			<tr>
				<td>Quantidade em estoque:</td><td>${estoque.quantidade}</td>
			</tr>
			<tr>
				<td>Quantidade para a venda:</td>
				<td><select name="quantidade">
						<c:forEach var="q" begin="1" end="${estoque.quantidade}">
							<option value="${q}">${q}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type='submit' value='Adicionar ao carrinho'/></td>
			</tr>
		</table>

	</form>
	</fieldset></c:if>
	<c:if test="${!empty sessionScope.carrinho}">
		<fieldset><legend>Carrinho de Vendas</legend>
		<form action="Controller?method=EfetuarVendaInserir" method='post'>
			<input type="hidden" name="estoque" value="${estoque}"/>
			<table align="center">
				<tr>
					<td>Nome</td><td>Valor</td><td>Quantidade</td><td></td>
				</tr>
				<c:forEach var="c" items="${sessionScope.carrinho}">
					<tr>
						<td>${c.nome}</td><td>${c.valor}</td><td>${c.quantidade}</td><td><a href="Controller?method=EfetuarVendaCarrinhoExcluirItem&item=${c.nome}">Excluir</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="2"><input type='submit' value='Efetuar Venda'/></td>
				</tr>
			</table>
	
		</form>
		</fieldset>
	</c:if>
	</fieldset></td></tr>
	<tr><td><table style="width: 100%"><tr><td><a href="/PayLess/funcionario/funcionario.jsp">Voltar</a>  </td><td align="right"> Login: ${login} <a style="align: right" href="/PayLess/Controller?method=Logout">(logout)</a></td></tr></table></td></tr>
	<tr><td><font face="tahoma" size="2" color="red">
		<div id="erro"></div>
	</font></td></tr>
</table>
</body>
</html>