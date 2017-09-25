package com.samples.leetcode;

/**
 * Valid Palindrome <br/>
 * https://leetcode.com/problems/valid-palindrome
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode125 {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println("Is Palindrom: " + isPalindrome(s));
	}

	/**
	 * returns if given string is a Palindrome - Case Insensitive and Use Letter
	 * and Digits only
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {

		int i = 0;
		int j = s.length() - 1;

		while (i <= j) {
			if (!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			} else if (!Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			} else {
				if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
					return false;
				}
				i++;
				j--;
			}
		}

		return true;
	}
}
