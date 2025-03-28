package br.com.enginer.domain.ui.schema.field;

import java.util.List;

/**
 * 
 */
public abstract class Base {

	private String type;
	private String label;
	private String field;
	private Boolean required;
	private Object value;
	private Integer order;
	private Integer group;
	private Boolean disabled;
	private String asyncValidatorFn;
	private String asyncValidatorFnMessage;
	private String syncValidatorFnMessage;
	private List<String> syncValidatorFn;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getGroup() {
		return group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getAsyncValidatorFn() {
		return asyncValidatorFn;
	}

	public void setAsyncValidatorFn(String asyncValidatorFn) {
		this.asyncValidatorFn = asyncValidatorFn;
	}

	public String getAsyncValidatorFnMessage() {
		return asyncValidatorFnMessage;
	}

	public void setAsyncValidatorFnMessage(String asyncValidatorFnMessage) {
		this.asyncValidatorFnMessage = asyncValidatorFnMessage;
	}

	public String getSyncValidatorFnMessage() {
		return syncValidatorFnMessage;
	}

	public void setSyncValidatorFnMessage(String syncValidatorFnMessage) {
		this.syncValidatorFnMessage = syncValidatorFnMessage;
	}

	public List<String> getSyncValidatorFn() {
		return syncValidatorFn;
	}

	public void setSyncValidatorFn(List<String> syncValidatorFn) {
		this.syncValidatorFn = syncValidatorFn;
	}

}
