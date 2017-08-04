package com.samples.leetcode;

import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii
 * @author Kumar, Prakash
 *
 */
public class LinkedList142 {
	public static void main(String[] args) {
		ListNode head = MyLinkedListUtil.createLinkedList(new int[] {10, 20, 15, 30, 8, 12});		
		MyLinkedListUtil.print(head);		
		MyLinkedListUtil.createCycle(head, 0);	
		
		ListNode startOfLoopNode = detectCycle(head);
		
		if (startOfLoopNode != null) {
			System.out.println("Start of Loop Node: " + detectCycle(head).value);
		} else {
			System.out.println("No cycle detected.");
		}
	}
	
	/**
	 * return true if Linked List has cycle
	 * @param head
	 * @return
	 */
	public static ListNode detectCycle(ListNode head) {
        
		if (head == null || head.next == null) {
            return null;
        }
        
        if (head.next == head) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        boolean isCircular = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                isCircular = true;
                break;
            }
        }
        
        if (isCircular) {
            slow = head;
            
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            
            return slow;
            
        } else {
            return null;
        }
    }
}
