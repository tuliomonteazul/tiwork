package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import beans.Doencas;

public class DoencaHsql implements DoencaDao {
	private PreparedStatement stat;
	private HsqlSource hs;
	private Connection conn;
	private QueryManager query;
	
	public DoencaHsql() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		hs = HsqlSource.getInstance();
		conn = hs.getConnection();
		query = QueryManager.getInstance();
	}
	
	public void cadastrarDoenca(Doencas doenca) throws SQLException {
		stat = query.getPrepared(conn,"Cadastrar.doenca" );
		stat.setString(0,doenca.getNome());
		stat.execute();
	}

	public List<Doencas> listar()throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Doencas> trazerPorSintoma(String sintomas) throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

}
