package com.samples.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Numbers Disappeared in an Array of 1 -> n
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
 * @author Kumar, Prakash
 *
 */
public class LeetCode448 {

	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		
		System.out.println(findDisappearedNumbers(nums).toString());
	}

	/**
	 * return list of numbers disappeared from array of number 1 -> n
	 * @param nums
	 * @return
	 */
	public static List<Integer> findDisappearedNumbers(int[] nums) {

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
			if (temp[i] == 0) {
				result.add(i + 1);
			}
		}

		return result;
	}

}
