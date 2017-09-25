package com.samples.leetcode;

/**
 * Excel Sheet Column Number <br/>
 * https://leetcode.com/problems/excel-sheet-column-number
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode171 {

	public static void main(String[] args) {
		System.out.println(titleToNumber("AA"));
		System.out.println(titleToNumber("AB"));
	}

	/**
	 * return excel sheet titles as number
	 * 
	 * @param s
	 * @return
	 */
	public static int titleToNumber(String s) {

		if (s == null || s.length() == 0)
			return 0;

		int m = 1;
		int column = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			int value = s.charAt(i) - 'A' + 1;
			column += value * m;
			m *= 26;
		}

		return column;
	}
}
