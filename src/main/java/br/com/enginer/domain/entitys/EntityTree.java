package br.com.enginer.domain.entitys;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.ui.annotation.field.UIDate;
import br.com.enginer.domain.ui.annotation.field.UIFilter;
import br.com.enginer.domain.ui.annotation.field.UISelect;
import br.com.enginer.domain.ui.annotation.field.UIText;
import br.com.enginer.domain.ui.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.annotation.field.behavior.autocomplete.UIAutoComplete;
import br.com.enginer.domain.ui.annotation.instance.UITitle;
import br.com.enginer.domain.ui.schema.field.behavior.Option;
import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

/**
 * 
 */
@UITitle("Entity Tree -> Stream")
public class EntityTree implements Domain<String> {

	private Id<String> id;
	
	@UIPosition(x = 1, y = 1)
	@UIText(label = "Animal Name", min = 4, max = 50)
	@UIAutoComplete(domain = "entityOne", attribute = "name")
	private String animal;
	
	@UIPosition(x = 2, y = 1)
	@UIFilter(label = "Entity Status", field = "name", select = false)
	private EntityStatus entityStatus;	
	
	@UIPosition(x = 1, y = 2)
	@UISelect(label = "Inidicador", provider = EntityTree.class, method = "options")
	private Integer indicator;
	
	@UIPosition(x = 2, y = 2)
	private Double amount;
	
	@UIPosition(x = 4, y = 2)
	@UIDate(label = "Date local", format = Constants.DATE_FORMAT, showtime = false)
	private LocalDate localDate;
	
	@UIPosition(x = 3, y = 2)
	@UIDate(label = "Date local time", format = Constants.DATE_TIME_FORMAT, showtime = true)
	private LocalDateTime localDateTime;
	
	private EntityFour entityFour;

	@Override
	public Id<String> getId() {
		return id;
	}
	
	@Override
	public void setId(Id<String> id) {
		this.id = id;
	}
	
	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public Integer getIndicator() {
		return indicator;
	}

	public void setIndicator(Integer indicator) {
		this.indicator = indicator;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public EntityFour getEntityFour() {
		return entityFour;
	}

	public void setEntityFour(EntityFour entityFour) {
		this.entityFour = entityFour;
	}

	public EntityStatus getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
	}
	
	public List<Option> options() {
		List<Option> options = new ArrayList<>();
		options.add(new Option("Indicador 11", 11));
		options.add(new Option("Indicador 22", 22));
		options.add(new Option("Indicador 33", 33));
		options.add(new Option("Indicador 44", 44));
		return options;
	}
}
