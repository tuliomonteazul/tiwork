package persistencia;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import beans.Medicamentos;
import beans.Remedio;

public class MedicamentoHsql implements MedicamentosDao {
	private HsqlSource hsql;
	public MedicamentoHsql() throws ClassNotFoundException, SQLException{
		hsql = HsqlSource.getInstance();
	}
	public void cadastrarMedicamentos(Medicamentos m) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Medicamentos> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Remedio> listarRemediosPorData(Date dataInicio, Date dataFim) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medicamentos trazer(String nomeMedicamento) {
		// TODO Auto-generated method stub
		return null;
	}

}
