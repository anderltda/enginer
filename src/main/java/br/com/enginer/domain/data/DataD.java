package br.com.enginer.domain.data;

import java.math.BigInteger;

import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

public class DataD implements Domain<Long> {

	private Id<Long> id;

	private String codeProtocoll;

	private Long numberProtocoll;

	private Short numberAscii;

	private Integer numberAgent;

	private BigInteger numberChip;

	private BigInteger leadAccess;

	private String possibly;

	private String emailOwner;

	private Boolean privacy;

	private Boolean approved;

	private Boolean success;

	private String console;

	private String animal;

	private DataE dataE;

	@Override
	public Id<Long> getId() {
		return id;
	}

	@Override
	public void setId(Id<Long> id) {
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

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
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

	public DataE getDataE() {
		return dataE;
	}

	public void setDataE(DataE dataE) {
		this.dataE = dataE;
	}

}
