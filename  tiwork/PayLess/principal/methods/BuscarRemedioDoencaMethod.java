package methods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Doencas;
import beans.Medicamentos;

import negocio.DoencaNegocio;
import negocio.MedicamentoNegocio;

public class BuscarRemedioDoencaMethod implements Method{

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		DoencaNegocio doencaNegocio = null;
		MedicamentoNegocio medicamentoNegocio = null;
		ArrayList<Doencas> doencas = null;
		ArrayList<Medicamentos> medicamentos = null;
		String[] sintomasJsp2 = req.getParameterValues("sintomasDir");
		String[] sintomasJsp = req.getParameterValues("sintomas");
		
		try {
			
			RequestDispatcher d = req.getRequestDispatcher("funcionario/buscarRemedio.jsp");;
			doencaNegocio = new DoencaNegocio();
			
			doencas = (ArrayList<Doencas>) doencaNegocio.trazerPorSintomas(sintomasJsp);
			
			
			if (doencas.size()==0){
				req.setAttribute("erro", "Não há doenças para os sintomas selecionados");
				d = req.getRequestDispatcher("funcionario/buscarRemedio.jsp");;
			}else {
				req.setAttribute("doencas", doencas);
			}
			d.forward(req, resp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			req.setAttribute("erro", "ERRO - Não foi possível exibir a lista de sintomas");
			RequestDispatcher d = req.getRequestDispatcher("funcionario/buscarRemedio.jsp");;
			d.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("erro", "ERRO - Não foi possível exibir a lista de sintomas");
			RequestDispatcher d = req.getRequestDispatcher("funcionario/buscarRemedio.jsp");;
			d.forward(req, resp);
		}
	
	}

}
