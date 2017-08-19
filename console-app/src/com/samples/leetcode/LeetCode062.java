package com.samples.leetcode;

import java.util.Arrays;

/**
 * Unique Paths
 * https://leetcode.com/problems/unique-paths
 * @author Kumar, Prakash
 *
 */
public class LeetCode062 {

	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		
		System.out.println(uniquePaths(m, n));

	}
	
	/**
	 * return unique paths a robot can move from top left cell to bottom right cell
	 * @param m
	 * @param n
	 * @return
	 */
    public static int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        
        // set first coloumn values to 1;
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }
        
        // set first row values to 1;
        for (int i = 0; i < n; i++) {
            matrix[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // sum of left and top cell values
                matrix[i][j] = matrix[i -1][j] + matrix[i][j - 1]; 
            }
        }
        
        
        
        for (int[] row : matrix) {
        	System.out.println(Arrays.toString(row));
        }
        
        return matrix[m - 1][n - 1];        
    }
}
