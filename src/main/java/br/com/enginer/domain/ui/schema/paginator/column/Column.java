package br.com.enginer.domain.ui.schema.paginator.column;

import java.util.List;

/**
 * 
 */
public class Column {

	private List<String> initial;
	private List<String> hidden;

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
}
