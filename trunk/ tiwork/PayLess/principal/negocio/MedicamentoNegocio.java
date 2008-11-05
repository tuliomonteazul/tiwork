package negocio;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import persistencia.MedicamentoHsql;
import persistencia.MedicamentosDao;

import beans.Medicamentos;
import beans.Remedio;

public class MedicamentoNegocio{
	private MedicamentosDao med;
	public MedicamentoNegocio() throws ClassNotFoundException, SQLException{
		med =  new MedicamentoHsql();
	}
	
	public void cadastrarMedicamentos(Medicamentos m,String tipo) {
		// TODO Auto-generated method stub
		
	}

	public List<Medicamentos> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Remedio> listarRemediosPorData(Date dataInicio, Date dataFim) throws Exception {
		List<Remedio> remedio;
		if(dataInicio.compareTo(dataFim)>0){
			throw new Exception();
		}else{
			remedio = med.listarRemediosPorData(dataInicio, dataFim);
		}
		return remedio;
	}
	public Medicamentos trazer(String nomeMedicamento) throws Exception {
		if(nomeMedicamento == null || "".equalsIgnoreCase(nomeMedicamento)){
			throw new Exception();
		}
		return med.trazer(nomeMedicamento);
	}

}
