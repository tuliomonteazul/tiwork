package negocio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import persistencia.MedicamentoHsql;
import persistencia.UsuarioDao;
import persistencia.UsuarioHsql;
import beans.Medicamentos;
import beans.Remedio;
import beans.Usuario;

public class UsuarioNegocio{
	private UsuarioDao usuarioDao;
	public UsuarioNegocio() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		usuarioDao =  new UsuarioHsql();
	}
	
	/*
	 * Metódo para cadastrar um usuario
	 *
	 * @param Usuario
	 * @throws SQLException
	*/
	public void cadastrarUsuario(Usuario usuario)throws SQLException{
		usuarioDao.cadastrarUsuario(usuario);
	}

	/*
	 * Metódo para retornar um usuario farmaceutico pelo seu login
	 *
	 * @param String
	 * @return Usuario
	 * @throws SQLException
	*/
	public Usuario trazerFarmaceutico(String login)
			throws SQLException {
		Usuario usuario = usuarioDao.trazerFarmaceutico(login);
		return usuario;
	}

	/*
	 * Metódo para retornar um usuario funcionario pelo seu login
	 *
	 * @param String
	 * @return Usuario
	 * @throws SQLException
	*/
	public Usuario trazerFuncionario(String login)
			throws SQLException {
		Usuario usuario = usuarioDao.trazerFuncionario(login);
		return usuario;
	}
	
	/*
	 * Metódo para retornar um usuario pelo seu login
	 *
	 * @param String
	 * @return Usuario
	 * @throws SQLException
	*/
	public Usuario trazerUsuario(String login)
			throws SQLException {
		Usuario usuario = usuarioDao.trazerUsuario(login);
		return usuario;
	}

}
