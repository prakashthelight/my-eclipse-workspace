package com.samples.leetcode;

import java.util.Arrays;

/**
 * Reshape the Matrix
 * https://leetcode.com/problems/reshape-the-matrix
 * @author Kumar, Prakash
 *
 */
public class LeetCode566 {

	public static void main(String[] args) {
		int[][] nums = new int[][] {{1, 2},{3, 4}};
		int r = 1;
		int c = 4;
		
		int[][] matrix = matrixReshape(nums, r, c);
		
		System.out.print("[");
		for (int[] row : matrix) {
			System.out.print(Arrays.toString(row));
		}
		System.out.print("]");
		

	}
	
	public static int[][] matrixReshape(int[][] nums, int r, int c) {   
        
        // if array is null, return null;
        if (nums == null) {
            return nums;
        }
        
        int m = nums.length;
        int n = nums[0].length;
        if (m == 0 || n == 0) return nums;
        
        int k = 0;
        int l = 0;
        
        if (m * n < r * c) 
            return nums;
        
        // initialize new matrix
        int[][] matrix = new int[r][c];
        
        // traverse and set matrix;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = nums[k][l];
                
                // make sure l, k stays within safe boundry
                // if at last coloumn, set it to 0 column and next row;
                if (l == n - 1) {
                    l = 0;
                    k++;
                } else {
                    l++;
                }
            }
        }
        
        return matrix;
    }

}
