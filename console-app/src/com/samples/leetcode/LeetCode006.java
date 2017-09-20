package com.samples.leetcode;

/**
 * ZigZag Conversion <br/>
 * https://leetcode.com/problems/zigzag-conversion
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode006 {

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 3;

		/**
		 * PAYPALISHIRING ->
		 * P   A   H   N
		 * A P L S I I G
		 * Y   I   R
		 */
		System.out.println(convert(s, numRows));
	}

	/**
	 * returns string converted zigzag pattern
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {

		if (s == null || s.length() == 0 || numRows < 1) {
			return "";
		}

		char[] chars = s.toCharArray();

		// array of StringBuilder for each row, declared and initialized
		StringBuilder[] sbs = new StringBuilder[numRows];
		for (int i = 0; i < sbs.length; i++) {
			sbs[i] = new StringBuilder();
		}

		int i = 0;
		int length = chars.length;
		while (i < length) {
			
			// fill each row with one character - down
			for (int index = 0; index < numRows && i < length; index++) {
				sbs[index].append(chars[i++]);
			}

			// fill form second last (numRows - 2) to second (1) with one character - up
			for (int index = numRows - 2; index >= 1 && i < length; index--) {
				sbs[index].append(chars[i++]);
			}
		}

		// merge all string builder content to first one
		for (int index = 1; index < sbs.length; index++) {
			sbs[0].append(sbs[index]);
		}

		return sbs[0].toString();
	}
}
