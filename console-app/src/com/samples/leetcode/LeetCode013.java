package com.samples.leetcode;

/**
 * Roman to Integer
 * https://leetcode.com/problems/roman-to-integer
 * @author Kumar, Prakash
 *
 */
public class LeetCode013 {

	public static void main(String[] args) {	
		String romanNumber = "DCXXI";
		
		System.out.println(romanToInt(romanNumber));
	}

	/**
	 * converts roman string to integer
	 * @param s
	 * @return
	 */
	public static int romanToInt(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		int[] nums = new int[s.length()];

		for (int i = 0; i < nums.length; i++) {
			char ch = s.charAt(i);

			switch (ch) {
			case 'M':
				nums[i] = 1000;
				break;
			case 'D':
				nums[i] = 500;
				break;
			case 'C':
				nums[i] = 100;
				break;
			case 'L':
				nums[i] = 50;
				break;
			case 'X':
				nums[i] = 10;
				break;
			case 'V':
				nums[i] = 5;
				break;
			case 'I':
				nums[i] = 1;
				break;
			}
		}

		int result = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < nums[i + 1]) { // XL is -10 + 50
				result -= nums[i];
			} else {
				result += nums[i];
			}
		}

		// add last item
		result += nums[nums.length - 1];

		return result;
	}

}
