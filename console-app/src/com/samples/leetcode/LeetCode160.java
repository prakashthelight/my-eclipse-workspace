package com.samples.leetcode;

import com.samples.model.ListNode;

/**
 * Intersection of Two Linked Lists <br/>
 * https://leetcode.com/problems/intersection-of-two-linked-lists
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode160 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * returns node where intersection of two Linked List starts
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) {
			return null;
		}

		int lengthA = getLength(headA);
		int lengthB = getLength(headB);

		ListNode tempA = headA;
		ListNode tempB = headB;

		// move start of longer list so that length to traverse becomes equal
		// for both lists
		if (lengthA > lengthB) {
			int i = lengthA - lengthB;
			while (i > 0) {
				tempA = tempA.next;
				i--;
			}
		} else if (lengthA < lengthB) {
			int i = lengthB - lengthA;
			while (i > 0) {
				tempB = tempB.next;
				i--;
			}
		}

		// keep moving unless find common node which will be intersection point
		while (tempA != null && tempB != null) {
			if (tempA == tempB) {
				return tempA;
			}

			tempA = tempA.next;
			tempB = tempB.next;
		}

		return null;

	}

	/**
	 * return length of Linked List;
	 * 
	 * @param head
	 * @return
	 */
	public static int getLength(ListNode head) {
		int length = 0;
		ListNode temp = head;
		while (temp != null) {
			length++;
			temp = temp.next;
		}

		return length;
	}

}
