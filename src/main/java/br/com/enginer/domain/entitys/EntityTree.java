package br.com.enginer.domain.entitys;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.enginer.domain.ui.annotation.instance.UITitle;
import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

/**
 * 
 */
@UITitle("Criando a classe entity tree")
public class EntityTree implements Domain<String> {

	private Id<String> id;
	private String animal;
	private Integer indicator;
	private Double amount;
	private LocalDate localDate;
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

}
