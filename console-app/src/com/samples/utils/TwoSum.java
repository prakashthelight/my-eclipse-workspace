package com.samples.utils;

import java.util.*;

public class TwoSum {

	private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();

	/**
	 * Add number to collection
	 * 
	 * @param num
	 */
	public void Add(int num) {
		if (elements.containsKey(num)) {
			elements.put(num, elements.get(num) + 1);
		} else {
			elements.put(num, 1);
		}
	}

	/**
	 * Find if elements have numbers having sum equal to given number
	 * 
	 * @param sum
	 * @return
	 */
	public boolean Find(int sum) {
		for (int i : elements.keySet()) {
			int target = sum - i;
			if (elements.containsKey(target)) {
				if (i == target && elements.get(target) < 2) {
					continue;
				}
				return true;
			}
		}
		return false;
	}
}
