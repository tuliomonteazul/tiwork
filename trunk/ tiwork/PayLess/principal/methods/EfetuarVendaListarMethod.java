package methods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.EstoqueNegocio;
import negocio.MedicamentoNegocio;
import beans.Estoque;
import beans.Medicamentos;

public class EfetuarVendaListarMethod implements Method{

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Estoque> estoques = null;
		EstoqueNegocio estoqueNegocio = null;
		
		try {
			RequestDispatcher d = req.getRequestDispatcher("funcionario/efetuarVenda.jsp");;
			estoqueNegocio = new EstoqueNegocio();
			estoques = estoqueNegocio.listarEstoquesDistinct();
			if (estoques.size()==0){
				req.setAttribute("erro", "ERRO - Não há produtos no estoque");
				d = req.getRequestDispatcher("funcionario/funcionario.jsp");;
			}else {
				req.setAttribute("estoques", estoques);
			}
			d.forward(req, resp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
