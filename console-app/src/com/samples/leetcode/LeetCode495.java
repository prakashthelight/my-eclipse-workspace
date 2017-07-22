package com.samples.leetcode;

/**
 * Teemo Attacking
 * https://leetcode.com/problems/teemo-attacking
 * @author kumarpr
 *
 */
public class LeetCode495 {
	
	public static void main(String[] args) {
		int[] timeSeries = new int[] {1, 4};
		int duration = 2;		
		System.out.println(findPoisonedDuration(timeSeries, duration));
	}
	
	public static int findPoisonedDuration(int[] timeSeries, int duration) {        
        
        if (timeSeries == null || timeSeries.length == 0) return 0;
        if (duration == 0) return 0;
        
        // initialize with default poisioned duration
        int result = duration;    
        int prev = timeSeries[0];
        
        for (int i = 1; i < timeSeries.length; i++) {
        	// if current attack point is less than previous attack point + duration
        	int current = timeSeries[i]; 
        	if (current < prev + duration) {
                result += duration - (prev + duration - current);    
            } else {
                result += duration;
            }
        	
        	prev = current;
        }
        
        return result;
    }
}
