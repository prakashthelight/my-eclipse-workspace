package com.samples.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Insert Delete GetRandom O(1) - Duplicates are not allowed <br/>
 * https://leetcode.com/problems/insert-delete-getrandom-o1
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode380 {

	public static void main(String[] args) {
		RandomizedSet collection = new LeetCode380().new RandomizedSet();

		System.out.println(collection.insert(10));
		System.out.println(collection.insert(20));
		System.out.println(collection.insert(15));
		System.out.println(collection.getRandom());

		System.out.println(collection.remove(20));

		System.out.println(collection.getRandom());
	}

	class RandomizedSet {

		private ArrayList<Integer> list;
		private HashMap<Integer, Integer> map;

		public RandomizedSet() {
			this.list = new ArrayList<>();
			this.map = new HashMap<>();
		}

		public boolean insert(int value) {
			// duplicates are not allowed
			if (map.containsKey(value)) {
				return false;
			}

			list.add(value);
			map.put(value, list.size() - 1);
			return true;
		}

		public boolean remove(int value) {
			if (!map.containsKey(value)) {
				return false;
			}

			int removeIndex = map.get(value);

			int lastValue = list.get(list.size() - 1);

			if (removeIndex < list.size() - 1) {
				list.set(removeIndex, lastValue);
				map.put(lastValue, removeIndex);
			}

			map.remove(value);
			list.remove(list.size() - 1);

			return true;
		}

		public int getRandom() {
			return list.get(new Random().nextInt(list.size()));
		}
	}
}
