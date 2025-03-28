package br.com.enginer.domain.ui.schema.field;

/**
 * 
 */
public class Decimal extends Base {

	private static final String TYPE = "decimal";
	private String mask;
	private String icon;
	private String placeholder;

	public String getType() {
		return TYPE;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
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
