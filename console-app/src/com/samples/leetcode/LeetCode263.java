package com.samples.leetcode;

/**
 * Ugly Number
 * https://leetcode.com/problems/ugly-numbe
 * @author Kumar, Prakash
 *
 */
public class LeetCode263 {

	public static void main(String[] args) {
		System.out.println(isUgly(12));
		System.out.println(isUgly(14));
	}

	/**
	 * returns true if number is ugly number i.e. its factor include just 2, 3, and 5
	 * @param num
	 * @return
	 */
	public static boolean isUgly(int num) {

		if (num <= 0) {
			return false;
		}
		
		int[] factors = {2, 3, 5};
		
		for (int factor : factors) {
			while (num % factor == 0) {
				num /= factor;
			}
		}
		
		return num == 1;
	}
}
