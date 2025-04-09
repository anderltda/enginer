package br.com.enginer.domain.ui.template.form;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.enginer.domain.ui.annotation.field.UICheckbox;
import br.com.enginer.domain.ui.annotation.field.UIDate;
import br.com.enginer.domain.ui.annotation.field.UIDecimal;
import br.com.enginer.domain.ui.annotation.field.UIEmail;
import br.com.enginer.domain.ui.annotation.field.UIFile;
import br.com.enginer.domain.ui.annotation.field.UIFilter;
import br.com.enginer.domain.ui.annotation.field.UIId;
import br.com.enginer.domain.ui.annotation.field.UIJoin;
import br.com.enginer.domain.ui.annotation.field.UINumber;
import br.com.enginer.domain.ui.annotation.field.UIPassword;
import br.com.enginer.domain.ui.annotation.field.UIRadio;
import br.com.enginer.domain.ui.annotation.field.UISelect;
import br.com.enginer.domain.ui.annotation.field.UIText;
import br.com.enginer.domain.ui.annotation.field.UITextArea;
import br.com.enginer.domain.ui.annotation.field.UITime;
import br.com.enginer.domain.ui.annotation.field.behavior.UIAutoComplete;
import br.com.enginer.domain.ui.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.annotation.field.behavior.UITag;
import br.com.enginer.domain.ui.annotation.field.behavior.UIValidation;
import br.com.enginer.domain.ui.annotation.instance.UITitle;
import br.com.enginer.domain.ui.schema.Form;
import br.com.enginer.domain.ui.schema.field.behavior.Autocomplete;
import br.com.enginer.domain.ui.schema.field.behavior.Base;
import br.com.enginer.domain.ui.schema.field.behavior.Default;
import br.com.enginer.domain.ui.schema.field.behavior.Pattern;
import br.com.enginer.domain.ui.schema.field.behavior.Position;
import br.com.enginer.domain.ui.schema.field.behavior.validation.Async;
import br.com.enginer.domain.ui.schema.field.behavior.validation.Sync;
import br.com.enginer.domain.ui.schema.field.behavior.validation.Validation;
import br.com.enginer.domain.ui.schema.field.type.Area;
import br.com.enginer.domain.ui.schema.field.type.Checkbox;
import br.com.enginer.domain.ui.schema.field.type.Date;
import br.com.enginer.domain.ui.schema.field.type.Decimal;
import br.com.enginer.domain.ui.schema.field.type.Email;
import br.com.enginer.domain.ui.schema.field.type.File;
import br.com.enginer.domain.ui.schema.field.type.Filter;
import br.com.enginer.domain.ui.schema.field.type.Hidden;
import br.com.enginer.domain.ui.schema.field.type.Id;
import br.com.enginer.domain.ui.schema.field.type.Join;
import br.com.enginer.domain.ui.schema.field.type.Number;
import br.com.enginer.domain.ui.schema.field.type.Password;
import br.com.enginer.domain.ui.schema.field.type.Radio;
import br.com.enginer.domain.ui.schema.field.type.Select;
import br.com.enginer.domain.ui.schema.field.type.Tag;
import br.com.enginer.domain.ui.schema.field.type.Text;
import br.com.enginer.domain.ui.schema.field.type.Time;
import br.com.enginer.domain.utils.ReflectionUtils;
import br.com.enginer.domain.utils.StringsUtils;

public class FormTemplate {

	private static final Map<Class<? extends Annotation>, Class<? extends Annotation>> annotationMap = new HashMap<>();

	static {
		annotationMap.put(UIId.class, UIId.class);
		annotationMap.put(UIText.class, UIText.class);
		annotationMap.put(UIEmail.class, UIEmail.class);
		annotationMap.put(UIPassword.class, UIPassword.class);
		annotationMap.put(UINumber.class, UINumber.class);
		annotationMap.put(UIDecimal.class, UIDecimal.class);
		annotationMap.put(UICheckbox.class, UICheckbox.class);
		annotationMap.put(UIDate.class, UIDate.class);
		annotationMap.put(UITime.class, UITime.class);
		annotationMap.put(UIRadio.class, UIRadio.class);
		annotationMap.put(UISelect.class, UISelect.class);
		annotationMap.put(UITextArea.class, UITextArea.class);
		annotationMap.put(UITag.class, UITag.class);
		annotationMap.put(UIFile.class, UIFile.class);
		annotationMap.put(UIFilter.class, UIFilter.class);
		annotationMap.put(UIJoin.class, UIJoin.class);
		
		annotationMap.put(UIPosition.class, UIPosition.class);
		annotationMap.put(UIAutoComplete.class, UIAutoComplete.class);
		annotationMap.put(UIValidation.class, UIValidation.class);
	}

