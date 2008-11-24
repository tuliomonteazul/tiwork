package methods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.DoencaNegocio;
import negocio.MedicamentoNegocio;

import beans.Doencas;

public class ListarDoencaPorSintomasMethod implements Method {

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Doencas> doenca ;
		DoencaNegocio doencaMed;
		try {
			doencaMed = new DoencaNegocio();
			
			DoencaNegocio doenca1 = new DoencaNegocio();
			MedicamentoNegocio med = new MedicamentoNegocio();
			req.setAttribute("sintomas", doenca1.listarSintomas());
			if(req.getParameterValues("sintomas")!= null){
			doenca = doencaMed.trazerPorSintomas(req.getParameterValues("sintomas"));	
			}else{
			doenca = null;
			}
			req.setAttribute("doencas", doenca);
			RequestDispatcher dis = req.getRequestDispatcher("farmaceutico/consultarDoencas.jsp");
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
