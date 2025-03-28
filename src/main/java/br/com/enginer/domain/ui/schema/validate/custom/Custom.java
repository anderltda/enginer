package br.com.enginer.domain.ui.schema.validate.custom;

import java.util.List;

/**
 * 
 */
public class Custom {

	private String function;
	private String message;
	private List<String> fields;

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

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

}
