package com.samples.leetcode;

/**
 * Minimum Path Sum 
 * https://leetcode.com/problems/minimum-path-sum
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode064 {

	public static void main(String[] args) {
		int[][] grid = { { 1, 2, 3 }, { 2, 1, 4 } };

		System.out.println(minPathSum(grid));
	}

	/**
	 * returns minimum path sum for path from top-left to bottom-right;
	 * 
	 * @param grid
	 * @return
	 */
	public static int minPathSum(int[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;

		int[][] matrix = new int[m][n];

		matrix[0][0] = grid[0][0];

		// update path sum for each chell in first column;
		for (int i = 1; i < m; i++) {
			matrix[i][0] = matrix[i - 1][0] + grid[i][0];
		}

		// update path sum for each chell in first row;
		for (int j = 1; j < n; j++) {
			matrix[0][j] = matrix[0][j - 1] + grid[0][j];
		}

		// update each cell with min cost for path from left cell vs path from
		// top cell;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				matrix[i][j] = Math.min(matrix[i][j - 1] + grid[i][j], matrix[i - 1][j] + grid[i][j]);
			}
		}

		return matrix[m - 1][n - 1];
	}
}
