package com.samples.leetcode;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Convert BST to Greater Tree
 * https://leetcode.com/problems/convert-bst-to-greater-tree
 *  
 * @author Kumar, Prakash
 *
 */
public class LeetCode538 {

	public static void main(String[] args) {
		TreeNode root = MyTreeUtil.createBST(new int[] { 5, 2, 13 });

		MyTreeUtil.print(root);

		root = convertBST(root);

		MyTreeUtil.print(root);

	}

	public static TreeNode convertBST(TreeNode root) {
		if (root == null)
			return null;
		DFS(root, 0);
		return root;
	}

	public static int DFS(TreeNode root, int preSum) {
		if (root.right != null) {
			preSum = DFS(root.right, preSum);
		}

		root.value += preSum;
		return (root.left != null) ? DFS(root.left, root.value) : root.value;
	}

}
