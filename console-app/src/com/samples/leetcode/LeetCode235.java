package com.samples.leetcode;

import com.samples.model.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree <br/>
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 
 * @author Kumar, Prakash
 * @category Tree, Depth-First Search, Binary Search Tree, Binary Tree
 *
 */
public class LeetCode235 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		if (root.value < p.value && root.value < q.value) {
			return lowestCommonAncestor(root.right, p, q);
		} else if (root.value > p.value && root.value > q.value) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return root;
		}
	}
}
