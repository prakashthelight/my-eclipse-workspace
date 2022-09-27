package com.samples.leetcode;

/**
 * 704. Binary Search <br/>
 * https://leetcode.com/problems/binary-search
 * 
 * @author Kumar, Prakash
 * @category Array, Binary Search
 */
public class LeetCode704 {

	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		int target = 9;
		System.out.println(search(nums, target));

	}
	
	public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;       
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }            
        }
        
        return -1;
    }
}
