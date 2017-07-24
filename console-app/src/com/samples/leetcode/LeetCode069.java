package com.samples.leetcode;

/**
 * Sqrt(x)
 * https://leetcode.com/problems/sqrtx
 * @author kumarpr
 *
 */
public class LeetCode069 {
	
	public static void main(String[] args) {
		System.out.println(mySqrt(36));
	}
	
	/**
	 * return sqrt of given number, uses binary search
	 * @param x
	 * @return
	 */
	public static int mySqrt(int x) {
        if (x == 0) return 0;        
        
        int left = 1;
        int right = x / 2;
        int result = 1;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (mid * mid > x) {
                right = (int) mid - 1;    
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    result = (int) mid;
                    break;
                }
                
                left = (int) mid + 1;
            }
        } 
        
        return result;
    }

}
