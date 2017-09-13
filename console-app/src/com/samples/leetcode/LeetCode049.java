package com.samples.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group Anagrams <br/>
 * https://leetcode.com/problems/group-anagrams
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode049 {

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

		for (List<String> list : groupAnagrams(strs)) {
			System.out.println(list.toString());
		}
	}

	/**
	 * returns list of anagrams grouped together
	 * 
	 * @param strs
	 * @return
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {

		// We can also use TreeMap and TreeSet if required by test cases;
		Map<String, List<String>> anagramMap = new HashMap<>();

		for (String str : strs) {

			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);

			// if key not already present
			if (!anagramMap.containsKey(key)) {
				anagramMap.put(key, new ArrayList<String>());
			}

			anagramMap.get(key).add(str);
		}

		List<List<String>> output = new ArrayList<>();

		// populate output list;
		for (String key : anagramMap.keySet()) {
			List<String> list = new ArrayList<String>();

			for (String word : anagramMap.get(key)) {
				list.add(word);
			}

			output.add(list);
		}

		return output;
	}

}
