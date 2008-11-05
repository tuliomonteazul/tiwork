package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Usuario;

public class UsuarioHsql implements UsuarioDao {
	private HsqlSource source;
	private QueryManager manager;
	private PreparedStatement stat;
	private Connection con;
	public UsuarioHsql() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		source = HsqlSource.getInstance();
		manager = QueryManager.getInstance();
		con = source.getConnection();
	}
	public void cadastrarFuncionario(Usuario u) throws SQLException{
		
	}
	public void cadastrarFarmaceutico(Usuario u)throws SQLException{
		stat = manager.getPrepared(con, "Cadastrar.Farmaceutico");	
		stat.setString(0, u.getLogin());
		stat.setString(1, u.getSenha());
		stat.execute();
	}

	public void removerFuncionario(Usuario u) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public Usuario trazerFarmaceutico(String login, String senha)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario trazerFuncionario(String login, String senha)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
