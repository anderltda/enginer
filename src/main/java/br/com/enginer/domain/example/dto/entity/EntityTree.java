package br.com.enginer.domain.example.dto.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.enginer.domain.ui.usercase.annotation.field.UIDate;
import br.com.enginer.domain.ui.usercase.annotation.field.UIFilter;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UIJoin;
import br.com.enginer.domain.ui.usercase.annotation.field.UISelect;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.autocomplete.UIAutoComplete;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.enums.TypeDateFormat;
import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;
import br.com.enginer.domain.ui.usercase.helper.ComboHelper;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

/**
 * 
 */
@UITitle("Entity Tree -> Stream")
public class EntityTree extends DomainAbstract<EntityTree, String> {

	@UIId
	private String id;
	
	@UIPosition(x = 1, y = 1)
	@UIText(label = "Animal Name", min = 4, max = 50)
	@UIAutoComplete(domain = "entityOne", attribute = "name")
	private String animal;
	
	@UIPosition(x = 2, y = 1)
	@UIFilter(label = "Entity Status", field = "name", select = false)
	private EntityStatus entityStatus;	
	
	@UIPosition(x = 1, y = 2)
	@UISelect(label = "Inidicador", provider = ComboHelper.class, method = "indicadores")
	private Integer indicator;
	
	@UIPosition(x = 2, y = 2)
	private Double amount;
	
	@UIPosition(x = 4, y = 2)
	@UIDate(label = "Date local", format = TypeDateFormat.DATE_FORMAT, showtime = false)
	private LocalDate localDate;
	
	@UIPosition(x = 3, y = 2)
	@UIDate(label = "Date local time", format = TypeDateFormat.DATE_TIME_FORMAT, showtime = true)
	private LocalDateTime localDateTime;
	
	@UIJoin(layoutTarget = "form", template = {TypeTemplate.FORM})
	@UIFilter(label = "Entity Four", field = "fruit", template = { TypeTemplate.FILTER })
	private EntityFour entityFour;
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
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
}
