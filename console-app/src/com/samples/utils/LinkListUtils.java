package com.samples.utils;

public class LinkListUtils {
	/**
	 * Adds two number represented as linked list (numbers are stored in reverse
	 * order 123 = 3->2->1)
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static Node addIntegers(Node l1, Node l2) {
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

	/**
	 * 
	 * @param head
	 * @param num
	 * @return
	 */
	public static void appendNode(Node head, int num) {

		Node newNode = new Node(num);

		if (head == null) {
			head = newNode;
			return;
		}

		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = newNode;

		return;
	}

	public static void print(Node head) {
		System.out.println();
		Node temp = head;
		while (temp != null) {
			if (temp != head)
				System.out.print("->");
			System.out.print(temp.value);
			temp = temp.next;
		}
	}
}
