package methods;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.EstoqueNegocio;
import negocio.MedicamentoNegocio;
import negocio.UsuarioNegocio;
import negocio.VendaNegocio;
import beans.Medicamentos;
import beans.Venda;

public class VisualizarRemediosPorPeriodoMethod implements Method {

	@Override
	public void doMethod(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		List<Venda> vendas = null;
		VendaNegocio vendaNegocio = null;
		Date dataInicio = null;
		Date dataFim = null;
		String nomeRemedio = "";
		String nomeFuncionario = "";
		String dataString = "";
		int codRemedio = 0;
		
		try {
			vendaNegocio = new VendaNegocio();
			RequestDispatcher d = req.getRequestDispatcher("farmaceutico/listarRemedios.jsp");;
			String dc1 = req.getParameter("dc1");
			String dc2 = req.getParameter("dc2");
			String nome = req.getParameter("remedio");
			req.setAttribute("remedio", nome);
			req.setAttribute("dataInicio", dc1);
			req.setAttribute("dataFim", dc2);
			dataInicio = Venda.dataStringToDate(dc1);
			dataFim = Venda.dataStringToDate(dc2);
			vendas = vendaNegocio.listarVendaPorData(dataInicio, dataFim);
			List<Venda> vendidos = new ArrayList<Venda>();
			Venda aux;
			boolean testa,testa1=false;
			for(Venda v:vendas){
				aux = new Venda();
				testa=true;
				for(int i = 0 ;i<vendidos.size();i++){
					if(vendidos.get(i).getNomeRemedio().equalsIgnoreCase(v.getNomeRemedio())){
						testa = false;
					}
				}
				if(testa){
					for(int i = 0 ; i<vendas.size();i++){
						if(v.getNomeRemedio().equalsIgnoreCase(vendas.get(i).getNomeRemedio())){
							aux.setCodRemedio(v.getCodRemedio());
							aux.setNomeRemedio(v.getNomeRemedio());
							aux.setQuantidade(aux.getQuantidade()+vendas.get(i).getQuantidade());
							testa1=true;
							
						}
					}
					if(testa1){
						vendidos.add(aux);
					}
				}
				
			}
			int cont = 0;
			
			for(Venda v:vendidos){
				
				for(int i = cont ; i<vendidos.size();i++){
					if(v.getQuantidade()<vendidos.get(i).getQuantidade()){
						aux = v;
						vendidos.set(cont,vendidos.get(i));
						vendidos.set(i, aux);
					}
				}
				cont++;
			}
			if (vendidos.size()==0){
				req.setAttribute("erro", "Não há remedios vendidos no período selecionado");
			}else {
				req.setAttribute("vendas", vendidos);
			}
			d.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher d = req.getRequestDispatcher("farmaceutico/listarRemedios.jsp");;
			req.setAttribute("erro", "Não foi possível visualizar a lista de vendas");
			d.forward(req, resp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			RequestDispatcher d = req.getRequestDispatcher("farmaceutico/listarRemedios.jsp");;
			req.setAttribute("erro", "Não foi possível visualizar a lista de vendas");
			d.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher d = req.getRequestDispatcher("farmaceutico/listarRemedios.jsp");;
			req.setAttribute("erro", "Não foi possível visualizar a lista de vendas");
			d.forward(req, resp);
		}
	}

}
