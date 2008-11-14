package methods;

import java.io.IOException;
import java.sql.SQLException;
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
			String login = (String) sessao.getAttribute("login");
			usuario = usuarioNegocio.trazerFuncionario(login);
			codFuncionario = usuario.getCod();
			carrinho = (List<Estoque>) sessao.getAttribute("carrinho");
			RequestDispatcher d = req.getRequestDispatcher("funcionario/funcionario.jsp");;
			codigo = vendaNegocio.obterCodigo();
			estoques = estoqueNegocio.listarEstoquesDistinct();
			for (Estoque e : carrinho){
				venda = new Venda();
				venda.setCodFuncionario(codFuncionario);
				venda.setCodRemedio(e.getCod());
				venda.setCodVenda(codigo);
				venda.setQuantidade(e.getQuantidade());
				venda.setValor(e.getValor());
				vendaNegocio.inserirVenda(venda);
			}
			req.setAttribute("msg", "Venda efetuada com sucesso!");
			req.setAttribute("estoques", estoques);
			d.forward(req, resp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
