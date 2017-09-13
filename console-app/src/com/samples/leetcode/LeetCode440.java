package com.samples.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * K-th Smallest in Lexicographical Order <br/>
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode440 {
	
	public static void main(String[] args) {
		List<Integer> list = getLexicographicalOrder(13);
		
		System.out.println(list);
		int k = 2;
		System.out.println(list.get(k - 1));
	}

	public static List<Integer> getLexicographicalOrder(int n) {
		if (n < 1)
			return null;

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i + 1;
		}

		return getLexicographicalOrder(a);
	}

	public static List<Integer> getLexicographicalOrder(int[] array) {
		List<Integer> list = new ArrayList<Integer>();
		int[] temp = new int[array.length];

		mergeSort(array, temp, 0, array.length - 1);

		for (int item : array) {
			list.add(item);
		}
		return list;
	}

	public static void mergeSort(int[] array, int[] temp, int left, int right) {
		if (left >= right)
			return;

		int mid = (left + right) / 2;

		mergeSort(array, temp, left, mid);
		mergeSort(array, temp, mid + 1, right);
		merge(array, temp, left, mid, right);
	}

	public static void merge(int[] array, int[] temp, int left, int mid, int right) {
		
		int leftStart = left;
		int leftEnd = mid;
		int rightStart = mid + 1;
		int rightEnd = right;

		int tempIndex = leftStart;

		while (leftStart <= leftEnd && rightStart <= rightEnd) {
			
			// conver interger to string for comparison
			String a = String.valueOf(array[leftStart]);
			String b = String.valueOf(array[rightStart]);
			
			// compare for lexicographical order
			if (a.compareTo(b) <= 0) {
				temp[tempIndex++] = array[leftStart++];
			} else {
				temp[tempIndex++] = array[rightStart++];
			}
		}

		while (leftStart <= leftEnd) {
			temp[tempIndex++] = array[leftStart++];
		}

		while (rightStart <= rightEnd) {
			temp[tempIndex++] = array[rightStart++];
		}

		System.arraycopy(temp, left, array, left, right - left + 1);
	}
}
