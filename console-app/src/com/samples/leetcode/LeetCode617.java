package com.samples.leetcode;

import java.util.Stack;

import com.samples.model.TreeNode;

/**
 * Merge Two Binary Trees
 * https://leetcode.com/problems/merge-two-binary-trees
 * @author kumarpr
 *
 */
public class LeetCode617 {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.right = new TreeNode(2);	
		t1.left.left = new TreeNode(5);
		
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(3);	
		t2.left.right = new TreeNode(4);		
		t2.right.right = new TreeNode(7);
		
		t1 = mergeTrees(t1, t2);
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(t1);
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();			
			System.out.print(node.value + " ");		
			
			if (node.right != null) {
				stack.push(node.right);
			}
			
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}
	
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        if (t1 == null && t2 == null) return null;        
        if (t1 == null && t2 != null) return t2;
        if (t2 == null && t1 != null) return t1;       
        
        // if both nodes are not null - add values
        if (t1 != null && t2 != null) {
            t1.value += t2.value;
        }       
        
        if (t1.left == null) {
            t1.left = t2.left;
        } else if (t2.left != null) {
            t1.left = mergeTrees(t1.left, t2.left);
        }
        
        if (t1.right == null) {
            t1.right = t2.right;
        } else if (t2.right != null) {
            t2.right = mergeTrees(t1.right, t2.right);
        }
        
        return t1;
    }

}
