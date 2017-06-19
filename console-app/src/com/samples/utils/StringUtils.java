package com.samples.utils;

public class StringUtils {

	/**
	 * reverse statement by words i.e. last word becomes first
	 * @param str
	 * @return
	 */
	public static String reverseByWord(String str) {
		
		int i = 0;
		int j = 0;
		char[] array = str.toCharArray();

		while (i < array.length) {
			// reverse each word
			if (array[i] == ' ') {
				reverse(array, j, i - 1);
				j = i + 1;
			}
			
			i++;
		}

		// reverse last word
		reverse(array, j, array.length - 1);

		// reverse statement again
		reverse(array, 0, array.length - 1);

		return String.valueOf(array);
	}
	
	/**
	 * reverse char array
	 * @param array
	 * @param start
	 * @param end
	 */
	public static void reverse(char[] array, int start, int end) {

		while (start < end) {
			char temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
}
