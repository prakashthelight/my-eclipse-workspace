package com.samples.leetcode;

import com.samples.model.TreeNode;

/**
 * Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree
 * @author Kumar, Prakash
 *
 */
public class LeetCode111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * return minimum length of root to closest leaf node
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return getMinHeight(root);
    }
    
	/**
	 * return min distance from root to any leaf node
	 * @param root
	 * @return
	 */
    public int getMinHeight(TreeNode root) {        
        if (root.left == null && root.right == null) {
            return 1;
        }
            
        if (root.left != null && root.right != null) {
            return Math.min(getMinHeight(root.left), getMinHeight(root.right)) + 1;        
        }
        
        if (root.left == null) {
            return getMinHeight(root.right) + 1;
        } else {
            return getMinHeight(root.left) + 1;
        }
    }

}
