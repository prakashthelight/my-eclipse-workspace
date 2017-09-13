package com.samples.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Third Maximum Number <br/>
 * https://leetcode.com/problems/third-maximum-number
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode414 {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1 };
		System.out.println(thirdMax(nums));
	}

	/**
	 * return third max item from a list of integers, return first max if array
	 * length is less than 3
	 * 
	 * @param nums
	 * @return
	 */

	public static int thirdMax(int[] nums) {
		int k = 3;

		if (nums == null || nums.length == 0) {
			throw new IllegalArgumentException("invalid array");
		}

		// as duplicate numbers are to be treated as same position max, we need
		// to remove duplicates
		HashSet<Integer> set = new HashSet<>();
		for (int item : nums) {
			set.add(item);
		}
		// set to array
		Integer[] newArray = set.toArray(new Integer[set.size()]);

		// sort new array
		Arrays.sort(newArray);

		// if ke is greater than array length, set to return first max
		if (k > newArray.length) {
			k = 1;
		}

		return newArray[newArray.length - k];
	}
}
