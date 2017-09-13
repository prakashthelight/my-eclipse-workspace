package com.samples.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Path Sum II <br/>
 * https://leetcode.com/problems/path-sum-ii
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode113 {

	public static void main(String[] args) {
		TreeNode root = MyTreeUtil.createBinaryTree();

		MyTreeUtil.print(root);

		for (List<Integer> path : pathSum(root, 16)) {
			System.out.println(path);
		}
	}

	public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		return pathSum(root, 0, targetSum);
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum, int targetSum) {

		List<List<Integer>> paths = new ArrayList<>();

		if (root == null) {
			return paths;
		}

		if (root.left == null && root.right == null) {
			if (sum + root.value == targetSum) {
				List<Integer> path = new ArrayList<>();
				path.add(root.value);
				paths.add(path);
			}
		} else {
			List<List<Integer>> leftPaths = pathSum(root.left, sum + root.value, targetSum);
			List<List<Integer>> rightPaths = pathSum(root.right, sum + root.value, targetSum);

			for (List<Integer> path : leftPaths) {
				path.add(0, root.value);
			}

			for (List<Integer> path : rightPaths) {
				path.add(0, root.value);
			}

			paths.addAll(leftPaths);
			paths.addAll(rightPaths);
		}

		return paths;
	}

}
