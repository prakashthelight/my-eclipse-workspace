package com.samples.leetcode;

import java.util.Stack;

/**
 * Longest Valid Parentheses <br/>
 * https://leetcode.com/problems/longest-valid-parentheses
 * 
 * @author Kumar, Prakash
 *
 */

public class LeetCode032 {

	public static void main(String[] args) {
		String str = ")()())";

		System.out.println(longestValidParentheses(str));
	}

	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		// stack will endup having index of not matched braces, and
		// valid strings should be between these braces
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
				stack.push(i);
				break;
			case ')':

				if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
					stack.pop();
				} else {
					stack.push(i);
				}
				break;
			}
		}

		// if stack is empty, no invalid parenthesis, and hence full string is valid
		if (stack.isEmpty()) {
			return s.length();
		}

		int max = 0;

		int end = s.length(), start = 0;

		// get indeces of invalid parenthesis and calculate max length of valid string 
		while (!stack.isEmpty()) {			
			start = stack.pop();
			max = Math.max(max, end - start - 1);
			end = start;
		}

		// for valid string between 0 first invalid parenthesis
		max = Math.max(max, end);

		return max;
	}
}
