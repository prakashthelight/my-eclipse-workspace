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
	
	public static void moveZeroes(int[] nums) {        
        if (nums == null || nums.length < 2) return;
        
        int count = 0;
        int i = -1;
        int j = 0;
        
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[++i] = nums[j++];
            } else {
                j++;
                count++;
            }
        }
        
        while (count > 0) {
            nums[++i] = 0;
            count--;
        }
    }

}
