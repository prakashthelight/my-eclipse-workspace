package com.samples.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Word Break <br/>
 * https://leetcode.com/problems/word-break
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode139 {

	public static void main(String[] args) {
		String s = "leetcode";

		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");

		System.out.println(wordBreak(s, wordDict));

	}

	public static boolean wordBreak(String s, List<String> wordDict) {

		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
			System.out.println(i + " " + dp[i]);
		}

		return dp[s.length()];
	}
}
