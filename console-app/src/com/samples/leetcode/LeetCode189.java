package com.samples.leetcode;

import java.util.Arrays;

/**
 * Rotate Array <br/>
 * https://leetcode.com/problems/rotate-array
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode189 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		System.out.println(Arrays.toString(array));
		rotateRight(array, 2);
		System.out.println(Arrays.toString(array));
	}

	public static void rotateRight(int[] nums, int k) {
		if (nums == null || nums.length <= 1)
			return;

		// rotate 20 times a array with length 5 result
		// equal to not rotation
		k = k % nums.length;

		// no rotation required
		if (k == 0)
			return;

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
	
	/**
	 * Time complexity: O(n) Space complexity: O(1)
	 * @param nums
	 * @param k
	 */
	public static void rotateRight1(int[] nums, int k) {
		if (nums == null || nums.length <= 1)
			return;
		
		k = k % nums.length;
		
		if (k == 0)
			return ;
		
		for(int start = 0, count = 0; count < nums.length; start++) {
			int current = start;
			int previous = nums[start];			
			do {
				int next = (current + k) % nums.length;		
				int temp = nums[next];
				nums[next] = previous;
				previous = temp;
				current = next;
				count++;
			} while (start != current);
		}		
	}
}
