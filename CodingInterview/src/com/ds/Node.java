package com.ds;

public class Node
{
    Node next = null;
    int data;
    
    public Node(int data)
    {
        this.data = data;
    }

    public Node() {
		// TODO Auto-generated constructor stub
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
