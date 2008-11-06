package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		
		stat = query.getPrepared(con, "Cadastrar.Medicamentos");
		stat.setString(0, m.getNome());
		stat.setString(1, m.getPrincipioAtivo());
		stat.setString(2, m.getTipo());
		stat.setDouble(3, m.getPeso());
		stat.setInt(4,m.getMedida());
		stat.setInt(5,m.getQuantidade());
		stat.execute();
	}

	@Override
	public List<Medicamentos> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Remedio> listarRemediosPorData(Date dataInicio, Date dataFim) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medicamentos trazer(String nomeMedicamento) throws SQLException {
		stat = query.getPrepared(con,"Pegar.Medicamentos" );
		stat.setString(0,nomeMedicamento);
		res = stat.executeQuery();
		Medicamentos med = null;
		if(res.next()){
			med = new Medicamentos();
			med.setNome(res.getString("nome"));
			med.setPeso(res.getDouble("peso"));
			med.setTipo(res.getString("tipo_medicamento"));
			med.setPrincipioAtivo(res.getString("principio_ativo"));
			med.setQuantidade(res.getInt("quantidade"));
			med.setMedida(res.getInt("medida"));
				
		}
		return med;
	}

}
