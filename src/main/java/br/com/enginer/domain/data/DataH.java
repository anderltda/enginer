package br.com.enginer.domain.data;

import java.io.File;
import java.time.LocalDate;

import br.com.enginer.domain.ui.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.annotation.field.behavior.validation.UIValidation;
import br.com.enginer.domain.ui.annotation.field.file.TypeFileUpload;
import br.com.enginer.domain.ui.annotation.field.file.UIFile;
import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.instance.Domain;

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

	@UIFile(label = "Photo Wall <span class='semi-bold'>Picker</span>", title = "Gallery like file uploader for images that looks cool! Simply use <code>ListType='picture-card'</code>", mode = TypeFileUpload.WALL_PICKER)
	private File photo;

	@UIFile(label = "Simple <span class='semi-bold'>List</span>", title = "The most common way of upload control. Use any custom button and style you wish", mode = TypeFileUpload.SIMPLE)
	private File registre;

	@UIFile(label = "Image <span class='semi-bold'>List</span>", title = "Have a horizontal list of image uploader as you need, you can limit the type and size of the files you wish by using <code>Limit = 2</code> and <code>FileType = 'image/png'</code>.", mode = TypeFileUpload.LIST)
	private File image;

	@UIPosition(x = 1, y = 12)
	@UIValidation(required = true)
	@UIFile(label = "Drag n' drop uploader", mode = TypeFileUpload.DRAG_DROP)
	private File dragdrop;

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

	public File getRegistre() {
		return registre;
	}

	public void setRegistre(File registre) {
		this.registre = registre;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public File getDragdrop() {
		return dragdrop;
	}

	public void setDragdrop(File dragdrop) {
		this.dragdrop = dragdrop;
	}

}
