package br.com.enginer.domain.ui.schema.validate.dependency;

import java.util.List;

/**
 * 
 */
public class Dependency {

	private String label;
	private String field;
	private List<String> depends;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public List<String> getDepends() {
		return depends;
	}

	public void setDepends(List<String> depends) {
		this.depends = depends;
	}
}
