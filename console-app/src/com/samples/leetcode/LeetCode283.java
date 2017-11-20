package com.samples.leetcode;

import java.util.Arrays;

/**
 * Move Zeroes <br/>
 * https://leetcode.com/problems/move-zeroes
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode283 {

	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		
		System.out.println(Arrays.toString(nums));		
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	/**
	 * Moves all zeros to end of array
	 * @param nums
	 */
	public static void moveZeroes(int[] nums) {        
        if (nums == null || nums.length < 2) return;
        
        int j = 0; 
        int i = 0;
        
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
            
            i++;
        }
        
        while (j < nums.length) {
            nums[j++] = 0;            
        }
    }
}
