package com.samples.ds.utils;

import com.samples.model.ListNode;

public class MyLinkedListUtil {
	
	/**
	 * creates a Linked List
	 * @param items
	 * @return
	 */
	public static ListNode createLinkedList(int[] items) {
		
		ListNode head = new ListNode(items[0]);
		ListNode tail = head;
		
		for (int i = 1; i < items.length; i++) {
			tail.next = new ListNode(items[i]);
			tail = tail.next;
		}
		
		return head;		
	}
	
	public static void createCycle(ListNode head, int index) {
		
		ListNode temp = head;
		
		ListNode startOfLoop = null;
		ListNode lastNode = null;
		
		while (temp != null) {			
			if (startOfLoop == null && index == 0) {
				startOfLoop = temp;
			}
			
			if (temp.next == null) {
				lastNode = temp;
			}			
			index--;
			temp = temp.next;
		}
		
		lastNode.next = startOfLoop;	
	}
	
	/**
	 * prints linked list
	 * @param head
	 */
	public static void print (ListNode head) {
		
		StringBuilder sb = new StringBuilder();
		
		ListNode temp = head;
		sb.append("[");	
		while (temp != null) {
			if (temp != head) {
				sb.append(", ");
			}
			sb.append(temp.value);
			temp = temp.next;
		}
		
		sb.append("]");
		
		System.out.println(sb.toString());
	}

}
