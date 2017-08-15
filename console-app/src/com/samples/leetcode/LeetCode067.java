package com.samples.leetcode;

import java.util.Stack;

/**
 * Add Binary
 * https://leetcode.com/problems/add-binary/
 * @author kumarpr
 *
 */

public class LeetCode067 {

	public static void main(String[] args) {
		String a = "1001";
		String b = "101";
		System.out.println(String.format("%s + %s -> %s", a, b, addBinary(a, b)));
	}
	
	/**
	 * returns sum of two binary numbers as string
	 * @param a
	 * @param b
	 * @return
	 */
	
	public static String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            a = "0";
        }
        
        if (b == null || b.isEmpty()) {
            b = "0";
        }
        
        if ("0".equals(a)) return b;
        if ("0".equals(b)) return a;
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        Stack<Integer> st = new Stack<>();
        
        int remainder = 0;
        int sum = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                sum = Character.getNumericValue(a.charAt(i--)) + Character.getNumericValue(b.charAt(j--)) + remainder;
            } else if (i >= 0) {
                sum = Character.getNumericValue(a.charAt(i--)) + remainder;
            } else if (j >=0 ) {
                sum = Character.getNumericValue(b.charAt(j--)) + remainder;                
            }
            
            st.push(sum % 2);
            remainder = sum / 2;
        }
        
        if (remainder == 1) {
            st.push(remainder);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(String.valueOf(st.pop()));
        }
        
        return sb.toString();        
    }

}
