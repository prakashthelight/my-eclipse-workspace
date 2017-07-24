package com.samples.leetcode;

import java.util.Stack;

/**
 * Multiply two Strings
 * https://leetcode.com/problems/multiply-strings
 * @author kumarpr
 *
 */
public class LeetCode043 {
	
	public static void main(String[] args) {		
		//System.out.println("4689849346206".equals(multiply("856974", "5472569")));		
		//System.out.println("0".equals(multiply("856974", "0")));
		System.out.println(Integer.toString(237 * 284).equals(multiply("237", "284")));
	}	
	
	/**
	 * Multiplies two strings
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String multiply(String num1, String num2) {
        
        if (num1 == null || "0".equals(num1)) return "0";
        if (num2 == null || "0".equals(num2)) return "0";
        
		String result = "0";	
		String m = "";
		for (int i = num2.length() - 1; i >= 0; i--) {			
			String p = multiply(num1, num2.charAt(i));		
			
			if (i == num2.length() - 1) {
				result = p;
			} else {
				result = add(result, p + m);
			}
			m += "0";
		}		
		return result;
	}
	
	/**
	 * multiply Number-String with Single digit - char
	 * @param num1
	 * @param ch
	 * @return
	 */
	public static String multiply(String num1, char ch) {
        if (ch == '0') return "0";
		Stack<Integer> stack = new Stack<>();		
		int remainder = 0;
		int a = Character.getNumericValue(ch);		
		for (int i = num1.length()-1 ; i >= 0; i--) {
			int b = Character.getNumericValue(num1.charAt(i));		
			int value = a * b + remainder;
			stack.push(value % 10);			
			remainder = value / 10;
		}
		
		if (remainder != 0) {
			stack.push(remainder);
		}
		
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}
	
	/**
	 * Adds two Strings
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String add(String num1, String num2) {		
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
