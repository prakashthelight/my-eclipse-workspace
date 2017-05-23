package com.samples;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;

import com.samples.utils.ArrayUtils;
import com.samples.utils.TwoSum;

public class Program {

	@SuppressWarnings("serial")
	public static void main(String[] args) {		
		int[] array = new int[] {12, 7, 11, 15, 4, 5, 2};
		
		TwoSum twoSum = new TwoSum();
		
		for (int i = 0; i < array.length; i++) {
			twoSum.Add(array[i]);
		}
		
		System.out.println(twoSum.Find(10));
		
	}
}