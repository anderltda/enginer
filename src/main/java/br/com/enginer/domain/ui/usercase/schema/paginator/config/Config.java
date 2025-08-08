package br.com.enginer.domain.ui.usercase.schema.paginator.config;

/**
 * 
 */
public class Config {

	private Boolean expandable;
	private Boolean editableAllCell;
	private Boolean multiSelectable;
	private Boolean deletableCell;

	public Boolean getExpandable() {
		return expandable;
	}

	public void setExpandable(Boolean expandable) {
		this.expandable = expandable;
	}

	public Boolean getEditableAllCell() {
		return editableAllCell;
	}

	public void setEditableAllCell(Boolean editableAllCell) {
		this.editableAllCell = editableAllCell;
	}

	public Boolean getMultiSelectable() {
		return multiSelectable;
	}

	public void setMultiSelectable(Boolean multiSelectable) {
		this.multiSelectable = multiSelectable;
	}

	public Boolean getDeletableCell() {
		return deletableCell;
	}

	public void setDeletableCell(Boolean deletableCell) {
		this.deletableCell = deletableCell;
	}

	
}
