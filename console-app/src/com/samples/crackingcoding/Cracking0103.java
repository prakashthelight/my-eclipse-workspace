package com.samples.crackingcoding;

/**
 * Replace spaces with '%20'
 * Cracking Coding Interview - Chapter 01, Solution 03
 * @author Kumar, Prakash
 *
 */
public class Cracking0103 {

	public static void main(String[] args) {
		String str = "My name is Prakash Kumar.        ";
		System.out.println(urlify(str));
	}

	/**
	 * encode string by replacing space with "%20", given that string has
	 * additional spaces in the end.
	 * 
	 * @param str
	 * @return
	 */
	public static String urlify(String str) {

		if (str == null || str.isEmpty()) {
			return str;
		}

		char[] chars = str.toCharArray();

		int j = str.length() - 1;
		int k = j;
		while (k >= 0 && chars[k] == ' ') {
			k--;
		}

		// if all string was just spaces
		if (k == -1) {
			return str;
		}

		while (k >= 0 && j >= 0) {
			if (chars[k] != ' ') {
				chars[j--] = chars[k--];
			} else {
				chars[j--] = "%20".charAt(2);
				chars[j--] = "%20".charAt(1);
				chars[j--] = "%20".charAt(0);
				k--;
			}
		}

		return new String(chars);
	}
}
