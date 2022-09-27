package com.samples.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * 102. Binary Tree Level Order Traversal <br/>
 * https://leetcode.com/problems/binary-tree-level-order-traversal
 * 
 * @author Kumar, Prakash
 * @category Tree, Breadth-First Search, Binary Tree
 *
 */
public class LeetCode102 {

	public static void main(String[] args) {
		TreeNode root = MyTreeUtil.createBinaryTree();
		
		MyTreeUtil.print(root);
		
		// level order traversal
		for (List<Integer> level : levelOrder(root)) {
			System.out.println(level);
		}
	}

	/**
	 * level order traversal, using one queue
	 * 
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);

		int i = 0;
		int n = q.size();
		List<Integer> level = new ArrayList<>();

		while (i < n) {
			TreeNode temp = q.poll();
			level.add(temp.value);

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
			}
		}

		return result;
	}

	/**
	 * level order traversal using two queues
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder1(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		// using two queues keeping next level of TreeNodes alternately
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();

		q1.offer(root); // push root in one of the queue

		// interate if either of queue is not empty

		while (!q1.isEmpty() || !q2.isEmpty()) {
			List<Integer> level = new ArrayList<>();

			// empty first queue and store all next level TreeNodes in second
			while (!q1.isEmpty()) {
				TreeNode temp = q1.poll();
				level.add(temp.value);

				if (temp.left != null) {
					q2.offer(temp.left);
				}

				if (temp.right != null) {
					q2.offer(temp.right);
				}
			}

			if (level.size() > 0) {
				result.add(level);
			}

			// reset new list for next level of nodes
			level = new ArrayList<>();

			// empty first queue and store all next level TreeNodes in second
			while (!q2.isEmpty()) {
				TreeNode temp = q2.poll();
				level.add(temp.value);

				if (temp.left != null) {
					q1.offer(temp.left);
				}

				if (temp.right != null) {
					q1.offer(temp.right);
				}
			}

			if (level.size() > 0) {
				result.add(level);
			}
		}

		return result;
	}
}
