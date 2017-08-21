package com.samples.leetcode;

/**
 * Happy Number 
 * https://leetcode.com/problems/happy-number 
 * @author Kumar, Prakash
 *
 */
public class LeetCode202 {

	public static void main(String[] args) {
		System.out.println(isHappy(19));

	}

	/**
	 * returns true of given number is happy number - recursively adding sum of square of each digit becomes 1;
	 * Floyd's cycle-finding algorithm
	 * @param n
	 * @return
	 */
	public static boolean isHappy(int n) {

		int slow, fast;
		slow = fast = n;

		do {
			slow = digitSquareSum(slow);
			fast = digitSquareSum(fast);
			fast = digitSquareSum(fast);
		} while (slow != fast);

		return slow == 1;
	}

	/**
	 * returns integer after adding squares of each digit;
	 * @param n
	 * @return
	 */
	public static int digitSquareSum(int n) {
		int result = 0;
		while (n > 0) {
			result += Math.pow(n % 10, 2);
			n /= 10;
		}

		return result;
	}
}
