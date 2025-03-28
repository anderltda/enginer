package br.com.enginer.domain.schema.field;

/**
 * 
 */
public class Area extends Base {

	private static final String TYPE = "textarea";
	private String editor;
	private String placeholder;

	public String getType() {
		return TYPE;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

}
