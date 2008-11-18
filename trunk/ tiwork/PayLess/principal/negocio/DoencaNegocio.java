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
	public List<Doencas> trazerPorSintomas(String []sintomas) throws SQLException{
		List<Doencas> doencas = new ArrayList<Doencas>();
		List<Doencas> d1;
		for (int i=0;i<sintomas.length;i++){
			d1 = dao.trazerPorSintoma(sintomas[i]);
			for(Doencas doenca:d1){
				doencas.add(doenca);
			}
		}
		boolean teste;
		for(Doencas doenca:doencas){
			for(int i=0;i<sintomas.length;i++){
				teste=false;
				for(int j=0;j<doenca.getSintomas().size();j++){
					if(sintomas[i].equals(doenca.getSintomas().get(j))){
						teste=true;
					}
				}
			}
		}
		return doencas;
		
		
	}
	public List<String> listarSintomas() throws SQLException{
		return dao.listarSintomas();
	}
	
	public void cadastrarDoenca(Doencas doenca) throws SQLException{
//TODO FALTA COLOCAR CODIGO DA DOENCA
		dao.cadastrarDoenca(doenca);
		for(String sintomas:doenca.getSintomas()){
			dao.insereSintoma(doenca.getNome(),sintomas);
		}
		for(Medicamentos medicamento:doenca.getMedicamentos()){
			med.insereMedicacaoParaDoenca(doenca,medicamento);
		}
	}
	
}
