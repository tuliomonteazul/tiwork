package methods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Doencas;
import beans.Medicamentos;

import fachada.Facade;

public class CadastrarDoencaMethod implements Method {

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Facade fachada = Facade.getInstance();
			Doencas doenca =  new Doencas();
			
			doenca.setNome(req.getParameter("nome"));
			
			List<String> sintomas = new ArrayList<String>();
			
			for(String s:req.getParameterValues("sintomas")){
				sintomas.add(s);
			}
			
			doenca.setSintomas(sintomas);
			
			List<Medicamentos> medicamentos = new ArrayList<Medicamentos>();
			
			for(String s:req.getParameterValues("medicamentos")){
				medicamentos.add(fachada.trazerMedicamento(s));
			}
			doenca.setMedicamentos(medicamentos);
			
		
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
