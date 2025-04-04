package br.com.enginer.domain.ui.schema.field.behavior.validation;

/**
 * 
 */
public class Async {

	private String function;
	private String message;

	public Async() {
		super();
	}

	public Async(String function, String message) {
		super();
		this.function = function;
		this.message = message;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
