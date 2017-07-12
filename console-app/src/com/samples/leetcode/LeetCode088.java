package com.samples.leetcode;

import java.util.Arrays;

/**
 * Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array
 * @author kumarpr
 *
 */
public class LeetCode088 {
	
	public static void main(String[] args) {		
		int[] nums1 = new int[] {1, 2, 3, 4, 10, 23, 12, 0, 0, 0, 0};
		int[] nums2 = new int[] {2, 9, 18, 21};
		
		merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
		
		System.out.println(Arrays.toString(nums1));		
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // if second array is of zero length, return;
        if (n == 0) {
            return;
        }
        
        // if first array is zero length array, just copy second to first
        if (m == 0) {
            System.arraycopy (nums2, 0, nums1, 0, nums2.length);
        }
        
        int end1 = m - 1;
        int end2 = n - 1;
            
        for (int i = m + n - 1; i >= 0; i--) {            
            if (end1 >= 0 && end2 >= 0 ) {
                if (nums1[end1] > nums2[end2]) {
                    nums1[i] = nums1[end1];
                    end1--;
                } else {
                    nums1[i] = nums2[end2];
                    end2--;
                }    
            } else if (end2 >= 0) {
                nums1[i] = nums2[end2];
                end2--;
            }   
        }
    }
}
