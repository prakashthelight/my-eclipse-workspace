package com.samples.utils;

public class BinaryTreeUtils {
	
	public static TreeNode generateSampleBTree() {
		
		int[]  array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
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
	
	
	public static TreeNode createNode(int num) {
		return new TreeNode(num);
	}
	
	public static void traverseByLevel(TreeNode root) {
		
	}
	
	public static void inOrder(TreeNode root) {
		if (root == null) return;
		
		inOrder(root.left);
		System.out.print(root.value + " ");
		inOrder(root.right);
	}
	
	public static TreeNode findLeastCommonAncestor(TreeNode root, int num1, int num2) {
		if (root == null) return null;
		
		if (root.value == num1 || root.value == num2) {
			return root;
		} else {
			
			boolean leftNum1 = find(root.left, num1);
			boolean rightNum1 = find(root.right, num1);
			
			boolean leftNum2 = find(root.left, num2);
			boolean rightNum2 = find(root.right, num2);
			
			if ((leftNum1 && rightNum2) || (leftNum2 && rightNum1)) {
				return root;
			} else if (leftNum1 && leftNum2) {
				return findLeastCommonAncestor(root.left, num1, num2);
			}  else if (rightNum1 && rightNum2) {
				return findLeastCommonAncestor(root.right, num1, num2);						
			}
		}
		
		return null;
	}
	
	public static boolean find(TreeNode root, int num) {
		if (root == null) return false;		
		if (root.value == num) return true;		
		return find(root.left, num) || find(root.right, num);
	}
}
