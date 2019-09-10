package com.samples.leetcode;

import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * Swap Nodes in Pairs <br/>
 * https://leetcode.com/problems/swap-nodes-in-pairs
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode024 {

	public static void main(String[] args) {
		ListNode head = MyLinkedListUtil.createLinkedList(new int[] {1,2,3,4,5,6});
		
		//head = swapPairs(head);
		head = swapPairsRecursive(head);
		
		MyLinkedListUtil.print(head);
	}

	/**
	 * Swaps pair of LinkedList nodes - iterative
	 * @param head
	 * @return
	 */
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode p1 = head;
		ListNode p2 = head.next;	

		while (p1 != null && p2 != null) {
			int temp = p1.value;
			p1.value = p2.value;
			p2.value = temp;

			p1 = p2.next;

			if (p1 != null)
				p2 = p1.next;
		}

		return head;
	}
	
	/**
	 * Swaps pair of LinkedList nodes - recursive
	 * @param head
	 * @return
	 */
	public static ListNode swapPairsRecursive(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode temp = head.next;
		head.next = swapPairs(head.next.next);
		temp.next = head;
		
		return temp;
	}
}
