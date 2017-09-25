package com.samples.leetcode;

/**
 * Valid Sudoku <br/>
 * https://leetcode.com/problems/valid-sudoku
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode036 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValidSudoku(char[][] board) {
		return validRowsColumns(board) && valid3x3Grid(board);
	}

	boolean valid3x3Grid(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!valid3x3Grid(board, i * 3, j * 3)) {
					return false;
				}
			}
		}

		return true;
	}

	boolean valid3x3Grid(char[][] board, int r, int c) {
		boolean[] nums = new boolean[9];

		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				char ch = board[i][j];
				if ('1' <= ch && ch <= '9') {
					int item = Character.getNumericValue(ch) - 1;
					if (nums[item]) {
						return false;
					} else {
						nums[item] = true;
					}
				}
			}
		}

		return true;
	}

	boolean validRowsColumns(char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (!validRowsColumns(board, i, true) || !validRowsColumns(board, i, false)) {
				return false;
			}
		}

		return true;
	}

	boolean validRowsColumns(char[][] board, int rowOrCol, boolean isRow) {
		boolean[] nums = new boolean[9];

		for (int i = 0; i < 9; i++) {
			char ch = isRow ? board[rowOrCol][i] : board[i][rowOrCol];
			if ('1' <= ch && ch <= '9') {
				int item = Character.getNumericValue(ch) - 1;
				if (nums[item]) {
					return false;
				} else {
					nums[item] = true;
				}
			}
		}

		return true;
	}
}
