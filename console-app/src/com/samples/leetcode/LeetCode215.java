package com.samples.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Kth Largest Element in an Array <br/>
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode215 {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };

		System.out.println(findKthLargest(nums, 2));

	}

	public static int findKthLargest(int[] nums, int k) {		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int item : nums) {
			pq.offer(item);

			if (pq.size() > k) {
				pq.poll();
			}
		}

		return pq.peek();
	}

	public static int findKthLargest1(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
}
