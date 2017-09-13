package com.samples.leetcode;

/**
 * Find the Difference <br/>
 * https://leetcode.com/problems/find-the-difference
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode389 {

	public static void main(String[] args) {
		System.out.println(findTheDifference("abcd", "abced"));
	}

	/**
	 * find additional character added to target string
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static char findTheDifference(String s, String t) {
		char result = '\u0000';
		// as string just have lower-case letters
		int[] charCounts = new int[26];

		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a'; // mapping 'a' to 0 index
			charCounts[index]++;
		}

		for (int i = 0; i < t.length(); i++) {
			int index = t.charAt(i) - 'a';
			charCounts[index]--;
			if (charCounts[index] == -1) {
				result = (char) (index + 'a');
			}
		}

		return result;
	}

}
