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

import br.com.enginer.domain.ui.annotation.field.UIAutoComplete;
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
import br.com.enginer.domain.ui.annotation.field.UIPattern;
import br.com.enginer.domain.ui.annotation.field.UIRadio;
import br.com.enginer.domain.ui.annotation.field.UISelect;
import br.com.enginer.domain.ui.annotation.field.UITag;
import br.com.enginer.domain.ui.annotation.field.UIText;
import br.com.enginer.domain.ui.annotation.field.UITextArea;
import br.com.enginer.domain.ui.annotation.field.UITime;
import br.com.enginer.domain.ui.annotation.field.UIValidation;
import br.com.enginer.domain.ui.annotation.instance.UITitle;
import br.com.enginer.domain.ui.schema.Form;
import br.com.enginer.domain.ui.schema.field.behavior.Base;
import br.com.enginer.domain.ui.schema.field.behavior.Default;
import br.com.enginer.domain.ui.schema.field.behavior.Pattern;
import br.com.enginer.domain.ui.schema.field.type.Area;
import br.com.enginer.domain.ui.schema.field.type.Checkbox;
import br.com.enginer.domain.ui.schema.field.type.Date;
import br.com.enginer.domain.ui.schema.field.type.Decimal;
import br.com.enginer.domain.ui.schema.field.type.Hidden;
import br.com.enginer.domain.ui.schema.field.type.Join;
import br.com.enginer.domain.ui.schema.field.type.Number;
import br.com.enginer.domain.ui.schema.field.type.Select;
import br.com.enginer.domain.ui.schema.field.type.Text;
import br.com.enginer.domain.utils.ReflectionUtils;
import br.com.enginer.domain.utils.StringsUtils;

public class FormTemplate {

	private static final Map<Class<? extends Annotation>, Class<? extends Annotation>> annotationMap = new HashMap<>();

    static {
        annotationMap.put(UIAutoComplete.class, UIAutoComplete.class);
        annotationMap.put(UICheckbox.class, UICheckbox.class);
        annotationMap.put(UIDate.class, UIDate.class);
        annotationMap.put(UIDecimal.class, UIDecimal.class);
        annotationMap.put(UIEmail.class, UIEmail.class);
        annotationMap.put(UIFile.class, UIFile.class);
        annotationMap.put(UIFilter.class, UIFilter.class);
        annotationMap.put(UIId.class, UIId.class);
        annotationMap.put(UIJoin.class, UIJoin.class);
        annotationMap.put(UINumber.class, UINumber.class);
        annotationMap.put(UIPassword.class, UIPassword.class);
        annotationMap.put(UIPattern.class, UIPattern.class);
        annotationMap.put(UIRadio.class, UIRadio.class);
        annotationMap.put(UISelect.class, UISelect.class);
        annotationMap.put(UITag.class, UITag.class);
        annotationMap.put(UIText.class, UIText.class);
        annotationMap.put(UITextArea.class, UITextArea.class);
        annotationMap.put(UITime.class, UITime.class);
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

			int order = count;
			int group = count % 2 == 0 ? count - 1 : count;

			Default default_ = new Default(order, group, f.getName(), object);

			field = new br.com.enginer.domain.ui.schema.field.Field();
			fields.add(field);

			Annotation[] annotations = f.getAnnotations();

			System.out.println(annotations.length);

			if (f.getType().equals(Integer.class) || f.getType().equals(Long.class) || f.getType().equals(Short.class) || f.getType().equals(Byte.class) || f.getType().equals(BigInteger.class)) {

				Number number = default_.getNumber();

				field.setNumber(number);

			} else if (f.getType().equals(Double.class) || f.getType().equals(Float.class) || f.getType().equals(BigDecimal.class)) {

				Decimal decimal = default_.getDecimal();

				field.setDecimal(decimal);

			} else if (f.getType().equals(String.class) || f.getType().equals(StringBuilder.class) || f.getType().equals(StringBuffer.class)) {

				Text text = default_.getText();

				test(text, f, annotations);

				field.setText(text);

			} else if (f.getType().equals(StringBuilder.class) || f.getType().equals(StringBuffer.class)) {
				
				Area textarea = default_.getTextarea();

				field.setTextarea(textarea);

			} else if (f.getType().equals(LocalDate.class)) {
				
				Date date = default_.getDate(false);

				field.setDate(date);

			} else if (f.getType().equals(LocalDateTime.class)) {
				
				Date date = default_.getDate(true);

				field.setDate(date);

			} else if (f.getType().equals(Boolean.class)) {
				
				Checkbox checkbox = default_.getCheckbox();

				field.setCheckbox(checkbox);

			} else if (Collection.class.isAssignableFrom(f.getType())) {

				List<Object> options = new ArrayList<>();
				options.add("value_1");
				options.add("value_2");
				options.add("value_3");
				options.add("value_4");
				
				Select select = default_.getSelect(options);

				field.setSelect(select);

			} else if (!ReflectionUtils.extractIsJavaLangType(f.getType())) {
				
				Join join = default_.getJoin(f.getType().getSimpleName());

				field.setJoin(join);
				
				count--;

			} else if (f.getType() == Object.class) {
				
				Hidden hidden = default_.getHidden();

				field.setHidden(hidden);
				
				count--;
			}

			count++;
		}

		return form;
	}

	private static void test(Base base, Field field, Annotation[] annotations) {

		for (Annotation annotation : annotations) {

			Class<? extends Annotation> annotationType = annotation.annotationType();

			if (annotationMap.containsKey(annotationType)) {
				
				if (annotation instanceof UIAutoComplete uiAutoComplete) {
                	
                } else if (annotation instanceof UIPattern uiPattern) {
                	
                	Pattern pattern = new Pattern(uiPattern.regex(), uiPattern.message());
                	ReflectionUtils.executeSetMethod(base, StringsUtils.setMethod("pattern"), new Class<?>[] { pattern.getClass() }, new Object[] { pattern });
                	
                } else if (annotation instanceof UIValidation uiValidation) {
                	
                } else {
                			
        			Method[] methods = annotation.annotationType().getDeclaredMethods();

        			for (Method method : methods) {
        				Object object = ReflectionUtils.executeGetMethod(method.getName(), annotation);
        				ReflectionUtils.executeSetMethod(base, StringsUtils.setMethod(method.getName()), new Class<?>[] { object.getClass() }, new Object[] { object });
        			}

                }
			}
		}

	}

}