	/**
	 * @param object
	 * @return
	 */
	public static Form create(Object object) {

		List<br.com.enginer.domain.ui.schema.field.Field> fields = new ArrayList<>();
		br.com.enginer.domain.ui.schema.field.Field field = null;

		Form form = new Form();
		form.setTitle(StringsUtils.normalizeLabelToLowercaseCamelization(object.getClass().getSimpleName().toString()));
		form.setFields(fields);

		List<Field> fs = ReflectionUtils.extractFieldsDomain(object, false);

		int count = 1;

		if (object.getClass().isAnnotationPresent(UITitle.class)) {
			UITitle title = object.getClass().getAnnotation(UITitle.class);
			form.setTitle(title.value());
		}

		for (Field f : fs) {

			int x = count;
			int y = count % 2 == 0 ? count - 1 : count;

			Default default_ = new Default(x, y, f.getName(), object);

			field = new br.com.enginer.domain.ui.schema.field.Field();
			fields.add(field);

			Annotation[] annotations = f.getAnnotations();
			
			boolean identity = false;

			for (Annotation annotation : annotations) {

				Class<? extends Annotation> annotationType = annotation.annotationType();

				if (annotationMap.containsKey(annotationType)) {

					if (annotation instanceof UIId uiId) {

						Hidden hidden = default_.getHidden();
						addBehaviorAnnotation(hidden, f, annotations);
						field.setHidden(hidden);
						identity = true;

					} else if (annotation instanceof UIJoin uiJoin) {

						Join join = default_.getJoin(f.getType().getSimpleName());
						addBehaviorAnnotation(join, f, annotations);
						field.setJoin(join);
						identity = true;
						
					} else if (annotation instanceof UIText uiText) {

						Text text = default_.getText();
						addBehaviorAnnotation(text, f, annotations);
						field.setText(text);
						identity = true;
						count++;

					} else if (annotation instanceof UIEmail uiEmail) {

						Email email = default_.getEmail();
						addBehaviorAnnotation(email, f, annotations);
						field.setEmail(email);
						identity = true;
						count++;

					} else if (annotation instanceof UIPassword uiPassword) {

						Password password = default_.getPassword();
						addBehaviorAnnotation(password, f, annotations);
						field.setPassword(password);
						identity = true;
						count++;

					} else if (annotation instanceof UINumber uiNumber) {

						Number number = default_.getNumber();
						addBehaviorAnnotation(number, f, annotations);
						field.setNumber(number);
						identity = true;
						count++;

					} else if (annotation instanceof UIDecimal uiDecimal) {

						Decimal decimal = default_.getDecimal();
						addBehaviorAnnotation(decimal, f, annotations);
						field.setDecimal(decimal);
						identity = true;
						count++;

					} else if (annotation instanceof UICheckbox uiCheckbox) {

						Checkbox checkbox = default_.getCheckbox();
						addBehaviorAnnotation(checkbox, f, annotations);
						field.setCheckbox(checkbox);
						identity = true;
						count++;

					} else if (annotation instanceof UIDate uiDate) {

						Date date = default_.getDate(uiDate.showtime());
						addBehaviorAnnotation(date, f, annotations);
						field.setDate(date);
						identity = true;
						count++;

					} else if (annotation instanceof UITime uiTime) {

						Time time = default_.getTime();
						addBehaviorAnnotation(time, f, annotations);
						field.setTime(time);
						identity = true;
						count++;

					} else if (annotation instanceof UIRadio uiRadio) {

						Radio radio = default_.getRadio(null);
						addBehaviorAnnotation(radio, f, annotations);
						field.setRadio(radio);
						identity = true;
						count++;

					} else if (annotation instanceof UISelect uiSelect) {

						Select select = default_.getSelect(null);
						addBehaviorAnnotation(select, f, annotations);
						field.setSelect(select);
						identity = true;
						count++;

					} else if (annotation instanceof UITag uiTag) {

						Tag tag = default_.getTag();
						addBehaviorAnnotation(tag, f, annotations);
						field.setTag(tag);
						identity = true;
						count++;

					} else if (annotation instanceof UIFile uiFile) {

						File file = default_.getFile();
						addBehaviorAnnotation(file, f, annotations);
						field.setFile(file);
						identity = true;
						count++;

					} else if (annotation instanceof UITextArea textArea) {

						Area textarea = default_.getTextarea();
						addBehaviorAnnotation(textarea, f, annotations);
						field.setTextarea(textarea);
						identity = true;
						count++;

					} else if (annotation instanceof UIFilter) {

						Filter filter = default_.getFilter(f.getType().getSimpleName());
						addBehaviorAnnotation(filter, f, annotations);
						field.setFilter(filter);
						identity = true;
						count++;

					}
				}
			}
			
			
			if(identity) continue;
			

			if (f.getType() == Id.class) {

				Hidden hidden = default_.getHidden();

				addBehaviorAnnotation(hidden, f, annotations);

				field.setHidden(hidden);

				count--;

			} else if (f.getType().equals(Integer.class) || f.getType().equals(Short.class)
					|| f.getType().equals(Long.class) || f.getType().equals(Byte.class)
					|| f.getType().equals(BigInteger.class)) {

				Number number = default_.getNumber();

				addBehaviorAnnotation(number, f, annotations);

				field.setNumber(number);

			} else if (f.getType().equals(Float.class) || f.getType().equals(Double.class)
					|| f.getType().equals(BigDecimal.class)) {

				Decimal decimal = default_.getDecimal();

				addBehaviorAnnotation(decimal, f, annotations);

				field.setDecimal(decimal);

			} else if (f.getType().equals(String.class)) {

				Text text = default_.getText();

				addBehaviorAnnotation(text, f, annotations);

				field.setText(text);

			} else if (f.getType().equals(StringBuilder.class) || f.getType().equals(StringBuffer.class)) {

				Area textarea = default_.getTextarea();

				addBehaviorAnnotation(textarea, f, annotations);

				field.setTextarea(textarea);

			} else if (f.getType().equals(LocalDate.class)) {

				Date date = default_.getDate(false);

				addBehaviorAnnotation(date, f, annotations);

				field.setDate(date);

			} else if (f.getType().equals(LocalDateTime.class)) {

				Date date = default_.getDate(true);

				addBehaviorAnnotation(date, f, annotations);

				field.setDate(date);

			} else if (f.getType().equals(Boolean.class)) {

				Checkbox checkbox = default_.getCheckbox();

				addBehaviorAnnotation(checkbox, f, annotations);

				field.setCheckbox(checkbox);

			} else if (Collection.class.isAssignableFrom(f.getType())) {

				List<Object> options = new ArrayList<>();
				options.add("value_1");
				options.add("value_2");
				options.add("value_3");
				options.add("value_4");

				Select select = default_.getSelect(options);

				addBehaviorAnnotation(select, f, annotations);

				field.setSelect(select);

			} else if (!ReflectionUtils.extractIsJavaLangType(f.getType())) {

				Join join = default_.getJoin(f.getType().getSimpleName());
				addBehaviorAnnotation(join, f, annotations);
				field.setJoin(join);

				count--;

			}

			count++;
		}

		return form;
	}

