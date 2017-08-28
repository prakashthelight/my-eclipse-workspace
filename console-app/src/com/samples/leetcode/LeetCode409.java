package com.samples.leetcode;

/**
 * Longest Palindrome
 * https://leetcode.com/problems/longest-palindrome
 * @author Kumar, Prakash
 *
 */
public class LeetCode409 {

	public static void main(String[] args) {
		String s = "abccccdd";
		
		// longest possible palindrome
		System.out.println(longestPalindrome(s));
	}

	/**
	 * return length of longest possible palindrome from given string
	 * @param s
	 * @return
	 */
	public static int longestPalindrome(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int[] lowerChars = new int[26];
		int[] upperChars = new int[26];

		for (char ch : s.toCharArray()) {
			if ('a' <= ch && ch <= 'z') {
				lowerChars[ch - 'a']++;
			} else if ('A' <= ch && ch <= 'Z') {
				upperChars[ch - 'A']++;
			}
		}
		
		int maxLength = 0;
		int oddCount = 0;
		
		// add all even and odd occurences to maxLength and count all odd occurences
		for (int count : lowerChars) {
			maxLength += count;
			if (count % 2 != 0) {
				oddCount++;
			}
		}

		// add all even and odd occurences to maxLength and count all odd occurences
		for (int count : upperChars) {
			maxLength += count;
			if (count % 2 != 0) {
				oddCount++;
			}
		}
		
		return oddCount == 0 ? maxLength : maxLength - (oddCount - 1);
	}

}
