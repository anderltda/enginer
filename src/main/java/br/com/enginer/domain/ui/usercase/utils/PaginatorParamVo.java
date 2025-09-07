package br.com.enginer.domain.ui.usercase.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;

public class PaginatorParamVo {

	private String simpleName;
	private Field fieldClass;
	private TypeTemplate typeTemplate;
	private List<String> visibles;
	private List<String> initials;
	private List<Map.Entry<String, Integer>> rowsMap;
	private Map<String, String> columnNames;

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}

	public Field getFieldClass() {
		return fieldClass;
	}

	public void setFieldClass(Field fieldClass) {
		this.fieldClass = fieldClass;
	}

	public TypeTemplate getTypeTemplate() {
		return typeTemplate;
	}

	public void setTypeTemplate(TypeTemplate typeTemplate) {
		this.typeTemplate = typeTemplate;
	}

	public List<String> getVisibles() {
		return visibles;
	}

	public void addVisibles(String visible) {
		if(this.visibles == null) {
			visibles = new ArrayList<String>();
		}
		this.visibles.add(visible);
	}

	public List<String> getInitials() {
		return initials;
	}

	public void addInitials(String initial) {
		if(this.initials == null) {
			initials = new ArrayList<String>();
		}
		this.initials.add(initial);
	}

	public List<Map.Entry<String, Integer>> getRowsMap() {
		return rowsMap;
	}

	public void setRowsMap(List<Map.Entry<String, Integer>> rowsMap) {
		this.rowsMap = rowsMap;
	}

	public Map<String, String> getColumnNames() {
		return columnNames;
	}

	public void addColumnNames(String name, String label) {
		if(this.columnNames == null) {
			this.columnNames = new HashMap<String, String>();
		}
		
		this.columnNames.put(name, label);
	}

}
