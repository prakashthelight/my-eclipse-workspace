package com.samples.leetcode;

import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * Linked List Cycle <br/>
 * https://leetcode.com/problems/linked-list-cycle
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode141 {

	public static void main(String[] args) {
		ListNode head = MyLinkedListUtil.createLinkedList(new int[] { 10, 20, 15, 30, 8, 12 });
		MyLinkedListUtil.print(head);

		// create a cycle at position 2,
		// pointing last node's next to position 2 node
		MyLinkedListUtil.createCycle(head, 2);

		System.out.println("LinkedList has cycle: " + hasCycle(head));
	}

	/**
	 * return true if Linked List has cycle
	 * 
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(ListNode head) {

		if (head == null || head.next == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;
	}
}
