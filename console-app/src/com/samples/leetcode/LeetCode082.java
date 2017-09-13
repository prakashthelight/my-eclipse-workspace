package com.samples.leetcode;

import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * Remove Duplicates from Sorted List II <br/>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode082 {
	public static void main(String[] args) {
		// create a sorted linked list
		ListNode head = MyLinkedListUtil.createLinkedList(new int[] { 10, 10, 12, 15, 18, 18, 18, 30, 30 });
		MyLinkedListUtil.print(head);
		head = deleteDuplicates(head); // removes duplicate
		MyLinkedListUtil.print(head);
	}

	/**
	 * remove duplicate elementes from sorted Linked List, leaving only distinct
	 * elements 1->2->3->3->4->4->5, return 1->2->5
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;
		ListNode current = head;

		while (current != null) {

			// move to last similar value node
			while (current.next != null && current.value == current.next.value) {
				current = current.next;
			}

			// if not duplicates at next node and current did not move at all
			if (prev.next == current) {
				prev = prev.next;
			} else {
				prev.next = current.next;
			}

			current = current.next;
		}

		return dummy.next;
	}
}
