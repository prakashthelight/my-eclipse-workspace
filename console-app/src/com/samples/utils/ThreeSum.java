package com.samples.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {	
	
	public static List<List<Integer>> threeSum(int[] array, int sum) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if (array == null || array.length < 3) {
			return result;
		}
		
		Arrays.sort(array);
		
		for (int i = 0; i < array.length - 2; i++) {
			
			if (i == 0 || array[i] > array[i-1]) {
				int j = i + 1;
				int k = array.length - 1;
				
				while (j < k) {					
					if (array[i] + array[j] + array[k] == sum) {
						ArrayList<Integer> list = new ArrayList<>();						
						list.add(i);
						list.add(j);
						list.add(k);
						result.add(list);
						
						j++;
						k--;
						
						// handle duplicates
						while (j < k && array[j] == array[j+1]) {
							j++;
						}
						
						while (j < k && array[k] == array[k -1]) {
							k--;
						}
						
					} else if (array[i] + array[j] + array[k]  > sum) {
						k--;
					} else {
						j++;
					}
				}				
			}
		}
		
		return result;
	}

}
