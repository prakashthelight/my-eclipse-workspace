package com.samples.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.samples.model.TreeNode;

/**
 * Average of Levels in Binary Tree <br/>
 * https://leetcode.com/problems/average-of-levels-in-binary-tree
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode637 {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);

		root.left = new TreeNode(9);
		root.right = new TreeNode(20);

		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		List<Double> avgs = averageOfLevels(root);

		for (Double avg : avgs) {
			System.out.print(avg + " ");
		}
	}

	/**
	 * returns average of each level nodes
	 * 
	 * @param root
	 * @return
	 */

	public static List<Double> averageOfLevels(TreeNode root) {

		List<Double> avgs = new ArrayList<Double>();

		if (root == null)
			return avgs;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int prevCount = 1;

		while (!queue.isEmpty()) {
			int tempCount = prevCount;

			// count same level childs while adding and set it as prevCount
			// later to be used in next iteration
			int count = 0;

			// take it as long for avoiding overflow
			// just iterate till prevCount i.e. tempCount
			long sum = 0;

			while (tempCount > 0) {
				TreeNode temp = queue.poll();

				// push left child
				if (temp.left != null) {
					queue.offer(temp.left);
					count++;
				}

				// push right child
				if (temp.right != null) {
					queue.offer(temp.right);
					count++;
				}

				sum += temp.value;
				tempCount--;
			}

			avgs.add(sum / (double) prevCount);
			prevCount = count;
		}

		return avgs;
	}

}
