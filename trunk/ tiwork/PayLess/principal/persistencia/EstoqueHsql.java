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
			estoques.add(new Estoque(res.getInt("cod"), res.getString("nome"), res.getInt("quantidade"), res.getDouble("valor")));
		}
		return estoques;
	}
	
	/*
	 * Metódo para retornar uma List com o cod dos objetos de Estoque sem repetição junto com seu nome vindo da tabela Medicamentos
	 *
	 * @throws SQLException
	*/
	public List<Estoque> listarEstoquesDistinct() throws SQLException {
		stat = query.getPrepared(con, "Estoque.ListarDistinct");
		res = stat.executeQuery();
		List<Estoque> estoques = new ArrayList<Estoque>();
		Estoque estoque;
		while(res.next()){
			estoque = new Estoque();
			estoque.setCod(res.getInt("cod"));
			estoque.setNome(res.getString("nome"));
			estoque.setValor(res.getDouble("valor"));
			estoque.setQuantidade(res.getInt("quantidade"));
			if (res.getInt("quantidade") != 0){
				estoques.add(estoque);
			}
		}
		return estoques;
	}


	/*
	 * Metódo alterar a quantidade de um estoque
	 *
	 * @param int
	 * @param int
	 * @throws SQLException
	*/
	public void alterarQuantidade(int cod, int quantidade) throws SQLException {
		stat = query.getPrepared(con,"Estoque.Alterar.Quantidade" );
		stat.setInt(1, quantidade);
		stat.setInt(2, cod);
		stat.execute();
	}

	/*
	 * Metódo alterar o valor de um estoque
	 *
	 * @param int
	 * @param int
	 * @throws SQLException
	*/
	public void alterarValor(int cod, double valor) throws SQLException {
		stat = query.getPrepared(con,"Estoque.Alterar.Valor" );
		stat.setDouble(1, valor);
		stat.setInt(2, cod);
		stat.execute();
	}

	/*
	 * Metódo retornar um estoque pelo seu codigo
	 *
	 * @param int
	 * @return Estoque
	 * @throws SQLException
	*/
	public Estoque trazerEstoque(int cod) throws SQLException {
		stat = query.getPrepared(con, "Estoque.Trazer");
		stat.setInt(1, cod);
		res = stat.executeQuery();
		Estoque estoque = new Estoque();;
		while(res.next()){
			estoque.setCod(res.getInt("cod"));
			estoque.setNome(res.getString("nome"));
			estoque.setValor(res.getDouble("valor"));
			estoque.setQuantidade(res.getInt("quantidade"));
		}
		return estoque;
	}



}
