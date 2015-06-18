package com.sample.utils;

/**
 * Utility class for String operations 
 * @author Prakash
 * @since 2015-06-18
 */
public class StringUtils {
	
		
	/**
	 * Returns true if given string has all unique characters
	 * @param input
	 * @return
	 */
	public static boolean HasUniqueCharacters(String input)
	{
		boolean[] chars = new boolean[256];
		
		for (char c : input.toCharArray()) {
			if (chars[c]) {
				return false;
			}
			
			chars[c] = true;
		}
		
		return true;
	}

}
