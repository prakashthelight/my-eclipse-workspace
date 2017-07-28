package com.samples.leetcode;

/**
 * Island Perimeter
 * https://leetcode.com/problems/island-perimeter
 * @author Kumar, Prakash
 *
 */
public class LeetCode463 {
	
	public static void main(String[] args) {
		
		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		System.out.println(String.format("Pemeter of island is %d", islandPerimeter(grid)));				
				
	}

	public static int islandPerimeter(int[][] grid) {
		// base conditions
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		int m = grid.length;
		int n = grid[0].length;

		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					
					// add 4 sides for given 1 cell
					count += 4;
					
					// sustract sides for each adjacency sides with 1 cell

					// left cell
					if (j > 0) {
						count -= grid[i][j - 1] == 1 ? 1 : 0;
					}

					// right cell
					if (j < n - 1) {
						count -= grid[i][j + 1] == 1 ? 1 : 0;
					}

					// up cell
					if (i > 0) {
						count -= grid[i - 1][j] == 1 ? 1 : 0;
					}

					// down cell
					if (i < m - 1) {
						count -= grid[i + 1][j] == 1 ? 1 : 0;
					}
				}
			}
		}

		return count;
	}
}
