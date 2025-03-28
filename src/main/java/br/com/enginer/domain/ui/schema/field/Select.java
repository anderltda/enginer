package br.com.enginer.domain.ui.schema.field;

import java.util.List;

/**
 * 
 */
public class Select extends Base {

	private static final String TYPE = "select";
	private Boolean multi;
	private List<Option> options;

	public String getType() {
		return TYPE;
	}

	public Boolean getMulti() {
		return multi;
	}

	public void setMulti(Boolean multi) {
		this.multi = multi;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

}
