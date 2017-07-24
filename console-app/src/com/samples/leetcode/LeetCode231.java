package com.samples.leetcode;

/**
 * Power of Two
 * https://leetcode.com/problems/power-of-two
 * @author Kumar, Prakash
 *
 */
public class LeetCode231 {

	public static void main(String[] args) {
		int num = 32;
		System.out.println(String.format("%d is power of 2 - %s", num, isPowerOfTwo(num)));
		System.out.println(String.format("%d is power of 2 - %s", num, isPowerOfTwo_1(num)));
	}
	
	/**
	 * return true if given number is power of two - Binary presentation has only 1 bit set;
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwo(int n) {   
		
        if (n < 1) return false;
        if (n == 1) return true; // 2^0       
        
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {                
                count++;
            }
            if (count > 1) {
                return false;
            }
            
            n = n >> 1;
        }
        
        return true;
    }
	
	/**
	 * returns true if given number is power of two - keep dividing by 2 unless n mod 2 == 0
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwo_1(int n) {
		if (n < 1) return false;
        if (n == 1) return true; // 2^0     
        
        while (n % 2 == 0) {        	
        	n = n / 2;
        }
        
        return n == 1;
	}
}
