package br.com.enginer.domain.schema.field;

/**
 * 
 */
public class Hidden {

	private String type = "hidden";
	private String field;
	private Object value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
