package persistencia;

import java.sql.SQLException;
import java.util.List;

import beans.Doencas;

public interface DoencaDao {
 void cadastrarDoenca(Doencas doenca)throws SQLException;
 List<Doencas> listar()throws SQLException;
 List<Doencas>  trazerPorSintoma(String sintomas)throws SQLException;
 List<String> listarSintomas()throws SQLException;
 Doencas trazerDoenca(String nome) throws SQLException;
 public void insereSintoma(String sintoma) throws SQLException;
}
