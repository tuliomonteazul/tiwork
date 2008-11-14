package negocio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Doencas;
import beans.Medicamentos;
import persistencia.DoencaDao;
import persistencia.DoencaHsql;

public class DoencaNegocio {
	private DoencaDao dao;
	private MedicamentoNegocio med;
	public DoencaNegocio() throws FileNotFoundException, ClassNotFoundException, SQLException, IOException{
		dao = new  DoencaHsql();
		med = new MedicamentoNegocio();
	}
	public List<Doencas> trazerPorSintomas(List<String> sintomas){
		List<Doencas> doencas = new ArrayList<Doencas>();
		
		return null;
		
		
	}
	public List<String> listarSintomas() throws SQLException{
		return dao.listarSintomas();
	}
	
	public void cadastrarDoenca(Doencas doenca) throws SQLException{
		dao.cadastrarDoenca(doenca);
		for(String sintomas:doenca.getSintomas()){
			dao.insereSintoma(doenca.getNome(),sintomas);
		}
		for(Medicamentos medicamento:doenca.getMedicamentos()){
			med.insereMedicacaoParaDoenca(doenca,medicamento);
		}
	}
	
}