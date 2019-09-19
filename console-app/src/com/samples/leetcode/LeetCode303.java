package com.samples.leetcode;

/**
 * Range Sum Query - Immutable <br/>
 * https://leetcode.com/problems/range-sum-query-immutable
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode303 {

	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		NumArray array = new NumArray(nums);
		
		System.out.println(array.sumRange(0, 2)); // 1
		System.out.println(array.sumRange(2, 5)); // - 1
	}
}

class NumArray {
    int[] sumArray;
    
    public NumArray(int[] nums) {        
        sumArray = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            sumArray [i + 1] = sumArray[i] + nums[i]; 
        }        
    }
    
    public int sumRange(int i, int j) {
        return sumArray[j + 1] - sumArray[i];
    }
}

class NumArray1 {
	private int[] nums;
	private int[] temp;

	public NumArray1(int[] nums) {
		int length = nums.length;
		this.nums = nums;
		this.temp = new int[nums.length];

		for (int i = 0; i < length; i++) {
			if (i == 0) {
				this.temp[i] = this.nums[i];
			} else {
				this.temp[i] = this.temp[i - 1] + this.nums[i];
			}
		}
	}

	public int sumRange(int i, int j) {
		if (i == j) {
			return this.nums[i];
		}

		if (i == 0) {
			return this.temp[j];
		} else {
			return this.temp[j] - (this.temp[i] - this.nums[i]);
		}
	}
}
