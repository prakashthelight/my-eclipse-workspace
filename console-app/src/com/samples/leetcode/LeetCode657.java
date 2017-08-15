package com.samples.leetcode;

/**
 * Judge Route Circle
 * https://leetcode.com/problems/judge-route-circle
 * @author Kumar, Prakash
 *
 */
public class LeetCode657 {

	public static void main(String[] args) {
		String moves = "UD";
		System.out.println(judgeCircle(moves));
	}

	/**
	 * returns true if bot reach 0,0 after all moves;
	 * @param moves
	 * @return
	 */
	public static boolean judgeCircle(String moves) {

		int x = 0;
		int y = 0;

		for (char ch : moves.toCharArray()) {
			switch (ch) {
			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			case 'L':
				x--;
				break;
			case 'R':
				x++;
				break;
			}
		}

		return x == 0 && y == 0;
	}

}
