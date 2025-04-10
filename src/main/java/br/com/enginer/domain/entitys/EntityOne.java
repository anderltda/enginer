package br.com.enginer.domain.entitys;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.ui.annotation.field.UICheckbox;
import br.com.enginer.domain.ui.annotation.field.UIDate;
import br.com.enginer.domain.ui.annotation.field.UIDecimal;
import br.com.enginer.domain.ui.annotation.field.UIFilter;
import br.com.enginer.domain.ui.annotation.field.UIId;
import br.com.enginer.domain.ui.annotation.field.UIJoin;
import br.com.enginer.domain.ui.annotation.field.UINumber;
import br.com.enginer.domain.ui.annotation.field.UIText;
import br.com.enginer.domain.ui.annotation.field.behavior.UIAutoComplete;
import br.com.enginer.domain.ui.annotation.field.behavior.UIAutoCompleteSuggestion;
import br.com.enginer.domain.ui.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.annotation.field.behavior.UIValidation;
import br.com.enginer.domain.ui.annotation.instance.UITitle;
import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

/**
 * 
 */
@UITitle("Entity One -> Stream")
public class EntityOne implements Domain<Long> {

	@UIId
	private Id<Long> id;
	
	@UIText(label = "Name")
	@UIAutoCompleteSuggestion(suggestions = {"anderson", "pedro"})
	@UIAutoComplete(domain = "entityOne", attribute = "name")
	@UIPosition(x = 1, y = 1)
	@UIValidation(required = true, pattern = "^[^wW]*$", patternError = "*** PATTERN ***, nao pode adiciona a letra 'W'", method = "metodoJavaDominioEntityOne", asyncError = "Validação direto no field 'ASYNC'", syncFunc = {"dogMel", "dogMagrela"}, syncError = {"message1", "Validação direto no field 'SYNC' - O campo está randomico, acabou caindo no erro."})
	private String name;
	
	@UIPosition(x = 1, y = 2)
	@UIValidation(required = true)
	@UIFilter(label = "Entity Status", field = "name", readonly = true)
	private EntityStatus entityStatus;
	
	@UIPosition(x = 2, y = 2)
	@UICheckbox(label = "<b>Code</b>: I hereby certify that the information above is true and accurate", enableSwitch = false)
	private Boolean code = true;

	@UIPosition(x = 1, y = 3)
	@UINumber(label = "Age", min = 1, max = 60)
	private Integer age;
	
	@UIPosition(x = 2, y = 3)
	@UIDecimal(label = "Height", mask = "00.00")
	private Double height;
	
	@UIPosition(x = 3, y = 3)
	@UIDate(label = "Birth Date", format = Constants.DATE_FORMAT, showtime = false)
	private LocalDate birthDate;
	
	@UIPosition(x = 4, y = 3)
	@UIDate(label = "Prohibited Date Time", format = Constants.DATE_TIME_FORMAT, showtime = true)
	private LocalDateTime prohibitedDateTime;

	@UIValidation(required = true)
	@UIJoin(layoutTarget = "form")
	private EntityTwo entityTwo;

	@Override
	public Id<Long> getId() {
		return id;
	}
	
	@Override
	public void setId(Id<Long> id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDateTime getProhibitedDateTime() {
		return prohibitedDateTime;
	}

	public void setProhibitedDateTime(LocalDateTime prohibitedDateTime) {
		this.prohibitedDateTime = prohibitedDateTime;
	}

	public Boolean getCode() {
		return code;
	}

	public void setCode(Boolean code) {
		this.code = code;
	}

	public EntityStatus getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
	}

	public EntityTwo getEntityTwo() {
		return entityTwo;
	}

	public void setEntityTwo(EntityTwo entityTwo) {
		this.entityTwo = entityTwo;
	}

}
