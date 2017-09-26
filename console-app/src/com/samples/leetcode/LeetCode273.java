package com.samples.leetcode;

/**
 * Integer to English Words <br/>
 * https://leetcode.com/problems/integer-to-english-words
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode273 {

	private static final String[] ones = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	private static final String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
			"Eighty", "Ninety" };
	private static final String[] others = { "", "Thousand", "Million", "Billion" };

	public static void main(String[] args) {
		
		int num = 1_020_275;
		System.out.println(numberToWords(num));
	}

	public static String numberToWords(int num) {
		if (num == 0) {
			return ones[0];
		}

		int i = 0;
		String result = "";

		while (num > 0) {
			if (num % 1_000 != 0) {
				result = convertIntegerToString(num % 1000) + others[i] + " " + result;
			}

			num /= 1_000;
			i++;
		}

		return result.trim();
	}

	public static String convertIntegerToString(int num) {
		if (num == 0) {
			return "";
		} else if (num < 20) {
			return ones[num] + " ";
		} else if (num < 100) {
			return tens[num / 10] + " " + convertIntegerToString(num % 10);
		} else {
			return ones[num / 100] + " Hundred " + convertIntegerToString(num % 100);
		}
	}
}
