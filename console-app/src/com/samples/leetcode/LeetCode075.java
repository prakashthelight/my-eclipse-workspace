package com.samples.leetcode;

import java.util.Arrays;

/**
 * Sort Colors
 * https://leetcode.com/problems/sort-colors
 * @author Kumar, Prakash
 *
 */
public class LeetCode075 {
	
	public static void main(String[] args) {
		int[] colors = new int[] {0,2,2,1,0,2,1,0};		
		sortColors(colors);
		System.out.println(Arrays.toString(colors));
	}

	/**
	 * sorts and array of 0, 1 and 2s
	 * @param nums
	 */
	public static void sortColors(int[] nums) {
        
        int[] colorCounts = new int[3];
        
        // count all colors
        for (int color : nums) {
            colorCounts[color]++;
        }
        
        // fill in color in original array as 0s, 1s and 2s
        for (int i = 0, j = 0; i < nums.length && j < colorCounts.length; i++) {            
            while (colorCounts[j] == 0) {
                j++;
            }            
            nums[i] = j;
            colorCounts[j]--;            
        }
    }
}
