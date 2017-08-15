package com.samples.leetcode;

/**
 * Count Primes
 * https://leetcode.com/problems/count-primes
 * @author Kumar, Prakash
 *
 */
public class LeetCode204 {

	public static void main(String[] args) {
		int n = 100;
		System.out.println(String.format("No. of prime number smaller than %d is %d", n, countPrimes(n)));
	}

	/**
	 * return number of primes smaller then given number
	 * @param n
	 * @return
	 */
	public static int countPrimes(int n) {

		boolean[] isNotPrimes = new boolean[n];
		int primeCount = 0;

		for (int i = 2; i < n; i++) {
			
			// if still not marked as non-prime
			if (isNotPrimes[i] == false) {
				primeCount++;

				for (int j = 2; i * j < n; j++) {
					isNotPrimes[i * j] = true;
				}
			}
		}

		return primeCount;
	}

}
