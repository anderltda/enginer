package br.com.enginer.domain.entitys;

import java.time.LocalDateTime;

import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

/**
 * 
 */
public class EntityFour implements Domain<String> {

	private Id<String> id;
	private String fruit;
	private Integer attribute;
	private LocalDateTime inclusionDateTime;
	private EntityFive entityFive;

	@Override
	public Id<String> getId() {
		return id;
	}
	
	@Override
	public void setId(Id<String> id) {
		this.id = id;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public Integer getAttribute() {
		return attribute;
	}

	public void setAttribute(Integer attribute) {
		this.attribute = attribute;
	}

	public LocalDateTime getInclusionDateTime() {
		return inclusionDateTime;
	}

	public void setInclusionDateTime(LocalDateTime inclusionDateTime) {
		this.inclusionDateTime = inclusionDateTime;
	}

	public EntityFive getEntityFive() {
		return entityFive;
	}

	public void setEntityFive(EntityFive entityFive) {
		this.entityFive = entityFive;
	}

}
