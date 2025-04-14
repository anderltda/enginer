package br.com.enginer.domain.data;

import java.math.BigInteger;

import br.com.enginer.domain.ui.annotation.field.UICheckbox;
import br.com.enginer.domain.ui.annotation.field.UIEmail;
import br.com.enginer.domain.ui.annotation.field.UIId;
import br.com.enginer.domain.ui.annotation.field.UINumber;
import br.com.enginer.domain.ui.annotation.field.UISelect;
import br.com.enginer.domain.ui.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UIValidation;
import br.com.enginer.domain.ui.helper.ComboHelper;
import br.com.enginer.domain.ui.schema.instance.DomainAbstract;

public class DataD extends DomainAbstract<DataD, Long> {

	@UIId
	private Long id;

	@UIPosition(x = 1, y = 1)
	@UINumber(label = "Code Protocoll")
	@UIValidation(required = true)
	private String codeProtocoll;

	@UIPosition(x = 2, y = 1)
	@UISelect(label = "Number Protocoll", provider = ComboHelper.class, method = "numbers")
	@UIValidation(required = true)
	private Long numberProtocoll;

	@UIPosition(x = 3, y = 1)
	@UINumber(label = "Number Ascii")
	@UIValidation(required = true)
	private Short numberAscii;

	@UIPosition(x = 4, y = 1)
	@UISelect(label = "Number Agent", provider = ComboHelper.class, method = "numbers")
	@UIValidation(required = true)
	private Integer numberAgent;

	@UIPosition(x = 1, y = 2)
	@UINumber(label = "numberChip")
	@UIValidation(required = true)
	private BigInteger numberChip;

	@UIPosition(x = 3, y = 2)
	@UINumber(label = "leadAccess")
	@UIValidation(required = true)
	private BigInteger leadAccess;

	@UIPosition(x = 1, y = 3)
	@UIValidation(required = true)
	private String possibly;

	@UIPosition(x = 2, y = 3)
	@UIEmail(label = "Owner E-mail")
	@UIValidation(required = true)
	private String emailOwner;

	@UIPosition(x = 1, y = 4)
	@UICheckbox(label = "Privacy Policy - By clicking the 'Get Started!' button, you are creating a Pages account.")
	private Boolean privacy = true;

	@UIPosition(x = 2, y = 4)
	@UICheckbox(label = "Approved - By clicking the 'Get Started!' button, you are creating a Pages account.")
	private Boolean approved = true;

	@UIPosition(x = 1, y = 5)
	@UISelect(label = "Choose console?", provider = ComboHelper.class, method = "consoles")
	@UIValidation(required = true)
	private String console;

	@UIPosition(x = 2, y = 5)
	@UIValidation(required = true)
	private String animal;

	@UIPosition(x = 1, y = 6)
	@UICheckbox(label = "Success - By clicking the 'Get Started!' button, you are creating a Pages account.")
	private Boolean success;

	@UIPosition(x = 2, y = 6)
	@UICheckbox(label = "Policy - By clicking the 'Get Started!' button, you are creating a Pages account.")
	private Boolean policy;

	private DataE dataE;
	
	public DataD() {
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

	public String getCodeProtocoll() {
		return codeProtocoll;
	}

	public void setCodeProtocoll(String codeProtocoll) {
		this.codeProtocoll = codeProtocoll;
	}

	public Long getNumberProtocoll() {
		return numberProtocoll;
	}

	public void setNumberProtocoll(Long numberProtocoll) {
		this.numberProtocoll = numberProtocoll;
	}

	public Short getNumberAscii() {
		return numberAscii;
	}

	public void setNumberAscii(Short numberAscii) {
		this.numberAscii = numberAscii;
	}

	public Integer getNumberAgent() {
		return numberAgent;
	}

	public void setNumberAgent(Integer numberAgent) {
		this.numberAgent = numberAgent;
	}

	public BigInteger getNumberChip() {
		return numberChip;
	}

	public void setNumberChip(BigInteger numberChip) {
		this.numberChip = numberChip;
	}

	public BigInteger getLeadAccess() {
		return leadAccess;
	}

	public void setLeadAccess(BigInteger leadAccess) {
		this.leadAccess = leadAccess;
	}

	public String getPossibly() {
		return possibly;
	}

	public void setPossibly(String possibly) {
		this.possibly = possibly;
	}

	public String getEmailOwner() {
		return emailOwner;
	}

	public void setEmailOwner(String emailOwner) {
		this.emailOwner = emailOwner;
	}

	public Boolean getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Boolean privacy) {
		this.privacy = privacy;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Boolean getPolicy() {
		return policy;
	}

	public void setPolicy(Boolean policy) {
		this.policy = policy;
	}

	public DataE getDataE() {
		return dataE;
	}

	public void setDataE(DataE dataE) {
		this.dataE = dataE;
	}

}
