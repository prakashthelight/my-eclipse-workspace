package com.samples.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum <br/>
 * https://leetcode.com/problems/3sum
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode015 {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		
		nums = new int[] {-2, 0, 0, 2, 2};

		for (List<Integer> triplet : threeSum(nums)) {
			System.out.println(triplet);
		}
	}

	/**
	 * return list of unique triplets making sum to zero in given array
	 * 
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		if (nums == null || nums.length < 3) {
			return list;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

				int left = i + 1;
				int right = nums.length - 1;
				// setting target sum to two sum sweep
				int targetSum = 0 - nums[i];

				// binary search for targetSum
				while (left < right) {                    
					int sum = nums[left] + nums[right];

					if (sum < targetSum) {                        
						left++;
					} else if (sum > targetSum) {
						right--;
					} else {
                        ArrayList<Integer> l = new ArrayList<Integer>();
						l.add(nums[i]);
						l.add(nums[left]);
						l.add(nums[right]);
						list.add(l);
                        
                        // to avoid duplicate triplets to be added
                        while (left  < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        
                        while (left  < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        
                        left++;
                        right--;
					}
				}
			}
		}
		
		return list;
	}
}
