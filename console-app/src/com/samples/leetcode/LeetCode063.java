package com.samples.leetcode;

import java.util.Arrays;

/**
 * Unique Paths II <br/>
 * https://leetcode.com/problems/unique-paths-ii
 * 
 * @author Kumar, Prakash
 *
 */

public class LeetCode063 {

	public static void main(String[] args) {
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] matrix = new int[m][n];

		// set first coloumn values to 1;
		for (int i = 0; i < m; i++) {
			if (i == 0) {
				matrix[i][0] = obstacleGrid[i][0] == 1 ? 0 : 1;
			} else {
				if (obstacleGrid[i][0] == 1) {
					matrix[i][0] = 0;
				} else {
					matrix[i][0] = matrix[i - 1][0];
				}
			}
		}

		// set first row values to 1;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				matrix[0][i] = obstacleGrid[0][i] == 1 ? 0 : 1;
			} else {
				if (obstacleGrid[0][i] == 1) {
					matrix[0][i] = 0;
				} else {
					matrix[0][i] = matrix[0][i - 1];
				}
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				// sum of left and top cell values

				if (obstacleGrid[i][j] == 1) {
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
				}
			}
		}

		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}

		return matrix[m - 1][n - 1];
	}

}
