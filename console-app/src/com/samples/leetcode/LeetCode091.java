package com.samples.leetcode;

/**
 * Decode Ways <br/>
 * https://leetcode.com/problems/decode-ways/
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode091 {

	public static void main(String[] args) {		
		// "AB" (1, 2), "L" (12)		
		System.out.println(numDecodings("12"));
		// "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6)
		System.out.println(numDecodings("226"));
	}
	
	public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i <= n; i++) {
            int digitWithOneChar = Integer.valueOf(s.substring(i - 1, i));
            int digitWithTwoChars = Integer.valueOf(s.substring(i - 2, i));
            
            if (digitWithOneChar >= 1 && digitWithOneChar <= 9) {
                dp[i]+= dp[i - 1];
            }
            
            if (digitWithTwoChars >= 10 && digitWithTwoChars <= 26) {
                dp[i]+= dp[i - 2];
            }
        }
        
        return dp[n];
    }
}
