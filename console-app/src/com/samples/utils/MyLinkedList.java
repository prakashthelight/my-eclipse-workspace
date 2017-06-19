package com.samples.utils;

import java.util.HashSet;

public class MyLinkedList {

	private Node head;

	public Node getHead() {
		return head;
	}

	public void initialize(int[] nodes) {

		if (nodes == null || nodes.length == 0) {
			nodes = new int[] { 12, 23, 8, 12, 8, 18, 20, 30, 4, 15, 15 };
		}

		for (int num : nodes) {
			this.add(num);
		}
	}

	/**
	 * add new node to list
	 * 
	 * @param num
	 */
	public void add(int num) {

		// create new node
		Node newNode = new Node(num);

		// if head is null and this is the first node in list
		if (head == null) {
			head = newNode;
			return;
		}

		Node temp = head;

		// go to last node
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = newNode;
		return;
	}

	/**
	 * removes node at given index
	 * 
	 * @param position
	 */
	public void remove(int position) {

		if (head == null) {
			System.out.println("List is empty.");
			return;
		}

		if (position == 0) {
			head = head.next;
			return;
		}

		Node temp = head;
		int index = 1;

		while (temp.next != null) {
			if (position == index) {
				temp.next = temp.next.next;
				break;
			}

			index++;
			temp = temp.next;
		}

		return;
	}

	/**
	 * removes node having given key as value
	 * 
	 * @param key
	 */
	public void removeNode(int key) {

		if (head == null) {
			return;
		}

		if (head.value == key) {
			head = head.next;
			return;
		}

		Node temp = head;

		while (temp.next != null) {
			if (temp.next.value == key) {
				temp.next = temp.next.next;
				return;
			}

			temp = temp.next;
		}

		return;
	}
	
	/**
	 * remove all nodes for given key
	 * @param key
	 */
	public void removeAllNodes(int key) {

		if (head == null) {
			return;
		}

		while (head != null && head.value == key) {
			head = head.next;
		}

		Node temp = head;

		while (temp != null && temp.next != null) {
			if (temp.next.value == key) {
				temp.next = temp.next.next;				
			}
			
			temp = temp.next;
		}

		return;
	}
	
	

	/**
	 * removes duplicate nodes
	 */
	public void removeDuplicate() {

		if (head == null || head.next == null)
			return;

		HashSet<Integer> set = new HashSet<>();

		set.add(head.value);

		Node temp = head;
		while (temp.next != null) {
			if (set.contains(temp.next.value)) {
				temp.next = temp.next.next;
			} else {
				set.add(temp.next.value);
				temp = temp.next;
			}
		}

		return;
	}

	public void printKthFromLast() {
		printKthFromLast(head);
	}

	public int printKthFromLast(Node head) {

		int count = 0;
		if (head.next != null) {
			count = printKthFromLast(head.next) + 1;
		}

		System.out.println(head.value + " " + count);
		return count;
	}

	/**
	 * reverse a linked list
	 */
	public void reverse() {

		if (head == null || head.next == null) {
			return;
		}

		Node p1 = head;
		Node p2 = head.next;

		head.next = null;
		while (p2 != null) {
			Node temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}

		head = p1;
	}

	/**
	 * reverse linked list recursive
	 */
	public void reverseRecursvive() {
		head = reverse(head);
	}

	/**
	 * reverse linked list recursive
	 * 
	 * @param head
	 * @return
	 */
	private Node reverse(Node head) {
		if (head == null || head.next == null)
			return head;

		Node sec = head.next;
		head.next = null;

		Node newHead = reverse(sec);
		sec.next = head;

		return newHead;
	}
	
	/**
	 * arrange a linked list such that all odd position nodes are grouped in start and even position nodes are grouped in last
	 */
	public void arrangeEvenOddPosition() {
		
		if (this.head == null || this.head.next == null) {
			return;
		}
		
		Node p1 = head;
		Node p2 = head.next;
		
		Node h1 = head;
		Node h2 = head.next;
		
		if (p2.next == null) {
			p1.next = p2.next;
			p2.next = p1;			
			head = p2;
			return;
		}
		
		while (p2 != null && p2.next != null) {			
			p1.next = p2.next;
			p2.next = p1.next.next;
			
			p1 = p1.next;
			p2 = p2.next;
		}
		
		p1.next = h2;
		head = h1;
	}

	/**
	 * prints a linked list
	 */
	public void print() {
		if (head == null) {
			System.out.println("LinkedList is empty");
			return;
		}

		System.out.print("LinkedList: ");
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}

		System.out.println();
	}
}
