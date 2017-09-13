package com.samples.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Isomorphic Strings <br/>
 * https://leetcode.com/problems/isomorphic-strings
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode205 {

	public static void main(String[] args) {

		String s = "egg", t = "add"; // true
		// String s = "foo", t = "bar"; // true
		// String s = "paper", t = "title"; // true

		System.out.println(String.format("\'%s\' and \'%s\' are isomorphic : %s", s, t, isIsomorphic(s, t)));
	}

	public static boolean isIsomorphic(String s, String t) {

		if (s == null || t == null || s.length() != t.length())
			return false;

		if (s.equals(t))
			return true;

		LinkedHashMap<Character, ArrayList<Integer>> mapS = new LinkedHashMap<Character, ArrayList<Integer>>();
		LinkedHashMap<Character, ArrayList<Integer>> mapT = new LinkedHashMap<Character, ArrayList<Integer>>();

		// create map of unique keys and corresponding list of their indces for
		// s
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!mapS.containsKey(ch)) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				mapS.put(ch, list);
			} else {
				mapS.get(ch).add(i);
			}
		}

		// create map of unique keys and corresponding list of their indces for
		// t
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			if (!mapT.containsKey(ch)) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				mapT.put(ch, list);
			} else {
				mapT.get(ch).add(i);
			}
		}

		// if unique keys count are not same, return fasle;
		if (mapS.size() != mapT.size()) {
			return false;
		}

		Iterator<Character> itS = mapS.keySet().iterator();
		Iterator<Character> itT = mapT.keySet().iterator();

		// compare indeces for each unique keys
		while (itS.hasNext() && itT.hasNext()) {
			ArrayList<Integer> sList = mapS.get(itS.next());
			ArrayList<Integer> tList = mapT.get(itT.next());
			for (int index : sList) {
				if (!tList.contains(index)) {
					return false;
				}
			}
		}

		return true;
	}

}
