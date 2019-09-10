package com.samples.leetcode;

/**
 * Reverse String <br/>
 * https://leetcode.com/problems/reverse-string
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode344 {

	public static void main(String[] args) {
		String str = "hello";
		System.out.println(reverseString(str));
		
		char[] s = str.toCharArray();
		reverseString(s);
		System.out.println(new String(s));
	}

	/**
	 * reverse given string
	 * 
	 * @param s
	 * @return
	 */
	public static String reverseString(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}

		char[] chars = s.toCharArray();

		int i = 0;
		int j = chars.length - 1;

		while (i < j) {
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;

			i++;
			j--;
		}

		return new String(chars);
	}
	
	/*
	 * reverse given string - recursive
	 */
	public static void reverseString(char[] s) {
        if (s.length < 2) {
            return;
        }
        
        swapChars(s, 0, s.length - 1);
    }
    
	/*
	 * recursive 
	 */
    public static void swapChars(char[] s, int i, int j) {
        if (i >= j) {
            return;
        }
        
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        swapChars(s, i+1, j-1);
    }
}
