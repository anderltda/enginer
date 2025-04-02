package br.com.enginer.domain.ui.schema.field;

import java.util.ArrayList;
import java.util.List;

import br.com.enginer.domain.utils.ReflectionUtils;
import br.com.enginer.domain.utils.StringsUtils;

/**
 * 
 */
public class Default {

	private String label;
	private String field;
	private Object value;

	public Default(String name, Object object) {
		this.label = StringsUtils.normalizeLabelToLowercaseCamelization(object.getClass().getSimpleName().toString());
		this.field = StringsUtils.normalizeToCamelCaseFromPascalCase(object.getClass().getSimpleName().toString());
		this.value = ReflectionUtils.executeGetMethod(StringsUtils.getMethod(name), object);
	}

	/**
	 * @param value
	 * @return
	 */
	public Hidden getHidden() {
		Hidden hidden = new Hidden();
		hidden.setField(field);
		hidden.setValue(value);
		return hidden;
	}

	public Text getText() {
		Text text = new Text();
		text.setLabel(label);
		text.setField(field);
		text.setValue(value);
		text.setMin(1);
		text.setMax(20);
		text.setPlaceholder(text.getLabel());
		return text;
	}

	public Email getEmail() {
		Email email = new Email();
		email.setLabel(label);
		email.setField(field);
		email.setValue(value);
		email.setMin(1);
		email.setMax(50);
		email.setPlaceholder(email.getLabel());
		return email;
	}

	public Number getNumber() {
		Number number = new Number();
		number.setLabel(label);
		number.setField(field);
		number.setValue(value);
		number.setMin(1);
		number.setMax(50);
		number.setPlaceholder(number.getLabel());
		return number;
	}

	public Decimal getDecimal() {
		Decimal decimal = new Decimal();
		decimal.setLabel(label);
		decimal.setField(field);
		decimal.setValue(value);
		decimal.setPlaceholder(decimal.getLabel());
		return decimal;
	}

	public Password getPassword() {
		Password password = new Password();
		password.setLabel(label);
		password.setField(field);
		password.setMin(1);
		password.setMax(10);
		password.setPlaceholder(password.getLabel());
		return password;
	}

	public Date getDate(boolean showTime) {
		Date date = new Date();
		date.setLabel(label);
		date.setField(field);
		date.setValue(value);
		date.setShowtime(showTime);
		date.setFormat(showTime ? "DD/MM/YYYY HH:mm:ss" : "DD/MM/YYYY");
		date.setPlaceholder(date.getLabel());
		return date;
	}

	public Time getTime() {
		Time time = new Time();
		time.setLabel(label);
		time.setField(field);
		time.setValue(value);
		time.setPlaceholder(time.getLabel());
		return time;
	}

	public Radio getRadio(List<Object> objects) {
		List<Option> options = new ArrayList<>();
		Radio radio = new Radio();
		radio.setLabel(label);
		radio.setField(field);
		radio.setValue(value);
		radio.setOptions(options);
		objects.forEach(option -> {
			options.add(new Option(option.toString(), option.toString()));
		});
		return radio;
	}

	public Checkbox getCheckbox() {
		Checkbox checkbox = new Checkbox();
		checkbox.setLabel(label);
		checkbox.setField(field);
		checkbox.setValue(value);
		return checkbox;
	}

	public Switch getSwittch() {
		Switch swittch = new Switch();
		swittch.setLabel(label);
		swittch.setField(field);
		swittch.setValue(value);
		return swittch;
	}

	public Select getSelect(List<Object> objects) {
		List<Option> options = new ArrayList<>();
		Select select = new Select();
		select.setLabel(label);
		select.setField(field);
		select.setValue(value);
		select.setMulti(false);
		select.setOptions(options);
		objects.forEach(option -> {
			options.add(new Option(option.toString(), option.toString()));
		});

		return select;
	}

	public Tag getTag() {
		Tag tag = new Tag();
		tag.setLabel(label);
		tag.setField(field);
		tag.setValue(value);
		return tag;
	}

	public Area getTextarea() {
		Area textarea = new Area();
		textarea.setLabel(label);
		textarea.setField(field);
		textarea.setValue(value);
		textarea.setEditor(false);
		textarea.setPlaceholder(textarea.getLabel());
		return textarea;
	}

	public File getFile() {
		File file = new File();
		file.setLabel(label);
		file.setField(field);
		file.setValue(value);
		return file;
	}

	public Filter getFilter(String domain) {
		Filter filter = new Filter();
		filter.setLabel(label);
		filter.setField(field);
		filter.setValue(value);
		filter.setDomain(domain);
		filter.setPlaceholder(filter.getLabel());
		return filter;
	}

	public Join getJoin(String domain) {
		Join join = new Join();
		join.setLabel(label);
		join.setDomain(domain);
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
