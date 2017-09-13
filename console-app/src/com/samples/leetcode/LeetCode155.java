package com.samples.leetcode;

import java.util.Stack;

/**
 * Min Stack <br/>
 * https://leetcode.com/problems/min-stack
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode155 {

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(10);
		stack.push(-10);
		stack.push(-20);
		stack.push(30);
		System.out.println(stack.getMin());
	}
}

class MinStack {

	/** initialize your data structure here. */
	Stack<Node> stack;

	public MinStack() {
		stack = new Stack<Node>();
	}

	public void push(int value) {

		Node tempNode = new Node(value, value);
		if (!stack.isEmpty()) {
			tempNode.min = Math.min(value, stack.peek().min);
		}
		stack.push(tempNode);
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek().value;
	}

	public int getMin() {
		return stack.peek().min;
	}
}

/**
 * structure to keep track of min item
 * 
 * @author Kumar, Prakash
 *
 */
class Node {
	public Node(int value, int min) {
		this.value = value;
		this.min = min;
	}

	int value;
	int min;
}
