package br.com.enginer.domain.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.enginer.domain.ui.schema.Form;
import br.com.enginer.domain.ui.schema.field.Default;

public class ReflectionUtils {

	/**
	 * @param object
	 * @return
	 */
	public static Form extractFieldsDomain(Object object) {
		
		List<br.com.enginer.domain.ui.schema.field.Field> fields = new ArrayList<>();
		br.com.enginer.domain.ui.schema.field.Field field = null;

		Form form = new Form();			
		form.setTitle(StringsUtils.normalizeLabelToLowercaseCamelization(object.getClass().getSimpleName().toString()));
		form.setFields(fields);

		List<Field> fs = extractFieldsDomain(object, false);
		
		int count = 1;

		for (Field f : fs) {

			int order = count;
			int group = count%2==0 ? count-1 : count;

			Default default_ = new Default(order, group, f.getName(), object);

			field = new br.com.enginer.domain.ui.schema.field.Field();
			fields.add(field);

			if (f.getType().equals(Integer.class) || f.getType().equals(Long.class) || f.getType().equals(Short.class) || f.getType().equals(Byte.class) || f.getType().equals(BigInteger.class)) {

				field.setNumber(default_.getNumber());

			} else if (f.getType().equals(Double.class) || f.getType().equals(Float.class) || f.getType().equals(BigDecimal.class)) {

				field.setDecimal(default_.getDecimal());

			} else if (f.getType().equals(String.class) || f.getType().equals(StringBuilder.class) || f.getType().equals(StringBuffer.class)) {

				field.setText(default_.getText());

			} else if (f.getType().equals(StringBuilder.class) || f.getType().equals(StringBuffer.class)) {

				field.setTextarea(default_.getTextarea());

			} else if (f.getType().equals(LocalDate.class)) {

				field.setDate(default_.getDate(false));

			} else if (f.getType().equals(LocalDateTime.class)) {

				field.setDate(default_.getDate(true));

			} else if (f.getType().equals(Boolean.class)) {

				field.setCheckbox(default_.getCheckbox());

			} else if (Collection.class.isAssignableFrom(f.getType())) {
				
				List<Object> options = new ArrayList<>();
				
				options.add("value_1");
				options.add("value_2");
				options.add("value_3");
				options.add("value_4");

				field.setSelect(default_.getSelect(options));

			} else if (!extractIsJavaLangType(f.getType())) {

				field.setJoin(default_.getJoin(f.getType().getSimpleName()));
				count--;
				
			} else if (f.getType() == Object.class) {

				field.setHidden(default_.getHidden());
				count--;
			}

			//System.out.println(" - " + f.getName() + ": " + f.getType().getName());
			
			count++;
		}

		return form;
	}

	/**
	 * @param object
	 * @param recursive
	 * @return
	 */
	private static List<Field> extractFieldsDomain(Object object, boolean recursive) {
		List<Field> fields = new ArrayList<>();
		if (recursive) {
			Set<Class<?>> visited = new HashSet<>();
			extractFieldsRecursively(object.getClass(), Object.class, visited, fields);
		} else {
			extractFields(object.getClass(), Object.class, fields, ".*");
		}
		return fields;
	}

	/**
	 * @param clazz
	 * @param classLimit
	 * @param visited
	 * @param pattern
	 */
	private static void extractFields(Class<?> clazz, Class<?> classLimit, List<Field> visited, String pattern) {
		if (clazz != null && !clazz.equals(classLimit)) {
			for (Field field : clazz.getDeclaredFields()) {
				if (!visited.contains(field) && field.getName().matches(pattern)) {
					visited.add(field);
				}
			}
			extractFields(clazz.getSuperclass(), classLimit, visited, pattern);
		}
	}

	/**
	 * @param clazz
	 * @param classLimit
	 * @param visited
	 * @param result
	 */
	private static void extractFieldsRecursively(Class<?> clazz, Class<?> classLimit, Set<Class<?>> visited, List<Field> result) {
		if (clazz == null || clazz.equals(classLimit) || visited.contains(clazz))return;
		visited.add(clazz);
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			Class<?> fieldType = field.getType();
			if (extractIsJavaLangType(fieldType)) {
				result.add(field);
			} else {
				result.add(field);
				extractFieldsRecursively(fieldType, classLimit, visited, result);
			}
		}
		extractFieldsRecursively(clazz.getSuperclass(), classLimit, visited, result);
	}

	/**
	 * @param clazz
	 * @return
	 */
	private static boolean extractIsJavaLangType(Class<?> clazz) {
		return clazz.isPrimitive() || clazz.getName().startsWith("java.lang") || clazz.equals(LocalDate.class) || clazz.equals(LocalDateTime.class);
	}

	/**
	 * GET REFLECTION
	 */
	public static Object executeGetMethod(String methodName, Object object) {
		Method method = getMethod(object.getClass(), methodName);
		if (method != null) {
			try {
				return method.invoke(object);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @param <T>
	 * @param clazz
	 * @param methodName
	 * @param paramClass
	 * @return
	 */
	@SafeVarargs
	private static <T> Method getMethod(Class<T> clazz, String methodName, Class<T>... paramClass) {
		Method m = null;
		try {
			m = clazz.getDeclaredMethod(methodName, paramClass);
		} catch (Exception e) {
			try {
				m = clazz.getMethod(methodName, paramClass);
			} catch (Exception e1) {
				Method[] ms = clazz.getMethods();
				for (Method mtmp : ms) {
					if (mtmp.getName().equals(methodName)) {
						m = mtmp;
						break;
					}
				}
			}
		}
		return m;
	}
}