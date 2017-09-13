package com.samples.leetcode;

/**
 * Best Time to Buy and Sell Stock II <br/>
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode122 {

	public static void main(String[] args) {
		int[] sharePrices = { 7, 1, 5, 3, 6, 4 };
		System.out.println("Max Profit: " + maxProfit(sharePrices));
	}

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;

		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			maxProfit += Math.max(prices[i] - prices[i - 1], 0);
		}

		return maxProfit;
	}
}
