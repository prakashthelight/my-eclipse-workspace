package com.samples.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 01 Matrix
 * https://leetcode.com/problems/01-matrix
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * @author Kumar, Prakash
 *
 */
public class LeetCode542 {

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

		int[][] result = updateMatrix(matrix);

		for (int[] row : result) {
			System.out.println(Arrays.toString(row));
		}
	}

	/**
	 * returns updated matrix with distance from nearest 0 for earch cell
	 * @param matrix
	 * @return
	 */
	public static int[][] updateMatrix(int[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					queue.offer(new int[] { i, j });
				} else {
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		
		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			
			for (int[] direction : directions) {
				
				// adjacent cell
				int row = cell[0] + direction[0];
				int col = cell[1] + direction[1];
				
				// if adjacent cell has already minimum value, continue
				if (row < 0 || row >= m
						|| col < 0 || col >= n
						|| matrix[row][col] <= matrix[cell[0]][cell[1]] + 1) {
					continue;
				}
				
				// add this adjacent cell to updates its adjacent cells too
				queue.add(new int[] {row, col});
				matrix[row][col] = matrix[cell[0]][cell[1]] + 1;
			}
		}		
		
		return matrix;
	}

}
