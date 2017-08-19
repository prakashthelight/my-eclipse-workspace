package com.samples.leetcode;

/**
 * Guess Number Higher or Lower
 * https://leetcode.com/problems/guess-number-higher-or-lower
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode374 {

	private static int mychoice = 68;

	public static void main(String[] args) {
		System.out.println(guessNumber(100));
	}

	public static int guessNumber(int n) {
		int start = 1, end = n;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (guess(mid) == -1) {
				end = mid - 1;
			} else if (guess(mid) == 1) {
				start = mid + 1;
			} else {
				return mid;
			}
		}

		return start;
	}

	public static int guess(int num) {
		if (mychoice < num) {
			return -1;
		} else if (mychoice > num) {
			return 1;
		} else {
			return 0;
		}
	}
}
