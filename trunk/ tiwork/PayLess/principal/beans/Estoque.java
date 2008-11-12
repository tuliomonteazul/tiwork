package beans;

public class Estoque {
	private int cod, quantidade;
	private double valor;
	public Estoque() {
		super();
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
