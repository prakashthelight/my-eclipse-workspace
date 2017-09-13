package com.samples.leetcode;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Minimum Depth of Binary Tree <br/>
 * https://leetcode.com/problems/minimum-depth-of-binary-tree
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode111 {

	public static void main(String[] args) {
		TreeNode root = MyTreeUtil.createBinaryTree();

		System.out.println(minDepth(root));

	}

	/**
	 * return minimum length of root to closest leaf node
	 * 
	 * @param root
	 * @return
	 */
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return getMinHeight(root);
	}

	/**
	 * return min distance from root to any leaf node
	 * 
	 * @param root
	 * @return
	 */
	public static int getMinHeight(TreeNode root) {

		// if both, left and right child are null
		if (root.left == null && root.right == null) {
			return 1;
		}

		// if both, left and right child are not null
		if (root.left != null && root.right != null) {
			return Math.min(getMinHeight(root.left), getMinHeight(root.right)) + 1;
		}

		// if one of left or right child is null
		if (root.left == null) {
			return getMinHeight(root.right) + 1;
		} else {
			return getMinHeight(root.left) + 1;
		}
	}

}
