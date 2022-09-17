package com.samples.leetcode;

/**
 * 1480. Running Sum of 1d Array <br/>
 * https://leetcode.com/problems/running-sum-of-1d-array
 * 
 * @author Kumar, Prakash
 * @category Arrays, Prefix Sum
 */
public class LeetCode1480 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };

		var output = runningSum(nums);
		for (int item : output) {
			System.out.printf("%d ", item);
		}
	}

	public static int[] runningSum(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			nums[i] = sum;
		}

		return nums;
	}

	public static int[] runningSum1(int[] nums) {
		if (nums.length < 2) {
			return nums;
		}

		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i - 1] + nums[i];
		}

		return nums;
	}
}
