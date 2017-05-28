package com.samples;



import com.samples.utils.MyStack;
import com.samples.utils.Node;

public class Program {

	public static void main(String[] args) {		

		
		MyStack stack = new MyStack();
		stack.push(new Node(3));
		stack.push(new Node(4));
		stack.push(new Node(5));;
		
		stack.print();
		
	}
}