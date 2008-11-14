package beans;

public class Estoque {
	private int cod, quantidade;
	private double valor;
	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Estoque() {
		super();
	}
	public Estoque(int cod, String nome, int quantidade, double valor) {
		super();
		this.nome = nome;
		this.cod = cod;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	public Estoque(int cod, int quantidade, double valor) {
		super();
		this.cod = cod;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
