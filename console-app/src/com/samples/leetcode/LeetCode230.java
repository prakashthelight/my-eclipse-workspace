package com.samples.leetcode;

import java.util.ArrayList;
import java.util.Stack;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Kth Smallest Element in a BST <br/>
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode230 {

	public static void main(String[] args) {
		TreeNode root = MyTreeUtil.createBST();
		MyTreeUtil.print(root);

		System.out.println(kthSmallest(root, 3));
	}

	/**
	 * returns kth smallest item from a BST
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public static int kthSmallest(TreeNode root, int k) {

		if (root == null) {
			return -1;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();

		// just do an inorder traversal, and stop when kth item is traversed
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root;

		while (!stack.isEmpty() || temp != null) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				TreeNode item = stack.pop();
				list.add(item.value);
				temp = item.right;
			}

			if (list.size() == k) {
				return list.get(list.size() - 1);
			}
		}

		return -1;
	}
}
