package com.samples.leetcode;

/**
 * Maximal Square https://leetcode.com/problems/maximal-square <br/>
 * 
 * @author Kumar, Prakash
 *
 */

public class LeetCode221 {

	public static void main(String[] args) {

		char[][] matrix = { 
				{ '1', '0', '1', '0', '0' }, 
				{ '1', '0', '1', '1', '1' }, 
				{ '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } 
			};

		System.out.println(maximalSquare(matrix));

		System.out.println(maxSquareMatrixWithOnes(matrix));

	}

	/**
	 * Maximum size square sub-matrix with all 1s
	 * 
	 * @param matrix
	 * @return
	 */
	public static int maximalSquare(char[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;

		int[][] table = new int[m + 1][n + 1];

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (matrix[i - 1][j - 1] == '1') {

					// minimum of other 3 adjacent cell values + 1 for this as
					// bottom right cell.
					table[i][j] = Math.min(table[i][j - 1], Math.min(table[i - 1][j - 1], table[i - 1][j])) + 1;
					max = Math.max(max, table[i][j]);
				}
			}
		}

		return max * max;
	}

	/**
	 * Maximum size square sub-matrix with all 1s
	 * http://www.ideserve.co.in/learn/maximum-size-square-sub-matrix-with-all-1s
	 * 
	 * @param matrix
	 * @return
	 */
	public static int maxSquareMatrixWithOnes(char[][] matrix) {
		int max = -1;
		int n = matrix.length;
		int[][] table = new int[n][n];

		// set first row and column with values from matrix
		for (int i = 0; i < n; i++) {
			table[0][i] = matrix[0][i];
			table[i][0] = matrix[i][0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				// if value is zero, it cannot be part of any matrix with 1s
				if (matrix[i][j] == '0') {
					table[i][j] = 0;
				} else {

					// minimum of other 3 adjacent cell values + 1 for this as
					// bottom right cell.
					table[i][j] = Math.min(table[i][j - 1], Math.min(table[i - 1][j - 1], table[i - 1][j])) + 1;

					max = Math.max(max, table[i][j]);
				}
			}
		}

		return max;
	}

}
