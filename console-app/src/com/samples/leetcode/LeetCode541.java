package com.samples.leetcode;

public class LeetCode541 {

	public static void main(String[] args) {
		System.out.println(reverseStr("abcdefg", 2));
	}

	/**
	 * special reverse, reverse each k characters in set of each 2*K characters
	 * @param s
	 * @param k
	 * @return
	 */
	public static String reverseStr(String s, int k) {

		char[] chars = s.toCharArray();

		int i = 0;
		int j = k - 1;
		int skip = 2 * k;

		if (j >= chars.length) {
			j = chars.length - 1;
		}

		while (j < chars.length) {
			reverseString(chars, i, j);
			i = i + skip;
			j = i + k - 1;

			if (i < chars.length && j >= chars.length) {
				j = chars.length - 1;
			}
		}

		return new String(chars);
	}

	public static String reverseString(char[] chars, int i, int j) {

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
