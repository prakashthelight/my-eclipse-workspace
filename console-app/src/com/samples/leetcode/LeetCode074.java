package com.samples.leetcode;

/**
 * Search in a 2D Matrix, given integers in rows and columns are sorted ascending
 * @author kumarpr
 *
 */
public class LeetCode074 {
	public static void main(String[] args) {

		int[][] matrix = new int[][] {
			{1,   3,  5,  7},
			{10, 11, 16, 20}, 
			{23, 30, 34, 50}
		};
		
		System.out.println(searchMatrix(matrix, 3));	
	}
	
	/**
	 * return true if search element is found.
	 * @param matrix
	 * @param target
	 * @return
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        
        // start at top right
        int row = 0;
        int col = matrix[0].length - 1;
        
        // keep looking unless under valid boundaries
        while (row < matrix.length && col >= 0) {
        	
        	// if target is smaller, move left;
            if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) { // if target is greater, then move down
                row++;
            } else {
                return true;
            }
        }
        
        return false;
    }
}
