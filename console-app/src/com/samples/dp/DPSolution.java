package com.samples.dp;

public class DPSolution {
	
	/**
	 * Maximum size square sub-matrix with all 1s
	 * http://www.ideserve.co.in/learn/maximum-size-square-sub-matrix-with-all-1s
	 */
	public static void maxSquareMatrixWithOnes() {
		int[][] matrix = {
				{0,1,1,0,1,1},
				{1,1,0,1,1,1},
				{0,1,1,1,0,0},
				{1,1,1,1,0,0},
				{1,1,1,1,1,0},
				{0,1,1,1,0,1}
		};
		
		int maxSquarMatrixSizeWithOnes = maxSquareMatrixWithOnes(matrix);
		System.out.println(maxSquarMatrixSizeWithOnes);
	}
	
	/**
	 * Maximum size square sub-matrix with all 1s
	 * @param matrix
	 * @return
	 */
	public static int maxSquareMatrixWithOnes(int[][] matrix) {
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
				if (matrix[i][j] == 0) {
					table[i][j] = 0;
				} else {
					// minimum of other 3 adjacent cell values + 1 for this as bottom right cell.
					table[i][j] = Math.min(table[i][j - 1], Math.min(table[i - 1][j - 1], table[i -1 ][j])) + 1;
					
					max = Math.max(max, table[i][j]);
				}
			}
		}
		
		return max;
	}
	
	/**
	 * http://www.ideserve.co.in/learn/subset-sum-dynamic-programming
	 */
	public static void subsetSumDemo() {
		int[] array = new int[] {1, 3, 9, 2};
		int target = 5;
		
		System.out.println(subsetSum(array, target));
		
	}
	
	public static boolean subsetSum(int[] array, int target) {
		boolean[][] table = new boolean[array.length + 1][target + 1];
		
		// if target is zero, we can use empty set;
		for (int i = 0; i < array.length + 1; i++) {
			table[i][0] = true;
		}
				
		// if subset is empty, we cannot sum up to target
		for (int i = 1; i < target + 1; i++) {
			table[0][i] = false;
		}
		
		
		for (int i = 1; i <= array.length; i++) {
			for (int j = 1; j <= target; j++) {
				
				// fist copy the table date from top
				table[i][j] = table[i - 1][j];
				
				if (table[i][j] == false && j >= array[i - 1]) {
					table[i][j] = table[i][j] || table[i-1][j - array[i -1]]; 
				}
			}
		}
		
		for (boolean[] row : table) {
			for (boolean item : row) {
				System.out.print(item + " ");
			}
			
			System.out.print("\n");
		}
		
		return table[array.length][target];
	}
	
}
