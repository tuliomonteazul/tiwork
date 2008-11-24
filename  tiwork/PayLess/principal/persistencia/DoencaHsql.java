package persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Doencas;
import beans.Medicamentos;

public class DoencaHsql implements DoencaDao {
	private PreparedStatement stat;
	private HsqlSource hs;
	private Connection conn;
	private QueryManager query;
	private ResultSet res,res2,res3;
	public DoencaHsql() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		hs = HsqlSource.getInstance();
		conn = hs.getConnection();
		query = QueryManager.getInstance();
	}
	private int trazerSintomaCod(String sintoma) throws SQLException{
		stat = query.getPrepared(conn, "Sintomas.trazer");
		stat.setString(1,sintoma);
		res = stat.executeQuery();
		if(res.next()){
			System.out.println(res.getInt("COD"));
		return res.getInt("COD");
		}
		throw new SQLException();
	}
	
	public void cadastrarDoenca(Doencas doenca) throws SQLException {
		stat = query.getPrepared(conn,"Doenca.Cadastrar" );
		stat.setString(1,doenca.getNome());
		stat.execute();
		
	}
	public void insereSintoma(String doenca,String sintoma) throws SQLException{
		int doencas =  trazerDoenca(doenca).getCod();
		int sintomas = trazerSintomaCod(sintoma);
		stat = query.getPrepared(conn, "SintomasDoenca.inserir");
		stat.setInt(1,doencas);
		stat.setInt(2,sintomas);
		stat.execute();
		
	}

	public List<Doencas> listar()throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Doencas> trazerPorSintoma(String sintomas) throws SQLException{
		stat = query.getPrepared(conn, "Sintomas.trazer");
		stat.setString(1,sintomas);
		res = stat.executeQuery();
		List<Doencas>doencas = new ArrayList<Doencas>();
		List<String>sint;
		List<Medicamentos> medicamentos ;
		Doencas aux;
		if(res.next()){
			stat = query.getPrepared(conn,"SintomasDoenca.trazerPorCodSintoma");
			stat.setInt(1, res.getInt("COD"));
			res2 = stat.executeQuery();
			Medicamentos med;
			while(res2.next()){
				stat = query.getPrepared(conn,"Doenca.TrazerPorCod");
				stat.setInt(1, res2.getInt("COD_DOENCA"));
				res3 = stat.executeQuery();
				if(res3.next()){
					medicamentos = new ArrayList<Medicamentos>();
					sint =  new ArrayList<String>();
					aux = new Doencas();
					aux.setNome(res3.getString("DESCRICAO"));
					aux.setCod(res3.getInt("COD"));
					stat = query.getPrepared(conn, "SintomasDoenca.trazerPorCodDoenca");
					stat.setInt(1, aux.getCod());
					res = stat.executeQuery();
					while(res.next()){
						stat = query.getPrepared(conn, "Sintomas.trazerPorCod");
						stat.setInt(1, res.getInt("COD_SINTOMAS"));
						res3 = stat.executeQuery();
						res3.next();
						sint.add(res3.getString("DESCRICAO"));
					}
					aux.setSintomas(sint);
					stat = query.getPrepared(conn, "DoencaMedicacao.trazerPorCodDoenca");
					stat.setInt(1, aux.getCod());
					res = stat.executeQuery();
					while(res.next()){
						stat = query.getPrepared(conn, "Medicamentos.PegarPorCod");
						stat.setInt(1, res.getInt("COD_MEDICAMENTO"));
						res3 = stat.executeQuery();
						res3.next();
						med = new Medicamentos();
						med.setCod(res3.getInt("COD"));
						med.setNome(res3.getString("NOME"));
						med.setPeso(res3.getInt("PESO"));
						med.setPrincipioAtivo(res3.getString("principio_ativo"));
						med.setQuantidade(res3.getInt("quantidade"));
						med.setTipo(res3.getString("tipo_medicamento"));
						
						stat = query.getPrepared(conn, "Medidas.Pegar");
						stat.setInt(1, res3.getInt("MEDIDA"));
						res3 = stat.executeQuery();
						res3.next();
						med.setMedida(res3.getString("TIPO"));
						medicamentos.add(med);
					}
					aux.setMedicamentos(medicamentos);
					doencas.add(aux);
				}
			}
			
		}
		return doencas;
	}

	@Override
	public List<String> listarSintomas() throws SQLException {
	stat = query.getPrepared(conn,"Sintomas.Listar");
	res = stat.executeQuery();
	List<String> sintomas = new ArrayList<String>();
	while(res.next()){
		sintomas.add(res.getString("DESCRICAO"));
		
	}
	return sintomas;
	}

	@Override
	public Doencas trazerDoenca(String nome) throws SQLException {
		stat = query.getPrepared(conn, "Doenca.Trazer");
		stat.setString(1, nome);
		res = stat.executeQuery();
		Doencas doenca = null;
		if(res.next()){
			doenca = new Doencas();
			doenca.setCod(res.getInt("cod"));
			doenca.setNome(res.getString("descricao"));
		}
		return doenca;
	}

}
