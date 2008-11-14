package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

import beans.Venda;

public interface VendaDao {
	void inserirVenda(Venda venda) throws SQLException;
	
	int obterCodigo() throws SQLException;

	ArrayList<Venda> listarVendas() throws SQLException;

}
