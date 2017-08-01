package com.samples.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Set Mismatch
 * https://leetcode.com/problems/set-mismatch
 * @author Kumar, Prakash
 *
 */
public class LeetCode645 {

	public static void main(String[] args) {
		int[] nums = {1,2,2,4};
		
		System.out.println(Arrays.toString(findErrorNums(nums)));
	}
	
	/**
	 * return duplicate and missing number from 1 - n array
	 * @param nums
	 * @return
	 */
	public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        int duplicate = -1;
        for (int num : nums) {            
            sum+=num;
            if (duplicate == -1 && set.contains(num)) {
                duplicate = num;
            } else {
                set.add(num);
            }
        }
        
        long actualSum = (long)(n * (n + 1) ) / 2;
        
        int missing = (int)(actualSum - (sum - duplicate));
        
        return new int[] {duplicate, missing};        
    }

}
