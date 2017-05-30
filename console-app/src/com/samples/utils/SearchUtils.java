package com.samples.utils;

public class SearchUtils {
	
	/**
	 * binary search recursive
	 * @param array
	 * @param num
	 * @param left
	 * @param right
	 * @return
	 */
	public static boolean binarySearch(int[] array, int num, int left, int right) {
		boolean result = false;
		if (array == null || array.length == 0 || left > right) {
			return false;
		}
		
		int mid = (left + right)/2;
		
		// if found, return true
		if (num == array[mid]) {
			return true;
		} 
		
		// if target number less than middle, search into left array
		if (num < array[mid]) {
			result = binarySearch(array, num, left, mid-1);
		} else { // search into right array
			result = binarySearch(array, num, mid+1, right);
		}
		
		return result;
	}
	
	/**
	 * binary search non-recursive
	 * @param array
	 * @param num
	 * @return
	 */
	public static boolean binarySearch(int[] array, int num) {
		boolean result = false;
		
		if (array == null || array.length == 0) {
			return false;
		}
		
		int left = 0;
		int right = array.length - 1;
		
		while (left <= right) {
			int mid = (left + right)/2;			
			
			if (num == array[mid]) {
				result = true;
				break;
			} else if (num < array[mid]) {
				right = mid - 1;
			} else {
				left = mid +1;
			}
		}	
		
		return result;
	}
	
	/**
	 * Find number of occurrence of given number in sorted array
	 * @param array
	 * @param num
	 * @return
	 */	
	public static int findCount(int[] array, int num) {
		int firstIndex = findFirstIndex(array, num);
		
		if (firstIndex == -1) 
			return 0;
		else
			return findLastIndex(array, num) - firstIndex + 1;
	}

	/**
	 * Find index of first occurrence for given number in a sorted array
	 * @param array
	 * @param num
	 * @return
	 */
	public static int findFirstIndex(int[] array, int num) {
		return findFirstIndex(array, 0, array.length - 1, num);
	}

	/**
	 * Find index of first occurrence for given number in a sorted array
	 * @param array
	 * @param left
	 * @param right
	 * @param num
	 * @return
	 */
	private static int findFirstIndex(int[] array, int left, int right, int num) {
		if (array == null || array.length == 0 || left > right) {
			return -1;
		}
		
		int mid = (left + right) / 2;
		
		if (num < array[mid]) {
			return findFirstIndex(array, left, mid -1, num);
		} else if (num  > array[mid]) {
			return findFirstIndex(array, mid+1, right, num);
		} else {
			if (mid == 0 || array[mid-1] < num) {
				return mid;
			}else {
				return findFirstIndex(array, left, mid-1, num);
			}
		}		
	}
	
	/**
	 * Find index of last occurrence for given number in a sorted array
	 * @param array
	 * @param num
	 * @return
	 */
	public static int findLastIndex(int[] array, int num) {
		return findLastIndex(array, 0, array.length, num); 
	}
	
	/**
	 * Find index of last occurrence for given number in a sorted array
	 * @param array
	 * @param left
	 * @param right
	 * @param num
	 * @return
	 */
	private static int findLastIndex(int[] array, int left, int right, int num) {
		if (array == null || array.length == 0 || left > right) {
			return -1;
		}
		
		int mid = (left+right)/2;
		
		if (num < array[mid]) {
			return findLastIndex(array, left, mid -1, num);
		} else if (num > array[mid]) {
			return findLastIndex(array, mid+1, right, num);					
		} else {
			if (mid == array.length - 1 || array[mid+1] > num) {
				return mid;
			} else {
				return findFirstIndex(array, mid+1, right, num);
			}
		}		
	}
}
