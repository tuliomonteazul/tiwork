package negocio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Doencas;
import persistencia.DoencaDao;
import persistencia.DoencaHsql;

public class DoencaNegocio {
	private DoencaDao dao;
	public DoencaNegocio() throws FileNotFoundException, ClassNotFoundException, SQLException, IOException{
		dao = new  DoencaHsql();
	}
	public List<Doencas> trazerPorSintomas(List<String> sintomas){
		List<Doencas> doencas = new ArrayList<Doencas>();
		
		return null;
		
		
	}
}
