package com.samples.leetcode;

/**
 * Palindrome Number <br/>
 * https://leetcode.com/problems/palindrome-number
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode009 {

	public static void main(String[] args) {
		int num = 345543;
		System.out.println(isPalindrome(num));
	}

	/**
	 * returns true if given integer is palindrome
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isPalindrome(int num) {

		int temp = num;
		if (temp < 0 || (temp != 0 && temp % 10 == 0)) {
			return false;
		}

		int newNum = 0;
		while (temp > newNum) {
			newNum = newNum * 10 + temp % 10;
			temp = temp / 10;
		}

		return temp == newNum || temp == newNum / 10;
	}
}
