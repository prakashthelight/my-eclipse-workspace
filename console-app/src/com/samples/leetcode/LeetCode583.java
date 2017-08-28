package com.samples.leetcode;

/**
 * Delete Operation for Two Strings
 * https://leetcode.com/problems/delete-operation-for-two-strings
 * @author Kumar, Prakash
 *
 */
public class LeetCode583 {

	public static void main(String[] args) {
		String word1 = "sea";
		String word2 = "eat";
		
		System.out.println(minDistance(word1, word2));
	}

	public static int minDistance(String word1, String word2) {

		int m = word1.length();
		int n = word2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					// setting first row and column with 0
					dp[i][j] = 0;
				} else {
					if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
						// diagonal left - up cell
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
					}
				}
			}
		}

		/*
		 * for (int[] row : dp) { System.out.println(Arrays.toString(row)); }
		 */

		// max length of common subsequence in both words
		int maxLength = dp[m][n];

		// System.out.println(maxLength);
		return m + n - 2 * maxLength;

	}
}
