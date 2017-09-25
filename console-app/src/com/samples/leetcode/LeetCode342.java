package com.samples.leetcode;

/**
 * Power of Four <br/>
 * https://leetcode.com/problems/power-of-four
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode342 {

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(64));
	}
	
	/**
	 * returns true if given number is power of 4
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfFour(int n) {      
        if (n == 1 || n == 4) return true;
        if (n < 4) return false;
        
        while (n % 4 == 0)
            n /= 4;
        
        return n == 1;
    }
}
