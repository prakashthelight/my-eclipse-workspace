package com.samples.tests;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import com.samples.utils.SortUtils;
public class SortUtilsTest {
	
	@Test
	public void testBubbleSort() {		
		int[] testArray1 = { 10, 12, 8, 28, 45, 76, 34, 16 };
		int[] expectedArray1 = { 8, 10, 12, 16, 28, 34, 45, 76 };

		int[] testArray2 = {};
		int[] expectedArray2 = {};
		

		SortUtils.bubbleSort(testArray1);
		SortUtils.bubbleSort(testArray2);
		assertArrayEquals(expectedArray1, testArray1);
		assertArrayEquals(expectedArray2, testArray2);
	}

	@Test
	public void testSelectionSort() {
		int[] testArray1 = { 10, 12, 8, 28, 45, 76, 34, 16 };
		int[] expectedArray1 = { 8, 10, 12, 16, 28, 34, 45, 76 };

		int[] testArray2 = {};
		int[] expectedArray2 = {};
		
		SortUtils.selectionSort(testArray1);
		SortUtils.selectionSort(testArray2);
		assertArrayEquals(expectedArray1, testArray1);
		assertArrayEquals(expectedArray2, testArray2);
	}
	
	@Test
	public void testMergeSort() {		
		int[] testArray1 = { 10, 12, 8, 28, 45, 76, 34, 16 };
		int[] expectedArray1 = { 8, 10, 12, 16, 28, 34, 45, 76 };

		int[] testArray2 = {};
		int[] expectedArray2 = {};
		
		int[] testArray3 = {34, 25};
		int[] expectedArray3 = {25, 34};

		SortUtils.mergeSort(testArray1);
		SortUtils.mergeSort(testArray2);
		SortUtils.mergeSort(testArray3);
		assertArrayEquals(expectedArray1, testArray1);
		assertArrayEquals(expectedArray2, testArray2);
		assertArrayEquals(expectedArray3, testArray3);
	}
	
	@Test
	public void testQuickSort() {		
		int[] testArray1 = { 10, 12, 8, 28, 45, 76, 34, 16, 120 };
		int[] expectedArray1 = { 8, 10, 12, 16, 28, 34, 45, 76, 120};

		int[] testArray2 = {};
		int[] expectedArray2 = {};
		
		int[] testArray3 = {34, 25};
		int[] expectedArray3 = {25, 34};

		SortUtils.quickSort(testArray1);
		SortUtils.quickSort(testArray2);
		SortUtils.quickSort(testArray3);
		assertArrayEquals(expectedArray1, testArray1);
		assertArrayEquals(expectedArray2, testArray2);
		assertArrayEquals(expectedArray3, testArray3);
	}

}
