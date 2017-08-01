package com.samples.leetcode;

import com.samples.model.Node;

/**
 * 
 * https://leetcode.com/problems/linked-list-cycle-ii
 * @author Kumar, Prakash
 *
 */
public class LeetCode142 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public Node detectCycle(Node head) {
        
        if (head == null || head.next == null) {
            return null;
        }
        
        if (head.next == head) {
            return head;
        }
        
        
        Node slow = head;
        Node fast = head;
        
        boolean isCircular = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                isCircular = true;
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
