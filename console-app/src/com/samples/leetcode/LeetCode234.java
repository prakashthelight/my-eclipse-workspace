package com.samples.leetcode;

import java.util.Stack;
import com.samples.model.Node;
import com.samples.utils.MyLinkedList;

/**
 * Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list
 * @author kumarpr
 *
 */
public class LeetCode234 {
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();		
		list.initialize(new int[] {1, 2, 3, 3, 2, 1});
		
		System.out.println("Linked List is Palindrome: " + isPalindrome(list.getHead()));
	}

	/**
	 * returns true if Linked List is a palindrome
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(Node head) {
		if (head == null || head.next == null)
			return true;

		// push all elements in stack before middle element;
		Stack<Integer> stack = new Stack<Integer>();

		Node p1 = head;
		Node p2 = head;

		while (p2 != null && p2.next != null) {
			stack.push(p1.value);
			p1 = p1.next;
			p2 = p2.next.next;
		}

		if (p2 != null) {
			p1 = p1.next;
		}

		boolean isPalindrom = true;
		while (p1 != null) {
			if (stack.pop() != p1.value) {
				isPalindrom = false;
				break;
			}
			p1 = p1.next;
		}

		return isPalindrom;
	}
}
