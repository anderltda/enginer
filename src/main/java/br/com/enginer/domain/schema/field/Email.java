package br.com.enginer.domain.schema.field;

/**
 * 
 */
public class Email extends Base {

	private static final String TYPE = "email";
	private Integer min;
	private Integer max;
	private String icon;
	private String placeholder;
	private Autocomplete autocomplete;

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

	public Autocomplete getAutocomplete() {
		return autocomplete;
	}

	public void setAutocomplete(Autocomplete autocomplete) {
		this.autocomplete = autocomplete;
	}

}
