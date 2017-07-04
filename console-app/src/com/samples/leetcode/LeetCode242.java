package com.samples.leetcode;

import java.util.Hashtable;

public class LeetCode242 {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
	}

	public static boolean isAnagram(String s, String t) {
		if (s == null || t == null) {
			return false;
		}

		if (s.length() != t.length()) {
			return false;
		}

		Hashtable<Character, Integer> table = new Hashtable<>();
		for (char ch : s.toCharArray()) {
			if (table.containsKey(ch)) {
				table.put(ch, table.get(ch) + 1);
			} else {
				table.put(ch, 1);
			}
		}

		boolean isAnagram = true;
		for (char ch : t.toCharArray()) {
			if (table.containsKey(ch)) {
				int count = table.get(ch);
				if (count == 0) {
					isAnagram = false;
					break;
				} else {
					table.put(ch, count - 1);
				}
			} else {
				isAnagram = false;
				break;
			}
		}

		return isAnagram;
	}

}
