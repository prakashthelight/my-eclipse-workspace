package com.samples.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, find the longest palindromic substring in s.
 * https://leetcode.com/problems/longest-palindromic-substring
 * @author kumarpr
 *
 */
public class LeetCode005 {
	public static void main(String[] args) {
		String str = "babad";		
		System.out.println(longestPalindrome(str));
	}
	
	/**
	 * Finds all palindrome substrings in given Strings
	 * @param str
	 * @return
	 */
	public static String longestPalindrome(String str) {
		if (str == null || str.isEmpty()) return "";
		
		if (str.length() == 1) {
			return str;
		}
		
		if (str.length() == 2) {
			if (str.charAt(0) == str.charAt(1)) {
				return str;
			} else {
				return str.substring(0,1);
			}
		}
		
        String longestPalindrome = "";
        List<String> palindromes = new ArrayList<>();
        
                
        for (int k = 0; k < str.length() - 1 ; k++) {
        	// add all odd length palindroms
        	int i = k - 1;
        	int j = k + 1;        	
        	while (i >= 0 && j <= str.length() - 1) {
        		if (str.charAt(i) == str.charAt(j)) {
        			String palindrome = str.substring(i, j + 1); // a palindrome string
        			if (longestPalindrome.length() < palindrome.length()) {
        				longestPalindrome = palindrome;        				
        			}
        		} else {
        			break;
        		}        		
        		i--;j++;
        	}  
        	
        	// add all even length palindroms
        	i = k;
        	j = k + 1;
        	while (i >= 0 && j <= str.length() - 1) {
        		if (str.charAt(i) == str.charAt(j)) {
        			String palindrome = str.substring(i, j + 1); // a palindrome string        			
        			palindromes.add(palindrome);
        			if (longestPalindrome.length() < palindrome.length()) {
        				longestPalindrome = palindrome;        				
        			}
        		} else {
        			break;
        		}
        		i--; j++;
        	}        	
        }
        
        return "".equals(longestPalindrome) ? str.substring(0,1) : longestPalindrome;        
    }
}
