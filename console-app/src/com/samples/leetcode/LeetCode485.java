package com.samples.leetcode;

/**
 * Max Consecutive Ones <br/>
 * https://leetcode.com/problems/max-consecutive-ones
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode485 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 0, 1, 1, 1 };
		System.out.println(findMaxConsecutiveOnes(nums));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int maxConsecutiveOnes = 0;
		int currentCount = 0;
		for (int num : nums) {
			if (num == 1) {
				currentCount++;
			} else {
				maxConsecutiveOnes = Math.max(maxConsecutiveOnes, currentCount);
				currentCount = 0; // reset count
			}
		}

		// for case where last currentCount was not considered as did not find 0
		// afterward
		maxConsecutiveOnes = Math.max(maxConsecutiveOnes, currentCount);

		return maxConsecutiveOnes;
	}
}
