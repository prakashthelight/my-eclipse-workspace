package com.samples.leetcode;

/**
 * String to Integer (atoi) <br/>
 * https://leetcode.com/problems/string-to-integer-atoi
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode008 {

	public static void main(String[] args) {
		System.out.println(myAtoi("000123000"));
		System.out.println(myAtoi("-123"));
		System.out.println(myAtoi("  23abc"));
		System.out.println(myAtoi("2147483648"));
	}

	/**
	 * converts string to integer
	 * 
	 * @param str
	 * @return
	 */
	public static int myAtoi(String str) {

		if (str == null || str.length() == 0)
			return 0;

		// trim for leading and trailing spaces
		str = str.trim();
		if (str.isEmpty()) {
			return 0;
		}

		int len = str.length();

		boolean isNegative = false;

		int num = 0;

		// reading from left to right
		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);

			// if the first character is a sign character
			if (i == 0 && (ch == '+' || ch == '-')) {
				isNegative = ch == '-';
				continue;
			}

			if (ch >= '0' && ch <= '9') {
				int digit = ch - 48;

				// check for overflow
				if (Integer.MAX_VALUE / 10 < num || Integer.MAX_VALUE / 10 == num && Integer.MAX_VALUE % 10 < digit) {
					return !isNegative ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}

				num = num * 10 + digit;
			} else {
				break;
			}
		}

		return isNegative ? -num : num;
	}
}
