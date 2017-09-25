package com.samples.leetcode;

import java.util.Arrays;

/**
 * Two Sum II - Input array is sorted <br/>
 * @author Kumar, Prakash
 *
 */
public class LeetCode167 {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}
	
	/**
	 * returns the indeces of two item from array having sum equal to given target
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) {
            return new int[] {0, 0};
        }
        
        int left = 0;
        int right = numbers.length -1;
        
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                return new int[] {left+1, right+1};
            } 
            
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[] {0, 0};
    }

}
