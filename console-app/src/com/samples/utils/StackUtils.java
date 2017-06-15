package com.samples.utils;

import java.util.Stack;

public class StackUtils {

	public static boolean isValidExpression(String expression) {
		String openingBraces = "{([";
		String closingBraces = "})]";

		Stack<Character> stack = new Stack<>();

		boolean result = true;
		for (char ch : expression.toCharArray()) {
			if (openingBraces.indexOf(ch) > -1) {
				stack.push(ch);
			} else {
				int i = closingBraces.indexOf(ch);
				char open = openingBraces.charAt(i);

				if (stack.isEmpty() || stack.pop() != open) {
					result = false;
					break;
				}
			}
		}

		return result;
	}
	
	public static int evaluatePostfix(String expression) {
		
		if (expression == null || expression.length() == 0) return -1;
		
		Stack<Integer> stack = new Stack<>();
		
		String operators = "+-*/";
		
		for(char ch : expression.toCharArray()) {
			
			int operator = operators.indexOf(ch);
			
			if (operator == -1) {
				stack.push(Character.getNumericValue(ch));
			} else {
				switch (operator) {
				case 0:
					stack.push(stack.pop() + stack.pop());
					break;
				case 1:
					int a = stack.pop();
					int b = stack.pop();
					stack.push(b - a);
					break;
				case 2:
					stack.push(stack.pop() * stack.pop());
					break;
				case 3:
					int p = stack.pop();
					int q = stack.pop();
					stack.push(q / p);
					break;
				}
			}
		}
		
		System.out.print(stack);
		
		return stack.pop();		
	}
}
