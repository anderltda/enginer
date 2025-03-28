package br.com.enginer.domain.schema.field;

/**
 * 
 */
public class Password extends Base {

	private static final String TYPE = "password";
	private Integer min;
	private Integer max;
	private String icon;
	private String pattern;
	private String patternMessage;
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

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getPatternMessage() {
		return patternMessage;
	}

	public void setPatternMessage(String patternMessage) {
		this.patternMessage = patternMessage;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

}
