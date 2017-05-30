package com.samples.utils;

import java.util.*;

public class ArrayUtils {
	
	/**
	 * Returns index for numbers having sum equal to given number (unsorted array)
	 * @param array
	 * @param target
	 * @return 
	 */
	public static int[] twoSum(int[] array, int target) {
		if (array == null || array.length < 2) {
			return new int[] {-1, -1};
		}
		
		// Use HashMap to store compliment number we are looking for each number
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (hashMap.containsKey(array[i])) {
				return new int[] {hashMap.get(array[i]), i};
			} else {
				hashMap.put(target - array[i], i);
			}
		}
		
		return new int[] {-1, -1};
	}
	
	/**
	 * Returns index for numbers having sum equal to given number from sorted array
	 * @param array
	 * @param target
	 * @return 
	 */
	public static int[] twoSumSortedArray(int[] array, int target) {
		
		int[] result = new int[] {0, 0};
		
		if (array == null || array.length < 2) {
			return result;
		}
		
		int i = 0;
		int j = array.length - 1;
		
		while (i < j) {
			int sum = array[i] + array[j];
			if (sum < target) {
				i++;
			} else if (sum > target) {
				j--;
			} else {
				return new int[] {i, j};
			}
		}
		
		return result;

	}
	
	/**
	 * Sets entire row and column values to zero for each zero value in matrix
	 * @param array
	 */
	public static void setMatrixZeroes(ArrayList<ArrayList<Integer>> array) {		
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
	
	/**
	 * Prints a 2D array - 
	 * @param array
	 */
	public static void print(ArrayList<ArrayList<Integer>> array) {

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
	
	
	/**
	 * prints an array
	 * @param array
	 */
	public static void print(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			
			if (i > 0)
				System.out.print(", ");
			System.out.print(array[i]);
		}		
		System.out.print("]\n");
	}
	
	/**
	 * prints a 2D array
	 * @param array
	 */
	public static void print(int[][] array) {
		
		if (array == null) return;
		
		int rows = array.length;
		int coloumns = array[0].length;
		
		for (int i = 0; i < rows; i++) {
			System.out.print("[");
			for (int j = 0; j < coloumns; j++) {
				if (j > 0) System.out.print(", ");
					
				System.out.print(array[i][j]);
			}
			System.out.print("]");
			System.out.print("\n");
		}
	}
	
	/**
	 * Returns a concentric Pattern 2D Array
	 * @param num
	 * @return
	 */	
	public static int[][] getConcentricPattern(int num) {
		if (num < 1) return null;	
		
		
		int rows = 2* num -1, coloumns = 2* num -1;
		
		int[][] array = new int[rows][coloumns];
		
		int row = 0, col = 0, layer = 0;		
		int direction = 0;
		
		array[0][0] = num;
		for(int i = 1; i< rows * coloumns; i++) {
			switch (direction) {
			case 0:
                if (col == coloumns - layer - 1)
                {
                    direction++;
                    row++;
                }
                else
                {
                    col++;
                }
                break;
            case 1:
                if (row == rows - layer - 1)
                {
                    direction++;
                    col--;
                }
                else
                {
                    row++;
                }
                break;
            case 2:

                if (col == layer)
                {
                    direction++;
                    row--;
                }
                else
                {
                    col--;
                }

                break;
            case 3:
                if (row == layer + 1)
                {
                    direction = 0;
                    col++;
                    layer++;
                    num--;
                }
                else
                {
                    row--;
                }                
                break;
			}
			
			array[row][col] = num;			
		}	
		
		
		return array;
	}
	
	/**
	 * generates a nxn matrix with specific pattern
	 * @param a
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> prettyPrint(int a) {
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int[][] array = getConcentricPattern(a);
		
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				int[] row = array[i];		
				
				ArrayList<Integer> newRow = new ArrayList<>();				
				for (int num : row) {
					newRow.add(num);
				}
				
				list.add(newRow);
			}
		}
		
		return list;
	}
	
	public static void rotateSortedArray(int[] array, int count){
		
		if (count < 1 || array.length < 2) {
			return;
		}
		
		int length = array.length;
		
		while(count > 0) {
			int temp = array[0];			
			for (int i = 0; i < array.length - 1; i++) {
				array[i] = array[i+1];
			}
			array[length -1] = temp;
			count--;
		}
	}	
	
	public static int findPivot(int[] array){	
		return  findPivot(array, 0, array.length - 1);
	}

	private static int findPivot(int[] array, int left, int right) {
		
		return 0;
	}
	
	
}