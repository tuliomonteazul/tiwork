<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset><legend>Buscar Remédios Mais Vendido</legend>
	<form name="formulario" action="/PayLess/Controller?method=VisualizarRemediosPorPeriodo" method='post'>
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
				<td colspan="2" align="center"><input type='button' value='Buscar' onclick="validarCampos();"/></td>
			</tr>
		</table>

	</form>
	</fieldset>
<iframe width=132 height=142 name="gToday:contrast:agenda.js" id="gToday:contrast:agenda.js" src="/PayLess/funcionario/DateRange/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
</iframe>
</body>
</html>