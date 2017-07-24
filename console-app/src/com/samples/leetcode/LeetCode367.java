package com.samples.leetcode;

public class LeetCode367 {
	
	public static void main(String[] args) {
		int num = 144;
		System.out.println(String.format("%s is perfect square - %s", num, isPerfectSquare(num)));
	}
	
    public static boolean isPerfectSquare(int num) {
        if (num == 0) return false;
        if (num == 1) return true;
        
        int left = 1;
        int right = num;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (mid * mid == num) 
                return true;
            
            if (mid * mid > num) {
                right = (int) mid - 1;
            } else {
                left = (int) mid + 1;
            }            
        }
        
        return false;        
    }
}
