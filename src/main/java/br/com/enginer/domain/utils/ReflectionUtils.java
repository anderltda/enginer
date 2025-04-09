package br.com.enginer.domain.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import br.com.enginer.domain.ui.schema.field.type.Id;

public class ReflectionUtils {

	/**
	 * @param object
	 * @param recursive
	 * @return
	 */
	public static List<Field> extractFieldsDomain(Object object, boolean recursive) {
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
	private static void extractFieldsRecursively(Class<?> clazz, Class<?> classLimit, Set<Class<?>> visited,
			List<Field> result) {
		if (clazz == null || clazz.equals(classLimit) || visited.contains(clazz))
			return;
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
	public static boolean extractIsJavaLangType(Class<?> clazz) {
		return clazz.isPrimitive() || clazz.getName().startsWith("java.lang") || clazz.equals(LocalDate.class)
				|| clazz.equals(LocalDateTime.class) || clazz.equals(Id.class);
	}
	
	/**
	 * CONVERTE ID<T>
	 */
	
	
	/**
	 * @param <T>
	 * @param inputId
	 * @param expectedType
	 * @return
	 */
	public static <T> Id<T> convertIdToExpectedType(Id<?> inputId, Class<T> expectedType) {
		
		Object rawValue = inputId.getValue();

		if (rawValue == null) {
			return Id.of(null);
		}

		if (expectedType.isInstance(rawValue)) {
			return Id.of(expectedType.cast(rawValue));
		}

		// Conversão comum
		try {
			
			if (expectedType.equals(Long.class)) {
				return Id.of(expectedType.cast(Long.valueOf(rawValue.toString())));
			} else if (expectedType.equals(Integer.class)) {
				return Id.of(expectedType.cast(Integer.valueOf(rawValue.toString())));
			} else if (expectedType.equals(UUID.class)) {
				return Id.of(expectedType.cast(UUID.fromString(rawValue.toString())));
			} else if (expectedType.equals(String.class)) {
				return Id.of(expectedType.cast(rawValue.toString()));
			}
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Falha ao converter Id para tipo esperado: " + expectedType.getSimpleName(), e);
		}

		return Id.of(expectedType.cast(rawValue));
	}

	/**
	 * SET REFLECTION
	 */
	public static void set(Object object, String methodName, Class<?>[] paramClass, Object[] paramValue) {
		try {
			Method method = object.getClass().getMethod(methodName, paramClass);
			if (method != null) {
				method.invoke(object, paramValue);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * GET REFLECTION
	 */
	public static Object set(String methodName, Object object) {
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