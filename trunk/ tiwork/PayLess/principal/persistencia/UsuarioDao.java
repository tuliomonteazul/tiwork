package persistencia;

import java.sql.SQLException;

import beans.Usuario;

public interface UsuarioDao {
	void cadastrarUsuario(Usuario u) throws SQLException;

	Usuario trazerFarmaceutico(String login) throws SQLException;

	void removerFuncionario(Usuario u) throws SQLException;

	Usuario trazerFuncionario(String login) throws SQLException;

}
