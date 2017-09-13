package com.samples.dp;

public class DPSolution {
	
	
	
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
