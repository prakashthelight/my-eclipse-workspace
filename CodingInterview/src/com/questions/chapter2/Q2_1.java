package com.questions.chapter2;

import com.ds.LinkedList;

public class Q2_1 {
	public static void execute()
    {
        LinkedList list = new LinkedList();
        list.appendNodes(new int[] { 23, 21, 12, 5, 30, 45});
        list.display();
        list.reverseList();
        list.display();
    }
}
