package com.samples.utils;

public class SortUtils {

	/**
	 * sorts array using bubble sort algorithm - O(n^2)
	 * 
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		if (array == null)
			return;

		int n = array.length;

		// loop 0 -> n - 1
		for (int i = 0; i < n - 1; i++) {
			// loop 0 -> n - 1 - i
			for (int j = 0; j < n - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * sorts array using selection sort algorithm - O(n^2)
	 * 
	 * @param array
	 */
	public static void selectionSort(int[] array) {
		if (array == null)
			return;

		int n = array.length;

		// loop 0 -> n - 1
		for (int i = 0; i < n - 1; i++) {
			// loop i + 1 -> n
			for (int j = i + 1; j < n; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	/**
	 * sorts array using Merge Sort Algorithm
	 * 
	 * @param array
	 */
	public static void mergeSort(int[] array) {
		if (array == null) {
			return;
		}

		mergeSort(array, 0, array.length - 1);
	}

	/**
	 * divide, sorts and merges arrays
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	private static void mergeSort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}

		int mid = (start + end) / 2;
		mergeSort(array, start, mid);
		mergeSort(array, mid + 1, end);
		merge(array, start, end);
	}

	/**
	 * merges two sorted arrays
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	private static void merge(int[] array, int start, int end) {

		int[] temp = new int[end - start + 1];

		// create boundaries for both sub arrays to be merged
		int mid = (start + end) / 2;

		// temporary variables to be used in iteration
		int left = start;
		int right = mid + 1;

		// index for temp array
		int index = 0;

		// merge in temporary array
		while (left <= mid && right <= end) {
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

		System.arraycopy(array, left, temp, index, mid - left + 1);
		System.arraycopy(array, right, temp, index, end - right + 1);

		// override back in original array
		System.arraycopy(temp, 0, array, start, temp.length);
	}

	/**
	 * sorts an array using quick sort Algorithm
	 * 
	 * @param array
	 */
	public static void quickSort(int[] array) {
		if (array == null) {
			return;
		}

		quickSort(array, 0, array.length - 1);
	}

	/**
	 * recursive quick sort method
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	private static void quickSort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}

		int pivot = array[(start + end) / 2];
		int index = partition(array, start, end, pivot);
		quickSort(array, start, index - 1);
		quickSort(array, index, end);
	}

	private static int partition(int[] array, int start, int end, int pivot) {

		// two pointer traversal, till they cross each other
		while (start <= end) {
			// iterate to item greater than pivot
			while (array[start] < pivot) {
				start++;
			}

			// iterate to item lower than pivot
			while (array[end] > pivot) {
				end--;
			}

			// see if they can be swapped, if they are opposite side of pivot
			// e.g. 6 - > 4 -> 2, for pivot 4, 6 and 2 should be swapped with
			// each other
			if (start <= end) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
				start++;
				end--;
			}
		}

		return start;
	}

	/**
	 * Sorts a given array of negative and position elements such that all
	 * negative elements are before positive keeping their orginal order.
	 * 
	 * @param array
	 */
	public static void sortBySign(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > 0 && array[j + 1] < 0) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void sortOddEven(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				int a = array[j];
				int b = array[j + 1];

				if ((a % 2 == 0 && b % 2 == 1) || ((a % 2 == 0 && b % 2 == 0) && a > b)
						|| ((a % 2 == 1 && b % 2 == 1) && a < b)) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

}
