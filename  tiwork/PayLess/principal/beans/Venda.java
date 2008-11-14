package beans;

public class Venda {
	private int codVenda, codRemedio, codFuncionario, quantidade;
	private double valor;

	public Venda() {
		super();
	}

	public Venda(int codVenda, int codRemedio, int codFuncionario,
			int quantidade, double valor) {
		super();
		this.codVenda = codVenda;
		this.codRemedio = codRemedio;
		this.codFuncionario = codFuncionario;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public int getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}

	public int getCodRemedio() {
		return codRemedio;
	}

	public void setCodRemedio(int codRemedio) {
		this.codRemedio = codRemedio;
	}

	public int getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
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
