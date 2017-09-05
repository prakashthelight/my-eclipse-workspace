package com.samples.leetcode;

import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * Reorder List
 * https://leetcode.com/problems/reorder-list
 * @author Kumar, Prakash
 *
 */
public class LeetCode143 {

	public static void main(String[] args) {
		ListNode head = MyLinkedListUtil.createLinkedList(new int[] { 1, 2, 3, 4, 5, 6, 7 });

		MyLinkedListUtil.print(head);
		reorderList(head);
		MyLinkedListUtil.print(head);
	}

	public static void reorderList(ListNode head) {

		if (head == null || head.next == null) {
			return;
		}

		ListNode prev = null, slow = head, fast = head, list1 = head;

		// find middle of linked list and break it from middle

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null; // break;

		// reverse second list
		ListNode list2 = reverse(slow);

		merge(list1, list2);
	}

	/**
	 * Reverse Linked List;
	 * @param head
	 * @return
	 */
	public static ListNode reverse(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode p1 = head;
		ListNode p2 = head.next;

		head.next = null;

		while (p2 != null) {
			ListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}

		return p1;
	}

	/**
	 * Merge Two Linked List
	 * @param list1
	 * @param list2
	 */
	public static void merge(ListNode list1, ListNode list2) {
		while (list1 != null) {
			ListNode next1 = list1.next;
			ListNode next2 = list2.next;

			list1.next = list2;

			if (next1 == null) {
				break;
			}

			list2.next = next1;
			list1 = next1;
			list2 = next2;
		}
	}
}
