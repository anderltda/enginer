package br.com.enginer.domain.data;

import java.time.LocalDateTime;

import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

public class DataA implements Domain<Long> {

	private Id<Long> id;

	private String firstName;

	private String lastName;

	private String userName;

	private String login;

	private String password;

	private String confirmPassword;

	private Integer countAnimal;

	private LocalDateTime timeOne;

	private LocalDateTime timeTwo;

	private LocalDateTime dateTimeStart;

	private String phone;

	private String zipCode;

	private String cpf;

	private String cnpj;

	private Double money;

	private Double cost;

	private String drink;

	private String statement;

	private String color;

	private String accept;

	private DataB dataB;

	@Override
	public Id<Long> getId() {
		return id;
	}

	@Override
	public void setId(Id<Long> id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Integer getCountAnimal() {
		return countAnimal;
	}

	public void setCountAnimal(Integer countAnimal) {
		this.countAnimal = countAnimal;
	}

	public LocalDateTime getTimeOne() {
		return timeOne;
	}

	public void setTimeOne(LocalDateTime timeOne) {
		this.timeOne = timeOne;
	}

	public LocalDateTime getTimeTwo() {
		return timeTwo;
	}

	public void setTimeTwo(LocalDateTime timeTwo) {
		this.timeTwo = timeTwo;
	}

	public LocalDateTime getDateTimeStart() {
		return dateTimeStart;
	}

	public void setDateTimeStart(LocalDateTime dateTimeStart) {
		this.dateTimeStart = dateTimeStart;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public DataB getDataB() {
		return dataB;
	}

	public void setDataB(DataB dataB) {
		this.dataB = dataB;
	}

}
