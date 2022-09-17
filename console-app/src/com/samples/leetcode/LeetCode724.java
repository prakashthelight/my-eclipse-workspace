package com.samples.leetcode;

/**
 * 724. Find Pivot Index <br/>
 * https://leetcode.com/problems/find-pivot-index
 * 
 * @author Kumar, Prakash
 * @category Arrays, Prefix Sum
 */
public class LeetCode724 {

	public static void main(String[] args) {
		int[] nums = { 1, 7, 3, 6, 5, 6 };
		int leftmostPivotIndex = pivotIndex(nums);
		System.out.printf("Pivot Index: %d", leftmostPivotIndex);
	}

	public static int pivotIndex(int[] nums) {
		int[] leftSumArray = new int[nums.length];

		int leftSum = 0;
		for (int i = 0; i < nums.length; i++) {
			leftSumArray[i] = leftSum;
			leftSum += nums[i];
		}

		int leftmostPivotIndex = -1;

		int rightSum = 0;
		for (int j = nums.length - 1; j >= 0; j--) {
			if (leftSumArray[j] == rightSum) {
				leftmostPivotIndex = j;
			}

			rightSum += nums[j];
		}

		return leftmostPivotIndex;
	}
}
