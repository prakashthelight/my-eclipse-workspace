package com.samples.leetcode;

import com.samples.model.Node;

/**
 * Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle
 * @author Kumar, Prakash
 *
 */
public class LeetCode141 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * return true if Linked List has cycle
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(Node head) {
        
        if (head == null || head.next == null)  {
            return false;
        }
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {            
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;    
            }
        }
        
        return false;
    }

}
