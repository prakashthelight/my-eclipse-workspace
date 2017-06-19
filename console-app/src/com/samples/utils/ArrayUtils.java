package com.samples.utils;

import java.util.*;

public class ArrayUtils {

	public int[] initialize() {
		return new int[] { 12, 3, 56, 78, 2, 16, 43, 26 };
	}

	public int[][] initialize2D() {
		return new int[][] { { 11, 12, 13, 14 }, { 15, 16, 17, 18 }, { 19, 20, 21, 22 }, { 23, 24, 25, 26 } };
	}

	/**
	 * returns length of substring with non-repeating characters
	 * 
	 * @param str
	 * @return
	 */
	public static int longestSubstring(String s) {
		int start = 0;
		int max = 0;
		int index = 0;
		int length = s.length();

		HashSet<Character> chars = new HashSet<>();
		while (index < length) {
			if (!chars.contains(s.charAt(index))) {
				chars.add(s.charAt(index++));
				max = Math.max(max, chars.size());
			} else {
				chars.remove(s.charAt(start++));
			}
		}

		return max;
	}

	/**
	 * compressed a given string e.g. aabcccaaadd -> a2b1c3a3d2
	 * 
	 * @param str
	 * @return
	 */
	public static String compress(String str) {
		if (str == null || str.isEmpty())
			return str;

		StringBuilder sb = new StringBuilder();

		int count = 0;
		char[] chars = str.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			count++;
			if (i + 1 >= chars.length || chars[i] != chars[i + 1]) {
				sb.append(chars[i]).append(count);
				count = 0;
			}
		}

		String compressedStr = sb.toString();

