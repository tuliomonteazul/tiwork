package persistencia;

import java.util.List;

import beans.Doencas;

public interface DoencaDao {
 void cadastrarDoenca(Doencas doenca);
 List<Doencas> listar();
 List<Doencas>  trazerPorSintoma(List<String> sintomas);
 
}
