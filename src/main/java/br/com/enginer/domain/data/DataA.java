package br.com.enginer.domain.data;

import java.time.LocalDateTime;

import br.com.enginer.domain.entitys.EntityOne;
import br.com.enginer.domain.ui.annotation.field.UIDate;
import br.com.enginer.domain.ui.annotation.field.UIDecimal;
import br.com.enginer.domain.ui.annotation.field.UIEmail;
import br.com.enginer.domain.ui.annotation.field.UIFilter;
import br.com.enginer.domain.ui.annotation.field.UIId;
import br.com.enginer.domain.ui.annotation.field.UINumber;
import br.com.enginer.domain.ui.annotation.field.UIPassword;
import br.com.enginer.domain.ui.annotation.field.UIRadio;
import br.com.enginer.domain.ui.annotation.field.UISelect;
import br.com.enginer.domain.ui.annotation.field.UIText;
import br.com.enginer.domain.ui.annotation.field.UITime;
import br.com.enginer.domain.ui.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.annotation.field.behavior.autocomplete.UIAutoComplete;
import br.com.enginer.domain.ui.annotation.field.behavior.autocomplete.UIAutoCompleteSuggestion;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UIAsync;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UIPattern;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UISync;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UIValidation;
import br.com.enginer.domain.ui.enums.TypeDateFormat;
import br.com.enginer.domain.ui.helper.ComboHelper;
import br.com.enginer.domain.ui.schema.instance.DomainAbstract;

public class DataA extends DomainAbstract<DataA, Long> {

	@UIId
	private Long id;

	@UIPosition(x = 1, y = 1)
	@UIText(label = "First Name")
	@UIAutoComplete(domain = "entityOne", attribute = "name")
	@UIValidation(required = true, pattern = @UIPattern(pattern = "^[^wW]*$", patternError = "*** PATTERN ***, nao pode adiciona a letra 'W'"), async = @UIAsync(method = "metodoJavaDominioEntityOne", asyncError = "Validação direto no field 'ASYNC'"), sync = @UISync(syncFunc = {
			"dogMel", "dogMagrela" }, syncError = {
					"Validação direto no field 'SYNC' - O campo não pode conter apenas números.",
					"Validação direto no field 'SYNC' - O campo está randomico, acabou caindo no erro." }))
	private String firstName;

	@UIPosition(x = 2, y = 1)
	@UIText(label = "Last Name")
	@UIAutoCompleteSuggestion(suggestions = { "johndoe", "admin", "user123" })
	@UIValidation(required = true, pattern = @UIPattern(pattern = "^[^wW]*$", patternError = "*** PATTERN ***, nao pode adiciona a letra 'W'"), async = @UIAsync(method = "metodoJavaDominioEntityOne", asyncError = "Validação direto no field 'ASYNC'"), sync = @UISync(syncFunc = {
			"dogMel", "dogMagrela" }, syncError = {
					"Validação direto no field 'SYNC' - O campo não pode conter apenas números.",
					"Validação direto no field 'SYNC' - O campo está randomico, acabou caindo no erro." }))
	private String lastName;

	@UIPosition(x = 1, y = 2)
	@UIText(label = "User Name", icon = "user")
	@UIAutoCompleteSuggestion(suggestions = { "johndoe", "admin", "user123" })
	@UIValidation(required = true, pattern = @UIPattern(pattern = "^[^wW]*$", patternError = "*** PATTERN ***, nao pode adiciona a letra 'W'"))
	private String userName;

	@UIPosition(x = 2, y = 2)
	@UIEmail(label = "Login")
	@UIAutoComplete(domain = "entityOne", attribute = "name")
	private String login;

	@UIPosition(x = 1, y = 3)
	@UIPassword(label = "Password", icon = "shield_lock")
	@UIValidation(required = true)
	private String password;

	@UIPosition(x = 2, y = 3)
	@UIPassword(label = "Confirm Password", icon = "shield_lock")
	@UIValidation(required = true)
	private String confirmPassword;

	@UIPosition(x = 1, y = 4)
	@UINumber(label = "Count in Animal", icon = "animal")
	@UIValidation(required = true)
	private Integer countAnimal;

	@UIPosition(x = 2, y = 4)
	@UITime(label = "Time 1")
	private LocalDateTime timeOne;

	@UIPosition(x = 3, y = 4)
	@UITime(label = "Time 2")
	@UIValidation(required = true)
	private LocalDateTime timeTwo;

	@UIPosition(x = 4, y = 4)
	@UIDate(label = "Date Time Start", format = TypeDateFormat.DATE_TIME_FORMAT, showtime = true)
	@UIValidation(required = true)
	private LocalDateTime dateTimeStart;

	@UIPosition(x = 1, y = 5)
	@UIText(label = "Phone", mask = "(00) 0000-0000")
	@UIValidation(required = true)
	private String phone;

	@UIPosition(x = 2, y = 5)
	@UINumber(label = "Fibonacy")
	@UIValidation(required = true)
	private Integer fibonacy;

	@UIPosition(x = 3, y = 5)
	@UIText(label = "CNPJ", mask = "000.000.000/0000-00")
	@UIValidation(required = true)
	private String cnpj;

	@UIPosition(x = 4, y = 5)
	@UIEmail(label = "Spec E-mail")
	private String specemail;

	@UIPosition(x = 1, y = 6)
	@UIDecimal(label = "Money", placeholder = "Ex. 1,00", icon = "keyboard")
	@UIValidation(required = true)
	private Double money;

	@UIPosition(x = 2, y = 6)
	@UIDecimal(label = "Cost", placeholder = "Ex. 1,00", icon = "keyboard")
	@UIValidation(required = true)
	private Double cost;

	@UIPosition(x = 1, y = 7)
	@UISelect(label = "Drinks", multi = false, provider = ComboHelper.class, method = "drinks")
	@UIValidation(required = true)
	private String drink;

	@UIPosition(x = 2, y = 7)
	@UIFilter(label = "Entity One", field = "name")
	private EntityOne entityOne;
	
	@UIPosition(x = 1, y = 8)
	@UISelect(label = "Color", multi = false, provider = ComboHelper.class, method = "colors")
	@UIValidation(required = true)
	private String color;

	@UIPosition(x = 3, y = 7)
	@UIRadio(label = "This statement is correct?", provider = ComboHelper.class, method = "question")
	@UIValidation(required = true)
	private String statement;

	private DataB dataB;
	
	public DataA() {
		this.setDomain(this);
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
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

	public Integer getFibonacy() {
		return fibonacy;
	}

	public void setFibonacy(Integer fibonacy) {
		this.fibonacy = fibonacy;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSpecemail() {
		return specemail;
	}

	public void setSpecemail(String specemail) {
		this.specemail = specemail;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public DataB getDataB() {
		return dataB;
	}

	public void setDataB(DataB dataB) {
		this.dataB = dataB;
	}

	public EntityOne getEntityOne() {
		return entityOne;
	}

	public void setEntityOne(EntityOne entityOne) {
		this.entityOne = entityOne;
	}
	
	
}
