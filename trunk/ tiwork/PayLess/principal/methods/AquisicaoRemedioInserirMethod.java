package methods;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.EstoqueNegocio;
import negocio.MedicamentoNegocio;
import beans.Estoque;
import beans.Medicamentos;

public class AquisicaoRemedioInserirMethod implements Method{

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Medicamentos medicamentos = null;
		MedicamentoNegocio medicamentoNegocio = null;
		EstoqueNegocio estoqueNegocio = null;
		
		try {
			String nomeMedicamento = req.getParameter("medicamento");
			int quantidade = Integer.parseInt(req.getParameter("quantidade"));
			Double valor = Double.parseDouble(req.getParameter("valor"));
			estoqueNegocio = new EstoqueNegocio();
			medicamentoNegocio = new MedicamentoNegocio();
			medicamentos = medicamentoNegocio.trazer(nomeMedicamento);
			estoqueNegocio.inserirEstoque(new Estoque(medicamentos.getCod(), quantidade, valor));
			req.setAttribute("msg", "Medicamento "+nomeMedicamento+" adicionado ao estoque");
		} catch (ClassNotFoundException e) {
			req.setAttribute("erro", "Não foi possível adicionar o medicamento ao estoque");
			e.printStackTrace();
		} catch (SQLException e) {
			req.setAttribute("erro", "Não foi possível adicionar o medicamento ao estoque");
			e.printStackTrace();
		} catch (Exception e) {
			req.setAttribute("erro", "Não foi possível adicionar o medicamento ao estoque");
			e.printStackTrace();
		}
		RequestDispatcher d = req.getRequestDispatcher("Controller?method=AquisicaoRemedioListar");
		d.forward(req, resp);
	}

}
