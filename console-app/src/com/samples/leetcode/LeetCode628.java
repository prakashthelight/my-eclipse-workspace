package com.samples.leetcode;

import java.util.Arrays;

/**
 * Maximum Product of Three Numbers
 * https://leetcode.com/problems/maximum-product-of-three-numbers
 * @author kumarpr
 *
 */
public class LeetCode628 {	
	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3 };	

		// another test case;
		array = new int[] { -4, -3, -2, -1, 60 };
		System.out.println(maximumProduct(array));
	}

	public static int maximumProduct(int[] array) {
		if (array == null || array.length < 3) {
			throw new IllegalArgumentException("Invalid array or array length less than 3");
		}
        
        int n = array.length;
        
        Arrays.sort(array);
        
        // product of top 3 max numbers
        int a = array[n - 1] * array [ n - 2] * array [n - 3];
        
        // product of top positive and top two negative numbers 
        int b = array[n - 1] * array [1] * array[0];
            
        return Math.max(a, b);
	}
}
