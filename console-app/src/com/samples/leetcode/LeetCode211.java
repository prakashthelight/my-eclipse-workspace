package com.samples.leetcode;

import java.util.HashMap;

/**
 * Add and Search Word - Data structure design
 * https://leetcode.com/problems/add-and-search-word-data-structure-design
 * @author Kumar, Prakash
 *
 */
public class LeetCode211 {
	
	public static void main(String[] args) {
		WordDictionary dictionary = new WordDictionary();
		dictionary.addWord("mad1");
		dictionary.addWord("sad");

		System.out.println(dictionary.searchWord("mad1"));
	}
}

class WordDictionary {

	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode('/');
	}

	public void addWord(String word) {
		HashMap<Character, TrieNode> children = root.children;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode temp;
			if (!children.containsKey(ch)) {
				temp = new TrieNode(ch);
				children.put(ch, temp);
			} else {
				temp = children.get(ch);
			}

			children = temp.children;
			if (i == word.length() - 1) {
				temp.isLeaf = true;
			}
		}
	}

	public boolean searchWord(String word) {
		
		TrieNode temp = null;
		
		if (word.indexOf('.') > -1) {
			temp = searchPattern(word);
		} else {
			temp = searchTrieNode(word);
		}
		
		if (temp != null && temp.isLeaf) {
			return true;
		}

		return false;
	}
	
	public TrieNode searchPattern(String pattern) {	
		//HashMap<Character, TrieNode> children = root.children;
		TrieNode node = null;
		
		// TODO
		/**
		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			
			if (ch != '.') {
				if (children.containsKey(ch)) {
					TrieNode tempNode = children.get(ch);
					children = tempNode.children;

					node = tempNode;
				} else {
					return null;
				}
			} else {
				
			}			
		}**/
		
		return node;
	}

	private TrieNode searchTrieNode(String word) {
		HashMap<Character, TrieNode> children = root.children;
		TrieNode node = null;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);

			if (children.containsKey(ch)) {
				TrieNode tempNode = children.get(ch);
				children = tempNode.children;

				node = tempNode;
			} else {
				return null;
			}
		}

		return node;
	}
}

class TrieNode {
	char key;

	HashMap<Character, TrieNode> children = new HashMap<>();

	boolean isLeaf;	

	public TrieNode(char key) {
		this.key = key;
		this.children = new HashMap<>();
	}
}
