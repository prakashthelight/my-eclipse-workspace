package com.samples.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Keyboard Row <br/>
 * https://leetcode.com/problems/keyboard-row
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode500 {

	public static void main(String[] args) {
		String[] words = { "Hello", "Alaska", "Dad", "Peace" };
		String[] validWords = findWords(words);
		System.out.println(Arrays.toString(validWords));
	}

	/**
	 * returns list of words which can be written using one row of keyboard
	 * 
	 * @param words
	 * @return
	 */
	public static String[] findWords(String[] words) {
		List<String> result = new ArrayList<String>();
		for (String word : words) {
			if (isFromOneLine(word)) {
				result.add(word);
			}
		}

		return result.toArray(new String[result.size()]);
	}

	/**
	 * returns true if all characters are from one line
	 * 
	 * @param word
	 * @return
	 */
	public static boolean isFromOneLine(String word) {
		if (word == null || word.length() < 1)
			return false;

		int row = -1;
		// iterater over characters in word to see if they
		// are from one row of keyboard

		for (char ch : word.toCharArray()) {
			// get row number for given character
			int newRow = getRow(ch);

			// for first iteration of loop
			if (row == -1) {
				row = newRow;
			}

			// whenever got char from another line return false;
			if (newRow != row) {
				return false;
			}
		}

		return true;
	}

	/**
	 * returns line number for character;
	 * 
	 * @param ch
	 * @return
	 */
	public static int getRow(char ch) {

		// first row
		if ("qwertyuiop".indexOf(Character.toLowerCase(ch)) != -1)
			return 0;
		// second row
		if ("asdfghjkl".indexOf(Character.toLowerCase(ch)) != -1)
			return 1;
		// thrid row
		if ("zxcvbnm".indexOf(Character.toLowerCase(ch)) != -1)
			return 2;
		return -1;
	}
}
