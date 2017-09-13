package com.samples.leetcode;

/**
 * Edit Distance, - Find minimum number of edits - replace, insert, delete for
 * converting one string to another string <br/>
 * https://leetcode.com/problems/edit-distance
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode072 {

	public static void main(String[] args) {
		String str1 = "anshuman"; // a
		String str2 = "antihuman"; // b
		System.out.println(getMinEditDistance(str1, str2));
	}

	public static int getMinEditDistance(String str1, String str2) {

		if (str1 == null && str2 == null)
			return 0;

		if (str1.length() == 0)
			return str2.length();
		if (str2.length() == 0)
			return str1.length();

		int m = str1.length();
		int n = str2.length();

		int[][] dp = new int[m + 1][n + 1];

		// set rows to 0,1,2,3,4,...m
		for (int i = 0; i < m + 1; i++) {
			dp[i][0] = i;
		}

		// set rows to 0,1,2,3,4,...n
		for (int i = 0; i < n + 1; i++) {
			dp[0][i] = i;
		}

		// for match take previous diagonal value
		// for no match - take minimum of diagonal, up, and left and add 1
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
				}
			}
		}

		// last element in the matrix will give
		// minumum edits needed for this conversion
		return dp[m][n];
	}
}
