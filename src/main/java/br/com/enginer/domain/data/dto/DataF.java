package br.com.enginer.domain.data.dto;

import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UISelect;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.autocomplete.UIAutoComplete;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIFieldValidation;
import br.com.enginer.domain.ui.usercase.helper.ComboHelper;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

public class DataF extends DomainAbstract<DataF, Long> {

	@UIId
	private Long id;

	@UIPosition(x = 1, y = 1)
	@UIText(label = "Animal Name", min = 4, max = 50)
	@UIAutoComplete(domain = "entityOne", attribute = "name")
	@UIFieldValidation(required = true)
	private String computer;

	@UIPosition(x = 2, y = 1)
	@UISelect(label = "Whats desktop?", provider = ComboHelper.class, method = "osDesktops")
	@UIFieldValidation(required = true)
	private String desktop;

	@UIPosition(x = 3, y = 1)
	@UIFieldValidation(required = true)
	private Integer cell;

	@UIPosition(x = 4, y = 1)
	@UIFieldValidation(required = true)
	private Short row;

	@UIPosition(x = 1, y = 2)
	@UIFieldValidation(required = true)
	private String system;

	@UIPosition(x = 2, y = 2)
	@UIFieldValidation(required = true)
	private String middleName;

	@UIPosition(x = 3, y = 2)
	@UIFieldValidation(required = true)
	private String brand;

	@UIPosition(x = 3, y = 2)
	@UIFieldValidation(required = true)
	private String motocycle;

	@UIPosition(x = 1, y = 3)
	@UIFieldValidation(required = true)
	private StringBuilder area;

	private DataG dataG;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getComputer() {
		return computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}

	public String getDesktop() {
		return desktop;
	}

	public void setDesktop(String desktop) {
		this.desktop = desktop;
	}

	public Integer getCell() {
		return cell;
	}

	public void setCell(Integer cell) {
		this.cell = cell;
	}

	public Short getRow() {
		return row;
	}

	public void setRow(Short row) {
		this.row = row;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public StringBuilder getArea() {
		return area;
	}

	public void setArea(StringBuilder area) {
		this.area = area;
	}

	public String getMotocycle() {
		return motocycle;
	}

	public void setMotocycle(String motocycle) {
		this.motocycle = motocycle;
	}

	public DataG getDataG() {
		return dataG;
	}

	public void setDataG(DataG dataG) {
		this.dataG = dataG;
	}

}
