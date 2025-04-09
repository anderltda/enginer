package br.com.enginer.domain.ui.schema.field.behavior;

import java.util.List;

import br.com.enginer.domain.ui.schema.field.behavior.validation.Validation;

/**
 * 
 */
public abstract class Base {

	private String type;
	private String label;
	private String field;
	private String mask;
	private String icon;
	private String placeholder;
	private String format;
	private String title;
	private String action;
	private String mode;
	private String domain;
	private String layoutTarget;
	private Integer min;
	private Integer max;
	private Boolean required;
	private Boolean disabled;
	private Boolean editor;
	private Boolean showtime;
	private Boolean multi;
	private Boolean enableSwitch;
	private Object value;
	
	private Position position;
	private Validation validation;
	private Autocomplete autocomplete;
	
	private List<String> files;
	private List<Option> options;

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

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
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

	public Boolean getEditor() {
		return editor;
	}

	public void setEditor(Boolean editor) {
		this.editor = editor;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getLayoutTarget() {
		return layoutTarget;
	}

	public void setLayoutTarget(String layoutTarget) {
		this.layoutTarget = layoutTarget;
	}

	public Boolean getMulti() {
		return multi;
	}

	public void setMulti(Boolean multi) {
		this.multi = multi;
	}

	public Validation getValidation() {
		return validation;
	}

	public void setValidation(Validation validation) {
		this.validation = validation;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Autocomplete getAutocomplete() {
		return autocomplete;
	}

	public void setAutocomplete(Autocomplete autocomplete) {
		this.autocomplete = autocomplete;
	}

	public List<String> getFiles() {
		return files;
	}

	public void setFiles(List<String> files) {
		this.files = files;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Boolean getEnableSwitch() {
		return enableSwitch;
	}

	public void setEnableSwitch(Boolean enableSwitch) {
		this.enableSwitch = enableSwitch;
	}
}
