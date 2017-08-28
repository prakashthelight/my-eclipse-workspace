package com.samples.leetcode;

/**
 * Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string
 * @author Kumar, Prakash
 *
 */
public class LeetCode151 {

	public static void main(String[] args) {
		String str = "the    sky is blue";
		System.out.println(reverseWords(str));
	}

	/**
	 * reverse words in given string
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		int i = 0;
		int j = 0;
		// replace all muliple spaces with single space
		s = s.trim().replaceAll("( )+", " ");
		char[] array = s.toCharArray();

		while (i < array.length) {
			if (array[i] == ' ') {
				// reverse each word
				reverse(array, j, i - 1);
				j = i + 1;
			}

			i++;
		}

		// reverse last word
		reverse(array, j, array.length - 1);

		// reverse statement again
		reverse(array, 0, array.length - 1);

		return String.valueOf(array);

	}

	/**
	 * revers characters in given range
	 * @param array
	 * @param start
	 * @param end
	 */
	public static void reverse(char[] array, int start, int end) {
		while (start < end) {
			char temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}

}
