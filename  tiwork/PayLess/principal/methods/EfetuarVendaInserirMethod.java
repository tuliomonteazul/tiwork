package methods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.EstoqueNegocio;
import negocio.UsuarioNegocio;
import negocio.VendaNegocio;
import beans.Estoque;
import beans.Usuario;
import beans.Venda;

public class EfetuarVendaInserirMethod implements Method{

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Estoque> carrinho = null;
		List<Estoque> estoques = null;
		EstoqueNegocio estoqueNegocio = null;
		Estoque estoque = null;
		VendaNegocio vendaNegocio = null;
		HttpSession sessao = null;
		int codigo = 0;
		Venda venda = null;
		UsuarioNegocio usuarioNegocio = null;
		Usuario usuario = null;
		int codFuncionario;
		try {
			usuarioNegocio = new UsuarioNegocio();
			estoqueNegocio = new EstoqueNegocio();
			vendaNegocio = new VendaNegocio();
			sessao = req.getSession();
			String login = (String) req.getRemoteUser();
			RequestDispatcher d = req.getRequestDispatcher("funcionario/funcionario.jsp");;
			if (login != null){
				usuario = usuarioNegocio.trazerFuncionario(login);
				codFuncionario = usuario.getCod();
				carrinho = (List<Estoque>) sessao.getAttribute("carrinho");
				codigo = vendaNegocio.obterCodigo();
				estoques = estoqueNegocio.listarEstoquesDistinct();
				estoque = new Estoque();
				boolean estoqueSuficiente = true;
				for (Estoque e : carrinho){
					estoque = estoqueNegocio.trazerEstoque(e.getCod());
					if (e.getQuantidade()>estoque.getQuantidade()){
						req.setAttribute("erro", "ERRO - Quantidade em estoque insuficiente.");
						d = req.getRequestDispatcher("funcionario/efetuarVenda.jsp");;
						estoqueSuficiente = false;
					}
				}
				if (estoqueSuficiente){
					GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
					for (Estoque e : carrinho){
						estoque = estoqueNegocio.trazerEstoque(e.getCod());
						venda = new Venda();
						venda.setCodFuncionario(codFuncionario);
						venda.setCodRemedio(e.getCod());
						venda.setCodVenda(codigo);
						venda.setQuantidade(e.getQuantidade());
						venda.setValor((e.getQuantidade()*e.getValor()));
						venda.setData(new java.sql.Date(calendar.getTimeInMillis()));
						vendaNegocio.inserirVenda(venda);
						int qtd = estoque.getQuantidade();
						estoqueNegocio.alterarQuantidade(e.getCod(), qtd-e.getQuantidade());
						req.setAttribute("msg", "Venda efetuada com sucesso!");
					}
					sessao.removeAttribute("carrinho");
				}
			}else{
				req.setAttribute("erro", "ERRO - Voc� deve estar logado para efetuar uma venda.");
			}
			req.setAttribute("estoques", estoques);
			d.forward(req, resp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
