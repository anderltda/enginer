package br.com.enginer.domain.entitys;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 
 */
public class EntityOne {

	private Object id;
	private String name;
	private Integer age;
	private Double height;
	private LocalDate birthDate;
	private LocalDateTime prohibitedDateTime;
	private Boolean code;
	//private EntityStatus entityStatus;
	//private EntityTwo entityTwo;
	private List<String> codigos;

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
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

	//public EntityStatus getEntityStatus() {
	//	return entityStatus;
	//}

	//public void setEntityStatus(EntityStatus entityStatus) {
	//	this.entityStatus = entityStatus;
	//}

	//public EntityTwo getEntityTwo() {
	//	return entityTwo;
	//}

	//public void setEntityTwo(EntityTwo entityTwo) {
	//	this.entityTwo = entityTwo;
	//}

}
