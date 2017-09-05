package com.samples.leetcode;

public class LeetCode004 {

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 11, 17 };
		int[] b = { 9, 10, 11, 13, 14 };

		a = new int[] { 1, 3 };
		b = new int[] { 2 };

		System.out.println(findMedianSortedArrays(a, b));
	}

	public static double findMedianSortedArrays(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;

		// make sure b is the shorter length array
		if (m < n) {
			return findMedianSortedArrays(b, a);
		}

		int left = 0, right = n * 2;

		while (left <= right) {
			
			int mid_b = (left + right) / 2; // get middle of b
			int mid_a = m + n - mid_b; // calculate middle of a accordingly

			double l1 = (mid_a == 0) ? Integer.MIN_VALUE : a[(mid_a - 1) / 2];
			double l2 = (mid_b == 0) ? Integer.MIN_VALUE : b[(mid_b - 1) / 2];
			
			double r1 = (mid_a == m * 2) ? Integer.MAX_VALUE : a[(mid_a) / 2];
			double r2 = (mid_b == n * 2) ? Integer.MAX_VALUE : b[(mid_b) / 2];

			if (l1 > r2)
				left = mid_b + 1; 
			else if (l2 > r1)
				right = mid_b - 1; 
			else
				return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0; 
		}
		return -1;
	}
}
