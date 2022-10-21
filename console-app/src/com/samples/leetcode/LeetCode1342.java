package com.samples.leetcode;

/**
 * 1342. Number of Steps to Reduce a Number to Zero </br>
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/description/
 * 
 * @author Kumar, Prakash
 * @category Math, Bit Manipulation
 */
public class LeetCode1342 {

	public static void main(String[] args) {
		System.out.println(numberOfSteps(14));
	}
	
	public static int numberOfSteps(int num) {
        int step = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }

            step++;
        }

        return step;
    }
}
