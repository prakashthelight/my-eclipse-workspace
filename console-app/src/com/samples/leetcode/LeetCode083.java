package com.samples.leetcode;

import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * Remove Duplicates from Sorted List <br/>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode083 {

	public static void main(String[] args) {

		// create a sorted linked list
		ListNode head = MyLinkedListUtil.createLinkedList(new int[] { 10, 10, 12, 15, 18, 18, 18, 30, 30 });

		MyLinkedListUtil.print(head);
		head = deleteDuplicates(head); // removes duplicate
		MyLinkedListUtil.print(head);
	}

	/**
	 * remove duplicate elementes from sorted Linked List
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = head;
		ListNode current = head.next;

		while (current != null) {
			if (current.value != prev.value) {
				prev.next = current;
				prev = current;
			}
			current = current.next;
		}

		prev.next = current; // equivalent to setting prev.next = null

		return head;
	}
}
