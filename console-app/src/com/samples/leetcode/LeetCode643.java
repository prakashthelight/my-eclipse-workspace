package com.samples.leetcode;

/**
 * Maximum Average Subarray I
 * https://leetcode.com/problems/maximum-average-subarray-i
 * @author kumarpr
 *
 */
public class LeetCode643 {
	
	public static void main(String[] args) {
		int[] array = new int[] {4,2,1,3,3};
		int k = 2;
		
		System.out.println(findMaxAverage(array, k));		
	}
	
	public static double findMaxAverage(int[] nums, int k) {
		// if array is null or its length is less than k
        if (nums == null || nums.length < k) {
          return 0;  
        } 
        
        // get sum and average of first k elements
        int sum = 0;
        int i = 0;
        while (i < k) {
            sum += nums[i++];        
        }
        
        double maxAvg = sum / (double)k;
        
        i = 0;
        for (int j = k; j < nums.length; j++) {
        	// update sum with next element and substracting last element - sliding window
            sum += nums[j] - nums[i++];            
            // set max average
            maxAvg = Math.max(maxAvg, sum / (double)k);
        }

        return maxAvg;
    }
}
