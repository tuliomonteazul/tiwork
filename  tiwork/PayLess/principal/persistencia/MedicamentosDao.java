package persistencia;

import java.util.Date;
import java.util.List;

import beans.Medicamentos;
import beans.Remedio;

public interface MedicamentosDao {
 void cadastrarMedicamentos(Medicamentos m);
 Medicamentos trazer(String nomeMedicamento);
 List<Medicamentos> listar();
 List<Remedio> listarRemediosPorData(Date dataInicio,Date dataFim);
}
