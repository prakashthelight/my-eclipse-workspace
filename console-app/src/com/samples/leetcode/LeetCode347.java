package com.samples.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 * @author Kumar, Prakash
 *
 */
public class LeetCode347 {

	public static void main(String[] args) {
		
		int[] nums = {1,1,2,2,2,3};
		int k = 2;
		
		List<Integer> list = topKFrequent(nums, k);
		
		System.out.println(String.format("Array of integers: %s", Arrays.toString(nums)));
		System.out.println(String.format("Top frequency integers: %s", list.toString()));	
	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> counts = new HashMap<>();

		for (int num : nums) {
			if (counts.containsKey(num)) {
				counts.put(num, counts.get(num) + 1);
			} else {
				counts.put(num, 1);
			}
		}

		PriorityQueue<Item> q = new PriorityQueue<Item>(new Comparator<Item>(){
			@Override
			public int compare(Item a, Item b) {
				return b.count - a.count;
			}
		});

		for (int key : counts.keySet()) {
            q.offer(new Item(key, counts.get(key)));
        }

		List<Integer> list = new ArrayList<>();
		while (k > 0 && !q.isEmpty()) {
			list.add(q.poll().num);
			k--;
		}

		return list;
	}

	static class Item {
		int num;
		int count;

		public Item(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}
}
