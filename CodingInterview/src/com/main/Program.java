package com.main;

import com.questions.chapter1.Q1_1;
import com.questions.chapter1.Q1_2;
import com.questions.chapter1.Q1_4;
import com.questions.chapter1.Q1_5;
import com.questions.chapter2.Q2_1;

public class Program {
	public static void main(String[] args) {
		
		String str = "Prakash";
		
		//Chapter 1
		System.out.printf("Q1_1: String \"%s\" has %s all unique chars.\n", str, Q1_1.hasAllUniqueChars(str) ? "" : "not");
		System.out.printf("Q1_2: String: \"%s\" Reverse: %s\n", str, Q1_2.reverse(str));		
		System.out.println(Q1_4.repleceChar("My name is Prakash Kumar        "));		
		System.out.println(Q1_5.compress("aaaabbbcdd"));	
		
		// Chapter 2
		Q2_1.execute();
		System.out.println("\nDone");
	}
}
