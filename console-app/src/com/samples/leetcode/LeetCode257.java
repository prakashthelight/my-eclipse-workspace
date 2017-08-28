package com.samples.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths
 * @author Kumar, Prakash
 *
 */
public class LeetCode257 {

	public static void main(String[] args) {
		TreeNode root = MyTreeUtil.generateSampleBTree();
		
		MyTreeUtil.print(root);
		
		System.out.println(binaryTreePaths(root));
	}

	/**
	 * return all paths from root node to leaf nodes;
	 * @param root
	 * @return
	 */
	public static List<String> binaryTreePaths(TreeNode root) {

		List<String> paths = new ArrayList<>();

		// if root is null return empty list;
		if (root == null) {
			return paths;
		}

		// if this is leaf node; retun paths with just this node;
		if (root.left == null && root.right == null) {
			paths.add(String.valueOf(root.value));
		} else {

			// if left child is not null, get paths from left chile and append
			// with root.value to make new paths from this node;
			if (root.left != null) {
				List<String> leftPaths = binaryTreePaths(root.left);
				for (String path : leftPaths) {
					paths.add(String.valueOf(root.value) + "->" + path);
				}
			}

			// if right child is not null, get paths from right child and append
			// with root.val to make new paths from this node;
			if (root.right != null) {
				List<String> rightPaths = binaryTreePaths(root.right);
				for (String path : rightPaths) {
					paths.add(String.valueOf(root.value) + "->" + path);
				}
			}
		}

		return paths;
	}

}
