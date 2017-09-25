package com.samples.leetcode;

/**
 * Remove Element <br/>
 * https://leetcode.com/problems/remove-element
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode027 {

	public static void main(String[] args) {
		int[] nums = {3,2,2,3};
		
		int newLength = removeElement(nums, 3);
		
		for (int i = 0; i < newLength; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	/**
	 * removes given item from an array and returns new length
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {

		if (nums == null || nums.length == 0)
			return 0;

		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[j] = nums[i];
				j++;
			}
		}

		return j;
	}

}
