package com.samples.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Binary Tree Zigzag Level Order Traversal <br/>
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode103 {

	public static void main(String[] args) {
		TreeNode root = MyTreeUtil.createBinaryTree();

		MyTreeUtil.print(root);

		for (List<Integer> level : zigzagLevelOrder(root)) {
			System.out.println(level);
		}
	}

	/**
	 * level order traversal with alternate direction at each level
	 * 
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);

		int i = 0;
		int n = q.size();
		List<Integer> level = new ArrayList<>();

		boolean leftToRight = true;

		while (i < n) {
			TreeNode temp = q.poll();

			if (leftToRight) {
				level.add(temp.value);
			} else {
				level.add(0, temp.value);
			}

			if (temp.left != null) {
				q.offer(temp.left);
			}

			if (temp.right != null) {
				q.offer(temp.right);
			}

			i++;

			if (i == n) {
				result.add(level);
				level = new ArrayList<>();
				i = 0;
				n = q.size();
				leftToRight = !leftToRight;
			}
		}

		return result;
	}
}
