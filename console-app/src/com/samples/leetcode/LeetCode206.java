package com.samples.leetcode;

import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list
 * @author Kumar, Prakash
 *
 */
public class LeetCode206 {
	
	public static void main(String[] args) {
		ListNode head = MyLinkedListUtil.createLinkedList(new int[] {10, 20, 15, 30, 8, 12});		
		MyLinkedListUtil.print(head);
		head = reverseList(head);
		MyLinkedListUtil.print(head);		
	}
	
	public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode p1 = head;
        ListNode p2 = head.next;
        
        head.next = null;
        while(p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        
        return p1;
    }
}
