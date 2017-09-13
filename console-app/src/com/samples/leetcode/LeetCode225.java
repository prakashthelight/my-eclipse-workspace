package com.samples.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement Stack using Queues <br/>
 * https://leetcode.com/problems/implement-stack-using-queues
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode225 {

	public static void main(String[] args) {
		MyStack stack = new MyStack();

		stack.push(10);
		stack.push(20);
		stack.push(30);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}

class MyStack {

	Queue<Integer> stack;
	Queue<Integer> queue;

	public MyStack() {
		stack = new LinkedList<Integer>();
		queue = new LinkedList<Integer>();
	}

	/**
	 * Push element x onto stack.
	 * 
	 * @param x
	 */
	public void push(int x) {
		queue = stack;
		stack = new LinkedList<Integer>();

		stack.offer(x);

		while (!queue.isEmpty()) {
			stack.offer(queue.poll());
		}
	}

	/**
	 * Removes the element on top of the stack and returns that element.
	 * 
	 * @return
	 */
	public int pop() {
		return stack.poll();
	}

	/**
	 * Get the top element.
	 * 
	 * @return
	 */
	public int top() {
		return stack.peek();
	}

	/**
	 * Returns whether the stack is empty.
	 * 
	 * @return
	 */
	public boolean empty() {
		return stack.isEmpty();
	}
}