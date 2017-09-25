package com.samples.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * Merge k Sorted Lists <br/>
 * https://leetcode.com/problems/merge-k-sorted-lists
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode023 {

	public static void main(String[] args) {
		ListNode l1 = MyLinkedListUtil.createLinkedList(new int[] { 2, 5, 7, 12, 90 });
		ListNode l2 = MyLinkedListUtil.createLinkedList(new int[] { 1, 8, 35, 67, 85, 167 });

		ListNode[] lists = new ListNode[] { l1, l2 };

		ListNode head = mergeKLists(lists);

		MyLinkedListUtil.print(head);
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		PriorityQueue<ListNode> list = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode a, ListNode b) {
				return a.value - b.value;
			}
		});

		for (ListNode node : lists) {
			while (node != null) {
				list.offer(node);
				node = node.next;
			}
		}

		ListNode head = null;
		ListNode tail = null;

		while (!list.isEmpty()) {
			ListNode temp = list.poll();
			temp.next = null;

			if (head == null) {
				head = temp;
				tail = head;
			} else {
				tail.next = temp;
				tail = tail.next;
			}
		}

		return head;
	}
}
