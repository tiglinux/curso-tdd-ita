package camelCase;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import camelCase.exceptions.CamelCaseException;

/**
 * @author Tiago Santos
 */

public class CamelCaseToString {
	
	public static final String START_WITH_NUMBER = "^[0-9].*";
	public static final String HAS_SPECIAL_CHARACTER = "[^a-zA-Z0-9]+";
	public static final String SEPARATE_WORDS = "(?<!(^|[A-Z0-9]))(?=[A-Z0-9])|(?<!(^|[^A-Z]))(?=[0-9])|(?<!(^|[^0-9]))(?=[A-Za-z])|(?<!^)(?=[A-Z][a-z])";
	public static final String INVALID_START_ERROR = "Palavra nao deve começar com numeros";
	private static final String INVALID_CHARACTER_MESSAGE = "Palavra contem caracteres especiais não são permitidos, somente letras e números";
	private static final String INVALID_STRING = "Palavra não pode ser null ou vazia";
	
	public static List<String> converterCamelCase(String original){
		
		if(original.matches(START_WITH_NUMBER)) {
			throw new CamelCaseException(INVALID_START_ERROR);
		}
		
		if(original.matches(HAS_SPECIAL_CHARACTER)) {
			throw new CamelCaseException(INVALID_CHARACTER_MESSAGE);
		}
		
		if(!isValidString(original)) {
			throw new CamelCaseException(INVALID_STRING);
		}
		
		if(isNumberBetweenString(original)) {
			return numberBetweenStringCamelCase(original);
		}
		
		String[] splitStr = original.split(SEPARATE_WORDS);
		
		return convertToLowerCase(splitStr);
		
	}
	
	public static List<String> numberBetweenStringCamelCase(String str) {
		
		Pattern ptt = Pattern.compile("[A-Za-z]+|[0-9]+");
		Matcher mtr = ptt.matcher(str);
		
		List<String> strList = new ArrayList<String>();
		
		while (mtr.find()) {
			strList.add(mtr.group().trim());
		}
		

		String[] strSplit = new String[strList.size()];
		return convertToLowerCase(strList.toArray(strSplit));
	}

	public static boolean isNumberBetweenString(String str){
		return (str.matches("((.*)([0-9]+)(.*))"));
	}
	
	public static boolean isValidString(String original) {
		return ((original != null) && (original.trim().length() > 0));
	}
	
	private static List<String> convertToLowerCase(String[] array) {
		
		List<String> strList = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			if (!array[i].isEmpty()) {
				if (array[i].equals(array[i].toUpperCase())) {
					strList.add(array[i]);
				} else {
					strList.add(array[i].toLowerCase());
				}
			}
		}
		return strList;
	}	
	
}
