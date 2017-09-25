package com.samples.leetcode;

/**
 * Add Digits <br/>
 * https://leetcode.com/problems/add-digits
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode258 {

	public static void main(String[] args) {
		System.out.println(addDigits(38));
	}

	/**
	 * returns addition of all digits, repeats until becomes single digit
	 * 
	 * @param num
	 * @return
	 */
	public static int addDigits(int num) {
		// if num has just one digit
		if (num < 10) {
			return num;
		}

		int sum = 0;
		// add all digits
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}

		// get sum again or would return sum if has just one digit
		return addDigits(sum);
	}
}
