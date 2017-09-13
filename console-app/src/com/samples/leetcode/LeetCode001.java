package com.samples.leetcode;

import java.util.HashMap;

/**
 * Find, if we have two numbers giving required sum in an array <br/>
 * https://leetcode.com/problems/two-sum
 * 
 * @author Kumar, Prakash
 * @category Arrays, TwoSum
 */
public class LeetCode001 {

	public static void main(String[] args) {
		int[] array = new int[] { 12, 3, 4, 8, 28, 15 };
		int[] result = twoSum(array, 11);
		
		if (result[0] != -1) {
			System.out.println(array[result[0]] + " " + array[result[1]]);
		} else {
			System.out.println("Not found");
		}
	}

	public static int[] twoSum(int[] array, int sum) {
		int[] result = new int[] { -1, -1 };

		if (array == null || array.length == 0) {
			return result;
		}

		// map to have target, we are are looking for
		// i.e. found 4 now looking for 12-4 = 8
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			int target = sum - array[i];

			// if we already got the compliment stored
			if (map.containsKey(array[i])) {
				return new int[] { i, map.get(array[i]) };
			} else {
				map.put(target, i);
			}
		}

		return result;
	}
}
