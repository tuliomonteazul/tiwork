package negocio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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
	 * Metódo para retornar uma lista com as vendas entre duas datas
	 *
	 * @param java.sql.Date
	 * @param java.sql.Date
	 * @return ArrayList<Venda>
	 * @throws SQLException
	*/
	public ArrayList<Venda> listarVendaPorData(Date dataInicio, Date dataFim) throws SQLException {
		ArrayList<Venda> vendas = null;
		vendas = vendaoDao.listarVendaPorData(dataInicio, dataFim);
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
	
	/*
	 * Metódo para retornar vendas de um codigoVenda
	 *
	 * @param int
	 * @return ArrayList<Venda>
	 * @throws SQLException
	*/
	public ArrayList<Venda> listarVendaPorCodigo(int codigo) throws SQLException {
		ArrayList<Venda> vendas = null;
		vendas = vendaoDao.listarVendaPorCodigo(codigo);
		return vendas;
	}

	

}
