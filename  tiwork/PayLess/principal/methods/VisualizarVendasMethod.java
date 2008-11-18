package methods;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.EstoqueNegocio;
import negocio.MedicamentoNegocio;
import negocio.UsuarioNegocio;
import negocio.VendaNegocio;
import beans.Medicamentos;
import beans.Venda;

public class VisualizarVendasMethod implements Method{

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Venda> vendas = null;
		VendaNegocio vendaNegocio = null;
		EstoqueNegocio estoqueNegocio = null;
		UsuarioNegocio usuarioNegocio = null;
		MedicamentoNegocio medicamentoNegocio = null;
		Medicamentos medicamentos = null;
		Date dataInicio = null;
		Date dataFim = null;
		String nomeRemedio = "";
		String nomeFuncionario = "";
		String dataString = "";
		int codRemedio = 0;
		
		try {
			vendaNegocio = new VendaNegocio();
			medicamentoNegocio = new MedicamentoNegocio();
			estoqueNegocio = new EstoqueNegocio();
			usuarioNegocio = new UsuarioNegocio();
			RequestDispatcher d = req.getRequestDispatcher("funcionario/visualizarVendas.jsp");;
			String dc1 = req.getParameter("dc1");
			String dc2 = req.getParameter("dc2");
			String nome = req.getParameter("remedio");
			req.setAttribute("remedio", nome);
			req.setAttribute("dataInicio", dc1);
			req.setAttribute("dataFim", dc2);
			if (!(("".equals(dc1)&&"".equals(dc2))||(dc1==null&&dc2==null))&&(("".equals(nome)||nome==null))){
				dataInicio = Venda.dataStringToDate(dc1);
				dataFim = Venda.dataStringToDate(dc2);
				vendas = vendaNegocio.listarVendaPorData(dataInicio, dataFim);
				for (Venda v : vendas){
					nomeRemedio = estoqueNegocio.trazerEstoque(v.getCodRemedio()).getNome();
					v.setNomeRemedio(nomeRemedio);
					nomeFuncionario = usuarioNegocio.trazerUsuarioPorCodigo(v.getCodFuncionario()).getNome();
					v.setNomeFuncionario(nomeFuncionario);
					dataString = Venda.dataDateToString(v.getData());
					v.setDataString(dataString);
				}
				if (vendas.size()==0){
					req.setAttribute("erro", "Não há vendas no período selecionado");
				}else {
					req.setAttribute("vendas", vendas);
				}
			}else{
				if (!("".equals(nome)||nome==null)&&(("".equals(dc1)&&"".equals(dc2))||(dc1==null&&dc2==null))){
					medicamentos = medicamentoNegocio.trazer(nome);
					codRemedio = medicamentos.getCod();
					vendas = vendaNegocio.listarVendaPorCodigo(codRemedio);
					for (Venda v : vendas){
						nomeRemedio = estoqueNegocio.trazerEstoque(v.getCodRemedio()).getNome();
						v.setNomeRemedio(nomeRemedio);
						nomeFuncionario = usuarioNegocio.trazerUsuarioPorCodigo(v.getCodFuncionario()).getNome();
						v.setNomeFuncionario(nomeFuncionario);
						dataString = Venda.dataDateToString(v.getData());
						v.setDataString(dataString);
					}
					if (vendas.size()==0){
						req.setAttribute("erro", "Não há vendas do remédio "+nome+".");
					}else {
						req.setAttribute("vendas", vendas);
					}
				}
				else{
					if (!("".equals(nome)||nome==null)&&!(("".equals(dc1)&&"".equals(dc2))||(dc1==null&&dc2==null))){
						medicamentos = medicamentoNegocio.trazer(nome);
						codRemedio = medicamentos.getCod();
						dataInicio = Venda.dataStringToDate(dc1);
						dataFim = Venda.dataStringToDate(dc2);
						vendas = vendaNegocio.listarVendaPorCodigoData(codRemedio, dataInicio, dataFim);
						for (Venda v : vendas){
							nomeRemedio = estoqueNegocio.trazerEstoque(v.getCodRemedio()).getNome();
							v.setNomeRemedio(nomeRemedio);
							nomeFuncionario = usuarioNegocio.trazerUsuarioPorCodigo(v.getCodFuncionario()).getNome();
							v.setNomeFuncionario(nomeFuncionario);
							dataString = Venda.dataDateToString(v.getData());
							v.setDataString(dataString);
						}
						if (vendas.size()==0){
							req.setAttribute("erro", "Não há vendas do remédio "+nome+".");
						}else {
							req.setAttribute("vendas", vendas);
						}
					}
				}
			}
			d.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher d = req.getRequestDispatcher("funcionario/visualizarVendas.jsp");;
			req.setAttribute("erro", "Não foi possível visualizar a lista de vendas");
			d.forward(req, resp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			RequestDispatcher d = req.getRequestDispatcher("funcionario/visualizarVendas.jsp");;
			req.setAttribute("erro", "Não foi possível visualizar a lista de vendas");
			d.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher d = req.getRequestDispatcher("funcionario/visualizarVendas.jsp");;
			req.setAttribute("erro", "Não foi possível visualizar a lista de vendas");
			d.forward(req, resp);
		}
	
	}

}
