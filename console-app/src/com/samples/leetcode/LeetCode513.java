package com.samples.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.samples.model.TreeNode;

/**
 * Find Bottom Left Tree Value <br/>
 * https://leetcode.com/problems/find-bottom-left-tree-value
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode513 {

	public static void main(String[] args) {
		// create sample tree
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);

		// the left most item in last level of tree
		root.left.left = new TreeNode(4);

		System.out.println(findBottomLeftValue(root));
	}

	/**
	 * find left most item in the last level of the tree
	 * 
	 * @param root
	 * @return
	 */
	public static int findBottomLeftValue(TreeNode root) {

		// stack to keep left most from all levels;
		Stack<Integer> stack = new Stack<Integer>();

		// Queue for level order traversal;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		if (root == null) {
			return -1;
		}

		queue.offer(root);

		while (!queue.isEmpty()) {
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				TreeNode temp = queue.poll();

				if (i == 0) {
					stack.push(temp.value);
				}

				if (temp.left != null) {
					queue.offer(temp.left);
				}

				if (temp.right != null) {
					queue.offer(temp.right);
				}
			}
		}

		return stack.peek();
	}
}
