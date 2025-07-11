package br.com.enginer.domain.ui.usercase.schema.paginator.column;

import java.util.List;

/**
 * 
 */
public class Column {

	private String name;
	private List<String> initial;
	private List<String> row;
	private List<String> visible;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getInitial() {
		return initial;
	}

	public void setInitial(List<String> initial) {
		this.initial = initial;
	}

	public List<String> getRow() {
		return row;
	}

	public void setRow(List<String> row) {
		this.row = row;
	}

	public List<String> getVisible() {
		return visible;
	}

	public void setVisible(List<String> visible) {
		this.visible = visible;
	}

}
