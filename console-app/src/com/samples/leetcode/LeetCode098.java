package com.samples.leetcode;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * 98. Validate Binary Search Tree <br/>
 * https://leetcode.com/problems/validate-binary-search-tree
 * 
 * @author Kumar, Prakash
 * @category Tree, Depth-First Search, Binary Search Tree, Binary Tree
 */
public class LeetCode098 {

	public static void main(String[] args) {
		TreeNode root = MyTreeUtil.createBST();

		System.out.println(isValidBST(root));

	}

	/**
	 * return true if tree is a valid binary search tree
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	/**
	 * returns true if tree is a valid binary search tree
	 * 
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null)
			return true;

		// if root value is within the boundary of min and max, it is a BST at
		// this node
		if (min < (long) root.value && (long) root.value < max) {

			// return true if left subtree and right subtree both are valid BST
			return isValidBST(root.left, min, root.value) && isValidBST(root.right, root.value, max);
		}

		return false;
	}
	
	/**
	 * return true if tree is a valid binary search tree
	 * @param root
	 * @param minValue
	 * @param maxValue
	 * @return
	 */
	public boolean isValidBST1(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }

        if (((long) root.value <= minValue) || ((long) root.value >= maxValue)) {
            return false;
        }

        return isValidBST(root.left, minValue, root.value) && isValidBST(root.right, root.value, maxValue);
    }
}
