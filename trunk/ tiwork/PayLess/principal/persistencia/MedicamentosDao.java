package persistencia;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import beans.Doencas;
import beans.Medicamentos;
import beans.Remedio;

public interface MedicamentosDao {
 void cadastrarMedicamentos(Medicamentos m)throws SQLException;
 Medicamentos trazer(String nomeMedicamento)throws SQLException;
 List<Medicamentos> listar()throws SQLException;
 List<Remedio> listarRemediosPorData(Date dataInicio,Date dataFim)throws SQLException;
 List<Medicamentos> trazerPorSintoma(String sintomas ) throws SQLException;
 List<String> listarMedidas() throws SQLException;
 void insereDoenca(String doenca) throws SQLException;
}
