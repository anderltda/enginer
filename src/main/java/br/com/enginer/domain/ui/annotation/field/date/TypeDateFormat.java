package br.com.enginer.domain.ui.annotation.field.date;

public enum TypeDateFormat {

	DATE_TIME_FORMAT("DD/MM/YYYY HH:mm:ss"), DATE_FORMAT("DD/MM/YYYY");

	private final String symbol;

	TypeDateFormat(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}
}