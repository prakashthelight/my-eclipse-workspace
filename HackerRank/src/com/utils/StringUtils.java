package com.utils;

public class StringUtils {
	
	public static boolean isFunny(String input) {

		boolean isFunny = true;
		char[] chars = input.toCharArray();

		for (int i = 1, j = chars.length - 2; i < chars.length; i++, j--) {
			int a = Math.abs(chars[i] - chars[i - 1]);
			int b = Math.abs(chars[j] - chars[j + 1]);

			if (a != b) {
				isFunny = false;
				break;
			}
		}

		return isFunny;
	}

	public static boolean isPangrams(String str) {
		String newStr = str.toLowerCase();
		boolean pangram = true;

		int[] charCounts = new int[26];
		int indexOffset = 97; // 'a';

		for (int i : newStr.toCharArray()) {
			if (i >= 97 && i <= 122) {
				charCounts[i - indexOffset]++;
			}
		}

		for (int i : charCounts) {
			if (i == 0) {
				pangram = false;
				break;
			}
		}

		return pangram;
	}
}
