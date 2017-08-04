package com.samples.leetcode;

import com.samples.model.TreeNode;

/**
 * Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree
 * @author Kumar, Prakash
 *
 */
public class LeetCode110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * return true if binary tree is balanced
	 * @param root
	 * @return
	 */
	public static boolean isBalanced(TreeNode root) {
		// if root == null, return true;
        if (root == null) {
            return true;
        }
        
        // get height difference of left subtree and right subtree
        int heightDiff = Math.abs(getHeight(root.left) - getHeight(root.right));
        
        // if heigh difference of left subtree and right subtree is more than 1, return false;
        if (heightDiff > 1) {
            return false;
        }
        
        // check if left and right subtree are balanced
        return isBalanced(root.left) && isBalanced(root.right);        
    }
    
	/**
	 * return height of tree
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
