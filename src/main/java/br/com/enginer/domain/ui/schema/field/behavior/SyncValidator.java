package br.com.enginer.domain.ui.schema.field.behavior;

import java.util.List;

/**
 * 
 */
public class SyncValidator {

	private String message;
	private List<String> functions;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getFunctions() {
		return functions;
	}

	public void setFunctions(List<String> functions) {
		this.functions = functions;
	}

}
