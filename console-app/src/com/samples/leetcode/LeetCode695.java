package com.samples.leetcode;

/**
 * Max Area of Island <br/>
 * https://leetcode.com/problems/max-area-of-island
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode695 {

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

		System.out.println(maxAreaOfIsland(grid));
	}

	/**
	 * returns maxArea of island maded with contiguous 1s
	 * @param grid
	 * @return
	 */
	public static int maxAreaOfIsland(int[][] grid) {
		// base conditions
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int maxArea = 0;
		int m = grid.length;
		int n = grid[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					maxArea = Math.max(maxArea, getArea(grid, m, n, i, j));
				}
			}
		}

		return maxArea;
	}

	/**
	 * returns areas of given island starting with given position
	 * @param grid
	 * @param m
	 * @param n
	 * @param i
	 * @param j
	 * @return
	 */
	public static int getArea(int[][] grid, int m, int n, int i, int j) {
		if (i < 0 || i == m || j < 0 || j == n || grid[i][j] == 0) {
			return 0;
		}

		// marking it as water so that not being traversed again and not included in other island
		grid[i][j] = 0;

		return 1 + getArea(grid, m, n, i - 1, j) + getArea(grid, m, n, i + 1, j) + getArea(grid, m, n, i, j + 1)
				+ getArea(grid, m, n, i, j - 1);
	}
}
