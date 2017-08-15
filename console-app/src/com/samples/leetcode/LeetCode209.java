package com.samples.leetcode;

/**
 * Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum
 * @author Kumar, Prakash
 *
 */
public class LeetCode209 {
	public static void main(String[] args) {
		int[] array = new int[] {2,3,1,2,4,4};
		System.out.println(minSubArrayLen(7, array));
	}
	
	/**
	 * Finds length of smalles subarray having sum >= to given target 
	 * @param sum
	 * @param array
	 * @return
	 */
	public static int minSubArrayLen(int sum, int[] array) {
        int start = 0;
		int minLength = Integer.MAX_VALUE;
		int currentSum = 0;
		int i = 0;
		while (i < array.length) {			
			currentSum += array[i++];			
			while (currentSum >= sum && start < array.length) {
				minLength = Math.min(minLength, i - start);
				currentSum -= array[start++];
			}
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }	
}