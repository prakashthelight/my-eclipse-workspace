package com.samples.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 * @author Kumar, Prakash
 *
 */
public class LeetCode054 {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		
		System.out.println(spiralOrder(matrix).toString());
	}

	/**
	 * returns list of items after traversing matrix in spiral order
	 * @param matrix
	 * @return
	 */
	public static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> list = new ArrayList<>();
		int m = matrix.length;

		if (m == 0) {
			return list;
		}

		int n = matrix[0].length;

		if (n == 0) {
			return list;
		}

		int row = 0;
		int col = 0;
		int direction = 0;
		int layer = 0;

		list.add(matrix[row][col]);

		for (int i = 1; i < m * n; i++) {

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
				if (row == m - layer - 1) {
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

			list.add(matrix[row][col]);
		}

		return list;
	}
}
