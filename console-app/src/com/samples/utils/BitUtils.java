package com.samples.utils;

public class BitUtils {
	
	/**
	 * returns only number appearing once, rest comes twice in array
	 * @param array
	 * @return
	 */
	public static int singleOccurence(int[] array) {
		int num = 0;
		
		for (int item : array) {
			num ^= item;
		}
		
		return num;
	}
	
	/**
	 * count set bits in binary presentation of a number e.g. 5 -> 3
	 * @param a
	 * @return
	 */
	
	public static int numSetBits(long a) {		
		int count = 0;
		
		while (a != 0) {
			count += a & 1;
			a >>= 1;
		}
		
		return count;
	}
}
