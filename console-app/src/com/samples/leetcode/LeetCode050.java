package com.samples.leetcode;

/**
 * Pow (x, n)
 * https://leetcode.com/problems/powx-n
 * @author kumarpr
 *
 */
public class LeetCode050 {
	
	public static void main(String[] args) {
		System.out.println(myPow(2.0, 3));
	}
	
	/**
	 * returns x to the power n 
	 * @param x
	 * @param n
	 * @return
	 */
	public static double myPow(double x, int n) {
		
		// take care of negative power
        boolean isNegativePow = false;
        if (n < 0) {
            n *= -1;
            isNegativePow = true;
        }
        
        if (n == 0) return 1;
        
        if (n == 1)  {
            return isNegativePow ? 1 /(double) x : x;
        }
        
        double result = 0;
        if (n % 2 == 0) {
            double intermed = myPow(x, n/2);
            result =  intermed * intermed;
        } else {
            double intermed = myPow(x, (n-1)/2);
            result = x * intermed * intermed;
        }
        
        return isNegativePow ? result != 0 ? 1 / result : 0 : result;        
    }
}
