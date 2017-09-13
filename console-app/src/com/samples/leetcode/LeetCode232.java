package com.samples.leetcode;

import java.util.Stack;

/**
 * Implement Queue using Stacks <br/>
 * https://leetcode.com/problems/implement-queue-using-stacks
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode232 {

	public static void main(String[] args) {
		MyQueue q = new MyQueue();

		q.push(10);
		q.push(20);
		q.push(30);

		System.out.println(q.pop() + ", " + q.pop() + ", " + q.pop());
	}

}

/**
 * My Queue implementation using two stacks.
 * 
 * @author Kumar, Prakash
 *
 */
class MyQueue {

	Stack<Integer> front;
	Stack<Integer> rear;

	/**
	 * constructor
	 */
	public MyQueue() {
		front = new Stack<>();
		rear = new Stack<>();
	}

	/**
	 * Push element x to the back of queue.
	 * 
	 * @param x
	 */
	public void push(int x) {
		rear.push(x);
	}

	/**
	 * Removes the element from in front of queue and returns that element.
	 * 
	 * @return
	 */
	public int pop() {
		adjustStacks();

		return front.pop();
	}

	/**
	 * Get the front element.
	 * 
	 * @return
	 */
	public int peek() {
		adjustStacks();

		return front.peek();
	}

	/**
	 * Returns whether the queue is empty.
	 * 
	 * @return
	 */
	public boolean empty() {
		adjustStacks();

		return front.isEmpty();
	}

	public void adjustStacks() {
		if (front.isEmpty()) {
			while (!rear.isEmpty()) {
				front.push(rear.pop());
			}
		}
	}
}
