package com.samples.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Sliding Window Maximum <br/>
 * https://leetcode.com/problems/sliding-window-maximum *
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode239 {

	public static void main(String[] args) {
		
		int[] array = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;

		System.out.println(Arrays.toString(maxSlidingWindow(array, k)));

	}

	/**
	 * return max for each k width sliding window position in array
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public static int[] maxSlidingWindow(int[] array, int k) {

		if (array == null || k <= 0) {
			return new int[] {};
		}

		int[] maxSliding = new int[array.length - k + 1];
		int maxSlidingIndex = 0;

		Deque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < array.length; i++) {
			// remove number out of range
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}

			// remove smaller numbers in k range as they are not required
			while (!q.isEmpty() && array[q.peekLast()] < array[i]) {
				q.pollLast();
			}

			q.offer(i);

			if (i >= k - 1) {
				maxSliding[maxSlidingIndex++] = array[q.peek()];
			}
		}

		return maxSliding;
	}
}
