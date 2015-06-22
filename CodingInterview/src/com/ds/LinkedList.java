package com.ds;

public class LinkedList {
	Node head = null;

    public void appendNodes(int[] data)
    {
    	for (int d : data) {
    		this.append(d);
		}        
    }

    public void append(int data)
    {
        Node newNode = new Node(data);
        if (this.head == null)
        {
            this.head = newNode;
            return;
        }

        Node cursor = head;
        while (cursor.getNext() != null)
            cursor = cursor.getNext();

        cursor.setNext(newNode);        
    }

    public void display()
    {            
        if (this.head == null)
        {
            System.out.println("Empty list");
        }
        else
        {
            Node temp = this.head;
            System.out.println("\nLinkList: ");            
            while (temp != null)
            {
                if (temp != head)
                {
                    System.out.print(" -> ");
                }
                System.out.print("[" + temp.getData() + "]");
                temp = temp.getNext();
            }
        }            
    }

    public void removeDuplicates()
    {
        System.out.println("\nRemoving Duplicates..");
        
        //// Using Buffer
        //IDictionary<int, bool> container = new Dictionary<int, bool>();
        //Node prev = null;
        //Node temp = head;
        //while (temp != null)
        //{
        //    if (container.Keys.Contains(temp.Data))
        //    {
        //        prev.Next = temp.Next;
        //    }
        //    else
        //    {
        //        container.Add(temp.Data, true);
        //        prev = temp;
        //    }

        //    temp = temp.Next;
        //}

        //// Without Buffer, using two pointers.
        Node current = head;
        while (current != null)
        {                
            Node temp = current;                               
            while (temp.getNext() != null)
            {
                if (temp.getNext().getData() == current.getData())
                {
                    temp.setNext(temp.getNext().getNext());
                }
                temp = temp.getNext();
            }

            current = current.getNext();
        }
    }

    public void reverseList()
    {
        if (head == null)
        {
            return;
        }

        Node temp = head;
        Node nhead = null;
        Node prev = null;

        while (temp != null)
        {
            nhead = new Node();
            nhead.setData(temp.getData());
            nhead.setNext(prev);            
            prev = nhead;
            temp = temp.getNext();
        }

        head = nhead;
    } 
}
