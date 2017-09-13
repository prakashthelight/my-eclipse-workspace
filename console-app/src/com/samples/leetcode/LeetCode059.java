package com.samples.leetcode;

import java.util.Arrays;

/**
 * Spiral Matrix II <br/>
 * https://leetcode.com/problems/spiral-matrix-ii
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode059 {

	public static void main(String[] args) {
		int n = 3;
		int[][] matrix = generateMatrix(n);
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

	/**
	 * populates and returns a n x n matrix, traversing it spiral order
	 * 
	 * @param n
	 * @return
	 */
	public static int[][] generateMatrix(int n) {

		int[][] matrix = new int[n][n];
		if (n == 0) {
			return matrix;
		}

		int row = 0;
		int col = 0;
		int direction = 0;
		int layer = 0;

		matrix[row][col] = 1;

		for (int i = 1; i < n * n; i++) {

			switch (direction) {
			case 0: // left to right
				if (col == n - layer - 1) {
					row++;
					direction++;
				} else {
					col++;
				}
				break;
			case 1: // top to bottom
				if (row == n - layer - 1) {
					col--;
					direction++;
				} else {
					row++;
				}
				break;
			case 2: // right to left
				if (col == layer) {
					row--;
					direction++;
				} else {
					col--;
				}
				break;
			case 3: // bottom to up
				if (row == layer + 1) {
					col++;
					direction = 0;
					layer++;
				} else {
					row--;
				}
				break;
			}

			matrix[row][col] = i + 1;
		}

		return matrix;
	}

}
