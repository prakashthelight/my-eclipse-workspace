package com.samples.leetcode;

/**
 * Search a 2D Matrix II - matrix sorted ascending in rows and descending in columns 
 * https://leetcode.com/problems/search-a-2d-matrix-ii
 * @author kumarpr
 *
 */
public class LeetCode240 {
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1,   4,  7, 11, 15},
			{2,   5,  8, 12, 19},
			{3,   6,  9, 16, 22},
			{10, 13, 14, 17, 24},
			{18, 21, 23, 26, 30}
		};		
		
		System.out.println(searchMatrix(matrix, 15));
	}
	
	/**
	 * return true if search element is found.
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        
        // start at bottom left
        int row = matrix.length - 1;
        int col = 0;
        
        // keep looking unless under valid boundaries
        while (row >= 0 && col < matrix[0].length) {
        	
        	// if target is smaller, move up;
            if (target < matrix[row][col]) {
                row--;
            } else if (target > matrix[row][col]) { // if target is greater, move right
                col++;
            } else {
                return true;
            }
        }
        
        return false;
    }
}
