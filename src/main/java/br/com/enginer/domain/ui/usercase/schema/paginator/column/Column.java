package br.com.enginer.domain.ui.usercase.schema.paginator.column;

import java.util.List;

/**
 * 
 */
public class Column {

	private String name;
	private String totalizador;
	private List<String> initials;
	private List<String> rows;
	private List<String> hiddens;
	private List<String> editables;
	private List<String> visibles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTotalizador() {
		return totalizador;
	}

	public void setTotalizador(String totalizador) {
		this.totalizador = totalizador;
	}

	public List<String> getInitials() {
		return initials;
	}

	public void setInitials(List<String> initials) {
		this.initials = initials;
	}

	public List<String> getRows() {
		return rows;
	}

	public void setRows(List<String> rows) {
		this.rows = rows;
	}

	public List<String> getHiddens() {
		return hiddens;
	}

	public void setHiddens(List<String> hiddens) {
		this.hiddens = hiddens;
	}

	public List<String> getEditables() {
		return editables;
	}

	public void setEditables(List<String> editables) {
		this.editables = editables;
	}

	public List<String> getVisibles() {
		return visibles;
	}

	public void setVisibles(List<String> visibles) {
		this.visibles = visibles;
	}

}
