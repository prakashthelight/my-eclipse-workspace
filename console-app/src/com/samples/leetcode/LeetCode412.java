package com.samples.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz <br/>
 * https://leetcode.com/problems/fizz-buzz
 * 
 * @author Kumar, Prakash
 * @category Math, String, Simulation
 */
public class LeetCode412 {

	public static void main(String[] args) {
		for (String str : fizzBuzz(15)) {
			System.out.println(str);
		}
	}

	/**
	 * returns string representation of numbers, fizz for muliples of 3, and buzz for multiples of 5
	 * @param n
	 * @return
	 */
	public static List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<String>();

		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				list.add("FizzBuzz");
			} else if (i % 3 == 0) {
				list.add("Fizz");
			} else if (i % 5 == 0) {
				list.add("Buzz");
			} else {
				list.add(String.valueOf(i));
			}
		}

		return list;
	}
	
	public static List<String> fizzBuzz1(int n) {
        List<String> result = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            boolean isDivisibleBy3 = i % 3 == 0;
            boolean isDivisibleBy5 = i % 5 == 0;

            String item = "";
            if (isDivisibleBy3) {
                item += "Fizz";
            }

            if (isDivisibleBy5) {
                item += "Buzz";
            }

            if (item.isEmpty()) {
                item += String.valueOf(i);
            }

            result.add(item);
        } 

        return result;      
    }
}
