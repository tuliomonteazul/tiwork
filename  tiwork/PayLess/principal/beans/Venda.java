package beans;

import java.sql.Date;
import java.util.GregorianCalendar;

public class Venda {
	private int codVenda, codRemedio, codFuncionario, quantidade;
	private double valor;
	private Date data;
	private String nomeRemedio, nomeFuncionario, dataString;

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
	
	public String getNomeRemedio() {
		return nomeRemedio;
	}

	public void setNomeRemedio(String nomeRemedio) {
		this.nomeRemedio = nomeRemedio;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getDataString() {
		return dataString;
	}

	public void setDataString(String dataString) {
		this.dataString = dataString;
	}

	/*
	 * Metódo para transformar uma data String em java.sql.Date
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
	
	/*
	 * Metódo para transformar uma data em java.sql.Date em String
	 *
	 * @param Date
	 * @return String
	 * @throws SQLException
	*/
	public static String dataDateToString(Date date) {
		String data = "";
		String dateString = date.toString();
		String ano = dateString.substring(0,4);
		String mes = dateString.substring(5,7);
		String dia = dateString.substring(8,10);
		data = dia+"/"+mes+"/"+ano;
		return data;
	}
	
}
