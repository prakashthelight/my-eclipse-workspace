package com.samples.leetcode;

import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * Odd Even Linked List <br/>
 * https://leetcode.com/problems/odd-even-linked-list
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode328 {

	public static void main(String[] args) {
		ListNode head = MyLinkedListUtil.createLinkedList(new int[] { 1, 2, 3, 4, 5, 6 });
		
		MyLinkedListUtil.print(head);
		head = oddEvenList(head);
		MyLinkedListUtil.print(head);
	}

	public static ListNode oddEvenList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode h1 = head;
		ListNode h2 = head.next;
		ListNode p1 = head;
		ListNode p2 = head.next;

		if (h2.next == null) {
			return head;
		}

		while (p2 != null && p2.next != null) {
			p1.next = p2.next;
			p1 = p1.next;

			p2.next = p1.next;
			p2 = p2.next;
		}

		p1.next = h2;
		return h1;
	}
}
