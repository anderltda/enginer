package br.com.enginer.domain.ui.schema;

import java.util.List;

import br.com.enginer.domain.ui.schema.field.Field;
import br.com.enginer.domain.ui.schema.paginator.Paginator;
import br.com.enginer.domain.ui.schema.row.Row;
import br.com.enginer.domain.ui.schema.tab.Tab;
import br.com.enginer.domain.ui.schema.validate.Validate;

/**
 * 
 */
public class Form {

	private String title;
	private Tab tab;
	private Row row;
	private Validate validate;
	private Paginator paginator;
	private List<Field> fields;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Tab getTab() {
		return tab;
	}

	public void setTab(Tab tab) {
		this.tab = tab;
	}

	public Row getRow() {
		return row;
	}

	public void setRow(Row row) {
		this.row = row;
	}

	public Validate getValidate() {
		return validate;
	}

	public void setValidate(Validate validate) {
		this.validate = validate;
	}

	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

}
