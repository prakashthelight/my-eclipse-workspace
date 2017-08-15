package com.samples.leetcode;

/**
 * Remove 9
 * https://leetcode.com/problems/remove-9
 * @author Kumar, Prakash
 *
 */
public class LeetCode660 {

	public static void main(String[] args) {
		int position = 100;		
		System.out.println(newInteger(position));
	}
	
	/**
	 * return nth number in the sequence of interger skipping all integers with 9
	 * @param n
	 * @return
	 */
	public static int newInteger(int n) {
		int result = 0;
		int multi = 1;
		
		int base = 9;
		while (n > 0) {
			result += n % base * multi;			
			n /= base;
			multi *= 10;
		}
		
		return result;
	}
}
