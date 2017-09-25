package com.samples.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Intersection of Two Arrays II <br/>
 * https://leetcode.com/problems/intersection-of-two-arrays-ii
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode350 {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };

		System.out.println(Arrays.toString(intersect(nums1, nums2)));
	}
	
	public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null  || nums2 == null) return new int[]{};
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int item : nums1) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }
        
        ArrayList<Integer> common = new ArrayList<Integer>();        
        for (int item : nums2) {
            if (map.containsKey(item) && map.get(item) > 0) {
                common.add(item);
                map.put(item, map.get(item) - 1);
            }
        }
        
        int[] result = new int[common.size()];
        
        int i = 0;
        for (Integer item: common) {
            result[i] = item;
            i++;
        }
        
        return result;
    }
}
