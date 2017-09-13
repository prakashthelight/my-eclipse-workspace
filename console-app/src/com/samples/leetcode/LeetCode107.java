package com.samples.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Binary Tree Level Order Traversal II <br/>
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode107 {

	public static void main(String[] args) {
		TreeNode root = MyTreeUtil.createBinaryTree();

		List<List<Integer>> levelOrder = levelOrderBottom(root);

		for (List<Integer> level : levelOrder) {
			System.out.println(level);
		}
	}

	/**
	 * returns list of items grouped for level order from bottom
	 * 
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();

		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int prevCount = 1;

		while (!queue.isEmpty()) {
			int tempCount = prevCount;
			int count = 0;

			List<Integer> list = new ArrayList<>();

			while (tempCount > 0) {
				TreeNode temp = queue.poll();
				list.add(temp.value);

				if (temp.left != null) {
					queue.offer(temp.left);
					count++;
				}

				if (temp.right != null) {
					queue.offer(temp.right);
					count++;
				}

				tempCount--;
				prevCount = count;
			}

			result.add(list);
		}

		Collections.reverse(result);

		return result;
	}

}
