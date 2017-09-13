package com.samples.leetcode;

/**
 * Longest Common Prefix <br/>
 * https://leetcode.com/problems/longest-common-prefix
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode014 {

	public static void main(String[] args) {
		String[] strs = { "leet", "leetcode", "leet", "leeds" };

		System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));

		System.out
				.println("Longest Common Prefix using Binary Search: " + longestCommonPrefix(strs, 0, strs.length - 1));
	}

	/**
	 * returns longest common prefix
	 * 
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		String prefix = strs[0];

		// find common prefix between first and second element and keep reducing
		// it if needed
		// when comparing with next strings
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}

		return prefix;
	}

	public static String longestCommonPrefix(String[] strs, int start, int end) {
		if (start == end) {
			return strs[start];
		} else {
			int mid = (start + end) / 2;
			String commonPrefixInLeft = longestCommonPrefix(strs, start, mid);
			String commonPrefixInRight = longestCommonPrefix(strs, mid + 1, end);

			return commonPrefix(commonPrefixInLeft, commonPrefixInRight);
		}
	}

	private static String commonPrefix(String str1, String str2) {
		String prefix = str1;

		while (str2.indexOf(prefix) == -1) {
			prefix = prefix.substring(0, prefix.length() - 1);
		}

		return prefix;
	}

}
