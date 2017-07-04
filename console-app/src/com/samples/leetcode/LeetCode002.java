package com.samples.leetcode;

import com.samples.model.Node;
import com.samples.utils.LinkListUtils;

/**
 * Add two number represented as LinkedList
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * https://leetcode.com/problems/add-two-numbers
 * @author kumarpr
 *
 */
public class LeetCode002 {
	public static void main(String[] args) {
		Node num1 = new Node(2);
		LinkListUtils.appendNode(num1, 4);
		LinkListUtils.appendNode(num1, 3);

		Node num2 = new Node(5);
		LinkListUtils.appendNode(num2, 6);
		LinkListUtils.appendNode(num2, 4);

		Node sum = addTwoNumbers(num1, num2);

		LinkListUtils.print(num1);
		LinkListUtils.print(num2);
		LinkListUtils.print(sum);

	}

	public static Node addTwoNumbers(Node l1, Node l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		Node head = null;
		Node tail = null;

		int remainder = 0;

		// iterate over both lists
		while (l1 != null && l2 != null) {
			int sum = l1.value + l2.value + remainder;
			remainder = sum / 10;

			Node newNode = new Node(sum % 10);

			if (tail == null) {
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = tail.next;
			}

			if (head == null) {
				head = newNode;
			}

			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			int sum = l1.value + remainder;
			remainder = sum / 10;
			Node newNode = new Node(sum % 10);
			tail.next = newNode;
			tail = tail.next;

			l1 = l1.next;
		}

		while (l2 != null) {
			int sum = l2.value + remainder;
			remainder = sum / 10;
			Node newNode = new Node(sum % 10);
			tail.next = newNode;
			tail = tail.next;
			l2 = l2.next;
		}

		if (remainder == 1) {
			Node newNode = new Node(1);
			tail.next = newNode;
			tail = tail.next;
		}

		return head;
	}
}
