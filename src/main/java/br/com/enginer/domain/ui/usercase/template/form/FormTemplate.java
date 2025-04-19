package br.com.enginer.domain.ui.usercase.template.form;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.enginer.domain.ui.usercase.annotation.field.UICheckbox;
import br.com.enginer.domain.ui.usercase.annotation.field.UIDate;
import br.com.enginer.domain.ui.usercase.annotation.field.UIDecimal;
import br.com.enginer.domain.ui.usercase.annotation.field.UIEmail;
import br.com.enginer.domain.ui.usercase.annotation.field.UIFile;
import br.com.enginer.domain.ui.usercase.annotation.field.UIFilter;
import br.com.enginer.domain.ui.usercase.annotation.field.UIHidden;
import br.com.enginer.domain.ui.usercase.annotation.field.UIId;
import br.com.enginer.domain.ui.usercase.annotation.field.UIJoin;
import br.com.enginer.domain.ui.usercase.annotation.field.UINumber;
import br.com.enginer.domain.ui.usercase.annotation.field.UIPassword;
import br.com.enginer.domain.ui.usercase.annotation.field.UIRadio;
import br.com.enginer.domain.ui.usercase.annotation.field.UISelect;
import br.com.enginer.domain.ui.usercase.annotation.field.UIText;
import br.com.enginer.domain.ui.usercase.annotation.field.UITextArea;
import br.com.enginer.domain.ui.usercase.annotation.field.UITime;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UIPosition;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.UITag;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.autocomplete.UIAutoComplete;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.autocomplete.UIAutoCompleteSuggestion;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIAsync;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIPattern;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UISync;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIValidation;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButton;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButtonAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UISubmit;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.conditional.UIConditional;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.conditional.UIConditionalOn;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.custom.UICustom;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.custom.UICustomOn;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.dependency.UIDependency;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.dependency.UIDependsOn;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.global.UIGlobal;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.global.UIGlobalOn;
import br.com.enginer.domain.ui.usercase.enums.TypeButton;
import br.com.enginer.domain.ui.usercase.schema.Form;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.Autocomplete;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.Base;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.Default;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.Option;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.Pattern;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.Position;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.UploadFile;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.validation.Async;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.validation.Sync;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.validation.Validation;
import br.com.enginer.domain.ui.usercase.schema.field.type.Area;
import br.com.enginer.domain.ui.usercase.schema.field.type.Checkbox;
import br.com.enginer.domain.ui.usercase.schema.field.type.Date;
import br.com.enginer.domain.ui.usercase.schema.field.type.Decimal;
import br.com.enginer.domain.ui.usercase.schema.field.type.Email;
import br.com.enginer.domain.ui.usercase.schema.field.type.File;
import br.com.enginer.domain.ui.usercase.schema.field.type.Filter;
import br.com.enginer.domain.ui.usercase.schema.field.type.Hidden;
import br.com.enginer.domain.ui.usercase.schema.field.type.Id;
import br.com.enginer.domain.ui.usercase.schema.field.type.Join;
import br.com.enginer.domain.ui.usercase.schema.field.type.Number;
import br.com.enginer.domain.ui.usercase.schema.field.type.Password;
import br.com.enginer.domain.ui.usercase.schema.field.type.Radio;
import br.com.enginer.domain.ui.usercase.schema.field.type.Select;
import br.com.enginer.domain.ui.usercase.schema.field.type.Tag;
import br.com.enginer.domain.ui.usercase.schema.field.type.Text;
import br.com.enginer.domain.ui.usercase.schema.field.type.Time;
import br.com.enginer.domain.ui.usercase.schema.instance.Action;
import br.com.enginer.domain.ui.usercase.schema.instance.Button;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import br.com.enginer.domain.ui.usercase.schema.validate.Validate;
import br.com.enginer.domain.ui.usercase.schema.validate.conditional.Conditional;
import br.com.enginer.domain.ui.usercase.schema.validate.custom.Custom;
import br.com.enginer.domain.ui.usercase.schema.validate.dependency.Dependency;
import br.com.enginer.domain.ui.usercase.schema.validate.global.Global;
import br.com.enginer.domain.ui.usercase.utils.ReflectionUtils;
import br.com.enginer.domain.ui.usercase.utils.StringsUtils;

