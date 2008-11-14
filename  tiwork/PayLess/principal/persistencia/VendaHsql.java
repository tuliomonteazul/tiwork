package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Medicamentos;
import beans.Usuario;
import beans.Venda;

public class VendaHsql implements VendaDao {
	private HsqlSource source;
	private QueryManager query;
	private ResultSet res;
	private PreparedStatement stat;
	private Connection con;
	
	public VendaHsql() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		source = HsqlSource.getInstance();
		query = QueryManager.getInstance();
		con = source.getConnection();
	}
	
	/*
	 * Metódo para inserir uma venda no banco
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
		stat.execute();
	}
	
	/*
	 * Metódo para retornar o codigo a ser usado na proxima venda
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
	 * Metódo para retornar uma lista com todas as vendas
	 *
	 * @return ArrayList<Venda>
	 * @throws SQLException
	*/
	public ArrayList<Venda> listarVendas() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
