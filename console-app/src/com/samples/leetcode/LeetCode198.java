package com.samples.leetcode;

import java.util.Arrays;

/**
 * House Robber <br/>
 * https://leetcode.com/problems/house-robber
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode198 {
	public static void main(String[] args) {
		int[] houseMoney = new int[] { 12, 3, 4, 8, 10, 5, 29, 2 };
		System.out.println(rob(houseMoney));
	}

	/**
	 * 
	 * @param nums
	 * @return
	 */
	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] temp = new int[nums.length];

		// set array items as -1, as by default they are all set to 0
		Arrays.fill(temp, -1);

		return rob(nums, nums.length - 1, temp);
	}

	/**
	 * 
	 * @param nums
	 * @param n
	 * @param temp
	 * @return
	 */
	public static int rob(int[] nums, int n, int[] temp) {
		if (n == 0) {
			temp[n] = nums[n];
			return temp[n];
		}

		if (n == 1) {
			temp[n] = Math.max(nums[n], nums[n - 1]);
			return temp[n];
		}

		if (temp[n] == -1) {
			// max of [n + (n - 2)] and [n - 1]
			temp[n] = Math.max(nums[n] + rob(nums, n - 2, temp), rob(nums, n - 1, temp));
		}

		return temp[n];
	}
}
