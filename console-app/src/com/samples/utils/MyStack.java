package com.samples.utils;

import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack {

	private Node top;

	public void initialize() {
		int[] items = new int[] { 12, 3, 5, 10, 20, 23 };

		for (int item : items) {
			this.push(item);
		}
	}

	public int peek() {
		if (top == null) {
			throw new EmptyStackException();
		}

		return top.value;
	}

	public int pop() {
		// Stack is empty
		if (top == null) {
			throw new EmptyStackException();
		}

		int value = top.value;
		top = top.next;
		return value;
	}

	public void push(int value) {
		Node newNode = new Node(value);
		newNode.next = top;
		top = newNode;
	}

	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * sorts an stack
	 */
	public void sort() {

		// new items popped from original stack and pushed in s2 in proper order
		Stack<Integer> s2 = new Stack<>();

		while (!this.isEmpty()) {
			int temp = this.pop();

			while (!s2.isEmpty() && s2.peek() > temp) {
				this.push(s2.pop());
			}

			s2.push(temp);
		}

		while (!s2.isEmpty()) {
			this.push(s2.pop());
		}
	}

	public void print() {
		if (top == null) {
			System.out.println("Stack is empty");
		}

		Node temp = top;
		while (temp != null) {
			System.out.print("\n" + temp.value);
			if (temp == top) {
				System.out.print("<- Top");
			}
			temp = temp.next;
		}
	}
}
