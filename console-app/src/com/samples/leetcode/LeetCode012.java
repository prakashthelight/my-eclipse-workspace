package com.samples.leetcode;

/**
 * Integer to Roman <br/>
 * https://leetcode.com/problems/integer-to-roman
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode012 {

	public static void main(String[] args) {
		int num = 3999;

		System.out.println(intToRoman(num));
	}

	/**
	 * convert number to roman
	 * 
	 * @param num
	 * @return
	 */
	public static String intToRoman(int num) {

		String M[] = { "", "M", "MM", "MMM" };
		String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

		return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
	}
}
