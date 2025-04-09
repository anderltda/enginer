package br.com.enginer.domain.entitys;

import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

/**
 * 
 */
public class EntityFive implements Domain<String> {

	private Id<String> id;
	private String reference;
	private Integer factor;

	@Override
	public Id<String> getId() {
		return id;
	}
	
	@Override
	public void setId(Id<String> id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Integer getFactor() {
		return factor;
	}

	public void setFactor(Integer factor) {
		this.factor = factor;
	}

}
