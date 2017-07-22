package com.samples.leetcode;

/**
 * Detect Capital
 * https://leetcode.com/problems/detect-capital
 * @author kumarpr
 *
 */
public class LeetCode520 {

	public static void main(String[] args) {
		
		System.out.println(detectCapitalUse("USA"));
	}
	
	/**
	 * returns true if valid use of Capital letters
	 * @param word
	 * @return
	 */
	public static boolean detectCapitalUse(String word) {
        
        if (word == null || word.length() == 0) return false;
        
        boolean allCapitals = true;
        boolean justFirstCapital = true;
        boolean allSmall = true;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);            
            if ('A' <= ch && ch <= 'Z') {                
                allSmall = false;
                if (i > 0) {
                    justFirstCapital = false;
                }
                
            } else {
                allCapitals = false;                               
            }
        }
        
        return allCapitals || justFirstCapital || allSmall;
    }
}