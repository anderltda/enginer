package br.com.enginer.domain.ui.usercase.utils;

import br.com.enginer.domain.ui.usercase.exception.CheckedException;

public class StringsUtils {

	/**
	 * @param value
	 * @return
	 */
	public static String setMethod(String value) {
		return "set".concat(firstUpper(value));
	}

	/**
	 * @param value
	 * @return
	 */
	public static String getMethod(String value) {
		return "get".concat(firstUpper(value));
	}

	/**
	 * @param name
	 * @return
	 */
	public static String firstUpper(String name) {
		String returnValue = name.substring(0, 1).toUpperCase();
		if (name.length() > 1)
			returnValue += name.substring(1);
		return returnValue;
	}
	
	/**
	 * @param name
	 * @return
	 */
	public static String firstLower(String name) {
		String returnValue = name.substring(0, 1).toLowerCase();
		if (name.length() > 1)
			returnValue += name.substring(1);
		return returnValue;
	}
	
	/**
	 * @param className
	 * @return
	 * @throws CheckedException
	 */
	public static String getNameUserCase(String className) throws CheckedException {
		try {
			return className + "UserCase";
		} catch (Exception ex) {
			throw new CheckedException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * @param clazz
	 * @return
	 */
	public static String convertDtoToUsercasePackage(Class<?> clazz) {
	    String fullClassName = clazz.getName();
	    int dtoIndex = fullClassName.indexOf(".dto.");
	    if (dtoIndex == -1) {
	        throw new IllegalArgumentException("Pacote 'dto' não encontrado na classe: " + fullClassName);
	    }
	    String basePackage = fullClassName.substring(0, dtoIndex);
	    return getNameUserCase(basePackage.concat(".usercase.").concat(clazz.getSimpleName()));
	}

	/**
	 * Formatar atributo para uma formacao ex: Prohibited Date Time ou
	 * ProhibitedDateTime para isso prohibitedDateTime
	 * 
	 * @param input - valor a ser formatado
	 * @return
	 */
	public static String normalizeToCamelCaseFromPascalCase(String input) {
	    if (input == null || input.isEmpty()) return input;

	    return input.substring(0, 1).toLowerCase() + input.substring(1);
	}

	/**
	 * Formatar atributo para uma formacao ex: prohibitedDateTime para isso
	 * Prohibited Date Time
	 * 
	 * @param input - valor a ser formatado
	 * @return
	 */
	public static String normalizeLabelToLowercaseCamelization(String input) {
		if (input == null || input.isEmpty())
			return input;

		String spaced = input.replaceAll("([a-z])([A-Z])", "$1 $2");
		String[] words = spaced.split(" ");
		StringBuilder builder = new StringBuilder();
		for (String word : words) {
			if (!word.isEmpty()) {
				builder.append(Character.toUpperCase(word.charAt(0)));
				builder.append(word.substring(1));
				builder.append(" ");
			}
		}
		return builder.toString().trim();
	}

}
