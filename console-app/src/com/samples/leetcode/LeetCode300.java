package com.samples.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Longest Increasing Subsequence <br/>
 * https://leetcode.com/problems/longest-increasing-subsequence
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode300 {

	/**
	 * returns the length of longest increasing subsequence
	 * 
	 * @param array
	 * @return
	 */
	public static int longestIncSeq(int[] array) {

		// return 0 if array null
		if (array == null)
			return 0;

		// return 1 if only one element
		if (array.length == 1) {
			return 1;
		}

		// initialize an array of length equal to original array with values set
		// to 1
		int[] seqLength = new int[array.length];
		Arrays.fill(seqLength, 1);

		int maxSeqLength = 0; // keep updating with max value

		for (int i = 1; i < array.length; i++) {
			// compare with previous items
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i] && seqLength[i] < seqLength[j] + 1) {
					seqLength[i] = seqLength[j] + 1;
				}
			}

			maxSeqLength = Math.max(maxSeqLength, seqLength[i]);
		}

		return maxSeqLength;
	}

	/**
	 * returns list of items making longest increasing subsequence
	 * 
	 * @param array
	 * @return
	 */
	public static ArrayList<Integer> longestIncresingSubsequence(int[] array) {

		ArrayList<ArrayList<Integer>> subsequences = new ArrayList<>();

		// initialize all with empty list
		for (int i = 0; i < array.length; i++) {
			subsequences.add(i, new ArrayList<>(Arrays.asList(array[i])));
		}

		ArrayList<Integer> longestSubsequence = subsequences.get(0);

		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i] && subsequences.get(i).size() < subsequences.get(j).size() + 1) {
					subsequences.get(i).clear();
					subsequences.get(i).addAll(subsequences.get(j));
					subsequences.get(i).add(array[i]);
				}
			}

			if (longestSubsequence.size() < subsequences.get(i).size()) {
				longestSubsequence = subsequences.get(i);
			}
		}

		for (ArrayList<Integer> list : subsequences) {
			System.out.println(list);
		}

		return longestSubsequence;
	}

	public static void main(String[] args) {

		int[] array = new int[] { 9, 3, 7, 5, 6, 20, 18, 30 };

		ArrayList<Integer> subsequence = longestIncresingSubsequence(array);
		System.out.println("Longest Increasing Subsequence: " + subsequence);

		System.out.println("Length of Longest increasing subsequence: " + longestIncSeq(array));
	}

}
