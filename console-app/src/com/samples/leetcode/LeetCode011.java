package com.samples.leetcode;

/**
 * Container With Most Water <br/>
 * https://leetcode.com/problems/container-with-most-water
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode011 {

	public static void main(String[] args) {
		int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		System.out.println(maxArea(heights));
	}

	/**
	 * returns max area which can hold max water given default depth
	 * 
	 * @param heights
	 * @return
	 */
	public static int maxArea(int[] heights) {

		int maxArea = 0;

		int i = 0;
		int j = heights.length - 1;

		while (i < j) {

			// take minimum height, as this would be the limit to hold water
			int minHeight = Math.min(heights[i], heights[j]);

			maxArea = Math.max(maxArea, minHeight * (j - i));

			if (heights[i] <= heights[j]) {
				i++;
			} else {
				j--;
			}
		}

		return maxArea;
	}
}
