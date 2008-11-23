package persistencia;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Venda;

public interface VendaDao {
	void inserirVenda(Venda venda) throws SQLException;
	
	int obterCodigo() throws SQLException;

	ArrayList<Venda> listarVendas() throws SQLException;

	ArrayList<Venda> listarVendaPorData (Date dataInicio, Date dataFim) throws SQLException;
	
	ArrayList<Venda> listarVendaPorCodigo (int codigo) throws SQLException;
	
	ArrayList<Venda> listarVendaPorCodigoData (int codigo, Date dataInicio, Date dataFim) throws SQLException;
	
	List<Venda> trazer( Date dataFim) throws SQLException;
}
