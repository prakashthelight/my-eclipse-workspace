package com.samples.leetcode;

/**
 * Count and Say <br/>
 * https://leetcode.com/problems/count-and-say
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode038 {
	
	public static void main(String[] args) {
		System.out.println(countAndSay(10));
	}

	/**
	 * returns nth sequence of count and say i.e. 1, 11, 21, 1211, 111221
	 * @param n
	 * @return
	 */
	public static String countAndSay(int n) {
		if (n == 1)
			return "1";

		String output = "1";

		// repeatedly call countAndSay for n - 1 times
		while (n != 1) {
			output = countAndSay(output);
			n--;
		}

		return output;
	}

	/**
	 * return a string after converting that uring count and say algorithm
	 * @param str
	 * @return
	 */
	public static String countAndSay(String str) {

		int count = 1;
		char ch = str.charAt(0);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < str.length(); i++) {
			if (ch != str.charAt(i)) {
				sb.append(count + "" + ch);
				ch = str.charAt(i);
				count = 1;
			} else {
				count++;
			}
		}

		sb.append(count + "" + ch);

		return sb.toString();
	}

}
