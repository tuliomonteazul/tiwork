package fachada;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import negocio.MedicamentoNegocio;

import beans.Medicamentos;
import beans.Remedio;

public class Facade {

	private MedicamentoNegocio medNegocio;
	private static Facade fachada;
	public static Facade getInstance() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		if(fachada == null){
			fachada = new Facade();
		}
		return fachada;
	}
	private Facade() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		medNegocio = new MedicamentoNegocio();
	}
	
	public void cadastrarMedicamentos(Medicamentos m,String tipo) throws Exception {
		medNegocio.cadastrarMedicamentos(m, tipo);
	}

	public List<Medicamentos> listar() {
		return null;
	}

	public List<Remedio> listarRemediosPorData(Date dataInicio, Date dataFim) throws Exception {
		return medNegocio.listarRemediosPorData(dataInicio, dataFim);
	}
	public Medicamentos trazerMedicamento(String nomeMedicamento) throws Exception {
		return medNegocio.trazer(nomeMedicamento);
	}
}
