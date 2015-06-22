package com.utils;

import java.util.Scanner;

import com.main.ProgramNames;

public class CodeUtils {

	public static void execute(ProgramNames programName) {
		
		Scanner sc = new Scanner(System.in);
		
		switch (programName.name()) {
		
			case "FuzzyString": //https://www.hackerrank.com/challenges/funny-string
				int inputs = sc.nextInt();
				String[] inputStrings = new String[inputs];

				for (int i = 0; i < inputs; i++) {
					inputStrings[i] = sc.next();
				}
				
				for (int i = 0; i < inputs; i++) {
					// Input acxz, bcxz
					System.out.println( StringUtils.isFunny(inputStrings[i]) ? "Funny" : "Not Funny");
				}
				break;				
				
			case "IsPangrams": //https://www.hackerrank.com/challenges/pangrams				
				String line = sc.nextLine();
				// We promptly judged antique ivory buckles for the next prize
				boolean pangram= StringUtils.isPangrams(line);
				System.out.println(pangram ? "pangram" : "not pangram");
				sc.close();
			default:
				break;
		}

	}

}
