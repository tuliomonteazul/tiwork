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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
