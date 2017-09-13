package com.samples.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Largest Number <br/>
 * https://leetcode.com/problems/largest-number
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode179 {

	public static void main(String[] args) {		
		int[] nums = { 3, 30, 34, 5, 9 };

		System.out.println(largestNumber(nums));
	}

	/**
	 * return largest number created using items from a given integer array
	 * 
	 * @param nums
	 * @return
	 */
	public static String largestNumber(int[] nums) {

		if (nums == null || nums.length == 0) {
			return String.valueOf(0);
		}

		String[] numStr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			numStr[i] = String.valueOf(nums[i]);
		}

		// sort numbers, with this specific comparator
		Arrays.sort(numStr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String a = s1 + s2;
				String b = s2 + s1;

				return b.compareTo(a);
			}
		});

		// if first character of first element is 0, retun 0
		if (numStr[0].charAt(0) == '0') {
			return String.valueOf(0);
		}

		StringBuilder sb = new StringBuilder();
		for (String str : numStr) {
			sb.append(str);
		}

		return sb.toString();
	}
}
