package br.com.enginer.domain.data.dto;

import java.time.LocalDate;

import br.com.enginer.domain.ui.usercase.annotation.instance.action.UISubmit;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

@UISubmit(label = "Salvar", icon = "save")
public class Data extends DomainAbstract<Data, Long> {

	private Long id;

	private Boolean check;

	private String medium;

	private String loss;

	private Integer control;

	private Integer option;

	private Integer command;

	private Integer shift;

	private Double capsValue;

	private Double tabValue;

	private LocalDate dateMemory;


	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getCheck() {
		return check;
	}

	public void setCheck(Boolean check) {
		this.check = check;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getLoss() {
		return loss;
	}

	public void setLoss(String loss) {
		this.loss = loss;
	}

	public Integer getControl() {
		return control;
	}

	public void setControl(Integer control) {
		this.control = control;
	}

	public Integer getOption() {
		return option;
	}

	public void setOption(Integer option) {
		this.option = option;
	}

	public Integer getCommand() {
		return command;
	}

	public void setCommand(Integer command) {
		this.command = command;
	}

	public Integer getShift() {
		return shift;
	}

	public void setShift(Integer shift) {
		this.shift = shift;
	}

	public Double getCapsValue() {
		return capsValue;
	}

	public void setCapsValue(Double capsValue) {
		this.capsValue = capsValue;
	}

	public Double getTabValue() {
		return tabValue;
	}

	public void setTabValue(Double tabValue) {
		this.tabValue = tabValue;
	}

	public LocalDate getDateMemory() {
		return dateMemory;
	}

	public void setDateMemory(LocalDate dateMemory) {
		this.dateMemory = dateMemory;
	}
}
