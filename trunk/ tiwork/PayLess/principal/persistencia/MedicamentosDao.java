package persistencia;

import java.util.List;

import beans.Medicamentos;

public interface MedicamentosDao {
 void cadastrarMedicamentos(Medicamentos m);
 Medicamentos trazer(String nomeMedicamento);
 List<Medicamentos> listar();
 
}
