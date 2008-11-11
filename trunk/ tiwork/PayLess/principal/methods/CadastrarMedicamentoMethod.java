
package methods;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fachada.Facade;

import negocio.MedicamentoNegocio;

import beans.Medicamentos;

public class CadastrarMedicamentoMethod implements Method{

	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Medicamentos med = new Medicamentos();
		
		try {
			Facade negocio = Facade.getInstance();
			if("dragea".equalsIgnoreCase(req.getParameter("tipo"))){
				
				med.setNome(req.getParameter("nome"));
				med.setPrincipioAtivo(req.getParameter("principio"));
				med.setTipo(req.getParameter("tipo"));
				med.setPeso(Double.parseDouble(req.getParameter("peso")));
				med.setMedida(Integer.parseInt(req.getParameter("medida")));
				med.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
			}else{
				med.setNome(req.getParameter("nome"));
				med.setPrincipioAtivo(req.getParameter("principio"));
				med.setTipo(req.getParameter("tipo"));
				med.setPeso(Double.parseDouble(req.getParameter("peso")));
				med.setMedida(Integer.parseInt(req.getParameter("medida")));
					
			}
			negocio.cadastrarMedicamentos(med,req.getParameter("tipo"));
				
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
