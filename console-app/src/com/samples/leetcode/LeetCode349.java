package com.samples.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Intersection of Two Arrays <br/>
 * https://leetcode.com/problems/intersection-of-two-arrays
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode349 {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };

		System.out.println(Arrays.toString(intersection(nums1, nums2)));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null)
			return new int[] {};

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int item : nums1) {
			if (map.containsKey(item)) {
				map.put(item, map.get(item) + 1);
			} else {
				map.put(item, 1);
			}
		}

		HashSet<Integer> set = new HashSet<>();
		for (int item : nums2) {
			if (map.containsKey(item)) {
				set.add(item);
			}
		}

		int[] result = new int[set.size()];

		int i = 0;
		for (Integer item : set) {
			result[i] = item;
			i++;
		}

		return result;
	}
}
