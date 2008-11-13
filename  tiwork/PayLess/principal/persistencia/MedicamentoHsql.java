package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Medicamentos;
import beans.Remedio;

public class MedicamentoHsql implements MedicamentosDao {
	private HsqlSource hsql;
	private PreparedStatement stat;
	private Connection con;
	private QueryManager query;
	private ResultSet res;
	public MedicamentoHsql() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		hsql = HsqlSource.getInstance();
		con = hsql.getConnection();
		query = QueryManager.getInstance();
	}
	public void cadastrarMedicamentos(Medicamentos m) throws SQLException {
		
		stat = query.getPrepared(con, "Medicamentos.Cadastrar");
		stat.setString(1, m.getNome());
		stat.setString(2, m.getPrincipioAtivo());
		stat.setString(3, m.getTipo());
		stat.setDouble(4, m.getPeso());
		stat.setInt(6,m.getQuantidade());
		stat.setInt(5,trazerMedidaCod(m.getMedida()));
		stat.execute();
	}

	public List<Medicamentos> listar() throws SQLException {
		stat = query.getPrepared(con, "Medicamentos.Listar");
		
		res = stat.executeQuery();
		List<Medicamentos> medicamentos = new ArrayList<Medicamentos>();
		Medicamentos med = null;
		while(res.next()){
			med = new Medicamentos();
			med.setNome(res.getString("nome"));
//			med.setMedida(res.getInt("medida"));
			med.setPeso(res.getDouble("peso"));
			med.setPrincipioAtivo(res.getString("principio_ativo"));
			med.setQuantidade(res.getInt("quantidade"));
			med.setTipo(res.getString("tipo_medicamento"));
			medicamentos.add(med);
		}
		return medicamentos;
	}

	@Override
	public List<Remedio> listarRemediosPorData(Date dataInicio, Date dataFim) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medicamentos trazer(String nomeMedicamento) throws SQLException {
		stat = query.getPrepared(con,"Medicamentos.Pegar" );
		stat.setString(1,nomeMedicamento);
		res = stat.executeQuery();
		Medicamentos med = null;
		if(res.next()){
			med = new Medicamentos();
			med.setNome(res.getString("nome"));
			med.setPeso(res.getDouble("peso"));
			med.setTipo(res.getString("tipo_medicamento"));
			med.setPrincipioAtivo(res.getString("principio_ativo"));
			med.setQuantidade(res.getInt("quantidade"));
//			med.setMedida(trazerMedidaCod(n));
				
		}
		return med;
	}
	@Override
	public List<Medicamentos> trazerPorSintoma(String sintomas)
			throws SQLException {
		List<Medicamentos>medicamentos = new ArrayList<Medicamentos>();
		stat = query.getPrepared(con,"Medicamento.Sintoma.Trazer");
		return null;
	}
	@Override
	public List<String> listarMedidas() throws SQLException {
		List<String> medidas = new ArrayList<String>();
		stat = query.getPrepared(con, "Medidas.Listar");
		res = stat.executeQuery();
		while(res.next()){
			medidas.add(res.getString("tipo"));
		}
		return medidas;
	}
	private int trazerMedidaCod(String medida) throws SQLException {
		stat  = query.getPrepared(con,"Medidas.Pegar");
		stat.setString(1,medida);
		res = stat.executeQuery();
		int aux = 0;
		if(res.next()){
			aux = res.getInt("cod");
		}
		return aux;
	}

}
