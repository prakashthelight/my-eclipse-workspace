package com.samples.leetcode;

import java.util.Arrays;

/**
 * Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode238 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };

		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}

	/**
	 * returns an array with products for all elements except the item at each index
	 * @param nums
	 * @return
	 */
	public static int[] productExceptSelf(int[] nums) {

		if (nums == null || nums.length < 2) {
			return nums;
		}

		int n = nums.length;
		int[] products = new int[n];

		products[0] = 1;
		// start from second item
		for (int i = 1; i < n; i++) {
			products[i] = products[i - 1] * nums[i - 1];
		}

		int p = nums[n - 1];		
		// start for second from last item
		for (int i = n - 2; i >= 0; i--) {
			products[i] = products[i] * p;
			p *= nums[i];
		}

		return products;
	}
}
