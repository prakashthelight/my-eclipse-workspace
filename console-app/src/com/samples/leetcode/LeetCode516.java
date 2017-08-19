package com.samples.leetcode;

/**
 * Longest Palindromic Subsequence
 * https://leetcode.com/problems/longest-palindromic-subsequence
 * @author kumarpr
 *
 */
public class LeetCode516 {
	public static void main(String[] args) {
		String str = "bbbab";		
		System.out.println(String.format("Longest Palindrom Subsequence for %s is %d", str, longestPalindromeSubseq(str)));
	}	
	
	public static int longestPalindromeSubseq (String str) {
		int n = str.length();
		int[][] dp = new int[n][n];
		
		// iterate from i, n - 1 to 0 
		for (int i = n - 1; i >= 0; i--) {
			// set i,i to 1 as, there should be 1 length of palindrom subsequence for each character 
			dp[i][i] = 1;
			// iterate i from i+1 to n-1 
			for (int j = i + 1; j < n; j++) {
				// if matches add 2 to left down diagonal value
				if (str.charAt(i) == str.charAt(j)) {
					dp[i][j] = dp[i+1][j-1] + 2;
				} else {
					// set with max of left down  value
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[0][n - 1];
	}
}
