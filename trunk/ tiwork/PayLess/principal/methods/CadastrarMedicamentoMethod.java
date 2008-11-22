
package methods;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import negocio.MedicamentoNegocio;

import beans.Medicamentos;

public class CadastrarMedicamentoMethod implements Method{

	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Medicamentos med = new Medicamentos();
		MedicamentoNegocio medicamentoNegocio = null;
		
		try {
			medicamentoNegocio = new  MedicamentoNegocio();
			if("drageas".equalsIgnoreCase(req.getParameter("tipo"))){
				
				med.setNome(req.getParameter("nome"));
				med.setPrincipioAtivo(req.getParameter("principio"));
				med.setTipo(req.getParameter("tipo"));
				med.setPeso(Double.parseDouble(req.getParameter("peso")));
				med.setMedida(req.getParameter("medida"));
				med.setQuantidade(Integer.parseInt(req.getParameter("quantidade")));
			}else{
				med.setNome(req.getParameter("nome"));
				med.setPrincipioAtivo(req.getParameter("principio"));
				med.setTipo(req.getParameter("tipo"));
				med.setPeso(Double.parseDouble(req.getParameter("peso")));
				med.setMedida(req.getParameter("medida"));
			}
			req.setAttribute("medidas", medicamentoNegocio.listarMedidas());
			medicamentoNegocio.cadastrarMedicamentos(med,req.getParameter("tipo"));
			req.setAttribute("msg", "Medicamento "+req.getParameter("nome")+" cadastrado com sucesso.");
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			req.setAttribute("erro", "Erro ao tentar cadastrar o medicamento "+req.getParameter("nome"));
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("erro", "Erro ao tentar cadastrar o medicamento "+req.getParameter("nome"));
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("erro", "Erro ao tentar cadastrar o medicamento "+req.getParameter("nome"));
		} finally {
			RequestDispatcher d = req.getRequestDispatcher("farmaceutico/cadastrarMedicamento.jsp");
			d.forward(req, resp);
		}
		
	
	}
	

}
