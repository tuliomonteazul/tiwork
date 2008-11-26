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
import beans.Medicamentos;


public class CadastrarDoencaMethod implements Method {

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			RequestDispatcher dis = req.getRequestDispatcher("/farmaceutico/farmaceutico.jsp");
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
			
			DoencaNegocio doenca1 = new DoencaNegocio();
			MedicamentoNegocio med1 = new MedicamentoNegocio();
			req.setAttribute("medicamentos", med1.listar());
			req.setAttribute("sintomas", doenca1.listarSintomas());
			
			negocio.cadastrarDoenca(doenca);
		
			dis.forward(req,resp);
		} catch (ClassNotFoundException e) {
			RequestDispatcher d = req.getRequestDispatcher("farmaceutico/cadastrarTipoDeDoencas.jsp");
			req.setAttribute("erro", "Não foi possível listar os Sintomas");
			d.forward(req, resp);
		} catch (SQLException e) {
			RequestDispatcher d = req.getRequestDispatcher("farmaceutico/cadastrarTipoDeDoencas.jsp");
			req.setAttribute("erro", "Não foi possível listar os Sintomas");
			d.forward(req, resp);
		} catch (Exception e) {
			RequestDispatcher d = req.getRequestDispatcher("farmaceutico/cadastrarTipoDeDoencas.jsp");
			req.setAttribute("erro", "Não foi possível listar os Sintomas");
			d.forward(req, resp);
		}
	}

}