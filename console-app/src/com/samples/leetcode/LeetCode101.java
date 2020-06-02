package com.samples.leetcode;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode101 {

	public static void main(String[] args) {
		TreeNode root = MyTreeUtil.createBinaryTree();
		
		System.out.println(isSymmetric(root));

	}
	
	public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }
	
	public static boolean isSymmetric(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        
        if (r1 == null || r2 == null) {
            return false;
        }
        
        return r1.value == r2.value && isSymmetric(r1.left, r2.right) && isSymmetric(r1.right, r2.left);
    }
}
