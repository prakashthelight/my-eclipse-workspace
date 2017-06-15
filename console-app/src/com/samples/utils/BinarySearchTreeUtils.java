package com.samples.utils;

public class BinarySearchTreeUtils {

	/**
	 * validate if binary tree is binary search tree
	 * @param root
	 * @return
	 */
	public static boolean isBinarySearchTree(TreeNode root) {
		if (root ==  null || (root.left == null || root.right == null))
			return true;
		
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
	}
	
	public static boolean isBinarySearchTree(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		
		if (root.value <= min || root.value >= max) {
			return false;
		}
		
		return isBinarySearchTree(root, min, root.value) && isBinarySearchTree(root, root.value, max);		
	}
}
