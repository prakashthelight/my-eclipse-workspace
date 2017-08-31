package com.samples.leetcode;

/**
 * Divide Two Integers 
 * https://leetcode.com/problems/divide-two-integers
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode029 {

	public static void main(String[] args) {
		int dividend = -2147483648;
		int divisor = 2;

		System.out.print(divide(dividend, divisor));
	}

	/**
	 * divide two integers without using division, multiplication and modulus
	 * operation
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int divide(int dividend, int divisor) {

		if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
			return Integer.MAX_VALUE;
		}

		if (divisor == 1) {
			return dividend;
		}

		boolean isPositive = true;
		if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
			isPositive = false;
		}

		long dividendL = dividend == Integer.MIN_VALUE ? (long) Integer.MAX_VALUE + 1 : Math.abs((long) dividend);
		long divisorL = Math.abs((long) divisor);

		if (dividendL < divisorL) {
			return 0;
		}

		int result = 0;
		while (dividendL >= divisorL) {

			long temp = divisorL, multiple = 1;

			while (dividendL >= (temp << 1)) {
				temp <<= 1; // multiply by 2
				multiple <<= 1; // multiply by 2
			}

			dividendL -= temp;
			result += multiple;
		}

		return isPositive ? result : -result;
	}
}
