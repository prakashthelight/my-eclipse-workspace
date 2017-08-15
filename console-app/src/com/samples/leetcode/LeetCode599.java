package com.samples.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Minimum Index Sum of Two Lists
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists
 * @author Kumar, Prakash
 *
 */
public class LeetCode599 {

	public static void main(String[] args) {
		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		
		System.out.println(Arrays.toString(findRestaurant(list1, list2)));
	}
	
	/**
	 * returns array of common strings with minimum index sum
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<String>();
        
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int j = 0; j < list2.length; j++) {
            
            String str = list2[j];
            
            if (map.containsKey(str)) {
                int index = map.get(str);
                if (index + j <= min) {                    
                    if (index + j < min) {
                        result = new ArrayList<String>();
                        min = index + j;                        
                    }
                    
                    result.add(str);    
                }
            }
        }
        
        return result.toArray(new String[result.size()]);
    }

}
