package br.com.enginer.domain.data.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.enginer.domain.example.dto.entity.EntityOne;
import br.com.enginer.domain.example.dto.entity.EntityStatus;
import br.com.enginer.domain.ui.usercase.annotation.field.UICheckbox;
import br.com.enginer.domain.ui.usercase.annotation.field.UIDate;
import br.com.enginer.domain.ui.usercase.annotation.field.UIFilter;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.annotation.field.UITime;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIFieldValidation;
import br.com.enginer.domain.ui.usercase.enums.TypeDateFormat;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

public class DataB extends DomainAbstract<DataB, Long> {

	@UIId
	private Long id;

	@UIPosition(x = 1, y = 1)
	@UIFieldValidation(required = true)
	@UIFilter(label = "Entity Status", field = "name", readonly = true)
	private EntityStatus entityStatus;

	@UIPosition(x = 2, y = 1)
	@UICheckbox(label = "Accept - By clicking the 'Get Started!' button, you are creating a Pages account, and you agree to Pages's Terms of Use and Privacy Policy.", enableSwitch = false)
	private Boolean accept = true;

	@UIPosition(x = 1, y = 2)
	@UIText(label = "CPF", mask = "000.000.000-00")
	@UIFieldValidation(required = true)
	private String cpf;

	@UIPosition(x = 2, y = 2)
	@UIText(label = "Product Name")
	private String productName;

	@UIPosition(x = 3, y = 2)
	private String codeName;
	
	@UIPosition(x = 1, y = 3)
	@UIFilter(label = "Entity One", field = "name")
	private EntityOne entityOne;

	@UIPosition(x = 2, y = 3)
	@UIText(label = "Zip Code", mask = "00000-000")
	@UIFieldValidation(required = true)
	private String zipCode;

	@UIPosition(x = 1, y = 4)
	@UIText(label = "Address")
	@UIFieldValidation(required = true)
	private String address;

	@UIPosition(x = 1, y = 4)
	@UIText(label = "Number")
	@UIFieldValidation(required = true)
	private String number;

	@UIPosition(x = 2, y = 4)
	@UIText(label = "Neighborhood")
	@UIFieldValidation(required = true)
	private String neighborhood;

	@UIPosition(x = 1, y = 5)
	@UIDate(label = "Date Start")
	@UIFieldValidation(required = true)
	private LocalDate dateStart;

	@UIPosition(x = 2, y = 5)
	@UIDate(label = "Date End")
	@UIFieldValidation(required = true)
	private LocalDate dateEnd;

	@UIPosition(x = 3, y = 5)
	@UITime(label = "Time Start")
	@UIFieldValidation(required = true)
	private LocalDateTime timeStart;

	@UIPosition(x = 1, y = 6)
	@UITime(label = "Time End")
	@UIFieldValidation(required = true)
	private LocalDateTime timeEnd;

	@UIPosition(x = 2, y = 6)
	@UIDate(label = "Date Time Start", format = TypeDateFormat.DATE_TIME_FORMAT, showtime = true)
	@UIFieldValidation(required = true)
	private LocalDateTime dateTimeStart;

	@UIPosition(x = 3, y = 6)
	@UIDate(label = "Date Time End", format = TypeDateFormat.DATE_TIME_FORMAT, showtime = true)
	@UIFieldValidation(required = true)
	private LocalDateTime dateTimeEnd;

	@UIPosition(x = 1, y = 7)
	@UICheckbox(enableSwitch = true, label = "Other - By clicking the 'Get Started!' button, you are creating a Pages account, and you agree to Pages's Terms of Use and Privacy Policy.")
	private Boolean other;

	private DataC dataC;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public EntityStatus getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
	}

	public Boolean getAccept() {
		return accept;
	}

	public void setAccept(Boolean accept) {
		this.accept = accept;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public LocalDate getDateStart() {
		return dateStart;
	}

	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

	public LocalDate getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public LocalDateTime getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(LocalDateTime timeStart) {
		this.timeStart = timeStart;
	}

	public LocalDateTime getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(LocalDateTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	public LocalDateTime getDateTimeStart() {
		return dateTimeStart;
	}

	public void setDateTimeStart(LocalDateTime dateTimeStart) {
		this.dateTimeStart = dateTimeStart;
	}

	public LocalDateTime getDateTimeEnd() {
		return dateTimeEnd;
	}

	public void setDateTimeEnd(LocalDateTime dateTimeEnd) {
		this.dateTimeEnd = dateTimeEnd;
	}

	public Boolean getOther() {
		return other;
	}

	public void setOther(Boolean other) {
		this.other = other;
	}

	public DataC getDataC() {
		return dataC;
	}

	public void setDataC(DataC dataC) {
		this.dataC = dataC;
	}

	public EntityOne getEntityOne() {
		return entityOne;
	}

	public void setEntityOne(EntityOne entityOne) {
		this.entityOne = entityOne;
	}

}
