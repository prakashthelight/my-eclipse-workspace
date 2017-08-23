package com.samples.leetcode;

/**
 * Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode191 {

	public static void main(String[] args) {
		System.out.println(hammingWeight(5)); // 2
	}
	
	/**
	 * returns number of set bits
	 * @param n
	 * @return
	 */
	public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count+= n & 1;
            n >>>= 1;
        }
        return count;
    }
}
