package com.samples.leetcode;

/**
 * 392. Is Subsequence <br/>
 * https://leetcode.com/problems/is-subsequence/
 * 
 * @author Kumar, Prakash
 * @category Two Pointers, String
 */
public class LeetCode392 {

	public static void main(String[] args) {
		String s = "abc", t = "ahbgdc";
		
		System.out.print(isSubsequence(s, t));

	}
	
	public static boolean isSubsequence(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        if (sArray.length > tArray.length) {
        	return false;
        }
        
        int i = 0;
        int j = 0;
        
        while (i < sArray.length && j < tArray.length) {
        	if (sArray[i] == tArray[j]) {
        		i++;
        		j++;
        	} else {
        		j++;
        	}
        }
        
        if (i < sArray.length) {
        	return false;
        }
        
		return true;
	}

}
