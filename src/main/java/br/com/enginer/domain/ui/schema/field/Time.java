package br.com.enginer.domain.ui.schema.field;

/**
 * 
 */
public class Time extends Base {

	private static final String TYPE = "time";
	private String icon;
	private String placeholder;

	public String getType() {
		return TYPE;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

}
