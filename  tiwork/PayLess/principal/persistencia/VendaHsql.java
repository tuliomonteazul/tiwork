package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Venda;

public class VendaHsql implements VendaDao {
	private HsqlSource source;
	private QueryManager query;
	private ResultSet res,res2;
	private PreparedStatement stat;
	private Connection con;
	
	public VendaHsql() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		source = HsqlSource.getInstance();
		query = QueryManager.getInstance();
		con = source.getConnection();
	}
	
	/*
	 * Met�do para inserir uma venda no banco
	 *
	 * @param Venda
	 * @throws SQLException
	*/
	public void inserirVenda(Venda venda) throws SQLException {
		stat = query.getPrepared(con, "Venda.inserir");	
		stat.setInt(1, venda.getCodVenda());
		stat.setInt(2, venda.getCodRemedio());
		stat.setInt(3, venda.getCodFuncionario());
		stat.setInt(4, venda.getQuantidade());
		stat.setDouble(5, venda.getValor());
		stat.setDate(6, venda.getData());
		stat.execute();
	}
	
	/*
	 * Met�do para retornar o codigo a ser usado na proxima venda
	 *
	 * @return int
	 * @throws SQLException
	*/
	public int obterCodigo() throws SQLException {
		stat = query.getPrepared(con, "Venda.obter.codigo" );
		res = stat.executeQuery();
		int codigo = 0;
		if(res.next()){
			codigo = res.getInt("codigo");
		}
		codigo++;
		return codigo;
	}
	
	/*
	 * Met�do para retornar uma lista com todas as vendas
	 *
	 * @return ArrayList<Venda>
	 * @throws SQLException
	*/
	public ArrayList<Venda> listarVendas() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * Met�do para retornar uma lista com as vendas entre duas datas
	 * 
	 * @param Date
	 * @param Date
	 * @return ArrayList<Venda>
	 * @throws SQLException
	*/
	public ArrayList<Venda> listarVendaPorData(Date dataInicio, Date dataFim) throws SQLException {
		stat = query.getPrepared(con, "Venda.Listar.Por.Data" );
		stat.setDate(1, dataInicio);
		stat.setDate(2, dataFim);
		res = stat.executeQuery();
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		Venda venda = null;
		while(res.next()){
			venda = new Venda();
			venda.setCodVenda(res.getInt("codVenda"));
			venda.setCodRemedio(res.getInt("codRemedio"));
			venda.setCodFuncionario(res.getInt("codFuncionario"));
			venda.setQuantidade(res.getInt("quantidade"));
			venda.setValor(res.getDouble("valor"));
			venda.setData(res.getDate("data"));
			stat = query.getPrepared(con,"Medicamentos.PegarPorCod");
			stat.setInt(1,res.getInt("CODREMEDIO"));
			res2 = stat.executeQuery();
			res2.next();
			venda.setNomeRemedio(res2.getString("NOME"));
			
			vendas.add(venda);
		}
		return vendas;
	}
	
	/*
	 * Met�do para retornar vendas de um codigoVenda
	 *
	 * @param int
	 * @return ArrayList<Venda>
	 * @throws SQLException
	*/
	public ArrayList<Venda> listarVendaPorCodigo(int codigo) throws SQLException {
		stat = query.getPrepared(con, "Venda.Listar.Por.Codigo" );
		stat.setInt(1, codigo);
		res = stat.executeQuery();
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		Venda venda = null;
		while(res.next()){
			venda = new Venda();
			venda.setCodVenda(res.getInt("codVenda"));
			venda.setCodRemedio(res.getInt("codRemedio"));
			venda.setCodFuncionario(res.getInt("codFuncionario"));
			venda.setQuantidade(res.getInt("quantidade"));
			venda.setValor(res.getDouble("valor"));
			venda.setData(res.getDate("data"));
			vendas.add(venda);
		}
		return vendas;
	}
	
	/*
	 * Met�do para retornar vendas de um codigoVenda em um per�odo
	 *
	 * @param int
	 * @param Date
	 * @param Date
	 * @return ArrayList<Venda>
	 * @throws SQLException
	*/
	public ArrayList<Venda> listarVendaPorCodigoData(int codigo, Date dataInicio, Date dataFim) throws SQLException {
		stat = query.getPrepared(con, "Venda.Listar.Por.Codigo.Data" );
		stat.setInt(1, codigo);
		stat.setDate(2, dataInicio);
		stat.setDate(3, dataFim);
		res = stat.executeQuery();
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		Venda venda = null;
		while(res.next()){
			venda = new Venda();
			venda.setCodVenda(res.getInt("codVenda"));
			venda.setCodRemedio(res.getInt("codRemedio"));
			venda.setCodFuncionario(res.getInt("codFuncionario"));
			venda.setQuantidade(res.getInt("quantidade"));
			venda.setValor(res.getDouble("valor"));
			venda.setData(res.getDate("data"));
			vendas.add(venda);
		}
		return vendas;
	}
	


}
