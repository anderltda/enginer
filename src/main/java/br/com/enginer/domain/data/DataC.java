package br.com.enginer.domain.data;

import java.time.LocalDate;

import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

public class DataC implements Domain<Long> {

	private Id<Long> id;

	private String page;

	private String email;

	private LocalDate dateInsert;

	private LocalDate dateUpdate;

	private Integer numberAccess;

	private String mobile;

	private String whatsStatement;

	private String systemOperational;

	private Double variavel;

	private Boolean car;

	private Boolean bus;

	private String cloud;

	private DataD dataD;

	@Override
	public Id<Long> getId() {
		return id;
	}

	@Override
	public void setId(Id<Long> id) {
		this.id = id;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(LocalDate dateInsert) {
		this.dateInsert = dateInsert;
	}

	public LocalDate getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(LocalDate dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public Integer getNumberAccess() {
		return numberAccess;
	}

	public void setNumberAccess(Integer numberAccess) {
		this.numberAccess = numberAccess;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getWhatsStatement() {
		return whatsStatement;
	}

	public void setWhatsStatement(String whatsStatement) {
		this.whatsStatement = whatsStatement;
	}

	public String getSystemOperational() {
		return systemOperational;
	}

	public void setSystemOperational(String systemOperational) {
		this.systemOperational = systemOperational;
	}

	public Double getVariavel() {
		return variavel;
	}

	public void setVariavel(Double variavel) {
		this.variavel = variavel;
	}

	public Boolean getCar() {
		return car;
	}

	public void setCar(Boolean car) {
		this.car = car;
	}

	public Boolean getBus() {
		return bus;
	}

	public void setBus(Boolean bus) {
		this.bus = bus;
	}

	public String getCloud() {
		return cloud;
	}

	public void setCloud(String cloud) {
		this.cloud = cloud;
	}

	public DataD getDataD() {
		return dataD;
	}

	public void setDataD(DataD dataD) {
		this.dataD = dataD;
	}

}
