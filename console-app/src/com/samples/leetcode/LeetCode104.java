package com.samples.leetcode;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Maximum Depth of Binary Tree <br/>
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode104 {

	public static void main(String[] args) {
		TreeNode root = MyTreeUtil.createBinaryTree();
		
		System.out.println(maxDepth(root));
	}

	/**
	 * return max depth of tree
	 * 
	 * @param root
	 * @return
	 */
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return getHeight(root) + 1;
	}

	/**
	 * return height of tree;
	 * 
	 * @param root
	 * @return
	 */
	public static int getHeight(TreeNode root) {
		if (root == null) {
			return -1;
		}

		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

}