		return compressedStr.length() < str.length() ? compressedStr : str;
	}

	/**
	 * Returns index for numbers having sum equal to given number (unsorted
	 * array)
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] array, int target) {
		if (array == null || array.length < 2) {
			return new int[] { 0, 0 };
		}

		// Use HashMap to store compliment number we are looking for each number
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (hashMap.containsKey(array[i])) {
				return new int[] { hashMap.get(array[i]), i };
			} else {
				hashMap.put(target - array[i], i);
			}
		}

		return new int[] { 0, 0 };
	}

	/**
	 * Returns index for numbers having sum equal to given number from sorted
	 * array
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	public static int[] twoSumSortedArray(int[] array, int target) {

		int[] result = new int[] { 0, 0 };

		if (array == null || array.length < 2) {
			return result;
		}

		int i = 0;
		int j = array.length - 1;

		while (i < j) {
			int sum = array[i] + array[j];
			if (sum < target) {
				i++;
			} else if (sum > target) {
				j--;
			} else {
				return new int[] { i, j };
			}
		}

		return result;

	}

	/**
	 * Sets entire row and column values to zero for each zero value in matrix
	 * 
	 * @param array
	 */
	public static void setMatrixZeroes(ArrayList<ArrayList<Integer>> array) {
		int[] rows = new int[array.size()];
		int[] coloumns = new int[array.get(0).size()];

		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.get(0).size(); j++) {
				if (array.get(i).get(j) == 0) {
					rows[i] = 1;
					coloumns[j] = 1;
				}
			}
		}

		for (int i = 0; i < rows.length; i++) {
			if (rows[i] == 1) {
				for (int j = 0; j < coloumns.length; j++) {
					array.get(i).set(j, 0);
				}
			}
		}

		for (int i = 0; i < coloumns.length; i++) {
			if (coloumns[i] == 1) {
				for (int j = 0; j < rows.length; j++) {
					array.get(j).set(i, 0);
				}
			}
		}
	}

	/**
	 * Prints a 2D array -
	 * 
	 * @param array
	 */
	public static void print(ArrayList<ArrayList<Integer>> array) {

		int rows = array.size();
		int coloumns = array.get(0).size();

		for (int i = 0; i < rows; i++) {
			System.out.print("[");
			for (int j = 0; j < coloumns; j++) {
				if (j > 0)
					System.out.print(", ");

				System.out.print(array.get(i).get(j));
			}
			System.out.print("]");
			System.out.print("\n");
		}
	}

	/**
	 * prints an array
	 * 
	 * @param array
	 */
	public static void print(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {

			if (i > 0)
				System.out.print(", ");
			System.out.print(array[i]);
		}
		System.out.print("]\n");
	}

	/**
	 * prints a 2D array
	 * 
	 * @param array
	 */
	public static void print(int[][] array) {

		if (array == null)
			return;

		int rows = array.length;
		int coloumns = array[0].length;

		for (int i = 0; i < rows; i++) {
			System.out.print("[");
			for (int j = 0; j < coloumns; j++) {
				if (j > 0)
					System.out.print(", ");

				System.out.print(array[i][j]);
			}
			System.out.print("]");
			System.out.print("\n");
		}
	}

	/**
	 * Returns a concentric Pattern 2D Array
	 * 
	 * @param num
	 * @return
	 */
	public static int[][] getConcentricPattern(int num) {
		if (num < 1)
			return null;

		int rows = 2 * num - 1, coloumns = 2 * num - 1;

		int[][] array = new int[rows][coloumns];

		int row = 0, col = 0, layer = 0;
		int direction = 0;

		array[0][0] = num;
		for (int i = 1; i < rows * coloumns; i++) {
			switch (direction) {
			case 0:
				if (col == coloumns - layer - 1) {
					direction++;
					row++;
				} else {
					col++;
				}
				break;
			case 1:
				if (row == rows - layer - 1) {
					direction++;
					col--;
				} else {
					row++;
				}
				break;
			case 2:

				if (col == layer) {
					direction++;
					row--;
				} else {
					col--;
				}

				break;
			case 3:
				if (row == layer + 1) {
					direction = 0;
					col++;
					layer++;
					num--;
				} else {
					row--;
				}
				break;
			}

			array[row][col] = num;
		}

		return array;
	}

	/**
	 * generates a nxn matrix with specific pattern
	 * 
	 * @param a
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> prettyPrint(int a) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int[][] array = getConcentricPattern(a);

		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				int[] row = array[i];

				ArrayList<Integer> newRow = new ArrayList<>();
				for (int num : row) {
					newRow.add(num);
				}

				list.add(newRow);
			}
		}

		return list;
	}

	/**
	 * rotates sorted array for given number of elements
	 * @param array
	 * @param count
	 */
	public static void rotateSortedArray(int[] array, int count) {

		if (count < 1 || array.length < 2) {
			return;
		}

		int length = array.length;

		while (count > 0) {
			int temp = array[0];
			for (int i = 0; i < array.length - 1; i++) {
				array[i] = array[i + 1];
			}
			array[length - 1] = temp;
			count--;
		}
	}

	public static boolean findInPivotedArray(int[] array, int num) {
		int pivot = findPivot(array);

		if (pivot == -1) {
			return SearchUtils.binarySearch(array, num);
		}

		if (array[0] <= num && num <= array[pivot]) {
			return SearchUtils.binarySearch(array, num, 0, pivot);
		} else {
			return SearchUtils.binarySearch(array, num, pivot + 1, array.length - 1);
		}
	}

	public static int findPivot(int[] array) {
		return findPivot(array, 0, array.length - 1);
	}

	private static int findPivot(int[] array, int left, int right) {

		if (left > right)
			return -1;
		if (left == right)
			return left;

		int mid = (left + right) / 2;

		if (mid < right && array[mid] > array[mid + 1]) {
			return mid;
		}

		if (mid > left && array[mid] < array[mid - 1]) {
			return mid - 1;
		}

		if (array[left] >= array[mid]) {
			return findPivot(array, left, mid - 1);
		}

		return findPivot(array, mid + 1, right);
	}

	/**
	 * rotates a 2D array by 90 degrees
	 * 
	 * @param array
	 */

	public static void rotate2DArray(int[][] array) {

		if (array == null || array.length == 0 || array.length != array[0].length)
			return;

		for (int layer = 0; layer < array.length / 2; layer++) {

			int start = layer;
			int end = array.length - layer - 1;

			for (int i = start; i < end; i++) {
				int offset = i - start;

				int top = array[start][i];
				array[start][i] = array[end - offset][start];
				array[end - offset][start] = array[end][end - offset];
				array[end][end - offset] = array[i][end];
				array[i][end] = top;
			}
		}
	}

	/**
	 * Returns shortest distance between two words in a array of strings
	 * 
	 * @param array
	 * @param word1
	 * @param word2
	 * @return
	 * {@code 
	 * String[] array = new String[] {"practice", "makes", "perfect", "coding", "makes"};
	 * System.out.println(ArrayUtils.shortestWordDistance(array, "makes", "coding"));}
	 */
	public static int shortestWordDistance(String[] array, String word1, String word2) {
		int m = -1;
		int n = -1;

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < array.length; i++) {
			if (word1.equals(array[i])) {
				m = i;
				if (n != -1) {
					min = Math.min(min, m - n);
				}
			} else if (word2.equals(array[i])) {
				n = i;

				if (m != -1) {
					min = Math.min(min, n - m);
				}
			}
		}

		return min;
	}
	
	/**
	 * prints running mean of an integer stream
	 * @param array - an array of integer
	 * <pre>
	 * {@code
	 * int[] array = new int[] {12, 3, 4, 6};
	 * ArrayUtils.printRunningMean(array);}
	 * </pre>
	 */
	
	public static void printRunningMean(int[] array) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		int[] temp = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			temp[i] = array[i];
			maxHeap.offer(array[i]);
			minHeap.offer(maxHeap.poll());
			
			if (maxHeap.size() < minHeap.size()) {
				maxHeap.offer(minHeap.poll());
			}
			
			double mean = 0.0;
			if (maxHeap.size() == minHeap.size()) {
				mean = (maxHeap.peek() + minHeap.peek()) / 2.0;
			} else {
				mean = maxHeap.peek();
			}
			
			System.out.println(Arrays.toString(temp) + " Mean: " + mean);
		}		
	}
	
	/**
	 * Returns index of target list into source list, else return -1
	 * @param source
	 * @param target
	 * @return
	 */
	public static int indexOfSublist(List<Integer> source, List<Integer> target) {
		
		// if source list is not long enough
		if (source.size() < target.size()) {
			return -1;
		}
		
		int i = 0;
		int j = 0;
		int startIndex = -1;
		
		while (i < source.size() && j < target.size()) {
			if (source.get(i) != target.get(j)) {
				if (startIndex == -1) {
					i++;
					continue;
				} else {
					i = startIndex + 1;
					startIndex = -1;
					j = 0;
				}
			} else {
				if (startIndex == -1) {
					startIndex = i;
				}
				i++;
				j++;
			}
		}
		
		return startIndex;
	}
	
	
	/**
	 * find median of two sorted arrays
	 * @param array1
	 * @param array2
	 * @return
	 */
	public static double findMedian(int[] array1, int[] array2) {
		int length = array1.length + array2.length;
		
		int count = 0;
		
		int middle = length / 2 + 1;
		int middle2 = length/ 2;
		
		int a = Integer.MIN_VALUE; 
		int b = Integer.MIN_VALUE;
		
		int i = 0;
		int j = 0;	
		
		while (count < middle) {
			int item = Integer.MIN_VALUE;
			if (i < array1.length && i < array2.length) {
				if (array1[i] <= array2[j]) {
					item = array1[i];
					count++;
					i++;
				} else {
					item = array2[j];
					count++;
					j++;
				}
			} else if (i < array1.length) {
				item = array1[i];
				count++;
				i++;
			} else if (j < array2.length) {
				item = array2[j];
				count++;
				j++;
			}			
			
			if (count == middle2) {
				b = item;
			}
			
			if (count == middle) {
				a = item;
			}			
		}
		
		System.out.println(a + " " + b);
		
		return length % 2 == 0 ? (a + b) / 2.0 : a / 2.0;
	}
}
