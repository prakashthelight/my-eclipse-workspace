package com.samples.leetcode;

import java.util.Arrays;

/**
 * Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode152 {

	public static void main(String[] args) {
		int[] nums = { 2, 3, -2, 4 };

		System.out.println(String.format("Maximum product of subarray in %s is %d", Arrays.toString(nums), maxProduct(nums)));
	}

	/**
	 * return max product of contiguous subarray
	 * @param nums
	 * @return
	 */
	public static int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int max = nums[0], min = nums[0], result = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int temp = max;

			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

			result = Math.max(result, max);
		}

		return result;
	}

}
