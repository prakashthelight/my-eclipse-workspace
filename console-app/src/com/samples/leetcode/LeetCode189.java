package com.samples.leetcode;

import java.util.Arrays;

/**
 * Rotate Array
 * https://leetcode.com/problems/rotate-array
 * @author kumarpr
 *
 */
public class LeetCode189 {
	
	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4,5,6,7};
		
		System.out.println(Arrays.toString(array));
		rotateRight(array, 2);
		System.out.println(Arrays.toString(array));
	}
	
	public static void rotateRight(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return;       
        
        k = k % nums.length; // rotate 20 times a array with length 5 result equal to not rotation
        if (k == 0) return;
        
        // store last k length array
        int[] temp = new int[k];        
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i + nums.length - k];
        }
        
        // shift right k positions
        for (int i = nums.length - 1; i > k - 1; i--) {
            nums[i] = nums[i - k]; // shift right k positions;
        }
        
        // place k length array in front of array
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }       
    }
}
