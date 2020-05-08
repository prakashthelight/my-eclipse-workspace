package com.samples.leetcode;

import com.samples.model.TreeNode;

/**
 * Cousins in Binary Tree
 * https://leetcode.com/problems/cousins-in-binary-tree/
 * @author Kumar, Prakash
 *
 */
public class LeetCode993 {
	
	static TreeNode xParent = null;
	static TreeNode yParent = null;
	static int xLevel = -1;
	static int yLevel = -1;

	public static void main(String[] args) {		
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		
		System.out.println(isCousins(root, 4, 3));
	}
	
	public static boolean isCousins(TreeNode root, int x, int y) {
		dfs(root, null, x, y, 0);		
		return xLevel == yLevel && xParent != yParent;				
	}	
	
	public static void dfs(TreeNode node, TreeNode parentNode, int x, int y, int level) {
		if (node == null) {
			return;
		}
		
		if (node.value == x) {
			xParent = parentNode;
			xLevel = level;
		} else if (node.value == y) {
			yParent = parentNode;
			yLevel = level;
		} else {
			dfs(node.left, node, x, y, level + 1);
			dfs(node.right, node, x, y, level + 1);
		}
	}
}
