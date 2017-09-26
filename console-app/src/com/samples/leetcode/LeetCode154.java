package com.samples.leetcode;

/**
 * Find Minimum in Rotated Sorted Array II <br/>
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode154 {

	public static void main(String[] args) {
		// rotated sorted array
		int[] nums = { 4, 5, 6, 7, 1, 2, 2, 2, 3 };

		System.out.println("Minimum item: " + findMin(nums));
	}

	public static int findMin(int[] nums) {
		int start = 0;
		int end = nums.length - 1;

		while (start < end) {
			int mid = (start + end) / 2;

			if (nums[mid] > nums[end]) {
				start = mid + 1;
			} else if (nums[mid] < nums[end]) {
				end = mid;
			} else {
				end--;
			}
		}

		return nums[start];
	}

}
