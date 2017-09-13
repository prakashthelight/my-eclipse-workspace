package com.samples.leetcode;

/**
 * Hamming Distance <br/>
 * https://leetcode.com/problems/hamming-distance
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode461 {

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
	}

	/**
	 * return happing distance between two intergers <br/>
	 * (position count where their bits does not match)
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int hammingDistance(int x, int y) {

		int count = 0;
		// while x and y are greater than 0
		while (x != 0 && y != 0) {
			// if there last bits differ
			if ((x & 1) != (y & 1)) {
				count++;
			}

			// right both for checking next bits
			x >>= 1;
			y >>= 1;
		}

		// if x is greater than y and hence still greater than 0
		while (x != 0) {
			if ((x & 1) == 1) {
				count++;
			}
			x >>= 1;
		}

		// if y is greater than x and hence still greater than 0
		while (y != 0) {
			if ((y & 1) == 1) {
				count++;
			}
			y >>= 1;
		}

		return count;
	}
}
