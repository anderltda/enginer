package br.com.enginer.domain.schema.paginator;

import java.util.List;

import br.com.enginer.domain.schema.field.Button;
import br.com.enginer.domain.schema.paginator.column.Column;
import br.com.enginer.domain.schema.paginator.config.Config;

/**
 * 
 */
public class Paginator {

	private Column column;
	private Config config;
	private List<Button> actions;

	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public List<Button> getActions() {
		return actions;
	}

	public void setActions(List<Button> actions) {
		this.actions = actions;
	}
}
