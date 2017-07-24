package com.samples.leetcode;

import java.util.Stack;

/**
 * Add Strings
 * https://leetcode.com/problems/add-strings
 * @author kumarpr
 *
 */
public class LeetCode415 {
	public static void main(String[] args) {
		String a = "567";		
		String b = "8975";
		System.out.println(addStrings(a, b));
	}
	
	public static String addStrings(String num1, String num2) {
        
        if (num1 == null || num1.isEmpty()) num1 = "0";
        if (num2 == null || num2.isEmpty()) num2 = "0";
        
        if ("0".equals(num1)) return num2;
        if ("0".equals(num2)) return num1;       
        
        
        int i = num1.length() - 1;
		int j = num2.length() - 1;
		
		int remainder = 0;
		Stack<Integer> stack = new Stack<>();
		while (i >= 0 && j >= 0) {		
			int sum = Character.getNumericValue(num1.charAt(i--)) + Character.getNumericValue(num2.charAt(j--)) + remainder;
			stack.push(sum % 10);
			remainder = sum / 10;						
		}
		
		while (i >= 0) {
			int sum = Character.getNumericValue(num1.charAt(i--)) + remainder;
			stack.push(sum % 10);
			remainder = sum / 10;
		} 
		
		while (j >= 0) {
			int sum = Character.getNumericValue(num2.charAt(j--)) + remainder;
			stack.push(sum % 10);
			remainder = sum / 10;
		}
		
		if (remainder == 1) {
			stack.push(remainder);
		}
		
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
    }
}
