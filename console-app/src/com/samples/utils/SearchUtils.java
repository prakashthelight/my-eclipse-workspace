package com.samples.utils;

public class SearchUtils {
	
	/**
	 * binary search recursive
	 * @param array
	 * @param num
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean binarySearch(int[] array, int num, int start, int end) {
		boolean result = false;
		if (array == null || array.length == 0 || start > end) {
			return false;
		}
		
		int mid = (start+end)/2;
		
		if (num == array[mid]) {
			return true;
		} else if (num < array[mid]) {
			result = binarySearch(array, num, start, mid-1);
		} else {
			result = binarySearch(array, num, mid+1, end);
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
		
		int start = 0;
		int end = array.length - 1;
		
		while (start <= end) {
			int mid = (start+end)/2;			
			
			if (num == array[mid]) {
				result = true;
				break;
			} else if (num < array[mid]) {
				end = mid - 1;
			} else {
				start = mid +1;
			}
		}	
		
		return result;
	}

}
