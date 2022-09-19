package com.samples.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * 205. Isomorphic Strings <br/>
 * https://leetcode.com/problems/isomorphic-strings
 * 
 * @author Kumar, Prakash
 * @category Hash Table, String
 */
public class LeetCode205 {

	public static void main(String[] args) {

		String s = "egg", t = "add"; // true
		// String s = "foo", t = "bar"; // true
		// String s = "paper", t = "title"; // true

		System.out.println(String.format("\'%s\' and \'%s\' are isomorphic : %s", s, t, isIsomorphic(s, t)));
	}
	
	public static boolean isIsomorphic(String s, String t) {		
		int[] sMap = new int[256];
		int[] tMap = new int[256];
		
		var sChars = s.toCharArray();
		var tChars = t.toCharArray();
		
		for(int i = 0; i < s.length(); i++) {
			char sch = sChars[i];
			char tch = tChars[i];
			
			if (sMap[sch] == 0 && tMap[tch] == 0) {
				sMap[sch] = tch;
				tMap[tch] = sch;
			} else if ( sMap[sch] != tch || tMap[tch] != sch) {
				return false;
			} 
		}	
		
		return true;
	}
	
	public static boolean isIsomorphic2(String s, String t) {		
		HashMap<Character, Character> s_to_t = new HashMap<Character, Character>();
		HashMap<Character, Character> t_to_s = new HashMap<Character, Character>();
		
		if (s.length() != t.length()) {
			return false;
		}
		
		for(int i = 0; i < s.length(); i++) {
			char sch = s.charAt(i);
			char tch = t.charAt(i);
			
			if (!s_to_t.containsKey(sch) && !t_to_s.containsKey(tch)) {
				s_to_t.put(sch, tch);
				t_to_s.put(tch, sch);
			} else if ((s_to_t.containsKey(sch) && s_to_t.get(sch) != tch) &&
					(t_to_s.containsKey(tch) && t_to_s.get(tch) != sch)) {
				return false;
			} 
		}	
		
		return true;
	}

	public static boolean isIsomorphic1(String s, String t) {

		if (s == null || t == null || s.length() != t.length())
			return false;

		if (s.equals(t))
			return true;

		LinkedHashMap<Character, ArrayList<Integer>> mapS = new LinkedHashMap<Character, ArrayList<Integer>>();
		LinkedHashMap<Character, ArrayList<Integer>> mapT = new LinkedHashMap<Character, ArrayList<Integer>>();

		// create map of unique keys and corresponding list of their indices for
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

		// create map of unique keys and corresponding list of their indices for
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

		// if unique keys count are not same, return false;
		if (mapS.size() != mapT.size()) {
			return false;
		}

		Iterator<Character> itS = mapS.keySet().iterator();
		Iterator<Character> itT = mapT.keySet().iterator();

		// compare indexes for each unique keys
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
