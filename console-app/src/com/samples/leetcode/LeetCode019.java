package com.samples.leetcode;

import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode019 {

	public static void main(String[] args) {
		ListNode head = MyLinkedListUtil.createLinkedList(new int[] { 10, 20, 30, 40, 50, 60 });

		MyLinkedListUtil.print(head);
		head = removeNthFromEnd(head, 1);
		MyLinkedListUtil.print(head);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int size = getListSize(head);

		if (size < n) {
			return head;
		}

		if (size == n) {
			head = head.next;
			return head;
		}

		int i = 0;
		ListNode prev = null;
		ListNode temp = head;

		while (i < size - n) {
			prev = temp;
			temp = temp.next;
			i++;
		}

		prev.next = temp.next;

		return head;
	}

	public static int getListSize(ListNode head) {
		ListNode temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}
}
