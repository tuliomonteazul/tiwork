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
	public List<Doencas> trazerPorSintomas(String [] sintomas) throws SQLException{
		List<Doencas> doencas = new ArrayList<Doencas>();
		List<Doencas> d1;
		for(String s:sintomas){
			d1 = dao.trazerPorSintoma(s);
			for(Doencas doenca:d1){
				doencas.add(doenca);
			}
		}
		for(Doencas doenca:doencas){
			for(int i=0;i<sintomas.length;i++){
				//if()
			}
		}
		return doencas;
		
		
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
