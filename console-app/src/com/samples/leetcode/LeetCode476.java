package com.samples.leetcode;

/**
 * Number Compliment <br/>
 * https://leetcode.com/problems/number-complement
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode476 {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(5) + " -> " + Integer.toBinaryString(findComplement(5)));
	}

	/**
	 * returns a compliment number i.e. number with flipped bits 101 -> 010
	 * 
	 * @param num
	 * @return
	 */
	public static int findComplement(int num) {
		if (num < 0)
			return -1;
		if (num == 0)
			return 1;
		if (num == 1)
			return 0;

		int newNum = 0;
		int multiplier = 1;
		while (num != 0) {
			newNum += ((num & 1) == 1 ? 0 : 1) * multiplier;
			multiplier *= 2;
			num >>= 1;
		}

		return newNum;
	}
}
