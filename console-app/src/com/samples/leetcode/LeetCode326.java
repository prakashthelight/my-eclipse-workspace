package com.samples.leetcode;

/**
 * Is Power of Three
 * https://leetcode.com/problems/power-of-three
 * @author Kumar, Prakash
 *
 */
public class LeetCode326 {

	public static void main(String[] args) {
		int num = 27;
		System.out.println(String.format("%d is power of three: %s", num, isPowerOfThree(num)));
	}
	
	/**
	 * returns true if given number is power of 3
	 * @param n
	 * @return
	 */
	
	public static boolean isPowerOfThree(int n) {               
        if (n == 1 || n == 3) return true;
        if (n < 3) return false;
        
        while (n % 3 == 0) 
            n /= 3;
        
        return n == 1;
    }
}
