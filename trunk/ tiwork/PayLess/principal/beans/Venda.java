package beans;

import java.sql.Date;
import java.util.GregorianCalendar;

public class Venda {
	private int codVenda, codRemedio, codFuncionario, quantidade;
	private double valor;
	private Date data;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Venda() {
		super();
	}

	
	
	public Venda(int codVenda, int codRemedio, int codFuncionario,
			int quantidade, double valor, Date data) {
		super();
		this.codVenda = codVenda;
		this.codRemedio = codRemedio;
		this.codFuncionario = codFuncionario;
		this.quantidade = quantidade;
		this.valor = valor;
		this.data = data;
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
	
	/*
	 * Metódo para transformar uma data em String em java.sql.Date
	 *
	 * @param String
	 * @return Date
	 * @throws SQLException
	*/
	public static Date dataStringToDate(String data) {
		Date date = null;
		String dia = data.substring(0,2);
		String mes = data.substring(3,5);
		String ano = data.substring(6,10);
		GregorianCalendar calendar = new GregorianCalendar(Integer.parseInt(ano), (Integer.parseInt(mes)-1), Integer.parseInt(dia));
		date = new Date(calendar.getTimeInMillis());
		return date;
	}
	
}
