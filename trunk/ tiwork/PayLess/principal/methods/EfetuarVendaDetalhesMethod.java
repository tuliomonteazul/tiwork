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

public class EfetuarVendaDetalhesMethod implements Method{

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Estoque estoque = null;
		List<Estoque> estoquesDistinct = null;
		List<Estoque> estoques = null;
		EstoqueNegocio estoqueNegocio = null;
		String nome = req.getParameter("remedio");
		
		try {
			RequestDispatcher d = req.getRequestDispatcher("funcionario/efetuarVenda.jsp");;
			estoqueNegocio = new EstoqueNegocio();
			estoquesDistinct = estoqueNegocio.listarEstoquesDistinct();
			estoques = estoqueNegocio.listarEstoques();
			for (Estoque e : estoquesDistinct){
				if (e.getNome().equalsIgnoreCase(nome)){
					estoque = e;
				}
			}
			if (estoque!=null){
				for (Estoque e : estoques){
					if (e.getCod() == estoque.getCod()){
						estoque.setQuantidade(e.getQuantidade());
						estoque.setValor(e.getValor());
					}
				}
				for (Estoque ed : estoquesDistinct){
					for (Estoque e : estoques){
						if (ed.getCod() == e.getCod()){
							ed.setQuantidade(ed.getQuantidade()+e.getQuantidade());
						}
					}
				}
				req.setAttribute("estoque", estoque);
			}else{
				req.setAttribute("erro", "ERRO - Nome do rem�dio inv�lido.");
			}
			req.setAttribute("estoques", estoquesDistinct);
			d.forward(req, resp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}