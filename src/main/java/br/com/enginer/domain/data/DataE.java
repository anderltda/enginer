package br.com.enginer.domain.data;

import java.time.LocalDateTime;

import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

public class DataE implements Domain<Long> {

	private Id<Long> id;

	private String fruit;

	private String read;

	private String object;

	private Integer countFruit;

	private Integer countObject;

	private Integer countName;

	private Integer countFile;

	private Double abstratValue;

	private Double absolutValue;

	private LocalDateTime dateTimeMemory;

	private String registroGeral;

	private Boolean sonysta;

	private Boolean microsonista;

	private String nintendista;

	private DataF dataF;

	@Override
	public Id<Long> getId() {
		return id;
	}

	@Override
	public void setId(Id<Long> id) {
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

}
