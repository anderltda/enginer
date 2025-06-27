package br.com.enginer.domain.ui.usercase.schema.paginator.column;

import java.util.List;

/**
 * 
 */
public class Column {

	private String name;
	private List<String> initial;
	private List<String> hidden;
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

	public List<String> getHidden() {
		return hidden;
	}

	public void setHidden(List<String> hidden) {
		this.hidden = hidden;
	}

	public List<String> getVisible() {
		return visible;
	}

	public void setVisible(List<String> visible) {
		this.visible = visible;
	}

}
