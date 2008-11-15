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

public class EfetuarVendaCarrinhoExcluirItemMethod implements Method{

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
			String item = (String) req.getParameter("item");
			sessao = req.getSession();
			RequestDispatcher d = req.getRequestDispatcher("funcionario/efetuarVenda.jsp");;
			if (sessao.getAttribute("carrinho") == null){
				carrinho = new ArrayList<Estoque>();
				carrinho.add(estoque);
			}else{
				carrinho = (ArrayList<Estoque>) sessao.getAttribute("carrinho");
				boolean achou = false;
				for (Estoque e : carrinho){
					if (item.equalsIgnoreCase(e.getNome())){
						achou = true;
						carrinho.remove(e);
						req.setAttribute("msg", "Item "+item+" removido com sucesso.");
						break;
					}
				}
				if (achou==false){
					req.setAttribute("erro", "Item inv�lido");
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
