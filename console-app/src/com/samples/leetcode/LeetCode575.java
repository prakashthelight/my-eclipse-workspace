package com.samples.leetcode;

import java.util.HashSet;

/**
 * Distribute Candies
 * https://leetcode.com/problems/distribute-candies
 * @author Kumar, Prakash
 *
 */
public class LeetCode575 {
	
	public static void main(String[] args) {
		int[] candies = {1,1,2,2,3,3};
		
		System.out.println(distributeCandies(candies));
	}
	
	/**
	 * return number of types of candies sister can get, if candies need to 
	 * be divided equally between brother and sister
	 * @param candies
	 * @return
	 */
	public static int distributeCandies(int[] candies) {
        int total = candies.length;        
        int maxCandies = total / 2;
        
        // get types of candies
        HashSet<Integer> typeOfCandies = new HashSet<Integer>();
        
        for (int candy : candies) {
            typeOfCandies.add(candy);
        }
        
        // return minimum of ones share (which is half of all candies) 
        // and unique types of candies
        return Math.min(maxCandies, typeOfCandies.size());
    }
}
