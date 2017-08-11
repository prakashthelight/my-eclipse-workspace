package com.samples.leetcode;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree
 * @author Kumar, Prakash
 *
 */
public class LeetCode226 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		root.right.right = new TreeNode(40);
		
		MyTreeUtil.print(root);
		invertTree(root);	
		MyTreeUtil.print(root);
	}
	
	/**
	 * returns root after inverting tree i.e. swap left node with right node;
	 * @param root
	 * @return
	 */
	public static TreeNode invertTree(TreeNode root) {
        if (root == null)  {
            return null;
        }
        
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        
        return root;
    }
}
