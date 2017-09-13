package com.samples.ds.utils;

import java.util.Stack;

import com.samples.model.TreeNode;

public class MyTreeUtil {

	public static TreeNode createBinaryTree(int[] array) {		

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
	
	public static TreeNode createBinaryTree () {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		return createBinaryTree(array);
	}
	
	public static TreeNode createBST(int[] array) {
		TreeNode root = new TreeNode(array[0]);
		
		for (int i = 1; i < array.length; i++) {
			addTreeNode(root, array[i]);
		}
		
		return root;
	}
	
	public static TreeNode addTreeNode(TreeNode root, int key) {
		
		if (root == null) {			
			root = new TreeNode(key);
			return root;
		}
		
		if (key < root.value) {
			root.left = addTreeNode(root.left, key);
		} else {
			root.right = addTreeNode(root.right, key);
		}
		
		return root;
	}
	
	public static TreeNode createBST() {
		int [] array = new int[] {50, 30, 70, 20, 40, 60, 80};
		
		TreeNode root = new TreeNode(array[0]);
		
		for(int i = 1; i< array.length; i++) {
			addTreeNode(root, array[i]);
		}
		
		return root;
	}

	public static TreeNode createNode(int num) {
		return new TreeNode(num);
	}
	
	
	public static void print(TreeNode root) {
		StringBuilder sb = new StringBuilder();		
				
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if (root != null) {
			stack.push(root);
		}
		
		sb.append("[");
		
		TreeNode top = stack.peek();
		
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			if (temp != top) {
				sb.append(", ");
			}
			sb.append(temp.value);
			
			if (temp.right != null) {
				stack.push(temp.right);
			}
			
			if (temp.left != null) {
				stack.push(temp.left);
			} else {
				if (temp.right != null) {					
					sb.append(", null");
				}
			}
		}
		
		sb.append("]");
		
		System.out.println(sb.toString());
	}
}
