package br.com.enginer.domain.data.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.enginer.domain.example.dto.entity.EntityStatus;
import br.com.enginer.domain.ui.usercase.annotation.field.UICheckbox;
import br.com.enginer.domain.ui.usercase.annotation.field.UIDate;
import br.com.enginer.domain.ui.usercase.annotation.field.UIEmail;
import br.com.enginer.domain.ui.usercase.annotation.field.UIFilter;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UINumber;
import br.com.enginer.domain.ui.usercase.annotation.field.UIRadio;
import br.com.enginer.domain.ui.usercase.annotation.field.UISelect;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIValidation;
import br.com.enginer.domain.ui.usercase.helper.ComboHelper;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.Option;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

public class DataC extends DomainAbstract<DataC, Long> {

	@UIId
	private Long id;

	@UIPosition(x = 1, y = 1)
	@UIText(label = "Product Name")
	@UIValidation(required = true)
	private String pagee;

	@UIPosition(x = 1, y = 1)
	@UIEmail(label = "E-mail")
	@UIValidation(required = true)
	private String email;

	@UIPosition(x = 1, y = 3)
	@UIValidation(required = true)
	@UIFilter(label = "Entity Status", field = "name", select = true)
	private EntityStatus entityStatus;

	@UIPosition(x = 1, y = 4)
	@UIDate(label = "Date Insert")
	@UIValidation(required = true)
	private LocalDate dateInsert;

	@UIPosition(x = 2, y = 4)
	@UINumber(label = "Number Access", min = 3, max = 20)
	@UIValidation(required = true)
	private Integer numberAccess;

	@UIPosition(x = 3, y = 4)
	@UIDate(label = "Date Update")
	@UIValidation(required = true)
	private LocalDate dateUpdate;

	@UIPosition(x = 1, y = 5)
	@UISelect(label = "Mobiles", multi = true, provider = ComboHelper.class, method = "mobiles")
	@UIValidation(required = true)
	private List<Option> mobiles;

	@UIPosition(x = 2, y = 5)
	@UISelect(label = "Cloud Utilization", provider = ComboHelper.class, method = "clouds")
	@UIValidation(required = true)
	private String cloud;

	@UIPosition(x = 3, y = 5)
	@UISelect(label = "System Operational", provider = ComboHelper.class, method = "osDesktops")
	@UIValidation(required = true)
	private String systemOperational;

	@UIPosition(x = 4, y = 5)
	@UISelect(label = "Whats OS Mobile?", provider = ComboHelper.class, method = "osMobiles")
	@UIValidation(required = true)
	private String whatsStatement;

	@UIPosition(x = 1, y = 6)
	@UICheckbox(label = "Car - The most common way of upload control. Use any custom button and style you wish?")
	private Boolean car;

	@UIPosition(x = 2, y = 6)
	@UICheckbox(label = "Bus - The most common way of upload control. Use any custom button and style you wish?")
	private Boolean bus;
	
	@UIPosition(x = 3, y = 6)
	@UIRadio(label = "Have SO desktop?", provider = ComboHelper.class, method = "confirm")
	private Double variavel;

	private DataD dataD;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getPagee() {
		return pagee;
	}

	public void setPagee(String pagee) {
		this.pagee = pagee;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EntityStatus getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(EntityStatus entityStatus) {
		this.entityStatus = entityStatus;
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

	public List<Option> getMobiles() {
		return mobiles;
	}

	public void setMobiles(List<Option> mobiles) {
		this.mobiles = mobiles;
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
