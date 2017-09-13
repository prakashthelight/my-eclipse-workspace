package com.samples.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Anagrams in a String <br/>
 * https://leetcode.com/problems/find-all-anagrams-in-a-string
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode438 {

	public static void main(String[] args) {
		String s = "cbaebabacd"; // 'cba' and 'bac' are anagram of 'abc'
		String p = "abc";

		System.out.println(findAnagrams(s, p));

	}

	static char[] pCharCounts = new char[26];

	/**
	 * returns indeces of all anagram strings in string s for given string p
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static List<Integer> findAnagrams(String s, String p) {

		// list of start index for all anagrams of p in s
		List<Integer> list = new ArrayList<>();

		if (s == null || s.length() < p.length()) {
			return list;
		}

		int m = s.length();
		int n = p.length();

		// keeps count of each character in p
		for (int i = 0; i < n; i++) {
			pCharCounts[p.charAt(i) - 'a']++;
		}

		for (int i = 0; i < m - n + 1; i++) {
			String temp = s.substring(i, i + n);

			// see if temp can be created using all characters in p
			if (isAnagram(temp)) {
				list.add(i);
			}
		}

		return list;
	}

	/**
	 * returns true if string is anagram of target string p
	 * 
	 * @param temp
	 * @return
	 */
	public static boolean isAnagram(String temp) {
		char[] charCounts = new char[26];

		for (int i = 0; i < temp.length(); i++) {
			charCounts[temp.charAt(i) - 'a']++;
		}

		for (int i = 0; i < pCharCounts.length; i++) {
			if (pCharCounts[i] != charCounts[i]) {
				return false;
			}
		}

		return true;
	}

}
