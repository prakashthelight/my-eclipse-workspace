package com.samples.leetcode;

/**
 * Factorial Trailing Zeroes <br/>
 * https://leetcode.com/problems/factorial-trailing-zeroes
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode172 {

	public static void main(String[] args) {
		System.out.println(trailingZeroes(10));
	}

	/**
	 * returns number of trailing zeros in n!
	 * @param n
	 * @return
	 */
	public static int trailingZeroes(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}
}
