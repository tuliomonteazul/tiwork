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
		d1 = new ArrayList<Doencas>();;
		for(int i = 0;i < doencas.size();i++){
			for(int j = i+1; j < doencas.size()-1 ; j++){
				if(doencas.get(i).getNome().equals(doencas.get(j).getNome())){
					d1.add(doencas.get(j));
				}
			}
		}
		for(int i=0 ; i < d1.size() ; i++){
			doencas.remove(d1.get(i));
		}
		d1 = new ArrayList<Doencas>();
		int cont;
		for(Doencas doenca:doencas){
			cont = 0;
			for(int j = 0;j < sintomas.length;j++){
				for(int i = 0;i < doenca.getSintomas().size();i++){
					if(sintomas[j].equals(doenca.getSintomas().get(i))){
						cont++;
					}
				}
			}
			if(cont < doenca.getSintomas().size()){
				d1.add(doenca);
			}
		}
		for(int i=0 ; i < d1.size() ; i++){
			doencas.remove(d1.get(i));
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
