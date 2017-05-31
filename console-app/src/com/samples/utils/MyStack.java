package com.samples.utils;

public class MyStack {

	private Node top;

	public Node peek() {
		if (top != null) {
			return top;
		}

		return null;
	}

	public Node pop() {
		// Stack is empty
		if (top == null) {
			return null;
		} else {
			Node temp = new Node(top.value);
			top = top.next;
			return temp;
		}
	}

	public void push(Node node) {
		if (node != null) {
			node.next = top;
			top = node;
		}
	}

	public void push(int value) {
		this.push(new Node(value));
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
