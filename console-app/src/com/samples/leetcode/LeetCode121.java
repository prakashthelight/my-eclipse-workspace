package com.samples.leetcode;

/**
 * Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 * @author Kumar, Prakash
 *
 */
public class LeetCode121 {

	public static void main(String[] args) {
		int[] sharePrices = {7, 1, 5, 3, 6, 4};		
		System.out.println("Max Profit: " + maxProfit(sharePrices));
	}
	
	public static int maxProfit(int[] prices) {      
        
        if (prices == null || prices.length < 2) return 0;
        
        int minPrice = prices[0];
        int maxProfit = prices[1] - minPrice;
        
        for (int i = 1; i < prices.length; i++) {            
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(prices[i], minPrice);            
        }
        
        return maxProfit > 0 ? maxProfit : 0;
    }	
}
