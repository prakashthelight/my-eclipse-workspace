package com.samples.leetcode;

/**
 * Given a string s, find the longest palindromic substring in s.
 * https://leetcode.com/problems/longest-palindromic-substring
 * @author kumarpr
 *
 */
public class LeetCode005 {
	
	// expand method will keep updating it for max length palindrome
    static int index, maxLength;
    
	public static void main(String[] args) {
		String str = "babad";		
		System.out.println(longestPalindrome(str));
	}
	
	/**
	 * return logest palindrom substring
	 * @param str
	 * @return
	 */
    
    public static String longestPalindrome(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        
        for (int i = 0; i < str.length() - 1; i++) {
            expandPalindrome(str, i, i);
            expandPalindrome(str, i, i + 1);
        }
        
        return str.substring(index, index + maxLength);
    }
    
    /**
     * keep expanding boundaries if valid palindrome
     * @param str
     * @param start
     * @param end
     */
    public static void expandPalindrome(String str, int start, int end) {
        
        // while start and end still under boundry and both position has same character expand start and end;
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }
        
        if (maxLength < end - start - 1) {
            index = start + 1;
            maxLength =  end - start - 1;
        }
    }
}
