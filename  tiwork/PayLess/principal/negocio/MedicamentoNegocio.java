package negocio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import persistencia.MedicamentoHsql;
import persistencia.MedicamentosDao;

import beans.Doencas;
import beans.Medicamentos;
import beans.Remedio;

public class MedicamentoNegocio{
	private MedicamentosDao med;
	public MedicamentoNegocio() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		med =  new MedicamentoHsql();
	}
	
	public void cadastrarMedicamentos(Medicamentos m,String tipo) throws Exception {
		if("drageas".equals(tipo)){
			if( m.getQuantidade() <= 0){
				throw new Exception();
			}else{
				med.cadastrarMedicamentos(m,tipo);
			}
		}else{
			med.cadastrarMedicamentos(m,tipo);
		}
	}

	public List<Medicamentos> listar() throws SQLException {
		List<Medicamentos> medicamentos = med.listar();
		return medicamentos;
	}

	public List<String> listarMedidas() throws SQLException{
		return med.listarMedidas();
		
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
	public void insereMedicacaoParaDoenca(Doencas doenca,Medicamentos medicacao) throws SQLException{
		med.insereMedicacaoParaDoenca(doenca,medicacao);
	}

}
