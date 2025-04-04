package br.com.enginer.domain.ui.schema.field.behavior;

public class Pattern {

	private String regex;
	private String message;
	
	public Pattern() {
		super();
	}

	public Pattern(String regex, String message) {
		this.regex = regex;
		this.message = message;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
