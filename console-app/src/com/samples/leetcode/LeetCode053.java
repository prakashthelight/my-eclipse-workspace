package com.samples.leetcode;

/**
 * Maximum Subarray
 * Algorithm https://leetcode.com/problems/maximum-subarray
 * @author kumarpr
 *
 */
public class LeetCode053 {

	public static void main(String[] args) {

		int[] array = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] allNegativeArray = new int[] { -2, -11, -3, -4, -1, -2, -1, -5, -4 };
		
		System.out.println(findMaxSumSubArray(array));
		System.out.println(findMaxSumSubArray(allNegativeArray));

	}

	/**
	 * returns maximum sum using sub-array elements in given array - Kadane's 
	 * @param array
	 * @return
	 */
	public static int findMaxSumSubArray(int[] array) {
		int currentSum = array[0];
		int overallMaxSum = array[0];

		for (int i = 1; i < array.length; i++) {
			currentSum = Math.max(array[i], currentSum + array[i]);
			overallMaxSum = Math.max(currentSum, overallMaxSum);
		}

		return overallMaxSum;
	}
}
