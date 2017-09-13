package com.samples.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle <br/>
 * https://leetcode.com/problems/pascals-triangle
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode118 {

	public static void main(String[] args) {
		int numRows = 5;
		
		List<List<Integer>> result = generate(numRows);
		
		for (List<Integer> row : result) {
			System.out.println(row);
		}
	}

	/**
	 * generates list of list (Pascal's triangle)
	 * 
	 * @param numRows
	 * @return
	 */

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<>();

			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					list.add(1);
				} else {
					// take items from previous list for same and prvious index
					// and add
					list.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
				}
			}

			result.add(list);
		}

		return result;
	}

}
