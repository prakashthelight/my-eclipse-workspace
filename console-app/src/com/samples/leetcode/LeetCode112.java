package com.samples.leetcode;

import com.samples.model.TreeNode;

/**
 * Path Sum
 * https://leetcode.com/problems/path-sum
 * @author Kumar, Prakash
 *
 */
public class LeetCode112 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		System.out.println(hasPathSum(root, 3));
	}
	
	public static boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }
    
    public static boolean hasPathSum(TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return false;
        }
        
        sum = sum + root.value;
        
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }
        
        return hasPathSum(root.left, sum, targetSum) || hasPathSum(root.right, sum, targetSum);        
    }
}
