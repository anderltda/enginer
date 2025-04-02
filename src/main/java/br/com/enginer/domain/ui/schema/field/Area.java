package br.com.enginer.domain.ui.schema.field;

/**
 * 
 */
public class Area extends Base {

	private static final String TYPE = "textarea";
	private Boolean editor;
	private String placeholder;

	public String getType() {
		return TYPE;
	}

	public Boolean getEditor() {
		return editor;
	}

	public void setEditor(Boolean editor) {
		this.editor = editor;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

}
