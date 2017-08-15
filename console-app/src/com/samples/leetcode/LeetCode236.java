package com.samples.leetcode;

import com.samples.model.TreeNode;

/**
 * Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
 * @author Kumar, Prakash
 *
 */
public class LeetCode236 {

	public static void main(String[] args) {
		

	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p|| root == q) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor (root.left, p, q);
        TreeNode right = lowestCommonAncestor (root.right, p, q);
        
        if (left != null && right != null) return root;
        
        return left != null ? left : right;
    }
}
