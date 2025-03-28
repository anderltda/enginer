package br.com.enginer.domain.ui.schema.field;

/**
 * 
 */
public class Number extends Base {

	private static final String TYPE = "number";
	private Integer min;
	private Integer max;
	private String icon;
	private String placeholder;

	public String getType() {
		return TYPE;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
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
