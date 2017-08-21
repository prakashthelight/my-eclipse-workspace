package com.samples.leetcode;

/**
 * Coin Change 
 * https://leetcode.com/problems/coin-change * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode322 {
	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 11;

		System.out.println(String.format("Minimum number of coins for %d : %d", amount, coinChange(coins, amount)));

	}

	/**
	 * returns minimum number of coins required for given amount
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange(int[] coins, int amount) {

		if (coins == null || coins.length == 0 || amount <= 0) {
			return 0;
		}

		// minimum number of coints for each amount from 1 to amount
		int[] minCoins = new int[amount + 1];

		for (int i = 1; i <= amount; i++) {
			minCoins[i] = Integer.MAX_VALUE;

			for (int coin : coins) {
				if (coin <= i && minCoins[i - coin] != Integer.MAX_VALUE) {
					minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coin]);
				}
			}
		}

		return minCoins[amount] == Integer.MAX_VALUE ? -1 : minCoins[amount];
	}

}
