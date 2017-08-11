package com.samples.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal
 * @author Kumar, Prakash
 *
 */
public class LeetCode094 {

	public static void main(String[] args) {
		TreeNode root = MyTreeUtil.createBST();		
		MyTreeUtil.print(root);
		
		List<Integer> items = inorderTraversal(root);
		
		System.out.println(items.toString());

	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {        
        List<Integer> list = new ArrayList<Integer>();
        
        if (root == null) return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();        
        TreeNode temp = root;
        
        while (!stack.isEmpty() || temp != null) {
            
            // keep moving left;
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                // traverse item and go to right
                TreeNode item = stack.pop();
                list.add(item.value);
                temp = item.right;
            }
        }
        
        return list;        
    }
}
