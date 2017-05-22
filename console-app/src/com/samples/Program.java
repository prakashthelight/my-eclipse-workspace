package com.samples;

import java.util.ArrayList;
import java.util.Arrays;

import com.samples.utils.ArrayUtils;

public class Program {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
		
		array.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1)));
		array.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
		array.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
				
		ArrayUtils.Print(array);
		ArrayUtils.SetMatrixZeroes(array);
		ArrayUtils.Print(array);
	}
}