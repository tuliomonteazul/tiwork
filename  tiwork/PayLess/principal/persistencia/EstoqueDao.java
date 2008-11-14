package persistencia;

import java.sql.SQLException;
import java.util.List;

import beans.Estoque;

public interface EstoqueDao {
	void inserirEstoque(Estoque estoque) throws SQLException;
	List<Estoque> listarEstoques() throws SQLException;
	List<Estoque> listarEstoquesDistinct() throws SQLException;

}
