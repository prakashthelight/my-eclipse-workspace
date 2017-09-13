package com.samples.leetcode;

import com.samples.model.Node;
import com.samples.utils.MyLinkedList;

/**
 * Rotate Right Linked List <br/>
 * https://leetcode.com/problems/rotate-list
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode061 {
	public static void main(String[] args) {

		MyLinkedList list = new MyLinkedList();
		list.initialize(new int[] { 1, 2, 3, 4, 5 });

		int k = 3;
		Node newHead = rotateRight(list.getHead(), k);
		list.print();

		System.out.print("Linked List after " + k + " right rotatations: ");
		while (newHead != null) {
			System.out.print(newHead.value + " ");
			newHead = newHead.next;
		}
	}

	/**
	 * rotate linked list right k times;
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static Node rotateRight(Node head, int k) {

		if (head == null || head.next == null)
			return head;

		int length = getLength(head);
		k = k % length;

		Node newHead = head;
		while (k > 0) {
			newHead = rotateRight(newHead);
			k--;
		}

		return newHead;
	}

	/**
	 * rotate linked list right
	 * 
	 * @param head
	 * @return
	 */
	public static Node rotateRight(Node head) {

		// base conditions
		if (head == null || head.next == null)
			return head;

		Node prev = head;
		Node current = head.next;

		// go to last node
		while (current.next != null) {
			prev = current;
			current = current.next;
		}

		prev.next = null;
		current.next = head;
		head = current;

		return head;
	}

	/**
	 * get length of linked list
	 * 
	 * @param head
	 * @return
	 */
	public static int getLength(Node head) {
		int length = 0;

		Node temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}

		return length;
	}
}
