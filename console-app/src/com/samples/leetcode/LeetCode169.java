package com.samples.leetcode;

import java.util.Arrays;

/**
 * Majority Element <br/>
 * https://leetcode.com/problems/majority-element
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode169 {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };

		System.out.println(majorityElement(nums));
	}

	/**
	 * return majority number appearing more than n/2 times in n size array
	 * 
	 * @param nums
	 * @return
	 */
	public static int majorityElement(int[] nums) {
		int major = nums[0];
		int count = 1;

		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				major = nums[i];
				count++;
			} else if (major == nums[i]) {
				count++;
			} else {
				count--;
			}
		}

		return major;
	}

	public int majorityElement1(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

}
