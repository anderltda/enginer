package br.com.enginer.domain.entitys;

import java.time.LocalDate;

import br.com.enginer.domain.ui.annotation.instance.UITitle;

/**
 * 
 */
@UITitle("#### Entity -> Two #####")
public class EntityTwo {

	private Object id;
	private String color;
	private Integer hex;
	private Double cost;
	private LocalDate inclusionDate;
	private EntityTree entityTree;

	public Object getId() {
		return id;
	}

	public void setId(String id) {
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
