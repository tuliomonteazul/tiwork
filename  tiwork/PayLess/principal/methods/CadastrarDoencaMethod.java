package methods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.DoencaNegocio;
import negocio.MedicamentoNegocio;

import beans.Doencas;
import beans.Medicamentos;


public class CadastrarDoencaMethod implements Method {

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			//Facade fachada = Facade.getInstance();
			MedicamentoNegocio med = new MedicamentoNegocio();
			DoencaNegocio negocio =  new DoencaNegocio();
			Doencas doenca =  new Doencas();
			doenca.setNome(req.getParameter("descricao"));
			List<String> sintomas = new ArrayList<String>();
			
			for(String s:req.getParameterValues("sintomas")){
				sintomas.add(s);
			}
			
			doenca.setSintomas(sintomas);
			
			List<Medicamentos> medicamentos = new ArrayList<Medicamentos>();
			
			for(String s:req.getParameterValues("medicamentos")){
				medicamentos.add(med.trazer(s));
			}
			doenca.setMedicamentos(medicamentos);
			
			negocio.cadastrarDoenca(doenca);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
