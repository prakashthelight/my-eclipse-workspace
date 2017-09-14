package com.samples.leetcode;

/**
 * Reverse Integer <br/>
 * https://leetcode.com/problems/reverse-integer
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode007 {

	public static void main(String[] args) {
		System.out.println(reverse(2354));
	}

	/**
	 * reverse a given integer
	 * @param num
	 * @return
	 */
	public static int reverse(int num) {

		int newInt = 0;

		boolean isNegative = false;
		if (num < 0) {
			isNegative = true;
			num *= -1;
		}

		while (num != 0) {

			if (Integer.MAX_VALUE / 10 < newInt) {
				return 0;
			}

			newInt *= 10;

			if (Integer.MAX_VALUE - num % 10 < newInt) {
				return 0;
			}

			newInt += num % 10;
			num = num / 10;
		}

		if (isNegative) {
			newInt *= -1;
		}

		return newInt;
	}

}
