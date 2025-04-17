package br.com.enginer.domain.data.dto;

import br.com.enginer.domain.ui.usercase.annotation.field.UIEmail;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UITextArea;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIValidation;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

public class DataG extends DomainAbstract<DataG, Long> {

	@UIId
	private Long id;

	@UIPosition(x = 1, y = 1)
	private String nickName;

	@UIPosition(x = 2, y = 1)
	@UIEmail(label = "User loging")
	@UIValidation(required = true)
	private String userLogin;

	@UIPosition(x = 3, y = 1)
	@UIValidation(required = true)
	private Integer age;

	@UIPosition(x = 4, y = 1)
	@UIValidation(required = true)
	private Integer numberCode;
	
	@UIPosition(x = 1, y = 3)
	@UITextArea(label = "Area Edit", editor = true)
	@UIValidation(required = true)
	private String areaEdit;

	private DataH dataH;
	
	public DataG() {
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getNumberCode() {
		return numberCode;
	}

	public void setNumberCode(Integer numberCode) {
		this.numberCode = numberCode;
	}

	public DataH getDataH() {
		return dataH;
	}

	public void setDataH(DataH dataH) {
		this.dataH = dataH;
	}
}
