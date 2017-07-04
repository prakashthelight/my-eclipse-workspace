package com.samples.leetcode;

import java.util.HashSet;

public class LeetCode003 {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

	/**
	 * returns length of longest substring with unique characters
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		int start = 0;
		int max = 0;

		int index = 0;
		int length = s.length();

		// set of characters, having unique characters
		// and size of this chars will be the result;
		HashSet<Character> chars = new HashSet<>();
		while (index < length) {
			char ch = s.charAt(index);
			if (!chars.contains(ch)) {
				chars.add(ch);
				index++;
				max = Math.max(max, chars.size());
			} else {
				// keep removing till we remove this exact character added
				// previously
				chars.remove(s.charAt(start));
				start++;
			}
		}

		return max;
	}

}
