package com.samples.leetcode;

/**
 * Arranging Coins in staircase shape
 * @author Kumar, Prakash
 *
 */
public class LeetCode441 {

	public static void main(String[] args) {
		int n = 5;		
		System.out.println(String.format("Number of full steps with %d counts is %d", n, arrangeCoins(n)));
	}
	
	/**
	 * return number of full steps of staircase
	 * @param n
	 * @return
	 */
	public static int arrangeCoins(int n) {
        
        if (n == 0 || n == 1) return n;
        
        int steps = 0; 
        
        int i = 1; 
        while (n >= i) {
            n -= i;
            i++;
            steps++;
        }
        
        return steps;
    }
}
