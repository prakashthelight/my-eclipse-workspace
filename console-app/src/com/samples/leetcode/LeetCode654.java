package com.samples.leetcode;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Maximum Binary Tree <br/>
 * https://leetcode.com/problems/maximum-binary-tree
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode654 {
	public static void main(String[] args) {
		int[] nums = new int[] { 3, 2, 1, 6, 0, 5 };

		TreeNode root = constructMaxBinaryTree(nums, 0, nums.length - 1);
		MyTreeUtil.print(root);
	}

	/**
	 * creates a maximum binary tree i.e. root value is greater than child values
	 * @param nums
	 * @return
	 */
	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMaxBinaryTree(nums, 0, nums.length - 1);
	}

	/**
	 * creates a miximum binary tree
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public static TreeNode constructMaxBinaryTree(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}

		int maxIndex = findMaxIndex(nums, left, right);

		// create root with max item
		TreeNode root = new TreeNode(nums[maxIndex]);

		// creat left subtree and right subtree with subarrays divided by max
		// item
		if (maxIndex != left) {
			root.left = constructMaxBinaryTree(nums, left, maxIndex - 1);
		} else {
			root.left = null;
		}

		if (maxIndex != right) {
			root.right = constructMaxBinaryTree(nums, maxIndex + 1, right);
		} else {
			root.right = null;
		}

		return root;
	}

	/**
	 * returns max item index for give subarray between left and right
	 * 
	 * @param nums
	 * @param left
	 * @param right
	 * @return
	 */
	public static int findMaxIndex(int[] nums, int left, int right) {
		int maxIndex = left;
		for (int i = left; i <= right; i++) {
			if (nums[i] > nums[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
