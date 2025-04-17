package br.com.enginer.infrastructure.utils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import br.com.enginer.domain.ui.usercase.utils.ReflectionUtils;
import br.com.enginer.domain.ui.usercase.utils.StringsUtils;

public class NormalizeUtils {

	public static void normalize(JsonNode jsonNode, Domain<?> domain) {

		List<Field> fields = ReflectionUtils.extractFieldsDomain(domain, false);

		System.out.println(domain);

		for (Field field : fields) {

			if (jsonNode.has(field.getName())) {
				System.out.println(StringsUtils.setMethod(field.getName()) +" = "+ jsonNode.get(field.getName()));
				ReflectionUtils.set(domain, StringsUtils.setMethod(field.getName()), new Class<?>[] { identifyFieldClass(field.getType().getName()).getClass() }, new Object[] { extractValueFromJson(field, jsonNode) });
			}
		}
	}
	
	private static Object identifyFieldClass(String instance) {
		try {
			ClassLoader classLoader = NormalizeUtils.class.getClassLoader();
			Class<?> main = classLoader.loadClass(instance);
			// Tratamento para tipos primitivos e wrappers
			if (main.equals(Integer.class)) return 0;
			if (main.equals(Long.class)) return 0L;
			if (main.equals(Double.class)) return 0.0;
			if (main.equals(Boolean.class)) return false;
			if (main.equals(String.class)) return "";
			if (main.equals(LocalDate.class)) return LocalDate.now();
			if (main.equals(LocalDateTime.class)) return LocalDateTime.now();
			// Caso seja uma classe com construtor padrão
			return main.getDeclaredConstructor().newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private static Object extractValueFromJson(Field field, JsonNode jsonNode) {
	    String fieldName = field.getName();
	    Class<?> fieldType = field.getType();

	    JsonNode valueNode = jsonNode.get(fieldName);
	    if (valueNode == null || valueNode.isNull()) return null;

	    if (fieldType.equals(String.class)) {
	        return valueNode.asText();
	    } else if (fieldType.equals(Integer.class) || fieldType.equals(int.class)) {
	        return (Integer) valueNode.asInt();
	    } else if (fieldType.equals(Long.class) || fieldType.equals(long.class)) {
	        return (Long) valueNode.asLong();
	    } else if (fieldType.equals(Double.class) || fieldType.equals(double.class)) {
	        return (Double) valueNode.asDouble();
	    } else if (fieldType.equals(Boolean.class) || fieldType.equals(boolean.class)) {
	        return (Boolean) valueNode.asBoolean();
	    } else if (fieldType.equals(LocalDate.class)) {
	        return LocalDate.parse(valueNode.asText());
	    } else if (fieldType.equals(LocalDateTime.class)) {
	        return LocalDateTime.parse(valueNode.asText());
	    } else if (fieldType.isEnum()) {
	        return Enum.valueOf((Class<Enum>) fieldType, valueNode.asText());
	    } else {
	    	Domain<?> domain = (Domain<?>)identifyFieldClass(field.getType().getName());
	    	normalize(jsonNode.get(field.getName()), domain);
	    	return domain;
	    }
	}

}
