package com.samples;



import java.util.LinkedList;

import com.samples.utils.ArrayUtils;
import com.samples.utils.MyLinkedList;
import com.samples.utils.MyStack;
import com.samples.utils.Node;
import com.samples.utils.SearchUtils;
import com.samples.utils.SortUtils;

public class Program {

	public static void main(String[] args) {		
	
		int[] array = new int[] {12, 2, 14, 17, 9, 10, 26, 11, 67, 34, 89, 110, 2};
		
		ArrayUtils.print(array);		
		SortUtils.quickSort(array);
		ArrayUtils.print(array);
	}
}