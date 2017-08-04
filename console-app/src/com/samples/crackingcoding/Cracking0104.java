package com.samples.crackingcoding;

/**
 * 
 * @author Kumar, Prakash
 *
 */
public class Cracking0104 {

	public static void main(String[] args) {
		String str = "tactcoa";
		System.out.println(isPermutationOfPalindrome(str));
	}
	
	public static boolean isPermutationOfPalindrome(String str) {
		int[] charFrequencyCounts = new int['z' - 'a' + 1];
		
		for (char ch : str.toCharArray()) {
			if ('a' <= ch && ch <= 'z') {				
				charFrequencyCounts[ch - 'a']++;				
			}
		}
		
		boolean findOdd = false;
		for (int count : charFrequencyCounts) {
			if (count % 2 == 1) {
				if (findOdd) {
					return false;
				}
				
				findOdd = true;
			}
		}
		
		return true;
	}

}
