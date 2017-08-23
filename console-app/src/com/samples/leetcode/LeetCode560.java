package com.samples.leetcode;

import java.util.HashMap;

/**
 * Subarray Sum Equals K https://leetcode.com/problems/subarray-sum-equals-k
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode560 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 2, 1, 3 };
		int k = 3;

		System.out.println(subarraySum(nums, k));
	}

	/**
	 * returns count of continuous subarrays with sum equals to given number -
	 * O(n)
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		map.put(0, 1);

		int sum = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}

			if (map.containsKey(sum)) {
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}
		}

		return count;
	}

	/**
	 * returns count of continuous subarrays with sum equals to given number -
	 * O(n^2)
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum1(int[] nums, int k) {
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			int sum = 0;

			for (int j = i; j < nums.length; j++) {
				sum += nums[j];

				if (sum == k) {
					count++;
				}
			}
		}

		return count;
	}
}
