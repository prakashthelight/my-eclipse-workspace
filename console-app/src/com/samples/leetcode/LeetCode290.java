package com.samples.leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Word Pattern
 * https://leetcode.com/problems/word-pattern
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode290 {

	public static void main(String[] args) {
		
		String pattern = "abba", str = "dog cat cat dog"; // true.
		// String pattern = "abba", str = "dog cat cat fish"; // false.
		// String pattern = "aaaa", str = "dog cat cat dog"; // false.
		// String pattern = "abba", str = "dog dog dog dog"; // false.
		
		System.out.println(wordPattern(pattern, str));
	}

	public static boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");

		if (pattern.length() != words.length)
			return false;

		LinkedHashMap<Character, LinkedList<Integer>> charToIndeces = new LinkedHashMap<>(); 
		LinkedHashMap<String, LinkedList<Integer>> wordToIndeces = new LinkedHashMap<>(); 

		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			if (!charToIndeces.containsKey(ch)) {
				LinkedList<Integer> indeces = new LinkedList<Integer>();
				indeces.add(i);
				charToIndeces.put(ch, indeces);
			} else {
				charToIndeces.get(ch).add(i);
			}
		}

		// make map of unique strings as key and list of their indeces
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (!wordToIndeces.containsKey(word)) {
				LinkedList<Integer> indeces = new LinkedList<Integer>();
				indeces.add(i);
				wordToIndeces.put(word, indeces);
			} else {
				wordToIndeces.get(word).add(i);
			}
		}

		// if unique key count is different for pattern and words
		if (charToIndeces.size() != wordToIndeces.size())
			return false;

		Iterator<Character> charIt = charToIndeces.keySet().iterator();
		Iterator<String> wordIt = wordToIndeces.keySet().iterator();

		while (charIt.hasNext() && wordIt.hasNext()) {
			LinkedList<Integer> charIndeces = charToIndeces.get(charIt.next());
			LinkedList<Integer> wordIndeces = wordToIndeces.get(wordIt.next());

			if (charIndeces.size() != wordIndeces.size()) {
				return false;
			}

			for (int index : charIndeces) {
				if (!wordIndeces.contains(index)) {
					return false;
				}
			}
		}

		return true;
	}

}
