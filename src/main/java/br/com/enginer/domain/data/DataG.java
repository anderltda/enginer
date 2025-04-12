package br.com.enginer.domain.data;

import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

public class DataG implements Domain<Long> {

	private Id<Long> id;

	private String nickName;

	private String userLogin;

	private Integer age;

	private Integer numberCode;

	private DataH dataH;

	@Override
	public Id<Long> getId() {
		return id;
	}

	@Override
	public void setId(Id<Long> id) {
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
