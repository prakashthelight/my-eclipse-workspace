package com.samples.leetcode;

/**
 * Number of Islands <br/>
 * https://leetcode.com/problems/number-of-islands
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode200 {

	public static void main(String[] args) {
		char[][] matrix = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

		System.out.println(String.format("Number of Islands : %d", numIslands(matrix)));

	}

	/**
	 * returns number of Islands (adjascent group of 1s)
	 * 
	 * @param grid
	 * @return
	 */
	public static int numIslands(char[][] grid) {

		int count = 0;

		int rows = grid.length;

		if (rows == 0)
			return 0;
		int cols = grid[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// if found one piece of island, set all of adjascent 1's to 0
				if (grid[i][j] == '1') {
					MarkAsWater(grid, rows, cols, i, j);
					count++;
				}
			}
		}

		return count;
	}

	/**
	 * Marsks Island as water i.e. change all 1s to 0s as Island has been
	 * counted
	 * 
	 * @param grid
	 * @param rows
	 * @param cols
	 * @param i
	 * @param j
	 */
	public static void MarkAsWater(char[][] grid, int rows, int cols, int i, int j) {
		if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1')
			return;

		grid[i][j] = '0';

		// recursively mark all adjacent land [1] as water[0] as they make one
		// island
		MarkAsWater(grid, rows, cols, i - 1, j);
		MarkAsWater(grid, rows, cols, i + 1, j);
		MarkAsWater(grid, rows, cols, i, j - 1);
		MarkAsWater(grid, rows, cols, i, j + 1);
	}

}
