package br.com.enginer.domain.utils;

public class StringsUtils {

	public static String setMethod(String value) {
		return "set".concat(firstUpper(value));
	}

	public static String getMethod(String value) {
		return "get".concat(firstUpper(value));
	}

	public static String firstUpper(String name) {
		String returnValue = name.substring(0, 1).toUpperCase();
		if (name.length() > 1)
			returnValue += name.substring(1);
		return returnValue;
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
