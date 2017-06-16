package com.samples.utils;

public class LinkListUtils {
	/**
	 * adds two number represented as linked list (numbers are stored in reverse
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
	 * appends new node as the last node
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

	/**
	 * makes a loop in given linked list
	 * 
	 * @param head
	 * @param position
	 */
	public static void makeCircular(Node head, int position) {

		if (head == null || head.next == null)
			return;

		Node positionNode = null;
		Node temp = head;

		int pos = 1;

		while (temp.next != null) {
			if (position == pos) {
				positionNode = temp;
			}

			temp = temp.next;
			pos++;
		}

		// if last is the one where we need to point for making it circular
		if (position == pos) {
			positionNode = temp;
		}

		if (positionNode != null) {
			temp.next = positionNode;
		}

		return;
	}

	public static int circularLinkStart(Node head) {

		if (head == null || head.next == null)
			return -1;

		Node slow = head;
		Node fast = head.next;

		while (fast != null && fast.next != null) {
			if (slow == fast) {
				break;
			}

			slow = slow.next;
			fast = fast.next.next;
		}

		if (slow != fast) {
			slow = null;
		}

		return slow != null ? slow.next.value : -1;
	}

	/**
	 * return true if linked list is circular
	 * 
	 * @param head
	 * @return
	 */
	public static boolean isCirtular(Node head) {
		if (head == null || head.next == null)
			return false;

		Node slow = head;
		Node fast = head.next;

		boolean result = false;
		while (fast != null && fast.next != null) {

			if (slow == fast) {
				result = true;
				break;
			}

			slow = slow.next;
			fast = fast.next.next;
		}

		return result;

	}

	/**
	 * remove duplicate nodes from sorted linked list
	 * 
	 * @param head
	 * @return
	 */
	public static Node deleteDuplicates(Node head) {

		if (head == null || head.next == null)
			return head;

		Node temp = head.next;
		Node prev = head;

		int value = head.value;

		while (temp != null) {
			if (temp.value == value) {
				prev.next = temp.next;
			} else {
				prev = temp;
				value = temp.value;
			}

			temp = temp.next;
		}

		return head;
	}

	/**
	 * prints linked list
	 * 
	 * @param head
	 */
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
