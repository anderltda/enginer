package br.com.enginer.domain.ui.schema.field;

/**
 * 
 */
public class Join {

	private static final String TYPE = "join";
	private String label;
	private String domain;
	private String icon;
	private Integer order;
	private String layoutTarget;

	public String getType() {
		return TYPE;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getLayoutTarget() {
		return layoutTarget;
	}

	public void setLayoutTarget(String layoutTarget) {
		this.layoutTarget = layoutTarget;
	}

}
