package methods;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistencia.UsuarioHsql;
import beans.Usuario;

public class LogoutMethod implements Method{

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher d = req.getRequestDispatcher("index.jsp");
		//req.getSession().removeAttribute("login");
		req.getSession().invalidate();
		d.forward(req, resp);
	}

}
