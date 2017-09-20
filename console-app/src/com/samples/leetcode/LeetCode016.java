package com.samples.leetcode;

import java.util.Arrays;

/**
 * 3Sum Closest <br/>
 * https://leetcode.com/problems/3sum-closest
 * @author Kumar, Prakash
 *
 */
public class LeetCode016 {

	public static void main(String[] args) {
		int[] nums = {-1, 2, 1, -4};
		int target = 1;
		
		System.out.println(threeSumClosest(nums, target));
	}
	
	/**
	 * returns sum of three items from a given array which closest to given target;
	 * @param nums
	 * @param target
	 * @return
	 */
	
	public static int threeSumClosest(int[] nums, int target) {        
        if (nums == null || nums.length == 0) {
	        return 0;
	    }
	    
        Arrays.sort(nums);	    
	    
	    int minDiff = Integer.MAX_VALUE;
	    int closestSum = 0;
        int n = nums.length;
	    
	    for (int i = 0; i < n - 2; i++) {
	        int left = i + 1;
	        int right = n - 1;
	        
	        while (left < right) {
	            int sum = nums[i] + nums[left] + nums[right];
	            
	            if (sum > target) {
	                right--;
	            } else if (sum < target) {
	                left++;
	            } else  {
	                return sum;
	            }
	            
	            int diff = Math.abs(sum - target);
	            if (minDiff > diff) {
	                minDiff = diff;
	                closestSum = sum;
	            }
	        }
	    }
	    
	    return closestSum;        
    }
}
