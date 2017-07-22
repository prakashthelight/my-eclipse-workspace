package com.samples.leetcode;

import java.util.HashSet;
import java.util.LinkedHashMap;

/**
 * First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string
 * @author kumarpr
 *
 */
public class LeetCode387 {

	public static void main(String[] args) {
		System.out.println(firstUniqChar("loveleetcode"));
	}
	
	/**
	 * find index of first unique character in string
	 * @param s
	 * @return
	 */
	public static int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> unique = new LinkedHashMap<Character, Integer>();
        HashSet<Character> repeated = new HashSet<Character>();
        
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (unique.containsKey(ch)) {
                unique.remove(ch);
                repeated.add(ch);
            } else {
                if (!repeated.contains(ch)) {
                    unique.put(ch, i);
                }
            }
            i++;
        }
        
        return unique.keySet().size() > 0 ? unique.get(unique.keySet().iterator().next()) : -1;
    }
	
	/**
	 * another efficient one
	 * @param s
	 * @return
	 */
	public static int firstUniqChar1(String s) {
        int frequency[] = new int[26];
        for(int i = 0; i < s.length(); i++)
        	frequency[s.charAt(i) - 'a']++;
        
        for(int i = 0; i < s.length(); i++)
        	// look for first one with count 1;
            if(frequency[s.charAt(i) - 'a'] == 1) 
                return i;
        return -1;
    }

}
