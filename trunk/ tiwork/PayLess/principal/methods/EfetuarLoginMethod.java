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
			RequestDispatcher d = req.getRequestDispatcher("index.jsp");;
			Usuario usuario = null;
			UsuarioHsql usuarioHsql = new UsuarioHsql();
			String login = req.getParameter("login");
			String senha = req.getParameter("senha");
			usuario = usuarioHsql.trazerUsuario(login);
			if(usuario != null){
				//Funcionario
				if (usuario.getPapel() == 1){
					if (usuario.getSenha().equalsIgnoreCase(senha)){
						req.getSession().setAttribute("login", usuario.getLogin());
						d = req.getRequestDispatcher("funcionario/funcionario.jsp");
					}else {
						req.setAttribute("erro", "Senha incorreta");
						d = req.getRequestDispatcher("index.jsp");
					}
					
				//Farmaceutico
				}else{
					if (usuario.getPapel() == 2){
						if (usuario.getSenha().equalsIgnoreCase(senha)){
							req.getSession().setAttribute("login", usuario.getLogin());
							d = req.getRequestDispatcher("farmaceutico/farmaceutico.jsp");
						}else {
							req.setAttribute("erro", "Senha incorreta");
							d = req.getRequestDispatcher("index.jsp");
						}
					}
				}
			}else{
				req.setAttribute("erro", "Login inválido");
				d = req.getRequestDispatcher("index.jsp");
			}
			
			d.forward(req, resp);
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
