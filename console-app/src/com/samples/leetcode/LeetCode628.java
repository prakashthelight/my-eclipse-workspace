package com.samples.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Maximum Product of Three Numbers
 * https://leetcode.com/problems/maximum-product-of-three-numbers
 * @author kumarpr
 *
 */
public class LeetCode628 {
	public static void main(String[] args) {		
		System.out.println("Running  - Leetcode - 628");
		
		int[] array = new int[] { 1, 2, 3 };

		// another test case;
		array = new int[] { -4, -3, -2, -1, 60 };
		System.out.println(maximumProduct(array));
	}

	public static int maximumProduct(int[] array) {
		if (array == null || array.length < 3) {
			throw new IllegalArgumentException("Invalid array or array length less than 3");
		}

		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				if (a < 0 && b < 0) {
					return a - b;
				} else {
					return b - a;
				}
			}
		});

		for (int item : array) {
			q.offer(item);
		}

		return q.poll() * q.poll() * q.poll();
	}
}
