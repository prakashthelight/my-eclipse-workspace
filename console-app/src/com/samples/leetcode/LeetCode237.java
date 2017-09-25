package com.samples.leetcode;

import com.samples.model.ListNode;

/**
 * Delete Node in a Linked List 
 * @author Kumar, Prakash
 *
 */
public class LeetCode237 {

	public static void main(String[] args) {		
		
	}
	
	/**
	 * deletes give node in a LinkedList
	 * @param node
	 */
	public void deleteNode(ListNode node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }
}
