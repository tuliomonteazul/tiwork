package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import methods.Method;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {

	private void calledMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeDaClasse = "methods."+request.getParameter("method")+"Method";
		try {
			Method method = (Method) Class.forName(nomeDaClasse).newInstance();
			method.doMethod(request, response);
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		calledMethod(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		calledMethod(request, response);
	}

}
