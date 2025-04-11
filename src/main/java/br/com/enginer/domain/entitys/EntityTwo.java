package br.com.enginer.domain.entitys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.ui.annotation.field.UIDate;
import br.com.enginer.domain.ui.annotation.field.UIFilter;
import br.com.enginer.domain.ui.annotation.field.UISelect;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UIValidation;
import br.com.enginer.domain.ui.annotation.instance.UITitle;
import br.com.enginer.domain.ui.schema.field.behavior.Option;
import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

/**
 * 
 */
@UITitle("Entity Two -> Stream")
public class EntityTwo implements Domain<String> {

	private Id<String> id;

	@UISelect(label = "Colors", multi = true, provider = EntityTwo.class, method = "options")
	private List<String> color;

	@UIDate(label = "Date Inclusion", showtime = false, format = Constants.DATE_FORMAT)
	private LocalDate inclusionDate;

	private Integer hex;
	
	private Double cost;

	@UIValidation(required = true)
	@UIFilter(label = "Entity Status", field = "name", select = false)
	private EntityStatus entityStatus;

	private EntityTree entityTree;

	@Override
	public Id<String> getId() {
		return id;
	}

	@Override
	public void setId(Id<String> id) {
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

	public List<Option> options() {
		List<Option> options = new ArrayList<>();
		options.add(new Option("Amarelo", "amarelo"));
		options.add(new Option("Verde", "verde"));
		options.add(new Option("Azul", "azul"));
		options.add(new Option("Roxo", "roxo"));
		options.add(new Option("Preto", "preto"));
		options.add(new Option("Laranja", "laranja"));
		options.add(new Option("Vermelho", "vermelho"));
		return options;
	}
}
