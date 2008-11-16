package persistencia;

import java.sql.SQLException;

import beans.Usuario;

public interface UsuarioDao {
	void cadastrarUsuario(Usuario usuario) throws SQLException;

	Usuario trazerFarmaceutico(String login) throws SQLException;

	void removerFuncionario(Usuario usuario) throws SQLException;

	Usuario trazerFuncionario(String login) throws SQLException;
	
	Usuario trazerUsuario(String login) throws SQLException;
	
	Usuario trazerUsuarioPorCodigo(int codigo) throws SQLException;

}
