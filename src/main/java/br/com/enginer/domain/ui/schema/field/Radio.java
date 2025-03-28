package br.com.enginer.domain.ui.schema.field;

import java.util.List;

/**
 * 
 */
public class Radio extends Base {

	private static final String TYPE = "radio";
	private List<Option> options;

	public String getType() {
		return TYPE;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

}
