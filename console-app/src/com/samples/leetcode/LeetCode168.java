package com.samples.leetcode;

/**
 * Excel Sheet Column Title
 * https://leetcode.com/problems/excel-sheet-column-title
 * @author Kumar, Prakash
 *
 */
public class LeetCode168 {

	public static void main(String[] args) {
		int num = 1;
		
		System.out.println(convertToTitle(num));
	}

	/**
	 * converts number to excel column name
	 * @param n
	 * @return
	 */
	public static String convertToTitle(int n) {

		StringBuilder sb = new StringBuilder();

		while (n != 0) {
			char ch = (char) ((n - 1) % 26 + 65);
			n = (n - 1) / 26;
			sb.append(ch);
		}

		return sb.reverse().toString();
	}
}
