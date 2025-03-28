package br.com.enginer.domain.schema.row;

import java.util.List;

import br.com.enginer.domain.schema.field.Button;
import br.com.enginer.domain.schema.row.config.Config;

/**
 * 
 */
public class Row {

	private Config config;
	private List<Button> actions;

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
