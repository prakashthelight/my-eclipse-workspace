package com.samples.leetcode;

import java.util.Stack;
import com.samples.ds.utils.MyLinkedListUtil;
import com.samples.model.ListNode;

/**
 * Add Two Numbers II <br/>
 * https://leetcode.com/problems/add-two-numbers-ii
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode445 {

	public static void main(String[] args) {
		ListNode l1 = MyLinkedListUtil.createLinkedList(new int[] { 7, 2, 4, 3 });
		ListNode l2 = MyLinkedListUtil.createLinkedList(new int[] { 5, 6, 4 });

		ListNode sumList = addTwoNumbers(l1, l2);

		MyLinkedListUtil.print(sumList); // 7 -> 8 -> 0 -> 7
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null && l2 != null)
			return l2;
		if (l2 == null && l1 != null)
			return l1;

		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>();

		while (l1 != null) {
			s1.push(l1.value);
			l1 = l1.next;
		}

		while (l2 != null) {
			s2.push(l2.value);
			l2 = l2.next;
		}

		int remainder = 0;

		while (!s1.isEmpty() && !s2.isEmpty()) {
			int sum = s1.pop() + s2.pop() + remainder;
			remainder = sum / 10;
			sum = sum % 10;
			s3.push(sum);
		}

		while (!s1.isEmpty()) {
			int sum = s1.pop() + remainder;
			remainder = sum / 10;
			sum = sum % 10;
			s3.push(sum);
		}

		while (!s2.isEmpty()) {
			int sum = s2.pop() + remainder;
			remainder = sum / 10;
			sum = sum % 10;
			s3.push(sum);
		}

		if (remainder != 0) {
			s3.push(remainder);
		}

		ListNode head = null;
		ListNode tail = null;
		while (!s3.isEmpty()) {
			ListNode node = new ListNode(s3.pop());
			if (head == null) {
				head = node;
				tail = node;
				continue;
			}

			tail.next = node;
			tail = node;
		}

		return head;
	}
}
