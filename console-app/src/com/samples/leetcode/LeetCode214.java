package com.samples.leetcode;

/**
 * Shortest palindrome created after adding characters in front of given string
 * https://leetcode.com/problems/shortest-palindrome
 * @author kumarpr
 *
 */
public class LeetCode214 {
	
	public static void main(String[] args) {
		System.out.println(shortestPalindrome("aaacecaaa"));
	}
	
	public static String shortestPalindrome(String s) {        
        if (s == null || s.length() <= 1 ) return s;
        char[] chars = s.toCharArray();
        
        int start = 0;
        int end = chars.length - 1;
        
        boolean isPalindrome = false;
        while (!isPalindrome) {
            isPalindrome = isPalindrome(chars, start, end--);
        }      
        
        if (end + 1 == chars.length - 1) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        
        int j = chars.length - 1;
        while (j > end + 1) {
            sb.append(chars[j--]);            
        }
        
        return sb.append(s).toString();        
    }
    
    public static boolean isPalindrome(char[] chars, int start, int end) {        
        boolean isPalindrome = true;        
        
        while (start < end) {
            if (chars[start++] == chars[end--]) {
                continue;
            } else {
                isPalindrome = false;
                break;
            }            
        }
        
        return isPalindrome; 
    }
}
