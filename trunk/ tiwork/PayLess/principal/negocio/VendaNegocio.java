package negocio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.VendaDao;
import persistencia.VendaHsql;
import beans.Venda;

public class VendaNegocio{
	private VendaDao vendaoDao;
	public VendaNegocio() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		vendaoDao =  new VendaHsql();
	}
	
	/*
	 * Metódo para inserir uma venda no banco
	 *
	 * @param Venda
	 * @throws SQLException
	*/
	public void inserirVenda(Venda venda)
			throws SQLException {
		vendaoDao.inserirVenda(venda);
	}
	
	/*
	 * Metódo para uma lista com todas as vendas
	 *
	 * @return ArrayList<Venda>
	 * @throws SQLException
	*/
	public ArrayList<Venda> listarVendas()
			throws SQLException {
		ArrayList<Venda> vendas = vendaoDao.listarVendas();
		return vendas;
	}
	
	/*
	 * Metódo para retornar o codigo a ser usado na proxima venda
	 *
	 * @return int
	 * @throws SQLException
	*/
	public int obterCodigo()
			throws SQLException {
		int codigo = vendaoDao.obterCodigo();
		return codigo;
	}

}
