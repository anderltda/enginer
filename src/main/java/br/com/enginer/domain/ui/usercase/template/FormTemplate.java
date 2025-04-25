package br.com.enginer.domain.ui.usercase.template;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.enginer.domain.Constants;
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
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIFieldValidation;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UIPattern;
import br.com.enginer.domain.ui.usercase.annotation.field.behavior.validation.UISync;
import br.com.enginer.domain.ui.usercase.annotation.instance.UITitle;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionDomain;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionMethod;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionRedirect;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionResponse;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionResponseError;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIActionResponseSuccess;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButton;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UIButtonAction;
import br.com.enginer.domain.ui.usercase.annotation.instance.action.UISubmit;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIColumn;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIConfig;
import br.com.enginer.domain.ui.usercase.annotation.instance.paginator.UIPaginator;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.UIValidate;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.conditional.UIConditionalOn;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.custom.UICustomOn;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.dependency.UIDependency;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.dependency.UIDependsOn;
import br.com.enginer.domain.ui.usercase.annotation.instance.validate.global.UIGlobalOn;
import br.com.enginer.domain.ui.usercase.enums.TypeButton;
import br.com.enginer.domain.ui.usercase.enums.TypeTemplate;
import br.com.enginer.domain.ui.usercase.helper.ComboHelper;
import br.com.enginer.domain.ui.usercase.schema.Form;
import br.com.enginer.domain.ui.usercase.schema.field.Field;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.Autocomplete;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.Base;
import br.com.enginer.domain.ui.usercase.schema.field.behavior.Default;
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
import br.com.enginer.domain.ui.usercase.schema.instance.ActionObject;
import br.com.enginer.domain.ui.usercase.schema.instance.ActionResponse;
import br.com.enginer.domain.ui.usercase.schema.instance.ActionResponseError;
import br.com.enginer.domain.ui.usercase.schema.instance.ActionResponseSuccess;
import br.com.enginer.domain.ui.usercase.schema.instance.Button;
import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import br.com.enginer.domain.ui.usercase.schema.paginator.Paginator;
import br.com.enginer.domain.ui.usercase.schema.paginator.column.Column;
import br.com.enginer.domain.ui.usercase.schema.paginator.config.Config;
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

	private static TypeTemplate TYPE_TEMPLATE;

	private FormTemplate() {
	}

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
		annotationMap.put(UIFieldValidation.class, UIFieldValidation.class);
		annotationMap.put(UIDependency.class, UIDependency.class);

	}

	/**
	 * @param domain
	 * @return
	 */
	public static Form create(Domain<?> domain, TypeTemplate typeTemplate) throws Exception {

		Form form = null;

		try {

			TYPE_TEMPLATE = typeTemplate;

			List<Field> fields = new ArrayList<>();
			Field field = null;

			form = new Form();
			form.setTitle(getTitle(domain));
			form.setPaginator(getPaginator(domain));
			form.setValidate(getValidate(domain));
			form.setFields(fields);

			List<java.lang.reflect.Field> fs = ReflectionUtils.extractFieldsDomain(domain, false);

			int count = 1;

			for (java.lang.reflect.Field f : fs) {

				int x = count;
				int y = count % 2 == 0 ? count - 1 : count;

				Default default_ = new Default(x, y, f.getName(), false, domain);

				field = new Field();
				fields.add(field);

				Annotation[] annotations = f.getAnnotations();

				boolean identity = false;

				for (Annotation annotation : annotations) {

					Class<? extends Annotation> annotationType = annotation.annotationType();

					if (annotationMap.containsKey(annotationType)) {

						if (annotation instanceof UIId uiId) {

							boolean containsTemplate = checkTemplate(uiId);

							if (containsTemplate) {
								field.setHidden(getHidden(f, default_, annotations));
							}

							identity = true;

						} else if (annotation instanceof UIHidden uiHidden) {

							boolean containsTemplate = checkTemplate(uiHidden);

							if (containsTemplate) {
								field.setHidden(getHidden(f, default_, annotations));
							}

							identity = true;

						} else if (annotation instanceof UIJoin uiJoin) {

							boolean containsTemplate = checkTemplate(uiJoin);

							if (containsTemplate) {
								field.setJoin(getJoin(domain, f, default_, annotations));
							}

							identity = true;

						} else if (annotation instanceof UIText uiText) {

							boolean containsTemplate = checkTemplate(uiText);

							if (containsTemplate) {
								field.setText(getText(f, default_, annotations));
								count++;
							}

							identity = true;

						} else if (annotation instanceof UIEmail uiEmail) {

							boolean containsTemplate = checkTemplate(uiEmail);

							if (containsTemplate) {
								field.setEmail(getEmail(f, default_, annotations));
								count++;
							}

							identity = true;

						} else if (annotation instanceof UIPassword uiPassword) {

							boolean containsTemplate = checkTemplate(uiPassword);

							if (containsTemplate) {
								field.setPassword(getPassword(f, default_, annotations));
								count++;
							}

							identity = true;

						} else if (annotation instanceof UINumber uiNumber) {

							boolean containsTemplate = checkTemplate(uiNumber);

							if (containsTemplate) {
								field.setNumber(getNumber(f, default_, annotations));
								count++;
							}

							identity = true;

						} else if (annotation instanceof UIDecimal uiDecimal) {

							boolean containsTemplate = checkTemplate(uiDecimal);

							if (containsTemplate) {
								field.setDecimal(getDecimal(f, default_, annotations));
								count++;
							}

							identity = true;

						} else if (annotation instanceof UICheckbox uiCheckbox) {

							boolean containsTemplate = checkTemplate(uiCheckbox);

							if (containsTemplate) {
								field.setCheckbox(getCheckbox(f, default_, annotations));
								count++;
							}

							identity = true;

						} else if (annotation instanceof UIDate uiDate) {

							boolean containsTemplate = checkTemplate(uiDate);

							if (containsTemplate) {
								field.setDate(getDate(f, default_, annotations, uiDate.showtime()));
								count++;
							}

							identity = true;

						} else if (annotation instanceof UITime uiTime) {

							boolean containsTemplate = checkTemplate(uiTime);

							if (containsTemplate) {
								field.setTime(getTime(f, default_, annotations));
								count++;
							}

							identity = true;

						} else if (annotation instanceof UIRadio uiRadio) {

							boolean containsTemplate = checkTemplate(uiRadio);

							if (containsTemplate) {
								field.setRadio(getRadio(f, default_, annotations, uiRadio));
								count++;
							}

							identity = true;

						} else if (annotation instanceof UISelect uiSelect) {

							boolean containsTemplate = checkTemplate(uiSelect);

							if (containsTemplate) {
								field.setSelect(getSelect(f, default_, annotations, uiSelect));
								count++;
							}

							identity = true;

						} else if (annotation instanceof UITag uiTag) {

							boolean containsTemplate = checkTemplate(uiTag);

							if (containsTemplate) {
								field.setTag(getTag(f, default_, annotations));
								count++;
							}

							identity = true;

						} else if (annotation instanceof UIFile uiFilter) {

							boolean containsTemplate = checkTemplate(uiFilter);

							if (containsTemplate) {
								field.setFile(getFiles(f, default_, annotations));
								count++;
							}

							identity = true;

						} else if (annotation instanceof UITextArea uiTextArea) {

							boolean containsTemplate = checkTemplate(uiTextArea);

							if (containsTemplate) {
								field.setTextarea(getTextArea(f, default_, annotations));
								count++;
							}

							identity = true;

						} else if (annotation instanceof UIFilter uiFilter) {

							boolean containsTemplate = checkTemplate(uiFilter);

							if (containsTemplate) {
								field.setFilter(getFilter(domain, f, default_, annotations, uiFilter));
								count++;
							}

							identity = true;

						}
					}
				}

				if (identity)
					continue;

				if (f.getType() == Id.class) {

					field.setHidden(getHidden(f, default_, annotations));

					count--;

				} else if (!ReflectionUtils.extractIsJavaLangType(f.getType())) {

					field.setJoin(getJoin(domain, f, default_, annotations));

					count--;

				} else if (f.getType().equals(Integer.class) || f.getType().equals(Short.class)
						|| f.getType().equals(Long.class) || f.getType().equals(Byte.class)
						|| f.getType().equals(BigInteger.class)) {

					field.setNumber(getNumber(f, default_, annotations));

				} else if (f.getType().equals(Float.class) || f.getType().equals(Double.class)
						|| f.getType().equals(BigDecimal.class)) {

					field.setDecimal(getDecimal(f, default_, annotations));

				} else if (f.getType().equals(String.class)) {

					field.setText(getText(f, default_, annotations));

				} else if (f.getType().equals(StringBuilder.class) || f.getType().equals(StringBuffer.class)) {

					field.setTextarea(getTextArea(f, default_, annotations));

				} else if (f.getType().equals(LocalDate.class)) {

					field.setDate(getDate(f, default_, annotations, false));

				} else if (f.getType().equals(LocalDateTime.class)) {

					field.setDate(getDate(f, default_, annotations, true));

				} else if (f.getType().equals(Boolean.class)) {

					field.setCheckbox(getCheckbox(f, default_, annotations));

				} else if (Collection.class.isAssignableFrom(f.getType())) {

					Type genericType = f.getGenericType();

					if (genericType instanceof ParameterizedType parameterizedType) {
						Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
						if (actualTypeArguments.length == 1) {
							field.setFile(getFiles(f, default_, annotations));
						}
						continue;
					}

					field.setSelect(getSelect(f, default_, annotations, null));
				}

				count++;
			}

			List<Button> buttons = getButton(domain);

			if (buttons != null) {
				buttons.forEach(button -> {
					Field fieldButton = new Field();
					fieldButton.setButton(button);
					fields.add(fieldButton);
				});
			}

			Button submit = getSubmit(domain);

			if (submit != null) {
				Field fieldSubmit = new Field();
				fieldSubmit.setButton(submit);
				fields.add(fieldSubmit);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

		return form;
	}

	private static Paginator getPaginator(Domain<?> domain) {
		Paginator paginator = new Paginator();
		Config config = new Config();
		Column column = new Column();
		List<Field> actions = new ArrayList<>();

		paginator.setConfig(config);
		paginator.setColumn(column);
		paginator.setActions(actions);
		
		

		if (domain.getClass().isAnnotationPresent(UIPaginator.class)) {
			
			TypeTemplate copyTypeTemplate = TYPE_TEMPLATE;
			
			TYPE_TEMPLATE = TypeTemplate.PAGINATOR;
			
			UIPaginator uiPaginator = domain.getClass().getAnnotation(UIPaginator.class);

			UIConfig uiConfig = uiPaginator.config();
			config.setEditable(uiConfig.editable());
			config.setMultiSelection(uiConfig.multiSelection());
			config.setExpandable(uiConfig.expandable());

			UIColumn uiColumn = uiPaginator.column();
			column.setInitial(Arrays.asList(uiColumn.initial()));
			column.setHidden(Arrays.asList(uiColumn.hidden()));

			UIButtonAction uiButtonAction = uiPaginator.actions();
			UIButton[] uiButtons = uiButtonAction.value();
			
			List<UIButton> uiListButtons = new ArrayList<>(Arrays.asList(uiButtons));

			for (Class<? extends Annotation> custom : uiButtonAction.includes()) {
				uiListButtons.add(custom.getAnnotation(UIButton.class));
			}
			
			if (uiListButtons.size() > 0) {
				List<Button> buttons = new ArrayList<>();
				for (UIButton uiButton : uiListButtons) {
					boolean containsTemplate = checkTemplate(uiButton);
					if (containsTemplate) {
						Method[] methods = uiButton.annotationType().getDeclaredMethods();
						Button button = new Button(TypeButton.BUTTON);
						for (Method method : methods) {
							Object buttonObject = ReflectionUtils.get(method.getName(), uiButton);
							if (buttonObject instanceof UIAction uiAction) {
								button.setAction(getButtonAction(uiAction));
								continue;
							}
							if (method.getName().equals("template")) {
								continue;
							}
							
					        if (method.getName().equalsIgnoreCase("label") && uiButton.label().equals(Constants.LABEL_DELETE)) {
					        	ReflectionUtils.set(button, StringsUtils.setMethod(method.getName()), new Class<?>[] { buttonObject.getClass() }, new Object[] { Constants.LABEL_ACTION_DELETE });
					        	continue;
					        }
					        
							ReflectionUtils.set(button, StringsUtils.setMethod(method.getName()), new Class<?>[] { buttonObject.getClass() }, new Object[] { buttonObject });
						}
						buttons.add(button);
					}
				}

				if (buttons != null) {
					buttons.forEach(button -> {
						br.com.enginer.domain.ui.usercase.schema.field.Field fieldButton = new br.com.enginer.domain.ui.usercase.schema.field.Field();
						fieldButton.setButton(button);
						actions.add(fieldButton);
					});
				}

			}
			
			TYPE_TEMPLATE = copyTypeTemplate;
		}

		return paginator;
	}

	private static Filter getFilter(Domain<?> domain, java.lang.reflect.Field f, Default default_, Annotation[] annotations, UIFilter uiFilter) throws Exception {

		Map<String, Object> filters = ReflectionUtils.parseFilter(uiFilter.filter());

		Filter filter = default_.getFilter(f.getType().getSimpleName());

		if (uiFilter.select()) {
			Object provider = f.getType().getDeclaredConstructor().newInstance();
			List<?> options = (List<?>) ReflectionUtils.executeMethod(domain, "options", provider, filters);
			filter.setOptions(options);
		}

		addBehaviorAnnotation(filter, f, annotations);

		return filter;
	}

	private static Area getTextArea(java.lang.reflect.Field f, Default default_, Annotation[] annotations) {
		Area textarea = default_.getTextarea();
		addBehaviorAnnotation(textarea, f, annotations);
		return textarea;
	}

	private static File getFiles(java.lang.reflect.Field f, Default default_, Annotation[] annotations) {

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
		return file;
	}

	private static Tag getTag(java.lang.reflect.Field f, Default default_, Annotation[] annotations) {
		Tag tag = default_.getTag();
		addBehaviorAnnotation(tag, f, annotations);
		return tag;
	}

	@SuppressWarnings("unchecked")
	private static Select getSelect(java.lang.reflect.Field f, Default default_, Annotation[] annotations, UISelect uiSelect) throws Exception {

		List<Object> options = null;

		if (uiSelect != null) {
			Object provider = uiSelect.provider().getDeclaredConstructor().newInstance();
			options = (List<Object>) ReflectionUtils.executeMethod(provider, uiSelect.method());
		} else {
			options = new ComboHelper().values();
		}

		Select select = default_.getSelect(options);

		addBehaviorAnnotation(select, f, annotations);

		return select;
	}

	@SuppressWarnings("unchecked")
	private static Radio getRadio(java.lang.reflect.Field f, Default default_, Annotation[] annotations,
			UIRadio uiRadio) throws Exception {

		Object provider = uiRadio.provider().getDeclaredConstructor().newInstance();

		List<Object> options = (List<Object>) ReflectionUtils.executeMethod(provider, uiRadio.method());

		Radio radio = default_.getRadio(options);

		addBehaviorAnnotation(radio, f, annotations);

		return radio;
	}

	private static Time getTime(java.lang.reflect.Field f, Default default_, Annotation[] annotations) {
		Time time = default_.getTime();
		addBehaviorAnnotation(time, f, annotations);
		return time;
	}

	private static Date getDate(java.lang.reflect.Field f, Default default_, Annotation[] annotations,
			Boolean showtime) {
		Date date = default_.getDate(showtime);
		addBehaviorAnnotation(date, f, annotations);
		return date;
	}

	private static Checkbox getCheckbox(java.lang.reflect.Field f, Default default_, Annotation[] annotations) {
		Checkbox checkbox = default_.getCheckbox();
		addBehaviorAnnotation(checkbox, f, annotations);
		return checkbox;
	}

	private static Number getNumber(java.lang.reflect.Field f, Default default_, Annotation[] annotations) {
		Number number = default_.getNumber();
		addBehaviorAnnotation(number, f, annotations);
		return number;
	}

	private static Decimal getDecimal(java.lang.reflect.Field f, Default default_, Annotation[] annotations) {
		Decimal decimal = default_.getDecimal();
		addBehaviorAnnotation(decimal, f, annotations);
		return decimal;
	}

	private static Password getPassword(java.lang.reflect.Field f, Default default_, Annotation[] annotations) {
		Password password = default_.getPassword();
		addBehaviorAnnotation(password, f, annotations);
		return password;
	}

	private static Email getEmail(java.lang.reflect.Field f, Default default_, Annotation[] annotations) {
		Email email = default_.getEmail();
		addBehaviorAnnotation(email, f, annotations);
		return email;
	}

	private static Text getText(java.lang.reflect.Field f, Default default_, Annotation[] annotations) {
		Text text = default_.getText();
		addBehaviorAnnotation(text, f, annotations);
		return text;
	}

	private static Hidden getHidden(java.lang.reflect.Field f, Default default_, Annotation[] annotations) {
		Hidden hidden = default_.getHidden();
		addBehaviorAnnotation(hidden, f, annotations);
		return hidden;
	}

	private static Join getJoin(Domain<?> domain, java.lang.reflect.Field f, Default default_,
			Annotation[] annotations) {

		Object id = null;

		Join join = default_.getJoin(f.getType().getSimpleName());

		Object object = ReflectionUtils.get(StringsUtils.getMethod(f.getType().getSimpleName()), domain);

		if (object != null) {
			id = ReflectionUtils.get(StringsUtils.getMethod("id"), object);
		}

		join.setValue(id);

		addBehaviorAnnotation(join, f, annotations);

		return join;
	}

	private static void addBehaviorAnnotation(Base base, java.lang.reflect.Field field, Annotation[] annotations) {

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

				} else if (annotation instanceof UIFieldValidation uiValidation) {

					UIPattern uiPattern = uiValidation.pattern();
					UIAsync uiAsync = uiValidation.async();
					UISync uiSync = uiValidation.sync();

					Pattern pattern = new Pattern(uiPattern.pattern(), uiPattern.patternError());
					Async async = new Async(uiAsync.asyncFunc(), uiAsync.asyncError(), uiAsync.method());
					Sync sync = new Sync(uiSync.syncFunc(), uiSync.syncError());

					Validation validation = createValidationIfNotNull(pattern, async, sync);

					boolean containsTemplate = checkTemplate(uiValidation);

					if (containsTemplate) {
						base.setRequired(uiValidation.required());
					} else {
						base.setRequired(!uiValidation.required());
					}

					base.setValidation(validation);

				} else {

					Method[] methods = annotation.annotationType().getDeclaredMethods();
					for (Method method : methods) {
						if (method.getName().equals("template")) {
							boolean containsTemplate = checkTemplate(annotation);
							if (containsTemplate) {
								continue;
							}
						}

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

	private static Button getSubmit(Domain<?> domain) {

		Button button = null;

		if (domain.getClass().isAnnotationPresent(UISubmit.class)) {
			UISubmit uiSubmit = domain.getClass().getAnnotation(UISubmit.class);
			boolean containsTemplate = checkTemplate(uiSubmit);
			if (containsTemplate) {
				button = new Button(TypeButton.SUBMIT);
				Method[] methods = uiSubmit.annotationType().getDeclaredMethods();
				for (Method method : methods) {
					Object submitObject = ReflectionUtils.get(method.getName(), uiSubmit);
					ReflectionUtils.set(button, StringsUtils.setMethod(method.getName()),
							new Class<?>[] { submitObject.getClass() }, new Object[] { submitObject });
				}
			}
		}

		return button;
	}

	private static boolean checkTemplate(Annotation annotation) {
		TypeTemplate[] type = (TypeTemplate[]) ReflectionUtils.get("template", annotation);
		boolean containsFilter = Arrays.stream(type).anyMatch(t -> t == TYPE_TEMPLATE);
		return containsFilter;
	}
	
	private static String getTitle(Domain<?> domain) {
		String title = StringsUtils.normalizeLabelToLowercaseCamelization(domain.getClass().getSimpleName().toString());
		if (domain.getClass().isAnnotationPresent(UITitle.class)) {
			UITitle uiTitle = domain.getClass().getAnnotation(UITitle.class);
			title = uiTitle.value();
		}
		return title;
	}

	private static List<Button> getButton(Domain<?> domain) {

		List<Button> buttons = null;

		List<UIButton> uiListButtons = new ArrayList<>();

		if (domain.getClass().isAnnotationPresent(UIButtonAction.class)) {

			UIButtonAction uiButtonAction = domain.getClass().getAnnotation(UIButtonAction.class);
			UIButton[] uiButtons = domain.getClass().getAnnotationsByType(UIButton.class);

			uiListButtons.addAll(Arrays.asList(uiButtons));

			for (Class<? extends Annotation> custom : uiButtonAction.includes()) {
				uiListButtons.add(custom.getAnnotation(UIButton.class));
			}

			if (uiListButtons.size() > 0) {

				buttons = new ArrayList<>();

				for (UIButton uiButton : uiListButtons) {

					boolean containsTemplate = checkTemplate(uiButton);

					if (containsTemplate) {

						Method[] methods = uiButton.annotationType().getDeclaredMethods();

						Button button = new Button(TypeButton.BUTTON);

						for (Method method : methods) {

							Object buttonObject = ReflectionUtils.get(method.getName(), uiButton);

							if (buttonObject instanceof UIAction uiAction) {
								button.setAction(getButtonAction(uiAction));
								continue;
							}

							if (method.getName().equals("template"))
								continue;

							ReflectionUtils.set(button, StringsUtils.setMethod(method.getName()), new Class<?>[] { buttonObject.getClass() }, new Object[] { buttonObject });
						}
						buttons.add(button);
					}
				}

			}
		}
		return buttons;
	}

	private static Action getButtonAction(UIAction uiAction) {
		boolean containsTemplate = false;
		Action action = new Action();
		if (uiAction.method() instanceof UIActionMethod uiActionMethod) {
			containsTemplate = checkTemplate(uiActionMethod);
			if (containsTemplate) {
				action.setClientMethod(uiActionMethod.clientMethod());
				action.setServerMethod(uiActionMethod.serverMethod());
			}
		}

		if (uiAction.redirect() instanceof UIActionRedirect uiActionRedirect) {
			containsTemplate = checkTemplate(uiActionRedirect);
			if (containsTemplate) {
				action.setRedirect(uiActionRedirect.value());
			}
		}

		if (uiAction.domain() instanceof UIActionDomain uiActionDomain) {
			containsTemplate = checkTemplate(uiActionDomain);
			if (containsTemplate) {
				ActionObject actionObject = new ActionObject();
				actionObject.setObject(uiActionDomain.object());
				actionObject.setParam(uiActionDomain.param());
				if (!actionObject.getObject().isEmpty() && !actionObject.getParam().isEmpty()) {
					action.setDomain(actionObject);
				}
			}
		}
		
		if (uiAction.response() instanceof UIActionResponse uiActionResponse) {
			containsTemplate = checkTemplate(uiActionResponse);
			if (containsTemplate) {
				UIActionResponseSuccess uiActionResponseSuccess = uiActionResponse.success();
				UIActionResponseError uiActionResponseError = uiActionResponse.error();
				
				ActionResponse response = new ActionResponse();
				ActionResponseSuccess success = new ActionResponseSuccess();
				ActionResponseError error = new ActionResponseError();
				
				if (uiActionResponseSuccess.method() instanceof UIActionMethod uiActionMethod) {
					containsTemplate = checkTemplate(uiActionResponseSuccess);
					if (containsTemplate) {
						success.setClientMethod(uiActionMethod.clientMethod());
						success.setServerMethod(uiActionMethod.serverMethod());
					}
				}
				
				if (uiActionResponseSuccess.redirect() instanceof UIActionRedirect uiActionRedirect) {
					containsTemplate = checkTemplate(uiActionResponseSuccess);
					if (containsTemplate) {
						success.setRedirect(uiActionRedirect.value());
					}
				}
				
				if (uiActionResponseError.method() instanceof UIActionMethod uiActionMethod) {
					containsTemplate = checkTemplate(uiActionResponseError);
					if (containsTemplate) {
						error.setClientMethod(uiActionMethod.clientMethod());
						error.setServerMethod(uiActionMethod.serverMethod());
					}
				}
				
				if (uiActionResponseError.redirect() instanceof UIActionRedirect uiActionRedirect) {
					containsTemplate = checkTemplate(uiActionResponseError);
					if (containsTemplate) {
						error.setRedirect(uiActionRedirect.value());
					}
				}
				
				response.setSuccess(success);
				response.setError(error);
				
				action.setResponse(response);
				
			}
		}
		
		return action;
	}

	private static Validate getValidate(Domain<?> domain) {
		Validate validate = null;
		if (domain.getClass().isAnnotationPresent(UIValidate.class)) {
			validate = new Validate();
			UIValidate uiValidate = domain.getClass().getAnnotation(UIValidate.class);
			boolean containsTemplate = checkTemplate(uiValidate);
			if (containsTemplate) {
				validate.setGlobal(getGlobal(domain, uiValidate.global().value()));
				validate.setCustom(getCustom(domain, uiValidate.custom().value()));
				validate.setConditional(getConditional(domain, uiValidate.conditional().value()));
				validate.setDependency(getDependecy(domain, uiValidate.dependency().value()));
				if (validate.getGlobal().size() == 0 && validate.getCustom().size() == 0
						&& validate.getConditional().size() == 0 && validate.getDependency().size() == 0) {
					validate = null;
				}
			}
		}

		return validate;
	}

	private static List<Dependency> getDependecy(Domain<?> domain, UIDependsOn[] uiDependsOns) {
		List<Dependency> dependencys = new ArrayList<>();
		Dependency dependency = null;
		for (UIDependsOn uiDependsOn : uiDependsOns) {
			boolean containsTemplate = checkTemplate(uiDependsOn);
			if (containsTemplate) {
				dependency = new Dependency();
				dependency.setLabel(uiDependsOn.label());
				dependency.setField(uiDependsOn.field());
				dependency.setDepends(uiDependsOn.depends());
				dependencys.add(dependency);
			}
		}
		return dependencys;
	}

	private static List<Conditional> getConditional(Domain<?> domain, UIConditionalOn[] uiConditionalOns) {
		List<Conditional> conditionals = new ArrayList<>();
		Conditional conditional = null;
		for (UIConditionalOn uiConditionalOn : uiConditionalOns) {
			boolean containsTemplate = checkTemplate(uiConditionalOn);
			if (containsTemplate) {
				conditional = new Conditional();
				conditional.setLabel(uiConditionalOn.label());
				conditional.setField(uiConditionalOn.field());
				conditional.setOperator(uiConditionalOn.operator());
				conditional.setMatchs(uiConditionalOn.matchs());
				conditionals.add(conditional);
			}
		}
		return conditionals;
	}

	private static List<Custom> getCustom(Domain<?> domain, UICustomOn[] uiCustomOns) {
		List<Custom> custons = new ArrayList<>();
		Custom custom = null;
		for (UICustomOn uiCustomOn : uiCustomOns) {
			boolean containsTemplate = checkTemplate(uiCustomOn);
			if (containsTemplate) {
				custom = new Custom();
				custom.setFunction(uiCustomOn.function());
				custom.setMessage(uiCustomOn.message());
				custom.setFields(uiCustomOn.fields());
				custons.add(custom);
			}
		}
		return custons;
	}

	private static List<Global> getGlobal(Domain<?> domain, UIGlobalOn[] uiGlobalOns) {
		List<Global> globals = new ArrayList<>();
		Global global = null;
		for (UIGlobalOn uiGlobalOn : uiGlobalOns) {
			boolean containsTemplate = checkTemplate(uiGlobalOn);
			if (containsTemplate) {
				global = new Global();
				global.setFunction(uiGlobalOn.function());
				global.setMessage(uiGlobalOn.message());
				globals.add(global);
			}
		}
		return globals;
	}

}
