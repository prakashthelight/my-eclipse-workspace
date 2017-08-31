package com.samples.leetcode;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree
 * @author Kumar, Prakash
 *
 */
public class LeetCode543 {

	public static void main(String[] args) {
		TreeNode root = MyTreeUtil.generateSampleBTree();
		
		MyTreeUtil.print(root);
		System.out.println(diameterOfBinaryTree(root));
	}
	
	
	static int maxDiameter = 0;
	
    public static int diameterOfBinaryTree(TreeNode root) {        
        if (root == null) {
            return 0;
        }
        
        setMaxDiameter(root);
        return maxDiameter;        
    }
    
    public static int setMaxDiameter(TreeNode root) {        
        if (root == null) {
            return 0;
        }
        
        int leftMax = setMaxDiameter(root.left);
        int rightMax = setMaxDiameter(root.right);
        
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
        
        return Math.max(leftMax, rightMax) + 1;
    }
}
