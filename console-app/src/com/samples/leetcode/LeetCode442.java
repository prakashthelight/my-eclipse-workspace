package com.samples.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Duplicates in an Array [1,2,3...n]<br/>
 * https://leetcode.com/problems/find-all-duplicates-in-an-array
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode442 {

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };

		System.out.println(findDuplicates(nums).toString());

	}

	/**
	 * returns list of duplicate intergers in given array of integers
	 * @param nums
	 * @return
	 */
	public static List<Integer> findDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<Integer>();
		}

		int n = nums.length;
		int[] temp = new int[n];

		System.arraycopy(nums, 0, temp, 0, nums.length);

		// substract 1 from each item, as array is 0 indexed not 1
		for (int i = 0; i < temp.length; i++) {
			temp[i]--;
		}

		// add n in item at given index calculated by each item % n;
		for (int i = 0; i < temp.length; i++) {
			int index = temp[i] % n;
			temp[index] = temp[index] + n;
		}

		// devide each item by n
		for (int i = 0; i < temp.length; i++) {
			temp[i] /= n;
		}

		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] >= 2) {
				result.add(i + 1);
			}
		}

		return result;
	}
}
