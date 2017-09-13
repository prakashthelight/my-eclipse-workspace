package com.samples.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * Next Greater Element I <br/>
 * https://leetcode.com/problems/next-greater-element-i
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode496 {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 4, 2 };
		int[] findNums = { 4, 1, 2 };

		// Output [-1, 4, -1]
		System.out.println(Arrays.toString(nextGreaterElement(findNums, nums)));
	}

	/**
	 * return next max integer to right in big set for given set of integers in
	 * subset;
	 * 
	 * @param findNums
	 * @param nums
	 * @return
	 */
	public static int[] nextGreaterElement(int[] findNums, int[] nums) {

		HashMap<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<Integer>();

		for (int num : nums) {
			// map stores next greater value if found for give item
			while (!stack.isEmpty() && stack.peek() < num) {
				map.put(stack.pop(), num);
			}

			stack.push(num);
		}

		int[] result = new int[findNums.length];
		for (int i = 0; i < findNums.length; i++) {
			result[i] = map.getOrDefault(findNums[i], -1);
		}

		return result;
	}
}
