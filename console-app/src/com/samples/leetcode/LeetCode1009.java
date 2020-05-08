package com.samples.leetcode;

/**
 * Complement of Base 10 Integer
 * https://leetcode.com/problems/complement-of-base-10-integer/
 * @author Kumar, Prakash
 *
 */
public class LeetCode1009 {

	public static void main(String[] args) {
		
		System.out.println(bitwiseComplement(0));
		System.out.println(bitwiseComplement(2));
		System.out.println(bitwiseComplement(5));
		System.out.println(bitwiseComplement(10));

	}
	
	public static int bitwiseComplement(int num) {
		
		if (num == 0) return 1;
        
        int result = 0;
		
		int i = 0;
		while (num != 0) {
			int d = num % 2;
			num /= 2;
			
			if (d == 0)
			result += Math.pow(2, i);
			
			i++;					
		}
        
        return result;
    }

}
