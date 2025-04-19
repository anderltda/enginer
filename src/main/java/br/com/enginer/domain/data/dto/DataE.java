package br.com.enginer.domain.data.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.enginer.domain.ui.usercase.annotation.field.UICheckbox;
import br.com.enginer.domain.ui.usercase.annotation.field.UIDate;
import br.com.enginer.domain.ui.usercase.annotation.field.UIFile;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.autocomplete.UIAutoComplete;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIValidation;
import br.com.enginer.domain.ui.usercase.enums.TypeDateFormat;
import br.com.enginer.domain.ui.usercase.enums.TypeFileUpload;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.UploadFile;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

public class DataE extends DomainAbstract<DataE, Long> {

	@UIId
	private Long id;

	@UIPosition(x = 1, y = 1)
	@UIAutoComplete(domain = "entityTree", attribute = "animal")
	@UIValidation(required = true)
	private String fruit;

	@UIPosition(x = 2, y = 1)
	@UIAutoComplete(domain = "entityFour", attribute = "fruit")
	@UIValidation(required = true)
	private String read;

	@UIPosition(x = 3, y = 1)
	@UIAutoComplete(domain = "entityFour", attribute = "reference")
	@UIValidation(required = true)
	private String object;

	@UIPosition(x = 1, y = 2)
	private Integer countFruit;

	@UIPosition(x = 2, y = 2)
	private Integer countObject;

	@UIPosition(x = 3, y = 2)
	private Integer countName;

	@UIPosition(x = 4, y = 2)
	private Integer countFile;

	@UIPosition(x = 1, y = 3)
	private Double abstratValue;

	@UIPosition(x = 1, y = 3)
	private Double absolutValue;

	@UIPosition(x = 1, y = 3)
	@UIDate(label = "Date Time Memory", format = TypeDateFormat.DATE_TIME_FORMAT, showtime = true)
	private LocalDateTime dateTimeMemory;

	@UIPosition(x = 1, y = 3)
	@UIText(label = "RG", mask = "00.000.000-0")
	private String registroGeral;

	@UIPosition(x = 1, y = 4)
	@UICheckbox(label = "Is Sonysta?", enableSwitch = true)
	private Boolean sonysta;

	@UIPosition(x = 2, y = 4)
	@UICheckbox(label = "Ligado?", enableSwitch = true)
	private Boolean microsonista;

	@UIPosition(x = 3, y = 4)
	@UICheckbox(label = "Desligado?", enableSwitch = true)
	private String nintendista;

	@UIPosition(x = 4, y = 4)
	@UICheckbox(label = "Apple Boy?", enableSwitch = true)
	private String appleboy;

	@UIValidation(required = true)
	@UIPosition(x = 1, y = 5)
	@UIFile(label = "Drag n' drop uploader", mode = TypeFileUpload.DRAG_DROP)
	private List<UploadFile> dragdrops;

	private DataF dataF;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public Integer getCountFruit() {
		return countFruit;
	}

	public void setCountFruit(Integer countFruit) {
		this.countFruit = countFruit;
	}

	public Integer getCountObject() {
		return countObject;
	}

	public void setCountObject(Integer countObject) {
		this.countObject = countObject;
	}

	public Integer getCountName() {
		return countName;
	}

	public void setCountName(Integer countName) {
		this.countName = countName;
	}

	public Integer getCountFile() {
		return countFile;
	}

	public void setCountFile(Integer countFile) {
		this.countFile = countFile;
	}

	public Double getAbstratValue() {
		return abstratValue;
	}

	public void setAbstratValue(Double abstratValue) {
		this.abstratValue = abstratValue;
	}

	public Double getAbsolutValue() {
		return absolutValue;
	}

	public void setAbsolutValue(Double absolutValue) {
		this.absolutValue = absolutValue;
	}

	public LocalDateTime getDateTimeMemory() {
		return dateTimeMemory;
	}

	public void setDateTimeMemory(LocalDateTime dateTimeMemory) {
		this.dateTimeMemory = dateTimeMemory;
	}

	public String getRegistroGeral() {
		return registroGeral;
	}

	public void setRegistroGeral(String registroGeral) {
		this.registroGeral = registroGeral;
	}

	public Boolean getSonysta() {
		return sonysta;
	}

	public void setSonysta(Boolean sonysta) {
		this.sonysta = sonysta;
	}

	public Boolean getMicrosonista() {
		return microsonista;
	}

	public void setMicrosonista(Boolean microsonista) {
		this.microsonista = microsonista;
	}

	public String getNintendista() {
		return nintendista;
	}

	public void setNintendista(String nintendista) {
		this.nintendista = nintendista;
	}

	public DataF getDataF() {
		return dataF;
	}

	public void setDataF(DataF dataF) {
		this.dataF = dataF;
	}

	public String getAppleboy() {
		return appleboy;
	}

	public void setAppleboy(String appleboy) {
		this.appleboy = appleboy;
	}

	public List<UploadFile> getDragdrops() {
		return dragdrops;
	}

	public void setDragdrops(List<UploadFile> dragdrops) {
		this.dragdrops = dragdrops;
	}

}
