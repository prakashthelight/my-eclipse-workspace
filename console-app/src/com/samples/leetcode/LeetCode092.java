package com.samples.leetcode;

import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * Reverse Linked List II <br/>
 * https://leetcode.com/problems/reverse-linked-list-ii
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode092 {

	public static void main(String[] args) {
		ListNode head = MyLinkedListUtil.createLinkedList(new int[] { 10, 20, 15, 30, 8, 12 });
		MyLinkedListUtil.print(head);
		head = reverseBetween(head, 2, 4);
		MyLinkedListUtil.print(head);

	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;

		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;

		ListNode prev = dummyNode;

		for (int i = 0; i < m - 1; i++) {
			prev = prev.next;
		}

		ListNode p1 = prev.next;
		ListNode p2 = p1.next;

		for (int i = 0; i < n - m; i++) {
			p1.next = p2.next;
			p2.next = prev.next;
			prev.next = p2;
			p2 = p1.next;
		}

		return dummyNode.next;
	}
}
