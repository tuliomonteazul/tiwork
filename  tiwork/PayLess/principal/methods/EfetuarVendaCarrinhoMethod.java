package methods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.EstoqueNegocio;
import beans.Estoque;

public class EfetuarVendaCarrinhoMethod implements Method{

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Estoque> estoques = null;
		List<Estoque> estoquesDistinct = null;
		EstoqueNegocio estoqueNegocio = null;
		Estoque estoque = null;
		ArrayList<Estoque> carrinho = null;
		HttpSession sessao = null;
		
		try {
			String nome = (String) req.getParameter("nome");
			String quantidade = (String) req.getParameter("quantidade");
			String valor = (String) req.getParameter("valor");
			String cod = (String) req.getParameter("cod");
			estoque = new Estoque(Integer.parseInt(cod), nome, Integer.parseInt(quantidade), Double.parseDouble(valor));
			sessao = req.getSession();
			RequestDispatcher d = req.getRequestDispatcher("funcionario/efetuarVenda.jsp");;
			if (sessao.getAttribute("carrinho") == null){
				carrinho = new ArrayList<Estoque>();
				carrinho.add(estoque);
			}else{
				carrinho = (ArrayList<Estoque>) sessao.getAttribute("carrinho");
				boolean achou = false;
				for (Estoque e : carrinho){
					if (estoque.getCod()==e.getCod()){
						achou = true;
						e.setQuantidade(e.getQuantidade()+estoque.getQuantidade());
					}
				}
				if (achou==false){
					carrinho.add(estoque);
				}
			}
	
			estoqueNegocio = new EstoqueNegocio();
			estoquesDistinct = estoqueNegocio.listarEstoquesDistinct();
			estoques = estoqueNegocio.listarEstoques();
			for (Estoque ed : estoquesDistinct){
				for (Estoque e : estoques){
					if (ed.getCod() == e.getCod()){
						ed.setQuantidade(ed.getQuantidade()+e.getQuantidade());
					}
				}
			}
			req.setAttribute("estoques", estoquesDistinct);
			sessao.setAttribute("carrinho", carrinho);
			d.forward(req, resp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
