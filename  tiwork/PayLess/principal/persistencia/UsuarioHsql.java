package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Medicamentos;
import beans.Usuario;

public class UsuarioHsql implements UsuarioDao {
	private HsqlSource source;
	private QueryManager query;
	private ResultSet res;
	private PreparedStatement stat;
	private Connection con;
	
	public UsuarioHsql() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		source = HsqlSource.getInstance();
		query = QueryManager.getInstance();
		con = source.getConnection();
	}
	public void cadastrarUsuario(Usuario usuario)throws SQLException{
		stat = query.getPrepared(con, "Usuario.cadastrar");	
		stat.setString(1, usuario.getNome());
		stat.setString(2, usuario.getLogin());
		stat.setString(3, usuario.getSenha());
		stat.setInt(4, usuario.getPapel());
		stat.execute();
	}

	public void removerFuncionario(Usuario u) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Metódo para retornar um usuario farmaceutico pelo seu login
	 *
	 * @param String
	 * @return Usuario
	*/
	public Usuario trazerFarmaceutico(String login)
			throws SQLException {
		stat = query.getPrepared(con, "Usuario.Pegar.Farmaceutico" );
		stat.setString(1, login);
		res = stat.executeQuery();
		Usuario usuario = null;
		if(res.next()){
			usuario = new Usuario();
			usuario.setNome(res.getString("nome"));
			usuario.setSenha(res.getString("senha"));
			usuario.setLogin(res.getString("login"));
			usuario.setPapel(res.getInt("papel"));
				
		}
		return usuario;
	}

	/*
	 * Metódo para retornar um usuario funcionario pelo seu login
	 *
	 * @param String
	 * @return Usuario
	*/
	public Usuario trazerFuncionario(String login)
			throws SQLException {
		stat = query.getPrepared(con,"Usuario.Pegar.Funcionario" );
		stat.setString(1,login);
		res = stat.executeQuery();
		Usuario usuario = null;
		if(res.next()){
			usuario = new Usuario();
			usuario.setNome(res.getString("nome"));
			usuario.setSenha(res.getString("senha"));
			usuario.setLogin(res.getString("login"));
			usuario.setPapel(res.getInt("papel"));
				
		}
		return usuario;
	}
	
	/*
	 * Metódo para retornar um usuario pelo seu login
	 *
	 * @param String
	 * @return Usuario
	*/
	public Usuario trazerUsuario(String login)
			throws SQLException {
		stat = query.getPrepared(con,"Usuario.Pegar" );
		stat.setString(1,login);
		res = stat.executeQuery();
		Usuario usuario = null;
		if(res.next()){
			usuario = new Usuario();
			usuario.setNome(res.getString("nome"));
			usuario.setSenha(res.getString("senha"));
			usuario.setLogin(res.getString("login"));
			usuario.setPapel(res.getInt("papel"));
				
		}
		return usuario;
	}


}
