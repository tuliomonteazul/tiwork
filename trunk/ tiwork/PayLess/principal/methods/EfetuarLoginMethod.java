package methods;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistencia.UsuarioHsql;
import beans.Usuario;

public class EfetuarLoginMethod implements Method{

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
		try {
			RequestDispatcher r = req.getRequestDispatcher("index.jsp");;
			Usuario usuario = null;
			UsuarioHsql usuarioHsql = new UsuarioHsql();
			String login = req.getParameter("login");
			String senha = req.getParameter("senha");
			usuario = usuarioHsql.trazerFarmaceutico(login);
			if(usuario != null){
				if (usuario.getSenha().equalsIgnoreCase(senha)){
					r = req.getRequestDispatcher("farmaceutico.jsp");
				}else {
					req.setAttribute("erro", "Senha incorreta");
					r = req.getRequestDispatcher("index.jsp");
				}
			}else{
				usuario = usuarioHsql.trazerFuncionario(login);
				if(usuario != null){
					if (usuario.getSenha().equalsIgnoreCase(senha)){
						r = req.getRequestDispatcher("funcionario.jsp");
					}else {
						req.setAttribute("erro", "Senha incorreta");
						r = req.getRequestDispatcher("index.jsp");
					}
				}else{
					req.setAttribute("erro", "Login inválido");
					r = req.getRequestDispatcher("index.jsp");
				}
			}
			
			r.forward(req, resp);
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
