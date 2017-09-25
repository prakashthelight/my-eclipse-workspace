package com.samples.leetcode;

import java.util.Arrays;

/**
 * Rotate Image <br/>
 * https://leetcode.com/problems/rotate-image
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode048 {

	public static void main(String[] args) {
		int[][] matrix = {
				{0,0,1,1,1,0,0,0,0,0},
				{0,0,1,1,1,0,0,0,0,0},
				{0,0,1,1,1,0,0,0,0,0},
				{0,0,1,1,1,0,0,0,0,0},
				{0,0,1,1,1,1,1,1,1,1},
				{0,0,1,1,1,1,1,1,1,1},
				{0,0,1,1,1,1,1,1,1,1},
				{0,0,1,1,1,0,0,0,0,0},
				{0,0,1,1,1,0,0,0,0,0},
				{0,0,1,1,1,0,0,0,0,0},
		};
		
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
		
		rotate(matrix);
		
		System.out.println("After rotation:");
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

	/**
	 * rotates a given square matrix 90 degree clock wise;
	 * @param matrix
	 */
	public static void rotate(int[][] matrix) {

		int n = matrix.length;

		if (matrix[0].length != n)
			return;

		for (int layer = 0; layer < n / 2; layer++) {
			int start = layer;
			int end = n - 1 - layer;

			for (int i = start; i < end; i++) {
				int offset = i - start;

				int top = matrix[start][i];
				matrix[start][i] = matrix[end - offset][start];
				matrix[end - offset][start] = matrix[end][end - offset];
				matrix[end][end - offset] = matrix[i][end];
				matrix[i][end] = top;
			}
		}
	}

}
