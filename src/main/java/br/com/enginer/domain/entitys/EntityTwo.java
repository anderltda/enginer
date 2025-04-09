package br.com.enginer.domain.entitys;

import java.time.LocalDate;

import br.com.enginer.domain.ui.annotation.field.UIText;
import br.com.enginer.domain.ui.annotation.instance.UITitle;
import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

/**
 * 
 */
@UITitle("#### Entity -> Two #####")
public class EntityTwo implements Domain<String> {

	private Id<String> id;
	@UIText(label = "Color", disabled = false)
	private String color;
	private Integer hex;
	private Double cost;
	private LocalDate inclusionDate;
	private EntityTree entityTree;

	@Override
	public Id<String> getId() {
		return id;
	}
	
	@Override
	public void setId(Id<String> id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getHex() {
		return hex;
	}

	public void setHex(Integer hex) {
		this.hex = hex;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public LocalDate getInclusionDate() {
		return inclusionDate;
	}

	public void setInclusionDate(LocalDate inclusionDate) {
		this.inclusionDate = inclusionDate;
	}

	public EntityTree getEntityTree() {
		return entityTree;
	}

	public void setEntityTree(EntityTree entityTree) {
		this.entityTree = entityTree;
	}
}
