package br.com.enginer.domain.ui.schema.field.behavior.validation;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 */
public class Sync {

	private String[] functions;
	private Map<String, String> messages;

	public Sync(String[] functions, String[] messages) {
		this.functions = functions;
		this.messages = new LinkedHashMap<>();
		for (int i = 0; i < functions.length; i++) {
			this.messages.put(functions[i], messages[i]);
		}
	}

	public String[] getFunctions() {
		return functions;
	}

	public void setFunctions(String[] functions) {
		this.functions = functions;
	}

	public Map<String, String> getMessages() {
		return messages;
	}

	public void setMessages(Map<String, String> messages) {
		this.messages = messages;
	}
}
