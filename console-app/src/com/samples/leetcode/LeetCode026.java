package com.samples.leetcode;

import java.util.Arrays;

/**
 * Remove Duplicates from Sorted Array <br/>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode026 {

	public static void main(String[] args) {

		int[] array = { 1, 1, 2, 3, 4, 4, 5, 6, 6, 7, 7 };
		System.out.println("Original array: " + Arrays.toString(array));
		int length = removeDuplicates(array);

		// print updated array
		for (int i = 0; i < length; i++) {
			System.out.print((i == 0 ? "" : ", "));
			System.out.print(array[i]);
		}
	}

	/**
	 * removes duplicate from sorted array inplace, and returns the new length;
	 * 
	 * @param array
	 * @return
	 */
	public static int removeDuplicates(int[] array) {
		if (array == null || array.length == 0)
			return 0;

		int index = 1;

		for (int j = 1; j < array.length; j++) {
			if (array[j] != array[j - 1]) {
				array[index++] = array[j];
			}
		}

		return index;
	}

}
