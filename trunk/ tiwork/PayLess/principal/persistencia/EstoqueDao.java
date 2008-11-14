package persistencia;

import java.sql.SQLException;
import java.util.List;

import beans.Estoque;

public interface EstoqueDao {
	void inserirEstoque(Estoque estoque) throws SQLException;

	void alterarQuantidade(int cod, int quantidade) throws SQLException;

	List<Estoque> listarEstoques() throws SQLException;

	List<Estoque> listarEstoquesDistinct() throws SQLException;
	
	Estoque trazerEstoque(int cod) throws SQLException;

}
