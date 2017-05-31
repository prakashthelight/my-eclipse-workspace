package com.samples;

import com.samples.utils.LinkListUtils;
import com.samples.utils.Node;

public class Program {

	public static void main(String[] args) {
		
		// Define inputs and call methods to test
		Node l1 = new Node(3);
		Node l2 = new Node(5);

		LinkListUtils.appendNode(l1, 2);
		LinkListUtils.appendNode(l1, 1);

		LinkListUtils.appendNode(l2, 9);

		LinkListUtils.print(l1);
		LinkListUtils.print(l2);

		Node head = LinkListUtils.addIntegers(l1, l2);
		LinkListUtils.print(head);
	}
}