package beans;

import java.util.ArrayList;
import java.util.List;

public class Doencas {
	private List<Medicamentos> medicamentos;
	private String nome;
	private List<String> sintomas;
	public List<Medicamentos> getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(List<Medicamentos> medicamentos) {
		this.medicamentos = medicamentos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<String> getSintomas() {
		return sintomas;
	}
	public void setSintomas(List<String> sintomas) {
		this.sintomas = sintomas;
	}
}
