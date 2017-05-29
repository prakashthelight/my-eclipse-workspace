package com.samples.utils;

public class SortUtils {
	
	/**
	 * sorts array using Merge Sort Algorithm
	 * @param array
	 */
	public static void mergeSort(int[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		
		int[] result = new int[array.length];
		mergeSort(array, result, 0, array.length -1);		
	}
	
	/**
	 * divide, sorts and merges arrays
	 * @param array
	 * @param temp
	 * @param start
	 * @param end
	 */
	private static void mergeSort(int[] array, int[] temp, int start, int end) {
		
		if (start >= end) {
			return;
		}
		
		int mid = (start+end) / 2;
		
		mergeSort(array, temp, start, mid-1);
		mergeSort(array, temp, mid+1, end);
		merge(array, temp, start, end);
	}
	
	/**
	 * merges two arrays
	 * @param array
	 * @param temp
	 * @param leftStart
	 * @param rightEnd
	 */
	private static void merge(int[] array, int[] temp, int leftStart, int rightEnd) {

		// create boundaries for both sub arrays to be merged
		int leftEnd = (leftStart + rightEnd) / 2;
		int rightStart = leftEnd + 1;
		
		// temporary variables to be used in iteration
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		// merge in temporary array
		while (left <= leftEnd && right <= rightEnd) {
			if (array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
				index++;
			} else {
				temp[index] = array[right];
				right++;
				index++;
			}
		}
		
		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, rightEnd - right+ 1);
		
		// override back in original array
		System.arraycopy(temp, leftStart, array, leftStart, rightEnd - leftStart + 1);
	}

	/**
	 * sorts an array using Quick Sort Algorithm
	 * @param array
	 */
	public static void quickSort(int[] array) {
		
		if (array == null || array.length < 2) {
			return;
		}
		
		quickSort(array, 0, array.length -1);
		
	}
	
	private static void quickSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		
		int pivot = array[(left+right)/2];
		int index = partition(array, left, right, pivot);
		quickSort(array, left, index-1);
		quickSort(array, index, right);
	}

	private static int partition(int[] array, int left, int right, int pivot) {
		while (left <= right) {
			while(array[left] < pivot) {
				left++;
			}
			
			while (array[right] > pivot) {
				right--;
			}
			
			if (left<= right) {				
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;			
				left++;
				right--;
			}
		}
		
		return left;
	}
}
