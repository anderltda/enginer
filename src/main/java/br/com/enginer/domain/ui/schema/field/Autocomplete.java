package br.com.enginer.domain.ui.schema.field;

import java.util.List;

/**
 * 
 */
public class Autocomplete {

	private String domain;
	private String attribute;
	private List<String> suggestions;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public List<String> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<String> suggestions) {
		this.suggestions = suggestions;
	}

}
