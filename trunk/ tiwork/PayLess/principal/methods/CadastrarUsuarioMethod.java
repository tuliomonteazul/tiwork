package methods;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistencia.UsuarioHsql;

import beans.Usuario;

public class CadastrarUsuarioMethod implements Method {

	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			UsuarioHsql usuarioHsql = new UsuarioHsql();
			Usuario usuario = new Usuario();
			usuario.setNome(req.getParameter("nome"));
			usuario.setLogin(req.getParameter("login"));
			usuario.setSenha(req.getParameter("senha"));
			usuario.setPapel(Integer.parseInt(req.getParameter("papel")));
			usuarioHsql.cadastrarUsuario(usuario);
			req.setAttribute("msg", "Usuario "+req.getParameter("nome")+" cadastrado com sucesso");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			req.setAttribute("erro", "Erro ao tentar cadastrar o usuario "+req.getParameter("nome"));
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("erro", "Erro ao tentar cadastrar o usuario "+req.getParameter("nome"));
		} finally {
			RequestDispatcher d = req.getRequestDispatcher("funcionario/cadastrarUsuario.jsp");
			d.forward(req, resp);
		}
		
		

	}

}
