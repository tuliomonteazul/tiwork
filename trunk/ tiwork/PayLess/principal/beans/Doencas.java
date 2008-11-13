package beans;

import java.util.ArrayList;
import java.util.List;

public class Doencas {
	private List<Medicamentos> medicamentos;
	private String nome;
	private List<String> sintomas;
	private int cod;
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
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
