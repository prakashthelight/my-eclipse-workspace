package com.samples.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Stack;

public class StringUtils {

	/**
	 * returns true if string has all unique characters
	 * @param str
	 * @return
	 */
	public static boolean isUniqueChars(String str) {
		if (str == null || str.isEmpty())
			return true;

		// boolean array to set char value index set to true
		// if character is encountered
		boolean[] chars = new boolean[255];

		for (char ch : str.toCharArray()) {
			if (chars[ch]) {
				return false;
			}

			chars[ch] = true;
		}

		return true;
	}
	
	/**
	 * returns length of substring with non-repeating characters
	 * 
	 * @param str
	 * @return
	 */
	public static int longestSubstring(String s) {
		int start = 0;
		int max = 0;
		int index = 0;
		int length = s.length();

		HashSet<Character> chars = new HashSet<>();
		while (index < length) {
			if (!chars.contains(s.charAt(index))) {
				chars.add(s.charAt(index++));
				max = Math.max(max, chars.size());
			} else {
				chars.remove(s.charAt(start++));
			}
		}

		return max;
	}

	/**
	 * compressed a given string e.g. aabcccaaadd -> a2b1c3a3d2
	 * 
	 * @param str
	 * @return
	 */
	public static String compress(String str) {
		if (str == null || str.isEmpty())
			return str;

		StringBuilder sb = new StringBuilder();

		int count = 0;
		char[] chars = str.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			count++;
			if (i + 1 >= chars.length || chars[i] != chars[i + 1]) {
				sb.append(chars[i]).append(count);
				count = 0;
			}
		}

		String compressedStr = sb.toString();

		return compressedStr.length() < str.length() ? compressedStr : str;
	}
	
	/**
	 * remove paired characters aaabccddd -> abd
	 * @param str
	 * @return
	 */
	public static String getSuperReducedString(String str) {
		if (str == null || str.length() < 2)
			return str;

		Stack<Character> stack = new Stack<>();

		char[] chars = str.toCharArray();

		for (int i = chars.length - 1; i >= 0; i--) {
			char ch = chars[i];
			if (!stack.isEmpty()) {
				if (stack.peek() == ch) {
					stack.pop();
				} else {
					stack.push(ch);
				}
			} else {
				stack.push(ch);
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.toString();

	}
	
	/**
	 * returns true if given strings are permutation of each other
	 * @param source
	 * @param target
	 * @return
	 */
	
	public static boolean isPermutation(String source, String target) {
		if (source == null || source.isEmpty() || target == null || target.isEmpty()) {
			return false;
		}			
		
		// return false of lengths are not equal
		if (source.length() != target.length()) {
			return false;
		}
		
		if (sort(source).equals(sort(target))) {
			return true;
		}
		
		return false;
	}
	
	public static String sort(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	/**
	 * reverse statement by words i.e. last word becomes first
	 * @param str
	 * @return
	 */
	public static String reverseByWord(String str) {
		
		int i = 0;
		int j = 0;
		char[] array = str.toCharArray();

		while (i < array.length) {
			// reverse each word
			if (array[i] == ' ') {
				reverse(array, j, i - 1);
				j = i + 1;
			}
			
			i++;
		}

		// reverse last word
		reverse(array, j, array.length - 1);

		// reverse statement again
		reverse(array, 0, array.length - 1);

		return String.valueOf(array);
	}
	
	/**
	 * reverse char array
	 * @param array
	 * @param start
	 * @param end
	 */
	public static void reverse(char[] array, int start, int end) {

		while (start < end) {
			char temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
	
	public static String lookAndSay (String str) {
		
		char[] chars = str.toCharArray();	
		int i = 1;
		
		char ch = chars[0];
		int count = 1;
		
		StringBuilder sb = new StringBuilder();
		while (i < chars.length) {
			if (chars[i] == ch) {
				count++;
				i++;
			} else {
				sb.append(count+"" + ch);
				ch = chars[i];
				count=1;
				i++;
			}
		}
		
		sb.append(count+""+ch);
		
		return sb.toString();
	}
	
	public static char findFirstUniqueChar(String str) {
		
		char result = '\u0000';
		if (str == null || str.isEmpty()) return result;
		
		HashSet<Character> unique = new LinkedHashSet<>();
		HashSet<Character> repeated = new HashSet<>();
		
		for (char ch : str.toCharArray()) {
			if (unique.contains(ch)) {
				unique.remove(ch);
				repeated.add(ch);
			} else if (!repeated.contains(ch)) {
				unique.add(ch);
			}
		}
		
		return unique.isEmpty() ? result : unique.iterator().next();
	}
	
	
	/**
	 * search pattern in given source string - Boyer–Moore string search algorithm
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static int searchString(String source, String pattern) {
		int index = -1;
		
		Hashtable<Character, Integer> badMatchTable = new Hashtable<>();
		
		for (int i = 0; i < pattern.length(); i++) {
			badMatchTable.put(pattern.charAt(i), i);
		}
		
		int defaultShift = pattern.length();
		
		int current = pattern.length() - 1;
		int k = current;
		int j = 0;
		
		while (j < pattern.length() && current < source.length()) {
			if (source.charAt(k) == pattern.charAt(defaultShift - j - 1)) {
				k--;
				j++;
			} else {				
				char ch = source.charAt(k);
				
				int shift = -1;
				if (badMatchTable.containsKey(ch)) {
					shift = badMatchTable.get(ch);
				}
				
				shift = Math.max (1, k - shift);
				
				current = current + shift;
				k = current;
				j = 0;
			}
		}
		
		if (j == pattern.length()) {
			index = k + 1;
		}
		
		return index;		
	}
}
