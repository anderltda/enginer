package br.com.enginer.infrastructure.utils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import br.com.enginer.domain.ui.usercase.schema.instance.Domain;
import br.com.enginer.domain.ui.usercase.utils.ReflectionUtils;
import br.com.enginer.domain.ui.usercase.utils.StringsUtils;

public class NormalizeUtils {

	public static void normalize(JsonNode jsonNode, Domain<?> domain) {

		List<Field> fields = ReflectionUtils.extractFieldsDomain(domain, false);

		for (Field field : fields) {

			if (jsonNode.has(field.getName())) {
				System.out.println(StringsUtils.setMethod(field.getName()) + " = " + jsonNode.get(field.getName()));
				ReflectionUtils.set(domain, StringsUtils.setMethod(field.getName()),
						new Class<?>[] { identifyFieldClass(field.getType().getName()).getClass() },
						new Object[] { extractValueFromJson(field, jsonNode) });
			}
		}
	}

	private static Object identifyFieldClass(String instance) {
		try {
			ClassLoader classLoader = NormalizeUtils.class.getClassLoader();
			Class<?> main = classLoader.loadClass(instance);
			// Tratamento para tipos primitivos e wrappers
			if (main.equals(Integer.class))
				return 0;
			if (main.equals(Long.class))
				return 0L;
			if (main.equals(Double.class))
				return 0.0;
			if (main.equals(Boolean.class))
				return false;
			if (main.equals(String.class))
				return "";
			if (main.equals(LocalDate.class))
				return LocalDate.now();
			if (main.equals(LocalDateTime.class))
				return LocalDateTime.now();
			if (main.equals(Collection.class) || main.equals(List.class) || main.equals(Map.class))
			    return new ArrayList<>();
			
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

		System.out.println(fieldName);
		
		JsonNode valueNode = jsonNode.get(fieldName);
		if (valueNode == null || valueNode.isNull())
			return null;

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
			return parseToLocalDate(valueNode.asText());
		} else if (fieldType.equals(LocalDateTime.class)) {
			return parseToLocalDateTime(valueNode.asText());
		} else if (fieldType.isEnum()) {
			return Enum.valueOf((Class<Enum>) fieldType, valueNode.asText());
		} else if (Collection.class.isAssignableFrom(fieldType)) {
			Collection<Object> collection = new ArrayList<>();
			if (valueNode.isArray()) {
				for (JsonNode item : valueNode) {
					collection.add(item.asText());
				}
			}
			return collection;
		} else {
			Domain<?> domain = (Domain<?>) identifyFieldClass(field.getType().getName());
			normalize(jsonNode.get(field.getName()), domain);
			return domain;
		}
	}

	/**
	 * Converte uma string ISO 8601 em LocalDate, ignorando hora/fuso se presente.
	 * Aceita formatos como: - 2025-04-16 - 2025-04-16T03:00:00 -
	 * 2025-04-16T03:00:00.000Z
	 * 
	 * @param isoDateTime string em formato ISO
	 * @return LocalDate
	 * @throws IllegalArgumentException se a string não for parseável
	 */
	public static LocalDate parseToLocalDate(String isoDateTime) {
		try {
			// Caso seja apenas a data
			return LocalDate.parse(isoDateTime);
		} catch (DateTimeParseException e1) {
			try {
				// Caso contenha hora, mas sem fuso (ex: 2025-04-16T03:00:00)
				return LocalDateTime.parse(isoDateTime).toLocalDate();
			} catch (DateTimeParseException e2) {
				try {
					// Caso contenha fuso Z ou offset (ex: 2025-04-16T03:00:00.000Z)
					return OffsetDateTime.parse(isoDateTime).toLocalDate();
				} catch (DateTimeParseException e3) {
					throw new IllegalArgumentException("Data inválida: " + isoDateTime);
				}
			}
		}
	}

	/**
	 * Converte uma string ISO 8601 para LocalDateTime, ignorando fuso horário se
	 * presente. Aceita formatos como: - 2025-04-16T03:00:00 -
	 * 2025-04-16T03:00:00.000Z - 2025-04-16T03:00:00.000-03:00
	 *
	 * @param isoString string ISO
	 * @return LocalDateTime correspondente
	 * @throws IllegalArgumentException se a string não puder ser convertida
	 */
	public static LocalDateTime parseToLocalDateTime(String isoString) {
		try {
			// Exato LocalDateTime
			return LocalDateTime.parse(isoString);
		} catch (DateTimeParseException e1) {
			try {
				// OffsetDateTime com fuso -> extrai o LocalDateTime
				return OffsetDateTime.parse(isoString).toLocalDateTime();
			} catch (DateTimeParseException e2) {
				throw new IllegalArgumentException("Data/hora inválida: " + isoString);
			}
		}
	}

}
