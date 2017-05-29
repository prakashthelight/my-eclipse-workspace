package com.samples;



import java.util.LinkedList;

import com.samples.utils.MyLinkedList;
import com.samples.utils.MyStack;
import com.samples.utils.Node;

public class Program {

	public static void main(String[] args) {		
	
		MyLinkedList list = new MyLinkedList();
		
		list.add(12);
		list.add(23);
		list.add(45);
		list.add(16);
		list.add(14);
		
		list.print();
		list.remove(9);
		System.out.println();
		list.print();
	}
}