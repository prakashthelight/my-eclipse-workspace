package com.questions.chapter1;


/**
 * Determine if a string has unique characters
 * @author Prakash 
 *
 */
public class Q1_1 {
	
	public static boolean hasAllUniqueChars(String str)
    {
        boolean allUnique = true;
        boolean[] duplicate = new boolean[256];

        // If string has more than 256 char, it confirms that it has duplicate chars
        if (str.length() > 256)
        {
            return false;
        }
        
        for (char c : str.toCharArray()) {
        	int i = (int)c;
            // if for given char it has already been set true, string has duplicate chars
            if (duplicate[i])
            {
                allUnique = false;                    
                break;
            }
            else
            {
                //set true for the char found
                duplicate[i] = true;
            }
		}       

        return allUnique;
    }
}
