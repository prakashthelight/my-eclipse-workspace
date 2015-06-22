package com.questions.chapter1;

import java.util.Arrays;

/**
 * Write a program to find if one String is permutation of the other
 * @author Prakash
 *
 */
public class Q1_3 {
	
	public static boolean isPermutation(String str1, String str2)
    {
        boolean result = false;

        if (str1.length() != str2.length())
            return false;

       
        if(sort(str1).equals(sort(str2)))
        {
        	result=true;
        }        

        return result;
    }

    public static String sort(String str)
    {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);        
        return new String(chars);
    }
}
