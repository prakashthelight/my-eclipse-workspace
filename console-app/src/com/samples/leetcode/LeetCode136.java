package com.samples.leetcode;

/**
 * Single Number 
 * https://leetcode.com/problems/single-number
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode136 {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3, 4, 5, 4, 3, 2 };
		System.out.println(singleNumber(nums));
	}

	/**
	 * returns number appearing just once in an array with all elements
	 * appearing twice
	 * 
	 * @param nums
	 * @return
	 */
	public static int singleNumber(int[] nums) {
		int result = nums[0];

		for (int i = 1; i < nums.length; i++) {
			result ^= nums[i];
		}

		return result;
	}

}
