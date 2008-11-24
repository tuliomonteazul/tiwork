package methods;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.MedicamentoNegocio;

public class ListarReferenciaMethod implements Method {

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			MedicamentoNegocio med = new MedicamentoNegocio();
			req.setAttribute("medidas", med.listarMedidas());
			RequestDispatcher dis = req.getRequestDispatcher("farmaceutico/cadastrarMedicamento.jsp");
			dis.forward(req, resp);
			
		} catch (ClassNotFoundException e) {
			RequestDispatcher d = req.getRequestDispatcher("farmaceutico/cadastrarMedicamento.jsp");
			req.setAttribute("erro", "Não foi possível listar as Medidas");
			d.forward(req, resp);
		} catch (SQLException e) {
			RequestDispatcher d = req.getRequestDispatcher("farmaceutico/cadastrarMedicamento.jsp");
			req.setAttribute("erro", "Não foi possível listar as Medidas");
			d.forward(req, resp);
		}
		

	}

}