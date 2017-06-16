package com.samples.recursion;

public class RecursionUtils {

	/**
	 * fibo element
	 * @param n
	 * @return
	 * {@code fibo(0) = 1, fibo(1) = 1 and fibo(2) = fibo(1) + fibo(0)}
	 */
	public static int fibo(int n, int[] memo) {
		if (n == 0 || n == 1) {
			return 1;
		} else if (memo[n] == 0) {
			memo[n] = fibo(n - 1, memo) + fibo (n - 2, memo);
		}
		
		return memo[n];
	}
	
	/**
	 * 
	 * @param n
	 * @param memo
	 * @return
	 */
	public static int fibo(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else  {
			return fibo(n-1) + fibo(n-2);
		}
	}
}
