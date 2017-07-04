package com.samples.leetcode;

public class LeetCode344 {

	public static void main(String[] args) {
		System.out.println(reverseString("hello"));
	}

	/**
	 * reverse given string
	 * @param s
	 * @return
	 */
	public static String reverseString(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}

		char[] chars = s.toCharArray();

		int i = 0;
		int j = chars.length - 1;

		while (i < j) {
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;

			i++;
			j--;
		}

		return new String(chars);

	}
}
