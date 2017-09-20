package com.samples.leetcode;

import java.util.Arrays;

/**
 * Plus One <br/>
 * https://leetcode.com/problems/plus-one
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode066 {

	public static void main(String[] args) {
		int[] digits = { 1, 2, 9 }; // 129

		digits = plusOne(digits);
		System.out.println(Arrays.toString(digits)); // [1, 3, 0]
	}

	/**
	 * adds one to number represented by given int array
	 * 
	 * @param digits
	 * @return
	 */
	public static int[] plusOne(int[] digits) {

		if (digits == null || digits.length == 0) {
			return digits;
		}

		int length = digits.length;
		for (int i = length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}

		int[] newNumber = new int[length + 1];
		newNumber[0] = 1;

		System.arraycopy(digits, 0, newNumber, 1, digits.length);

		return newNumber;
	}
}
