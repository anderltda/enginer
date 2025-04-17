package br.com.enginer.domain.entitys.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.enginer.domain.ui.usercase.annotation.field.UIDate;
import br.com.enginer.domain.ui.usercase.annotation.field.UIFilter;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UISelect;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIValidation;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.enums.TypeDateFormat;
import br.com.enginer.domain.ui.usercase.helper.ComboHelper;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

/**
 * 
 */
@UITitle("Entity Two -> Stream")
public class EntityTwo extends DomainAbstract<EntityTwo, String> {

	@UIId
	private String id;

	@UISelect(label = "Colors", multi = true, provider = ComboHelper.class, method = "colors")
	private List<String> color;

	@UIDate(label = "Date Inclusion", showtime = false, format = TypeDateFormat.DATE_FORMAT)
	private LocalDate inclusionDate;

	private Integer hex;
	
	private Double cost;

	@UIValidation(required = true)
	@UIFilter(label = "Entity Status", field = "name", select = true)
	private EntityStatus entityStatus;

	private EntityTree entityTree;
	
	public EntityTwo() {
		this.setDomain(this);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public List<String> getColor() {
		return color;
	}

	public void setColor(List<String> color) {
		this.color = color;
	}

	public EntityStatus getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
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
