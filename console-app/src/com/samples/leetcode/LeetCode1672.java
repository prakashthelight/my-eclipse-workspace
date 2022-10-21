package com.samples.leetcode;

/**
 * 1672. Richest Customer Wealth </br>
 * https://leetcode.com/problems/richest-customer-wealth/
 * 
 * @author Prakash Kumar
 * @category Array, Matrix
 */
public class LeetCode1672 {

	public static void main(String[] args) {		
		System.out.println(maximumWealth(new int[][] {{1,2,3},{3,2,1}}));
	}
	
	public static int maximumWealth(int[][] accounts) {

        int maxWealth = 0;
        for (int[] balances : accounts) {
            int wealth = 0;
            for (int balance : balances) {
                wealth += balance;                
            }

            maxWealth = Math.max(wealth, maxWealth);
        }

        return maxWealth;
    }
}
