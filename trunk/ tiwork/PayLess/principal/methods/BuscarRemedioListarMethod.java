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
import negocio.EstoqueNegocio;
import negocio.MedicamentoNegocio;
import beans.Estoque;
import beans.Medicamentos;

public class BuscarRemedioListarMethod implements Method{

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		DoencaNegocio doencaNegocio = null;
		ArrayList<String> sintomas = null;
		
		try {
			RequestDispatcher d = req.getRequestDispatcher("funcionario/buscarRemedio.jsp");;
			doencaNegocio = new DoencaNegocio();
			sintomas = (ArrayList<String>) doencaNegocio.listarSintomas();
			if (sintomas.size()==0){
				req.setAttribute("erro", "ERRO - Não há sintomas cadastrados");
				d = req.getRequestDispatcher("funcionario/funcionario.jsp");;
			}else {
				req.setAttribute("sintomas", sintomas);
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
