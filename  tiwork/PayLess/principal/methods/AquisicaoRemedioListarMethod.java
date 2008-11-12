package methods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.MedicamentoNegocio;
import beans.Medicamentos;

public class AquisicaoRemedioListarMethod implements Method{

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Medicamentos> medicamentos = null;
		MedicamentoNegocio medicamentoNegocio = null;
		
		try {
			RequestDispatcher d = req.getRequestDispatcher("funcionario/aquisicaoRemedio.jsp");;
			medicamentoNegocio = new MedicamentoNegocio();
			medicamentos = medicamentoNegocio.listar();
			req.setAttribute("medicamentos", medicamentos);
			d.forward(req, resp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
