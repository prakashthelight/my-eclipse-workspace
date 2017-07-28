package com.samples.utils;

import java.util.Stack;

public class MathsUtils {
	
	public static int gcd(int a, int b) {
	    if (b > a) {
	        int temp = a;
	        a = b;
	        b = temp;
	    }
	    
	    if (b == 0) {
	        return a;
	    } else if (b == 1) {
	        return 1;
	    } else if ( a % b == 0) {
	        return b;
	    } else if (a == b) {
	        return b;
	    } else {
	        return gcd(a-b, b);    
	    }
    }
	
	
	public static String changeBaseTo7(int num) {
		
		if (num == 0) {
			return "0";
		}
		
		char[] chars = new char[] {'0', 'a', 't', 'l', 's', 'i', 'n'};
		
		Stack<Character> stack = new Stack<Character>();
		
		
		while (num != 0) {
			stack.push(chars[num % 7]);
			num = num / 7;			
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (!stack.isEmpty()) {			
			sb.append(stack.pop()+"");
		}
		
		return sb.toString();
	}
	
	public static String changeBaseTo2(int num) {
		
		if (num == 0) {
			return "0";
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while (num != 0) {
			stack.push(num % 2);
			num = num / 2;			
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (!stack.isEmpty()) {			
			sb.append(stack.pop()+"");
		}
		
		return sb.toString();
	}
	
	public static int reverse(int num) {
		int newInt = 0;        
        while (num != 0) {
            try {            	
            	if (newInt > newInt * 10) 
            		throw new ArithmeticException();
                newInt = newInt * 10 + num % 10;    
            } catch (ArithmeticException   e) {
                newInt = 0;
                break;
            }
            
            num = num / 10;
        }
        
        return newInt;
	}
	
	
	/**
	 * fibonacci - iterative
	 * @param n
	 * @return
	 */
	public static int fibonacci(int n) {		
		if (n == 0 || n == 1) return n;
		
		int a  = 0, b = 1;
		int c = a + b;
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return c;
	}
	
	/**
	 * fibonacci - recursive
	 * @param n
	 * @return
	 */
	public static long fibonacciRec(int n) {		
		if (n == 0 || n == 1) {
			return n;
		} 

		return fibonacciRec(n - 1) + fibonacciRec(n - 2);
	}
	
	/**
	 * fibonacci - memoization
	 * @param n
	 * @param memo
	 * @return
	 */
	public static int fibonacci(int n, int[] memo) {		
		if (n == 0 || n == 1) {
			return n;
		}
		
		if (memo[n] == 0) {
			memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);;			
		}		
		return memo[n];		
	}	
}
