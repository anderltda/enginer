package br.com.enginer.domain.data;

import java.time.LocalDate;
import java.util.List;

import br.com.enginer.domain.ui.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UIValidation;
import br.com.enginer.domain.ui.annotation.field.file.TypeFileUpload;
import br.com.enginer.domain.ui.annotation.field.file.UIFile;
import br.com.enginer.domain.ui.annotation.instance.action.UISubmit;
import br.com.enginer.domain.ui.schema.field.behavior.UploadFile;
import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

@UISubmit(label = "Salvar", method = "salvandoDataH", state = "btn-primary", icon = "save")
public class DataH implements Domain<Long> {

	private Id<Long> id;

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

	@UIPosition(x = 1, y = 12)
	@UIFile(label = "Photo Wall <span class='semi-bold'>Picker</span>", title = "Gallery like file uploader for images that looks cool! Simply use <code>ListType='picture-card'</code>", mode = TypeFileUpload.WALL_PICKER)
	private List<UploadFile> wallPickers;

	@UIPosition(x = 2, y = 12)
	@UIFile(label = "Simple <span class='semi-bold'>List</span>", title = "The most common way of upload control. Use any custom button and style you wish", mode = TypeFileUpload.SIMPLE)
	private List<UploadFile> simples;

	@UIPosition(x = 1, y = 13)
	@UIFile(label = "Image <span class='semi-bold'>List</span>", title = "Have a horizontal list of image uploader as you need, you can limit the type and size of the files you wish by using <code>Limit = 2</code> and <code>FileType = 'image/png'</code>.", mode = TypeFileUpload.LIST)
	private List<UploadFile> lists;

	@UIValidation(required = true)
	@UIPosition(x = 2, y = 13)
	@UIFile(label = "Drag n' drop uploader", mode = TypeFileUpload.DRAG_DROP)
	private List<UploadFile> dragdrops;

	@Override
	public Id<Long> getId() {
		return id;
	}

	@Override
	public void setId(Id<Long> id) {
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

	public List<UploadFile> getDragdrops() {
		return dragdrops;
	}

	public void setDragdrops(List<UploadFile> dragdrops) {
		this.dragdrops = dragdrops;
	}
}
