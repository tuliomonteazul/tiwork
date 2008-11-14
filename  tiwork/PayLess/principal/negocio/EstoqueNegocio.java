package negocio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import persistencia.EstoqueDao;
import persistencia.EstoqueHsql;
import beans.Estoque;
import beans.Usuario;

public class EstoqueNegocio{
	private EstoqueDao estoqueDao;
	public EstoqueNegocio() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		estoqueDao =  new EstoqueHsql();
	}
	
	/*
	 * Met�do inserir um objeto estoque no banco
	 *
	 * @param Estoque
	 * @throws SQLException
	*/
	public void inserirEstoque(Estoque estoque)throws SQLException{
		estoqueDao.inserirEstoque(estoque);
	}

	/*
	 * Met�do para retornar uma List com todos o elementos da tabela Estoque
	 *
	 * @throws SQLException
	*/
	public List<Estoque> listarEstoques()
			throws SQLException {
		List<Estoque> estoques = estoqueDao.listarEstoques();
		return estoques;
	}
	
	/*
	 * Met�do para retornar uma List com o cod dos objetos de Estoque sem repeti��o junto com seu nome vindo da tabela Medicamentos
	 *
	 * @throws SQLException
	*/
	public List<Estoque> listarEstoquesDistinct()
			throws SQLException {
		List<Estoque> estoques = estoqueDao.listarEstoquesDistinct();
		return estoques;
	}
	
	
	/*
	 * Met�do alterar a quantidade de um estoque
	 *
	 * @param int
	 * @param int
	 * @throws SQLException
	*/
	public void alterarQuantidade(int cod, int quantidade) throws SQLException {
		estoqueDao.alterarQuantidade(cod, quantidade);
	}
	
	/*
	 * Met�do retornar um estoque pelo seu codigo
	 *
	 * @param int
	 * @return Estoque
	 * @throws SQLException
	*/
	public Estoque trazerEstoque(int cod) throws SQLException {
		Estoque estoque = estoqueDao.trazerEstoque(cod);
		return estoque;
	}


}
