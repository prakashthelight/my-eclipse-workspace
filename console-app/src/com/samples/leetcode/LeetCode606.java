package com.samples.leetcode;

import com.samples.model.TreeNode;

/**
 * Construct String from Binary Tree
 * https://leetcode.com/problems/construct-string-from-binary-tree
 * @author Kumar, Prakash
 *
 */
public class LeetCode606 {
	
	public static void main(String[] args) {
		
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		
		head.left.left = new TreeNode(4);
		
		System.out.println(tree2str(head));
		
	}
	
	/**
	 * returns a pattern string of preorder traversal of tree
	 * @param t
	 * @return
	 */
	public static String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }   
        
        StringBuilder sb = new StringBuilder();
        sb.append(t.value);
        
        
        if (t.left != null) {
            sb.append("(");   
            sb.append(tree2str(t.left));
            sb.append(")");
        } else {
            if (t.right != null)  {
                sb.append("()");                
            }
        }
        
        if (t.right != null) {
            sb.append("(");   
            sb.append(tree2str(t.right));
            sb.append(")");
        }
        
        return sb.toString();
    }

}
