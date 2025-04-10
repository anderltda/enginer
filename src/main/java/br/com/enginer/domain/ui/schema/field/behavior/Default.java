package br.com.enginer.domain.ui.schema.field.behavior;

import java.util.List;

import br.com.enginer.domain.ui.schema.field.type.Area;
import br.com.enginer.domain.ui.schema.field.type.Checkbox;
import br.com.enginer.domain.ui.schema.field.type.Date;
import br.com.enginer.domain.ui.schema.field.type.Decimal;
import br.com.enginer.domain.ui.schema.field.type.Email;
import br.com.enginer.domain.ui.schema.field.type.File;
import br.com.enginer.domain.ui.schema.field.type.Filter;
import br.com.enginer.domain.ui.schema.field.type.Hidden;
import br.com.enginer.domain.ui.schema.field.type.Join;
import br.com.enginer.domain.ui.schema.field.type.Number;
import br.com.enginer.domain.ui.schema.field.type.Password;
import br.com.enginer.domain.ui.schema.field.type.Radio;
import br.com.enginer.domain.ui.schema.field.type.Select;
import br.com.enginer.domain.ui.schema.field.type.Tag;
import br.com.enginer.domain.ui.schema.field.type.Text;
import br.com.enginer.domain.ui.schema.field.type.Time;
import br.com.enginer.domain.ui.schema.instance.Button;
import br.com.enginer.domain.utils.ReflectionUtils;
import br.com.enginer.domain.utils.StringsUtils;

/**
 * 
 */
public class Default {

	private String label;
	private String field;
	private Object value;
	private Position position;

	public Default(Integer xposition, Integer yposition, String name, Object object) {
		this.label = StringsUtils.normalizeLabelToLowercaseCamelization(name);
		this.field = StringsUtils.normalizeToCamelCaseFromPascalCase(name);
		this.value = ReflectionUtils.get(StringsUtils.getMethod(name), object);
		this.position = new Position(xposition, yposition);
	}

	/**
	 * @param value
	 * @return
	 */
	public Hidden getHidden() {
		Hidden hidden = new Hidden();
		hidden.setField(field);
		hidden.setValue(value);
		hidden.setPosition(new Position(0, 0));
		return hidden;
	}

	public Text getText() {
		Text text = new Text();
		text.setLabel(label);
		text.setField(field);
		text.setValue(value);
		text.setMin(1);
		text.setMax(20);
		text.setPosition(position);
		return text;
	}

	public Email getEmail() {
		Email email = new Email();
		email.setLabel(label);
		email.setField(field);
		email.setValue(value);
		email.setMin(1);
		email.setMax(50);
		email.setPosition(position);
		return email;
	}

	public Number getNumber() {
		Number number = new Number();
		number.setLabel(label);
		number.setField(field);
		number.setValue(value);
		number.setMin(1);
		number.setMax(50);
		number.setPosition(position);
		return number;
	}

	public Decimal getDecimal() {
		Decimal decimal = new Decimal();
		decimal.setLabel(label);
		decimal.setField(field);
		decimal.setValue(value);
		decimal.setPosition(position);
		return decimal;
	}

	public Password getPassword() {
		Password password = new Password();
		password.setLabel(label);
		password.setField(field);
		password.setMin(1);
		password.setMax(10);
		password.setPosition(position);
		return password;
	}

	public Date getDate(boolean showTime) {
		Date date = new Date();
		date.setLabel(label);
		date.setField(field);
		date.setValue(value);
		date.setShowtime(showTime);
		date.setFormat(showTime ? "DD/MM/YYYY HH:mm:ss" : "DD/MM/YYYY");
		date.setPosition(position);
		return date;
	}

	public Time getTime() {
		Time time = new Time();
		time.setLabel(label);
		time.setField(field);
		time.setValue(value);
		time.setPosition(position);
		return time;
	}

	public Radio getRadio(List<Object> options) {
		Radio radio = new Radio();
		radio.setLabel(label);
		radio.setField(field);
		radio.setValue(value);
		radio.setOptions(options);
		radio.setPosition(position);
		return radio;
	}

	public Checkbox getCheckbox() {
		Checkbox checkbox = new Checkbox();
		checkbox.setLabel(label);
		checkbox.setField(field);
		checkbox.setValue(value);
		checkbox.setPosition(position);
		return checkbox;
	}

	public Select getSelect(List<Object> options) {
		Select select = new Select();
		select.setLabel(label);
		select.setField(field);
		select.setValue(value);
		select.setPosition(position);
		select.setOptions(options);
		return select;
	}

	public Tag getTag() {
		Tag tag = new Tag();
		tag.setLabel(label);
		tag.setField(field);
		tag.setValue(value);
		tag.setPosition(position);
		return tag;
	}

	public Area getTextarea() {
		Area textarea = new Area();
		textarea.setLabel(label);
		textarea.setField(field);
		textarea.setValue(value);
		textarea.setEditor(false);
		textarea.setPosition(position);
		return textarea;
	}

	public File getFile() {
		File file = new File();
		file.setLabel(label);
		file.setField(field);
		file.setValue(value);
		file.setPosition(position);
		return file;
	}

	public Filter getFilter(String domain) {
		Filter filter = new Filter();
		filter.setLabel(label);
		filter.setValue(value);
		filter.setDomain(StringsUtils.firstLower(domain));
		filter.setPosition(position);
		return filter;
	}

	public Join getJoin(String domain) {
		Join join = new Join();
		join.setLabel(label);
		join.setDomain(StringsUtils.firstLower(domain));
		join.setLayoutTarget("form");
		return join;
	}

	public Button getButton() {
		Button button = new Button();
		return button;
	}

	public Blank getBlank() {
		Blank blank = new Blank();
		return blank;
	}

}
