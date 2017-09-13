package com.samples.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * Insert Delete GetRandom O(1) - Duplicates allowed <br/>
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode381 {

	public static void main(String[] args) {
		RandomizedCollection collection = new LeetCode381().new RandomizedCollection();

		/*
		 * System.out.println(collection.insert(0));
		 * System.out.println(collection.insert(1));
		 * System.out.println(collection.insert(2));
		 * System.out.println(collection.insert(3));
		 * System.out.println(collection.insert(3));
		 * 
		 * System.out.println(collection.remove(2));
		 * System.out.println(collection.remove(3));
		 * System.out.println(collection.remove(0));
		 * 
		 * System.out.println(collection.getRandom());
		 * System.out.println(collection.getRandom());
		 * System.out.println(collection.getRandom());
		 * System.out.println(collection.getRandom());
		 */

		System.out.println(collection.insert(4));
		System.out.println(collection.insert(3));
		System.out.println(collection.insert(4));
		System.out.println(collection.insert(2));
		System.out.println(collection.insert(4));
		System.out.println(collection.remove(4));
		System.out.println(collection.remove(3));
		System.out.println(collection.remove(4));
		System.out.println(collection.remove(4));
	}

	class RandomizedCollection {

		private ArrayList<Integer> list;
		private HashMap<Integer, Set<Integer>> map;

		public RandomizedCollection() {
			this.list = new ArrayList<>();
			this.map = new HashMap<>();
		}

		public boolean insert(int value) {

			list.add(value);

			// duplicates are allowed
			if (!map.containsKey(value)) {
				map.put(value, new LinkedHashSet<>());
			}

			map.get(value).add(list.size() - 1);
			return true;
		}

		public boolean remove(int value) {
			
			// if map does not contains value, return false;
			if (!map.containsKey(value)) {
				return false;
			}

			int removeIndex = map.get(value).iterator().next();
			map.get(value).remove(removeIndex);

			int lastValue = list.get(list.size() - 1);

			if (removeIndex < list.size() - 1) {
				list.set(removeIndex, lastValue);

				map.get(lastValue).remove(list.size() - 1);
				map.get(lastValue).add(removeIndex);
			}

			if (map.get(value).size() == 0) {
				map.remove(value);
			}

			list.remove(list.size() - 1);

			return true;
		}

		public int getRandom() {
			return list.get(new Random().nextInt(list.size()));
		}
	}
}
