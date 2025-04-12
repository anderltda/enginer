package br.com.enginer.domain.data;

import java.time.LocalDateTime;

import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

public class DataB implements Domain<Long> {

	private Id<Long> id;

	private String productName;

	private String codeName;

	private String address;

	private Integer fibonacy;

	private LocalDateTime dateStart;

	private LocalDateTime dateEnd;

	private LocalDateTime timeStart;

	private LocalDateTime timeEnd;

	private LocalDateTime dateTimeStart;

	private LocalDateTime dateTimeEnd;

	private Boolean other;

	private String specemail;

	private DataC dataC;

	@Override
	public Id<Long> getId() {
		return id;
	}

	@Override
	public void setId(Id<Long> id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getFibonacy() {
		return fibonacy;
	}

	public void setFibonacy(Integer fibonacy) {
		this.fibonacy = fibonacy;
	}

	public LocalDateTime getDateStart() {
		return dateStart;
	}

	public void setDateStart(LocalDateTime dateStart) {
		this.dateStart = dateStart;
	}

	public LocalDateTime getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDateTime dateEnd) {
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

	public String getSpecemail() {
		return specemail;
	}

	public void setSpecemail(String specemail) {
		this.specemail = specemail;
	}

	public DataC getDataC() {
		return dataC;
	}

	public void setDataC(DataC dataC) {
		this.dataC = dataC;
	}

}
