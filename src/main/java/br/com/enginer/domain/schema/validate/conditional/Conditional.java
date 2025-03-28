package br.com.enginer.domain.schema.validate.conditional;

import java.util.List;

/**
 * 
 */
public class Conditional {

	private String label;
	private String field;
	private String operator; // '>' | '<' | '>=' | '<=' | '===' | '!==';
	private List<String> matchs;

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

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public List<String> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<String> matchs) {
		this.matchs = matchs;
	}

}
