package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Doencas;
import beans.Estoque;
import beans.Medicamentos;
import beans.Usuario;

public class EstoqueHsql implements EstoqueDao {
	private HsqlSource source;
	private QueryManager query;
	private ResultSet res;
	private PreparedStatement stat;
	private Connection con;
	
	public EstoqueHsql() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		source = HsqlSource.getInstance();
		query = QueryManager.getInstance();
		con = source.getConnection();
	}


	/*
	 * Metódo inserir um objeto estoque no banco
	 *
	 * @param Estoque
	 * @throws SQLException
	*/
	public void inserirEstoque(Estoque estoque) throws SQLException {
		stat = query.getPrepared(con,"Estoque.Inserir" );
		stat.setInt(1, estoque.getCod());
		stat.setInt(2, estoque.getQuantidade());
		stat.setDouble(3, estoque.getValor());
		stat.execute();
		
	}
	
	/*
	 * Metódo para retornar uma List com todos o elementos da tabela Estoque
	 *
	 * @throws SQLException
	*/
	public List<Estoque> listarEstoques() throws SQLException {
		stat = query.getPrepared(con, "Estoque.Listar");
		res = stat.executeQuery();
		List<Estoque> estoques = new ArrayList<Estoque>();
		while(res.next()){
			estoques.add(new Estoque(res.getInt("cod"), res.getInt("quantidade"), res.getDouble("valor")));
		}
		return estoques;
	}


}
