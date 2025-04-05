package br.com.enginer.domain.entitys;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.enginer.domain.Constants;
import br.com.enginer.domain.ui.annotation.field.UICheckbox;
import br.com.enginer.domain.ui.annotation.field.UIDate;
import br.com.enginer.domain.ui.annotation.field.UIDecimal;
import br.com.enginer.domain.ui.annotation.field.UIFilter;
import br.com.enginer.domain.ui.annotation.field.UIId;
import br.com.enginer.domain.ui.annotation.field.UINumber;
import br.com.enginer.domain.ui.annotation.field.UIText;
import br.com.enginer.domain.ui.annotation.field.UIValidation;
import br.com.enginer.domain.ui.annotation.instance.UITitle;

/**
 * 
 */
@UITitle("Teste que fiz para criar a anotation")
public class EntityOne {

	@UIId
	private Object id;
	
	@UIText(label = "Nome", order = 1, group = 1)
	@UIValidation(required = true, pattern = "^[^wW]*$", patternError = "*** PATTERN ***, nao pode adiciona a letra 'W'", method = "metodoJavaDominioEntityOne", asyncError = "Validação direto no field 'ASYNC'", syncFunc = {"dogMel", "dogMagrela"}, syncError = {"message1", "message2"})
	private String name;
	
	@UINumber(label = "Idade", order = 2, group = 1)
	@UIValidation(required = true)
	private Integer age;
	
	@UIValidation(required = true)
	@UIDecimal(label = "Altura", mask = "0.00", order = 1, group = 2)
	private Double height;
	
	@UIValidation(required = true)
	@UIDate(label = "Data de Aniversario", format = Constants.DATE_FORMAT, showtime = false, order = 1, group = 3)
	private LocalDate birthDate;
	
	@UIValidation(required = true)
	@UIDate(label = "Data e hora Proibido", format = Constants.DATE_TIME_FORMAT, showtime = true, order = 2, group = 3)
	private LocalDateTime prohibitedDateTime;
	
	@UICheckbox(label = "Ativo", enableSwitch = true, order = 2, group = 2)
	private Boolean code;
	
	@UIValidation(required = true)
	@UIFilter(label = "Status")
	private EntityStatus entityStatus;
	
	@UIValidation(required = true)
	@UIFilter(label = "Two")
	private EntityTwo entityTwo;
	
	private List<String> codigos;

	public Object getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<String> getCodigos() {
		return codigos;
	}

	public void setCodigos(List<String> codigos) {
		this.codigos = codigos;
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
