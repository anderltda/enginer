package br.com.enginer.domain.data;

import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

public class DataF implements Domain<Long> {

	private Id<Long> id;

	private String computer;

	private String desktop;

	private Integer cell;

	private Short row;

	private String system;

	private String middleName;

	private String brand;

	private StringBuilder area;

	private String motocycle;

	private DataG dataG;

	@Override
	public Id<Long> getId() {
		return id;
	}

	@Override
	public void setId(Id<Long> id) {
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
