package methods;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.DoencaNegocio;
import negocio.MedicamentoNegocio;

public class ListarSintomasMethod implements Method {

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			DoencaNegocio doenca = new DoencaNegocio();
			MedicamentoNegocio med = new MedicamentoNegocio();
			req.setAttribute("medicamentos", med.listar());
			req.setAttribute("sintomas", doenca.listarSintomas());
			RequestDispatcher dis = req.getRequestDispatcher("farmaceutico/cadastrarTipoDeDoencas.jsp");
			dis.forward(req, resp);
		} catch (ClassNotFoundException e) {
			RequestDispatcher d = req.getRequestDispatcher("farmaceutico/cadastrarTipoDeDoencas.jsp");
			req.setAttribute("erro", "Não foi possível listar os Sintomas");
			d.forward(req, resp);
		} catch (SQLException e) {
			RequestDispatcher d = req.getRequestDispatcher("farmaceutico/cadastrarTipoDeDoencas.jsp");
			req.setAttribute("erro", "Não foi possível listar os Sintomas");
			d.forward(req, resp);
		}
		

	}

}
