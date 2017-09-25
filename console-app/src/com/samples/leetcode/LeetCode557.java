package com.samples.leetcode;

/**
 * Reverse Words in a String III <br/>
 * https://leetcode.com/problems/reverse-words-in-a-string-iii
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode557 {

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		
		System.out.println(reverseWords(s));
	}

	public static String reverseWords(String s) {
		if (s == null || s.length() <= 1)
			return s;

		char[] chars = s.toCharArray();
		int start = 0;
		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] == ' ') {
				int end = i - 1;
				reverse(chars, start, end);
				start = i + 1;
			}
		}

		reverse(chars, start, chars.length - 1);

		return String.valueOf(chars);
	}

	public static void reverse(char[] chars, int start, int end) {
		int i = start;
		int j = end;

		while (i < j) {
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
			j--;
			i++;
		}
	}
}
