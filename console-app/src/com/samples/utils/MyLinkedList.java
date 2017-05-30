package com.samples.utils;

public class MyLinkedList {
	
	private Node head;
	
	/**
	 * add new node to list
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
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = newNode;
		return;
	}
	
	/**
	 * removes node at given index
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
		
		Node prev = head;
		Node current = head.next;
		int index = 1;
		
		while(current != null && position != index) {
			prev = current;
			current = current.next;
			index++;			
		}
		
		if (current != null) {
			prev.next = current.next;
		} else {
			System.out.println("IndexOutOfBound - Linked list is not long enough for this index");
		}
		
		return;
	}

	/**
	 * removes node having given key as value
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
		
		Node prev = head;
		Node current = head.next;
		
		while (current != null && current.value != key) {
			prev = current;
			current = current.next;
		}
		
		if (current != null) {
			prev.next = current.next;
		}	
		
		return;		
	}
	
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
	
	public void reverseRecursvive() {
		head = reverse(head);
	}
	
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
	 * prints a linked list	
	 */
	public void print() {
		
		if (head == null) {
			System.out.println("LinkedList is empty");
		}
		Node temp = head;	
		
		
		while(temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}		
	}
}
