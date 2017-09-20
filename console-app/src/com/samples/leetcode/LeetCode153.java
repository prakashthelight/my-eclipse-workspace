package com.samples.leetcode;

/**
 * Find Minimum in Rotated Sorted Array <br/>
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode153 {

	public static void main(String[] args) {
		// rotated sorted array
		int[] nums = { 4, 5, 6, 7, 1, 2, 3 };

		System.out.println("Minimum item: " + findMin(nums));
	}

	public static int findMin(int[] nums) {
		int start = 0;
		int end = nums.length - 1;

		while (start < end) {
			int mid = (start + end) / 2;

			if (nums[mid] > nums[end]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return nums[start];
	}
}
