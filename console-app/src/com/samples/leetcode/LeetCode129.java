package com.samples.leetcode;

import com.samples.model.TreeNode;

/**
 * Sum Root to Leaf Numbers <br/>
 * https://leetcode.com/problems/sum-root-to-leaf-numbers
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode129 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		// [1 -> 2 -> 4 (124) + 1 -> 2 -> 5 (125) + 1 -> 3 (13) = 262]
		System.out.println(sumNumbers(root));
	}

	public static int sumNumbers(TreeNode root) {
		return sumNumbers(root, 0);
	}

	public static int sumNumbers(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}

		sum = sum * 10 + root.value;

		if (root.left == null && root.right == null) {
			return sum;
		}

		return sumNumbers(root.left, sum) + sumNumbers(root.right, sum);
	}
}
