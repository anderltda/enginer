package br.com.enginer.domain.data.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.enginer.domain.ui.usercase.annotation.field.UICheckbox;
import br.com.enginer.domain.ui.usercase.annotation.field.UIFile;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIValidation;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UISubmit;
import br.com.enginer.domain.ui.usercase.enums.TypeFileUpload;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.UploadFile;
import br.com.enginer.domain.ui.usercase.schema.instance.DomainAbstract;

@UISubmit(label = "Salvar", method = "salvandoDataH", icon = "save")
public class DataH extends DomainAbstract<DataH, Long> {

	@UIId
	private Long id;

	@UIPosition(x = 1, y = 1)
	@UIValidation(required = true)
	@UICheckbox(label = "<span>Check</span> - yourname.pages.com (this can be changed later)?")
	private Boolean check;

	@UIPosition(x = 2, y = 1)
	@UIValidation(required = true)
	private String medium;

	@UIPosition(x = 3, y = 1)
	@UIValidation(required = true)
	private String loss;

	@UIValidation(required = true)
	private Integer control;

	@UIValidation(required = true)
	private Integer option;

	@UIValidation(required = true)
	private Integer command;

	@UIValidation(required = true)
	private Integer shift;

	@UIValidation(required = true)
	private Double capsValue;

	@UIValidation(required = true)
	private Double tabValue;

	@UIValidation(required = true)
	private LocalDate dateMemory;

	@UIPosition(x = 1, y = 12)
	@UIFile(label = "Photo Wall <span class='semi-bold'>Picker</span>", title = "Gallery like file uploader for images that looks cool! Simply use <code>ListType='picture-card'</code>", mode = TypeFileUpload.WALL_PICKER)
	private List<UploadFile> wallPickers;

	@UIPosition(x = 2, y = 12)
	@UIFile(label = "Simple <span class='semi-bold'>List</span>", title = "The most common way of upload control. Use any custom button and style you wish", mode = TypeFileUpload.SIMPLE)
	private List<UploadFile> simples;

	@UIPosition(x = 1, y = 13)
	@UIFile(label = "Image <span class='semi-bold'>List</span>", title = "Have a horizontal list of image uploader as you need, you can limit the type and size of the files you wish by using <code>Limit = 2</code> and <code>FileType = 'image/png'</code>.", mode = TypeFileUpload.LIST)
	private List<UploadFile> lists;

	public DataH() {
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

	public List<UploadFile> getWallPickers() {
		return wallPickers;
	}

	public void setWallPickers(List<UploadFile> wallPickers) {
		this.wallPickers = wallPickers;
	}

	public List<UploadFile> getSimples() {
		return simples;
	}

	public void setSimples(List<UploadFile> simples) {
		this.simples = simples;
	}

	public List<UploadFile> getLists() {
		return lists;
	}

	public void setLists(List<UploadFile> lists) {
		this.lists = lists;
	}
}
