package methods;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.EstoqueNegocio;
import negocio.VendaNegocio;
import beans.Estoque;
import beans.Venda;

public class VisualizarVendasMethod implements Method{

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Venda> vendas = null;
		VendaNegocio vendaNegocio = null;
		Date dataInicio = null;
		Date dataFim = null;
		
		try {
			RequestDispatcher d = req.getRequestDispatcher("funcionario/visualizarVendas.jsp");;
			String dc1 = req.getParameter("dc1");
			String dc2 = req.getParameter("dc2");
			if ("".equals(dc1)&&"".equals(dc2)){
				//TODO: listar por nome de remedio
			}else{
				dataInicio = Venda.dataStringToDate(dc1);
				dataFim = Venda.dataStringToDate(dc2);
				vendas = vendaNegocio.listarVendaPorData(dataInicio, dataFim);
				if (vendas.size()==0){
					req.setAttribute("erro", "Não há vendas no período selecionado");
				}else {
					req.setAttribute("vendas", vendas);
				}
			}
			d.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
