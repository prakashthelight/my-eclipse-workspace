package com.samples.leetcode;

import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
 * @author Kumar, Prakash
 *
 */
public class LeetCode082 {
	public static void main(String[] args) {
		// create a sorted linked list
		ListNode head = MyLinkedListUtil.createLinkedList(new int[] {10, 10, 12, 15, 18, 18, 18, 30, 30});		
		MyLinkedListUtil.print(head);
		head = deleteDuplicates(head); // removes duplicate
		MyLinkedListUtil.print(head);	
	}
	
	/**
	 * remove duplicate elementes from sorted Linked List, leaving only distinct elements
	 * 1->2->3->3->4->4->5, return 1->2->5
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		//TODO
		return head;		
    }
}
