package com.samples.leetcode;

import java.util.Stack;

/**
 * Valid Parentheses <br/>
 * https://leetcode.com/problems/valid-parentheses
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode020 {

	public static void main(String[] args) {
		String str = "()[]{}";
		System.out.println(isValid(str));
	}

	/**
	 * return true if valid order of open and close braces;
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		String openBraces = "({[";
		String closeBraces = ")}]";

		Stack<Character> stack = new Stack<Character>();

		for (char ch : s.toCharArray()) {
			// if open brace, push to stack
			if (openBraces.indexOf(ch) > -1) {
				stack.push(ch);
			}

			// if close brace, check if stack has corresponding open brace at
			// top of stack. If not return false;
			if (closeBraces.indexOf(ch) > -1) {

				if (stack.isEmpty() || stack.peek() != openBraces.charAt(closeBraces.indexOf(ch))) {
					return false;
				}
				stack.pop();
			}
		}

		// stack is sopposed to empty after all open braces balanced out with
		// close braces.
		return stack.isEmpty();
	}
}