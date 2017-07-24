package com.samples.leetcode;

/**
 * Perfect Squares
 * https://leetcode.com/problems/perfect-squares
 * @author kumarpr
 *
 */
public class LeetCode070 {

	public static void main(String[] args) {
		
		int numberOfStairs = 10;
		System.out.println(String.format("Number of stairs: %d Different ways to climb to top %d", numberOfStairs, climbStairs(numberOfStairs)));

	}
	
	public static int climbStairs(int n) {
        int[] temp = new int[n+1];
        
        return climbStairs(n, temp);
    }
    
	/**
	 * returns number of ways, one can climb to top
	 * @param n
	 * @param temp
	 * @return
	 */
    public static int climbStairs(int n, int[] temp) {
        
        if (n <= 2) {
            temp[n] = n;
            return n;
        }        
        
        if (temp[n] == 0) {
            temp[n] = climbStairs(n - 2, temp) + climbStairs(n - 1, temp);
        }
        
        return temp[n];        
    }
}
