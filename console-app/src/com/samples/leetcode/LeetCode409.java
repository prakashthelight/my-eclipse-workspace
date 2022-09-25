package com.samples.leetcode;

/**
 * 409. Longest Palindrome <br/>
 * https://leetcode.com/problems/longest-palindrome
 * 
 * @author Kumar, Prakash
 * @category Hash Table, String, Greedy
 */
public class LeetCode409 {

	public static void main(String[] args) {
		String s = "abccccdd";

		// longest possible palindrome
		System.out.println(longestPalindrome(s));
	}

	/**
	 * return length of longest possible palindrome from given string
	 * 
	 * @param s
	 * @return
	 */
	public static int longestPalindrome(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int[] lowerChars = new int[26];
		int[] upperChars = new int[26];

		for (char ch : s.toCharArray()) {
			if ('a' <= ch && ch <= 'z') {
				lowerChars[ch - 'a']++;
			} else if ('A' <= ch && ch <= 'Z') {
				upperChars[ch - 'A']++;
			}
		}

		int maxLength = 0;
		int oddCount = 0;

		// add all even and odd occurrences to maxLength and count all odd
		// occurrences
		for (int count : lowerChars) {
			maxLength += count;
			if (count % 2 != 0) {
				oddCount++;
			}
		}

		// add all even and odd occurrences to maxLength and count all odd
		// occurrences
		for (int count : upperChars) {
			maxLength += count;
			if (count % 2 != 0) {
				oddCount++;
			}
		}

		return oddCount == 0 ? maxLength : maxLength - (oddCount - 1);
	}
	
	public static int longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] charCounts = new int[52];
        
        
        for(char ch : s.toCharArray()) {
            if ('a' <= ch && ch <= 'z') {
                charCounts[ch - 'a']++;
            } else if ('A' <= ch && ch <= 'Z'){
                charCounts[ch - 'A' + 26]++;
            }
        }
        
        int maxLength = 0;
        
        for(int count: charCounts) {
            maxLength += count / 2 * 2; // just add even value e.g. if count == 21 add 20
            if (maxLength % 2 == 0 && count % 2 == 1) {
                maxLength++;
            }
        }        
        
        return maxLength;        
    }
	
	public static int longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] lowerChars = new int[26];
        int[] upperChars = new int[26];
        
        for(char ch : s.toCharArray()) {
            if ('a' <= ch && ch <= 'z') {
                lowerChars[ch - 'a']++;
            } else if ('A' <= ch && ch <= 'Z'){
                upperChars[ch - 'A']++;
            }
        }
        
        int maxLength = 0;
        
        for(int count: lowerChars) {
            if (count % 2 == 1) {
                if (maxLength % 2 == 0) {
                    maxLength += count;
                } else {
                    maxLength += count - 1;
                }
            } else {
                maxLength += count;    
            }
        }
        
        for(int count: upperChars) {
            if (count % 2 == 1) {
                if (maxLength % 2 == 0) {
                    maxLength += count;
                } else {
                    maxLength += count - 1;
                }
            } else {
                maxLength += count;    
            }
        }
        
        return maxLength;        
    }

}
