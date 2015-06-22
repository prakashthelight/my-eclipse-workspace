package com.questions.chapter1;

/**
 * Reverse a string
 * @author Prakash
 *
 */
public class Q1_2 {
	
	public static String reverse(String	 str)
    {
        char[] chars = str.toCharArray();

        for (int i = 0, j = str.length() -1; i < j; i++, j--)
        {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return new String(chars);
    }
}
