package com.samples.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * K-diff Pairs in an Array <br/>
 * https://leetcode.com/problems/k-diff-pairs-in-an-array
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode532 {

	public static void main(String[] args) {
		int[] nums = {3, 1, 4, 1, 5};
		int k = 2;
		
		System.out.println(findPairs(nums, k));
	}

	/**
	 * returns pair count where absolute difference is k
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findPairs(int[] nums, int k) {
		if (nums == null || nums.length < 2)
			return 0;

		Arrays.sort(nums);
		int i = 0, j = 1;

		HashSet<Integer> set = new HashSet<Integer>();

		int count = 0;
		while (i < nums.length && j < nums.length) {
			int diff = Math.abs(nums[i] - nums[j]);

			if (diff > k) {
				i++;
				if (i == j) {
					j++;
				}
			} else if (diff < k) {
				j++;
			} else {

				if (!set.contains(nums[i])) {
					set.add(nums[i]);
					count++;
				}
				i++;
				j++;
			}
		}

		return count;
	}
}
