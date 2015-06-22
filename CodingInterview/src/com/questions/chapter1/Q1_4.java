package com.questions.chapter1;

/**
 * Replace space char with %20 in the given string 
 * Q1_4.RepleceChar("My name is Prakash Kumar        ");
 * @author Prakash
 *
 */
public class Q1_4 {
	public static String repleceChar(String str)
    {
        char[] chars = str.toCharArray();

        int length = countChars(chars);

        int spaces = 0;
        // count spaces
        for (int i = 0; i < length; i++)
        {
            if (chars[i] == ' ') spaces++;
        }

        int newLength = length + 2 * spaces;

        for (int i = length - 1; i >= 0; i--)
        {
            if (chars[i] == ' ')
            {
                chars[--newLength] = '0';
                chars[--newLength] = '2';
                chars[--newLength] = '%';
            }
            else
            {
                chars[--newLength] = chars[i];
            }
        }

        return new String(chars);
    }       

    private static int countChars(char[] chars)
    {
        int lastCharIndex = 0;
        int i = 0;
        for (char c : chars) {
        	if(c != ' ') lastCharIndex = i;                
            i++;
		}
        
        return lastCharIndex + 1;
    }
}
