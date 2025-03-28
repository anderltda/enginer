package br.com.enginer.domain.schema.field;

public class Date extends Base {

	private static final String TYPE = "date";
	private String format;
	private Boolean showtime;
	private String icon;
	private String placeholder;

	public String getType() {
		return TYPE;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Boolean getShowtime() {
		return showtime;
	}

	public void setShowtime(Boolean showtime) {
		this.showtime = showtime;
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
