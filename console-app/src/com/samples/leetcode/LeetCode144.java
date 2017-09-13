package com.samples.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Binary Tree Preorder Traversal <br/>
 * https://leetcode.com/problems/binary-tree-preorder-traversal
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode144 {

	public static void main(String[] args) {
		TreeNode root = MyTreeUtil.createBinaryTree();

		MyTreeUtil.print(root);
		System.out.println(preorderTraversal(root));
	}

	/**
	 * pre-order traversal of binary tree
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();

		if (root == null) {
			return list;
		}

		// initalize stack and push head into stack to start with
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();

			list.add(temp.value);

			// push right node if not null
			if (temp.right != null) {
				stack.push(temp.right);
			}

			// push left node if not null
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}

		return list;
	}

}
