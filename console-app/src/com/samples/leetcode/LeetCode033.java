package com.samples.leetcode;

/**
 * Search in Rotated Sorted Array <br/>
 * https://leetcode.com/problems/search-in-rotated-sorted-array
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode033 {

	public static void main(String[] args) {
		int[] array = { 4, 5, 6, 7, 1, 2, 3 };

		System.out.println(search(array, 5));
	}

	/**
	 * search and returns index of target item in rotated sorted array - binary
	 * search <br/>
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	public static int search(int[] array, int target) {
		int actualStart = findMinimumIndex(array);

		int start = 0;
		int end = array.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			// consider rotation
			int actualMid = (mid + actualStart) % array.length;

			if (array[actualMid] > target) {
				end = mid - 1;
			} else if (array[actualMid] < target) {
				start = mid + 1;
			} else {
				return actualMid;
			}
		}

		return -1;
	}

	/**
	 * returns index of miminum item - binary search
	 * 
	 * @param array
	 * @return
	 */
	public static int findMinimumIndex(int[] array) {
		int start = 0;
		int end = array.length - 1;

		while (start < end) {
			int mid = (start + end) / 2;
			if (array[mid] > array[end]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return start;
	}
}
