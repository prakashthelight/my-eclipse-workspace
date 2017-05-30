package com.samples;

import java.util.Arrays;

import com.samples.utils.ArrayUtils;
import com.samples.utils.MyLinkedList;
import com.samples.utils.SearchUtils;
import com.samples.utils.SortUtils;

public class Program {

	public static void main(String[] args) {		
	
		int[] array = new int[] {12, 2, 14, 17, 9, 10, 26, 11, 67, 34, 89, 110, 2};
		int[] sortedArray = new int[] {2, 2, 9, 10, 11, 12, 14, 17, 26, 34, 67, 89, 110, 134};		
		int[] pivotedArray = new int[] {67, 89, 110, 134, 2, 2, 9, 10, 11, 12, 14, 17, 26, 34};

		
		ArrayUtils.print(sortedArray);
		
		System.out.println(SearchUtils.findCount(sortedArray, 19));	
	}
}