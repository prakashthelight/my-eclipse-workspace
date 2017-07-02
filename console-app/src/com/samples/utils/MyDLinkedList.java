package com.samples.utils;

import com.samples.model.DNode;

public class MyDLinkedList {
	
	DNode head;
	
	boolean isSorted = false;
	
	public MyDLinkedList(boolean isSorted) {
		this.isSorted = isSorted;
	}
	
	private void append(DNode node) {		
		if (this.head == null) {
			this.head = node;
			return;
		}
		
		DNode temp = this.head;		
		while (temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = node;
		node.prev = temp;		
	}
	
	private void appendSorted(DNode node) {
		
		if (this.head == null) {
			this.head = node;
			return;
		}
		
		if (head.value > node.value) {
			node.next = head;
			head.prev = node;
			head = node;
			return;
		}
		
		DNode temp = this.head;
		while (temp.next != null && temp.next.value < node.value) {
			temp = temp.next;
		}

		if (temp.next == null) {
			temp.next = node;
			node.prev = temp;
		} else {
			node.next = temp.next;
			node.next.prev = node;
			temp.next = node;
			node.prev = temp;
		}
	}
	
	public void append(int value) {
		if (this.isSorted) {
			this.appendSorted(new DNode(value));
		} else {
			this.append(new DNode(value));
		}		
	}
	
	public void reverse() {
		if (this.head == null) return;
		
		DNode p1 = this.head;
		DNode p2 = p1.next;
		
		p1.next = null;
		p1.prev = p2;
		
		while (p2 != null) {
			DNode temp = p2.next;
			p2.next = p1;
			p1.prev = p2;
			p1 = p2;
			p2 = temp;
		}
		
		this.head = p1;
		
	}
	@Override
	public String toString() {
		DNode temp = this.head;
		
		StringBuilder sb = new StringBuilder();
		
		while (temp != null) {
			sb.append(temp.value + " ");
			temp = temp.next;
		}
		
		return sb.toString();
	}
}
