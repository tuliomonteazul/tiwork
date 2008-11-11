package persistencia;

import java.sql.SQLException;
import java.util.List;

import beans.Doencas;

public interface DoencaDao {
 void cadastrarDoenca(Doencas doenca)throws SQLException;
 List<Doencas> listar()throws SQLException;
 List<Doencas>  trazerPorSintoma(String sintomas)throws SQLException;
 
}
