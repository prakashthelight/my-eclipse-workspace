package com.samples.leetcode;

import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * 876. Middle of the Linked List <br/>
 * https://leetcode.com/problems/middle-of-the-linked-list
 * 
 * @author Kumar, Prakash
 * @category Linked List, Two Pointers
 */
public class LeetCode876 {

	public static void main(String[] args) {
		ListNode head = MyLinkedListUtil.createLinkedList(new int[] { 10, 20, 15, 30, 8, 12 });
		MyLinkedListUtil.print(head);
		
		ListNode middleNode = middleNode(head);
		System.out.println(middleNode.value);
	}
	
	public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
