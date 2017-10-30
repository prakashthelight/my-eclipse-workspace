package com.samples.leetcode;

import java.util.HashMap;

/**
 * LRU Cache <br/>
 * https://leetcode.com/problems/lru-cache/ * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode146 {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4
	}
}

class LRUCache {
	int capacity;

	HashMap<Integer, DListNode> map;
	
	// head and tail pointers for each operations at both end;
	DListNode head, tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
	}	

	// retrieves value from cache
	public int get(int key) {
		if (!this.map.containsKey(key)) {
			return -1;
		}
		
		DListNode node = this.map.get(key);	
		
		// move node to head, as this is most recently used node now
		removeNode(node);
		addToHead(node);
		
		return node.value;
	}

	/**
	 * Adds new element in cache
	 * @param key
	 * @param value
	 */
	public void put(int key, int value) {		
		DListNode node = this.map.get(key);
		
		if (node != null) {
			node.value = value;
			removeNode(node);
		} else {			
			if (this.map.size() == this.capacity) {
				removeLastNode();
			}
			
			node = new DListNode(key, value);
		}
		
		addToHead(node);
	}
	
	/**
	 * adds node as the head of list, and updates map adding the key
	 * @param node
	 */
	private void addToHead(DListNode node) {
		
		if (this.head == null) {
			this.head = node;
			this.tail = node;
		} else {
			node.next = this.head;
			this.head.prev = node;
			this.head = node;
		}
		
		// update map
		this.map.put(node.key, node);
	}
	
	/**
	 * removes give node and updates map for key
	 * @param node
	 */
	private void removeNode (DListNode node) {
		
		if (node == this.tail) {
			removeLastNode();
			return;
		}
		
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		
		if (node == head && node == tail) {
			head = null;
			tail = null;					
		}
		
		if (node == tail) {
			tail = tail.prev;
		}
		
		if (node == head) {
			head = head.next;
		}	
		
		node.next = null;
		node.prev = null;
		
		// update map
		this.map.remove(node.key);
	}
	
	/**
	 * removes last node, and also updates the map and removes key entry
	 */
	private void removeLastNode() {
		DListNode tailNode = tail;
		
		if (tailNode != null) {
			if (tailNode.prev != null) {
				tailNode.prev.next = null;
			}
			
			tail = tailNode.prev;
			if (tail == null) {
				head = null;
			}
			
			// update map
			this.map.remove(tailNode.key);
		}
	}
}

/**
 * A double linklist node 
 * @author Kumar, Prakash
 *
 */
class DListNode {	
	int key;
	int value;
	DListNode prev;
	DListNode next;

	public DListNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
