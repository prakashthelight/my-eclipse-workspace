package com.samples.leetcode;

public class LeetCode348 {

	public static void main(String[] args) {	
		char[][] board = {
				{'X', '-', 'O'},
				{'X', 'X', 'O'},
				{'O', '-', 'X'},
		};
		
		TicTacToe game = new TicTacToe(board);
		
		System.out.println(game.isWinner('X'));
	}

}

class TicTacToe {
	char[][] board;
	
	public TicTacToe (char[][] board) {
		this.board = board;
	}
	
	boolean isWinner(char player) {
		
		// validated board;
		if (board == null || board.length == 0 || board[0].length == 0 || board.length != board[0].length) {
			return false;
		}
		
		int n = board.length;
		
		for (int i = 0; i < n; i++) {
			boolean row = true;
			boolean col = true;
			
			for (int j = 0; j < n; j++) {
				if (row && Character.compare(board[i][j], player) != 0) {
					row = false;
				}
				
				if (col && Character.compare(board[j][i], player) != 0) {
					col = false;
				}
			}
			
			if (row || col) {
				return true;
			}
		}
		
		boolean diagonal1 = true;
		boolean diagonal2 = true;
		
		for (int i = 0; i < n; i++) {
			if (Character.compare(board[i][i], player) != 0) {
				diagonal1 = false;
			}
			
			if (Character.compare(board[i][n - i - 1], player) != 0) {
				diagonal2 = false;
			}
		}
		
		return diagonal1 || diagonal2;
	}
}

