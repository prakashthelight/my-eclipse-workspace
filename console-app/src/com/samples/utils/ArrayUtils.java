package com.samples.utils;

import java.util.*;

public class ArrayUtils {
	
	public static void SetMatrixZeroes(ArrayList<ArrayList<Integer>> array) {		
		int[] rows = new int[array.size()];
		int[] coloumns = new int[array.get(0).size()];
		
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.get(0).size(); j++) {
				if (array.get(i).get(j) == 0) {
					rows[i] = 1;
					coloumns[j] = 1;
				}
			}
		}
		
		for (int i = 0; i < rows.length; i++) {
			if(rows[i] == 1) {
				for (int j = 0; j < coloumns.length; j++) {
					array.get(i).set(j, 0);
				}
			}
		}
		
		for (int i = 0; i < coloumns.length; i++) {
			if(coloumns[i] == 1) {
				for (int j = 0; j < rows.length; j++) {
					array.get(j).set(i, 0);
				}
			}
		}		
	}
	
	public static void Print(ArrayList<ArrayList<Integer>> array) {
		int rows = array.size();
		int coloumns = array.get(0).size();
		
		for (int i = 0; i < rows; i++) {
			System.out.print("[");
			for (int j = 0; j < coloumns; j++) {
				if (j > 0) System.out.print(", ");
					
				System.out.print(array.get(i).get(j));
			}
			System.out.print("]");
			System.out.print("\n");
		}
	}
}
