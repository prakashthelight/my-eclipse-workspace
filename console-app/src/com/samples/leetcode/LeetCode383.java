package com.samples.leetcode;

import java.util.HashMap;

/**
 * Ransom Note <br/>
 * https://leetcode.com/problems/ransom-note
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode383 {

	public static void main(String[] args) {
		String ransomNote = "aabc";
		String magazine = "aabbc";
		System.out.println(String.format("Can construct ransom note %s from %s : %s", ransomNote, magazine,
				canConstruct(ransomNote, magazine)));
	}

	/**
	 * returns true if given ransomNote can be made using characters in
	 * magazine.
	 * 
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public static boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> magazineMap = new HashMap<>();
		for (char ch : magazine.toCharArray()) {
			if (magazineMap.containsKey(ch)) {
				magazineMap.put(ch, magazineMap.get(ch) + 1);
			} else {
				magazineMap.put(ch, 1);
			}
		}

		// Make sure, if can all ransomNote characters in magazineMap characters
		for (char ch : ransomNote.toCharArray()) {
			if (!magazineMap.containsKey(ch) || magazineMap.get(ch) == 0) {
				return false;
			}

			magazineMap.put(ch, magazineMap.get(ch) - 1);
		}

		return true;
	}
}
