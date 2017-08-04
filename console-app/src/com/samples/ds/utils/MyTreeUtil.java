package com.samples.ds.utils;

import com.samples.model.TreeNode;

public class MyTreeUtil {

	public static TreeNode generateSampleBTree(int[] array) {		

		int i = 0;

		TreeNode root = new TreeNode(array[i++]);

		root.left = createNode(array[i++]);
		root.right = createNode(array[i++]);

		root.left.left = createNode(array[i++]);
		root.left.right = createNode(array[i++]);

		root.right.left = createNode(array[i++]);
		root.right.right = createNode(array[i++]);

		root.left.left.left = createNode(array[i++]);
		root.left.left.right = createNode(array[i++]);

		return root;
	}
	
	public static TreeNode generateSampleBTree () {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		return generateSampleBTree(array);
	}

	public static TreeNode createNode(int num) {
		return new TreeNode(num);
	}
}