	private static void addBehaviorAnnotation(Base base, Field field, Annotation[] annotations) {

		for (Annotation annotation : annotations) {

			Class<? extends Annotation> annotationType = annotation.annotationType();

			if (annotationMap.containsKey(annotationType)) {

				if (annotation instanceof UIAutoComplete uiAutoComplete) {

					Autocomplete autocomplete = new Autocomplete();

				} else if (annotation instanceof UIPosition uiPosition) {

					base.setPosition(new Position(uiPosition.x(), uiPosition.y()));

				} else if (annotation instanceof UIValidation uiValidation) {

					Pattern pattern = new Pattern(uiValidation.pattern(), uiValidation.patternError());
					Async async = new Async(uiValidation.asyncFunc(), uiValidation.asyncError(), uiValidation.method());
					Sync sync = new Sync(uiValidation.syncFunc(), uiValidation.syncError());
					Validation validation = createValidationIfNotNull(pattern, async, sync);
					base.setRequired(uiValidation.required());
					base.setValidation(validation);

				} else {

					Method[] methods = annotation.annotationType().getDeclaredMethods();

					for (Method method : methods) {
						Object object = ReflectionUtils.set(method.getName(), annotation);
						ReflectionUtils.set(base, StringsUtils.setMethod(method.getName()),
								new Class<?>[] { object.getClass() }, new Object[] { object });
					}

				}
			}
		}

	}

	private static Validation createValidationIfNotNull(Pattern pattern, Async async, Sync sync) {
		if (pattern.getRegex() != null || async.getFunction() != null || sync.getFunctions() != null) {
			Validation validation = new Validation();
			validation.setPattern(pattern.getRegex() != null ? pattern : null);
			validation.setAsync(async.getFunction() != null ? async : null);
			validation.setSync(sync.getFunctions() != null ? sync : null);
			return validation;
		}
		return null;
	}

}
