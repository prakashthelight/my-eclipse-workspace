package com.samples.leetcode;

import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * Merge Two Sorted Lists <br/>
 * https://leetcode.com/problems/merge-two-sorted-lists
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode021 {

	public static void main(String[] args) {
		ListNode l1 = MyLinkedListUtil.createLinkedList(new int[] { 2, 5, 7, 12, 90 });
		ListNode l2 = MyLinkedListUtil.createLinkedList(new int[] { 1, 8, 35, 67, 85, 167 });

		ListNode head = mergeTwoLists(l1, l2);

		MyLinkedListUtil.print(head);
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null && l2 == null)
			return null;

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode p1 = l1;
		ListNode p2 = l2;

		ListNode head = null;
		ListNode tail = null;

		while (p1 != null && p2 != null) {
			if (p1.value <= p2.value) {
				if (head == null) {
					head = p1;
					tail = p1;
				} else {
					tail.next = p1;
					tail = tail.next;
				}
				p1 = p1.next;
			} else {
				if (head == null) {
					head = p2;
					tail = p2;
				} else {
					tail.next = p2;
					tail = tail.next;
				}
				p2 = p2.next;
			}
		}

		while (p1 != null) {
			tail.next = p1;
			tail = tail.next;
			p1 = p1.next;
		}

		while (p2 != null) {
			tail.next = p2;
			tail = tail.next;
			p2 = p2.next;
		}

		return head;
	}
}
