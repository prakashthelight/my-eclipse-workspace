package com.questions.chapter1;

/**
 * Converts 'aabbbcdd' to 'a2b3c1d2'
 * @author Prakash
 *
 */
public class Q1_5 {
	public static String compress(String str)
    {
        StringBuilder sb = new StringBuilder();
        char last = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++)
        {        
            if (str.charAt(i) == last)
            {
                count++;
            }
            else
            {
                sb.append(last);
                sb.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }

        sb.append(last);
        sb.append(count);

        return sb.toString();
    }
}
