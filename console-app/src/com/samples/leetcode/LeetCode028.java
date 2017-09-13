package com.samples.leetcode;

import java.util.Hashtable;

/**
 * Implement strStr() <br/>
 * https://leetcode.com/problems/implement-strstr
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode028 {

	public static void main(String[] args) {
		System.out.println(searchString("aabaabbbaabbbbabaaab", "abaa"));
		System.out.println(searchString("ababbbbaaabbbaaa", "bbbb"));
		System.out.println(searchString("mississippi", "issipi"));
		System.out.println(searchString("mississippi", "issi"));
		System.out.println(searchString("mississippi", "pi"));
	}

	/**
	 * search pattern in given source string - Boyer–Moore string search
	 * algorithm
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static int searchString(String source, String pattern) {
		int index = -1;

		Hashtable<Character, Integer> badMatchTable = new Hashtable<>();

		for (int i = 0; i < pattern.length(); i++) {
			badMatchTable.put(pattern.charAt(i), i);
		}

		int defaultShift = pattern.length();

		int current = pattern.length() - 1;
		int k = current;
		int j = 0;

		while (j < pattern.length() && current < source.length()) {
			if (source.charAt(k) == pattern.charAt(defaultShift - j - 1)) {
				k--;
				j++;
			} else {
				char ch = source.charAt(k);

				int shift = -1;
				if (badMatchTable.containsKey(ch)) {
					shift = badMatchTable.get(ch);
				}

				shift = Math.max(1, k - shift);

				current = current + shift;
				k = current;
				j = 0;
			}
		}

		if (j == pattern.length()) {
			index = k + 1;
		}

		return index;
	}
}