/**
 * 
 */
public final class FormTemplate {

	private static final Map<Class<? extends Annotation>, Class<? extends Annotation>> annotationMap = new HashMap<>();

	private FormTemplate() {}

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
		annotationMap.put(UIHidden.class, UIHidden.class);

		annotationMap.put(UIPosition.class, UIPosition.class);
		annotationMap.put(UIAutoComplete.class, UIAutoComplete.class);
		annotationMap.put(UIAutoCompleteSuggestion.class, UIAutoCompleteSuggestion.class);
		annotationMap.put(UIValidation.class, UIValidation.class);
		annotationMap.put(UIDependency.class, UIDependency.class);

	}


	/**
	 * @param domain
	 * @return
	 */
	public static Form create(Domain<?> domain) throws Exception {

		Form form = null;

		try {
			
			List<br.com.enginer.domain.ui.usercase.schema.field.Field> fields = new ArrayList<>();

			br.com.enginer.domain.ui.usercase.schema.field.Field field = null;

			form = new Form();
			form.setTitle(StringsUtils.normalizeLabelToLowercaseCamelization(domain.getClass().getSimpleName().toString()));

			Validate validate = new Validate();
			List<Global> globals = new ArrayList<>();
			List<Custom> custons = new ArrayList<>();
			List<Conditional> conditionals = new ArrayList<>();
			List<Dependency> dependencys = new ArrayList<>();

			validate.setGlobal(globals);
			validate.setCustom(custons);
			validate.setConditional(conditionals);
			validate.setDependency(dependencys);

			if (domain.getClass().isAnnotationPresent(UIGlobal.class)) {
				UIGlobalOn[] uiGlobalOns = domain.getClass().getAnnotationsByType(UIGlobalOn.class);
				Global global = null;
				for (UIGlobalOn uiGlobalOn : uiGlobalOns) {
					global = new Global();
					global.setFunction(uiGlobalOn.function());
					global.setMessage(uiGlobalOn.message());
					globals.add(global);
				}
			}

			if (domain.getClass().isAnnotationPresent(UICustom.class)) {
				UICustomOn[] uiCustomOns = domain.getClass().getAnnotationsByType(UICustomOn.class);
				Custom custom = null;
				for (UICustomOn uiCustomOn : uiCustomOns) {
					custom = new Custom();
					custom.setFunction(uiCustomOn.function());
					custom.setMessage(uiCustomOn.message());
					custom.setFields(uiCustomOn.fields());
					custons.add(custom);
				}
			}

			if (domain.getClass().isAnnotationPresent(UIConditional.class)) {
				UIConditionalOn[] uiConditionalOns = domain.getClass().getAnnotationsByType(UIConditionalOn.class);
				Conditional conditional = null;
				for (UIConditionalOn uiConditionalOn : uiConditionalOns) {
					conditional = new Conditional();
					conditional.setLabel(uiConditionalOn.label());
					conditional.setField(uiConditionalOn.field());
					conditional.setOperator(uiConditionalOn.operator());
					conditional.setMatchs(uiConditionalOn.matchs());
					conditionals.add(conditional);
				}
			}

			if (domain.getClass().isAnnotationPresent(UIDependency.class)) {
				UIDependsOn[] uiDependsOns = domain.getClass().getAnnotationsByType(UIDependsOn.class);
				Dependency dependency = null;
				for (UIDependsOn uiDependsOn : uiDependsOns) {
					dependency = new Dependency();
					dependency.setLabel(uiDependsOn.label());
					dependency.setField(uiDependsOn.field());
					dependency.setDepends(uiDependsOn.depends());
					dependencys.add(dependency);
				}
			}

			if (domain.getClass().isAnnotationPresent(UITitle.class)) {
				UITitle uiTitle = domain.getClass().getAnnotation(UITitle.class);
				form.setTitle(uiTitle.value());
			}

			Button button = null;

			if (domain.getClass().isAnnotationPresent(UISubmit.class)) {
				UISubmit uiSubmit = domain.getClass().getAnnotation(UISubmit.class);
				field = new br.com.enginer.domain.ui.usercase.schema.field.Field();
				button = new Button(TypeButton.SUBMIT);
				Method[] methods = uiSubmit.annotationType().getDeclaredMethods();
				for (Method method : methods) {
					Object submitObject = ReflectionUtils.get(method.getName(), uiSubmit);
					ReflectionUtils.set(button, StringsUtils.setMethod(method.getName()),
							new Class<?>[] { submitObject.getClass() }, new Object[] { submitObject });
				}
				field.setButton(button);
				fields.add(field);
			}

			if (domain.getClass().isAnnotationPresent(UIButtonAction.class)) {

				UIButton[] uiButtons = domain.getClass().getAnnotationsByType(UIButton.class);

				for (UIButton uiButton : uiButtons) {
					Method[] methods = uiButton.annotationType().getDeclaredMethods();
					field = new br.com.enginer.domain.ui.usercase.schema.field.Field();
					button = new Button(TypeButton.BUTTON);
					for (Method method : methods) {
						Object buttonObject = ReflectionUtils.get(method.getName(), uiButton);
						if (buttonObject instanceof UIAction uiAction) {
							Action action = new Action();
							action.setMethod(uiAction.method());
							action.setRedirect(uiAction.redirect());
							// action.setDomain(uiAction.actionObject());
							button.setAction(action);
							continue;
						}
						ReflectionUtils.set(button, StringsUtils.setMethod(method.getName()),
								new Class<?>[] { buttonObject.getClass() }, new Object[] { buttonObject });
					}
					field.setButton(button);
					fields.add(field);
				}
			}

			form.setValidate(validate);
			form.setFields(fields);

			List<Field> fs = ReflectionUtils.extractFieldsDomain(domain, false);

			int count = 1;

			if (domain.getClass().isAnnotationPresent(UITitle.class)) {
				UITitle title = domain.getClass().getAnnotation(UITitle.class);
				form.setTitle(title.value());
			}

			for (Field f : fs) {

				int x = count;
				int y = count % 2 == 0 ? count - 1 : count;

				Default default_ = new Default(x, y, f.getName(), false, domain);

				field = new br.com.enginer.domain.ui.usercase.schema.field.Field();
				fields.add(field);

				Annotation[] annotations = f.getAnnotations();

				boolean identity = false;

				for (Annotation annotation : annotations) {

					Class<? extends Annotation> annotationType = annotation.annotationType();

					if (annotationMap.containsKey(annotationType)) {

						if (annotation instanceof UIId) {

							Hidden hidden = default_.getHidden();
							addBehaviorAnnotation(hidden, f, annotations);
							field.setHidden(hidden);
							identity = true;

						} else if (annotation instanceof UIHidden) {

							Hidden hidden = default_.getHidden();
							addBehaviorAnnotation(hidden, f, annotations);
							field.setHidden(hidden);
							identity = true;

						} else if (annotation instanceof UIJoin) {

							Join join = default_.getJoin(f.getType().getSimpleName());
							addBehaviorAnnotation(join, f, annotations);
							field.setJoin(join);
							identity = true;

						} else if (annotation instanceof UIText) {

							Text text = default_.getText();
							addBehaviorAnnotation(text, f, annotations);
							field.setText(text);
							identity = true;
							count++;

						} else if (annotation instanceof UIEmail) {

							Email email = default_.getEmail();
							addBehaviorAnnotation(email, f, annotations);
							field.setEmail(email);
							identity = true;
							count++;

						} else if (annotation instanceof UIPassword) {

							Password password = default_.getPassword();
							addBehaviorAnnotation(password, f, annotations);
							field.setPassword(password);
							identity = true;
							count++;

						} else if (annotation instanceof UINumber) {

							Number number = default_.getNumber();
							addBehaviorAnnotation(number, f, annotations);
							field.setNumber(number);
							identity = true;
							count++;

						} else if (annotation instanceof UIDecimal) {

							Decimal decimal = default_.getDecimal();
							addBehaviorAnnotation(decimal, f, annotations);
							field.setDecimal(decimal);
							identity = true;
							count++;

						} else if (annotation instanceof UICheckbox) {

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

						} else if (annotation instanceof UITime) {

							Time time = default_.getTime();
							addBehaviorAnnotation(time, f, annotations);
							field.setTime(time);
							identity = true;
							count++;

						} else if (annotation instanceof UIRadio uiRadio) {

							Object provider = uiRadio.provider().getDeclaredConstructor().newInstance();

							@SuppressWarnings("unchecked")
							List<Object> options = (List<Object>) ReflectionUtils.executeMethod(provider, uiRadio.method());

							Radio radio = default_.getRadio(options);

							addBehaviorAnnotation(radio, f, annotations);

							field.setRadio(radio);
							identity = true;
							count++;

						} else if (annotation instanceof UISelect uiSelect) {

							Object provider = uiSelect.provider().getDeclaredConstructor().newInstance();

							@SuppressWarnings("unchecked")
							List<Object> options = (List<Object>) ReflectionUtils.executeMethod(provider, uiSelect.method());

							Select select = default_.getSelect(options);

							addBehaviorAnnotation(select, f, annotations);

							field.setSelect(select);
							identity = true;
							count++;

						} else if (annotation instanceof UITag) {

							Tag tag = default_.getTag();
							addBehaviorAnnotation(tag, f, annotations);
							field.setTag(tag);
							identity = true;
							count++;

						} else if (annotation instanceof UIFile) {

							List<UploadFile> files = new ArrayList<>();

							UploadFile uploadFile = new UploadFile();
							uploadFile.setUid("550e8400-e29b-41d4-a716-44ar5wq00");
							uploadFile.setName("avatar_small2x.jpg");
							uploadFile.setStatus("done");
							uploadFile.setUrl(
									"https://cdn.awsli.com.br/2500x2500/1063/1063988/produto/240150477/bp3121s---002-2370yhtkq3.jpg");

							files.add(uploadFile);

							uploadFile = new UploadFile();
							uploadFile.setUid("110e8400-e29b-41d4-a716-44ar5wq00");
							uploadFile.setName("avatar_small2x.jpg");
							uploadFile.setStatus("done");
							uploadFile.setUrl(
									"https://beefpoint.com.br/wp-content/uploads/2022/02/Foto-1440px-x-960px-2022-02-03T104828.205-1200x675.png");

							files.add(uploadFile);

							File file = default_.getFile(files);
							addBehaviorAnnotation(file, f, annotations);
							field.setFile(file);
							identity = true;
							count++;

						} else if (annotation instanceof UITextArea) {

							Area textarea = default_.getTextarea();
							addBehaviorAnnotation(textarea, f, annotations);
							field.setTextarea(textarea);
							identity = true;
							count++;

						} else if (annotation instanceof UIFilter uiFilter) {

							Map<String, Object> filters = ReflectionUtils.parseFilter(uiFilter.filter());

							Filter filter = default_.getFilter(f.getType().getSimpleName());

							if (uiFilter.select()) {
								Object provider = f.getType().getDeclaredConstructor().newInstance();
								List<?> options = (List<?>) ReflectionUtils.executeMethod(domain, "options", provider, filters);
								filter.setOptions(options);
							}

							addBehaviorAnnotation(filter, f, annotations);

							field.setFilter(filter);
							identity = true;
							count++;

						}
					}
				}

				if (identity)
					continue;

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

					Type genericType = f.getGenericType();

					if (genericType instanceof ParameterizedType parameterizedType) {

						Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

						if (actualTypeArguments.length == 1) {

							Class<?> itemType = (Class<?>) actualTypeArguments[0];

							if (itemType.equals(UploadFile.class)) {

								List<UploadFile> files = new ArrayList<>();

								UploadFile uploadFile = new UploadFile();
								uploadFile.setUid("550e8400-e29b-41d4-a716-44ar5wq00");
								uploadFile.setName("avatar_small2x.jpg");
								uploadFile.setStatus("done");
								uploadFile.setUrl(
										"http://pages.revox.io/dashboard/3.0.0/html/condensed/assets/img/profiles/avatar_small2x.jpg");

								files.add(uploadFile);

								uploadFile = new UploadFile();
								uploadFile.setUid("110e8400-e29b-41d4-a716-44ar5wq00");
								uploadFile.setName("avatar_small2x.jpg");
								uploadFile.setStatus("done");
								uploadFile.setUrl(
										"http://pages.revox.io/dashboard/3.0.0/html/condensed/assets/img/profiles/avatar_small2x.jpg");

								files.add(uploadFile);

								File file = default_.getFile(files);

								addBehaviorAnnotation(file, f, annotations);

								field.setFile(file);

							}
						}
						continue;
					}

					List<Object> options = new ArrayList<>();
					options.add(new Option("option_1", 1));
					options.add(new Option("option_1", 2));

					Select select = default_.getSelect(options);

					addBehaviorAnnotation(select, f, annotations);

					field.setSelect(select);

				} else if (!ReflectionUtils.extractIsJavaLangType(f.getType())) {
					
					Object id = null;
					
					Join join = default_.getJoin(f.getType().getSimpleName());
					
					Object object = ReflectionUtils.get(StringsUtils.getMethod(f.getType().getSimpleName()), domain);
					
					if(object != null) {
						id = ReflectionUtils.get(StringsUtils.getMethod("id"), object);
					}
					
					join.setValue(id);
					
					addBehaviorAnnotation(join, f, annotations);
					
					field.setJoin(join);

					count--;

				}

				count++;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

		return form;
	}

	private static void addBehaviorAnnotation(Base base, Field field, Annotation[] annotations) {

		for (Annotation annotation : annotations) {

			Class<? extends Annotation> annotationType = annotation.annotationType();

			if (annotationMap.containsKey(annotationType)) {

				if (annotation instanceof UIAutoComplete uiAutoComplete) {

					Autocomplete autocomplete = new Autocomplete();
					autocomplete.setDomain(uiAutoComplete.domain());
					autocomplete.setAttribute(uiAutoComplete.attribute());
					base.setAutocomplete(autocomplete);

				} else if (annotation instanceof UIAutoCompleteSuggestion uiAutoCompleteSuggestion) {

					Autocomplete autocomplete = new Autocomplete();
					autocomplete.setSuggestions(uiAutoCompleteSuggestion.suggestions());
					base.setAutocomplete(autocomplete);

				} else if (annotation instanceof UIPosition uiPosition) {

					Position position = new Position(uiPosition.x(), uiPosition.y());
					base.setPosition(position);

				} else if (annotation instanceof UIValidation uiValidation) {

					UIPattern uiPattern = uiValidation.pattern();
					UIAsync uiAsync = uiValidation.async();
					UISync uiSync = uiValidation.sync();

					Pattern pattern = new Pattern(uiPattern.pattern(), uiPattern.patternError());
					Async async = new Async(uiAsync.asyncFunc(), uiAsync.asyncError(), uiAsync.method());
					Sync sync = new Sync(uiSync.syncFunc(), uiSync.syncError());

					Validation validation = createValidationIfNotNull(pattern, async, sync);

					base.setRequired(uiValidation.required());
					base.setValidation(validation);

				} else {

					Method[] methods = annotation.annotationType().getDeclaredMethods();

					for (Method method : methods) {
						
						Object object = ReflectionUtils.get(method.getName(), annotation);
						
						ReflectionUtils.set(base, StringsUtils.setMethod(method.getName()), new Class<?>[] { object.getClass() }, new Object[] { object });
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
