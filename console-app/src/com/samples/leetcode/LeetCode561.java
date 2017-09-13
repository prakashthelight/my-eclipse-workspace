package com.samples.leetcode;

import java.util.Arrays;

/**
 * Array Partition - Max sum of pairs <br/>
 * https://leetcode.com/problems/array-partition-i
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode561 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 4, 3, 2 };

		System.out.println(arrayPairSum(array));
	}

	public static int arrayPairSum(int[] nums) {
		int sum = 0;

		if (nums == null || nums.length % 2 != 0)
			return 0;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 1; i += 2) {
			sum += Math.min(nums[i], nums[i + 1]);
		}

		return sum;
	}
}
