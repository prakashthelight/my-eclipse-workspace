package com.samples.utils;

import java.util.ArrayList;
import java.util.Stack;

import com.samples.model.TreeNode;

public class BinarySearchTreeUtils {
	
	public static TreeNode createBST() {
		int [] array = new int[] {50, 30, 70, 20, 40, 60, 80};
		
		TreeNode root = new TreeNode(array[0]);
		
		for(int i = 1; i< array.length; i++) {
			addTreeNode(root, array[i]);
		}
		
		return root;
	}
	
	public static TreeNode createBST(int[] array) {
		TreeNode root = new TreeNode(array[0]);
		
		for (int i = 1; i < array.length; i++) {
			addTreeNode(root, array[i]);
		}
		
		return root;
	}
	
	
	public static int getHeight(TreeNode root) {
		if (root == null) return -1;
		
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));				
	}

	/**
	 * validate if binary tree is binary search tree
	 * @param root
	 * @return
	 */
	public static boolean isBinarySearchTree(TreeNode root) {
		if (root ==  null || (root.left == null && root.right == null))
			return true;
		
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
	}
	
	public static boolean isBinarySearchTree(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		
		if (root.value <= min || root.value >= max) {
			return false;
		}
		
		return isBinarySearchTree(root.left, min, root.value) 
				&& isBinarySearchTree(root.right, root.value, max);		
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
	
	/**
	 * find a element in binary search tree
	 * @param root
	 * @param key
	 * @return
	 */	
	public static TreeNode find(TreeNode root, int key) {
		
		if (root == null || root.value == key) {
			return root;
		}		
		
		// if key is less than root value
		if (key < root.value) {
			return find(root.left, key); // look in left subtree
		} else {
			return find (root.right, key); // look in right subtree
		}
	}
	
	
	/**
	 * delete give key node
	 * @param root
	 * @param key
	 * @return
	 */
	public static TreeNode deleteNode(TreeNode root, int key) {
		
		if (root == null) {
			return null;
		}
		
		if (key < root.value) {
			root.left = deleteNode(root.left, key);
			
		} else if (key > root.value) {
			root.right = deleteNode(root.right, key);
			
		} else {
			
			TreeNode temp = null;
			
			// if no left child, return right node;
			if (root.left == null) {
				temp = root.right;
				return temp;
			} else if (root.right == null) { // if no right node, return left node;
				temp = root.left;
				return temp;
			}
			
			// find min node from right subtree
			temp = minValueNode(root.right);			
			
			// assign value of that min node from right subtree to root node
			root.value = temp.value;
			
			// delete that min node from right subtree
			root.right = deleteNode(root.right, temp.value);
			
		}
		
		return root;
	}	
	
	public static TreeNode minValueNode(TreeNode root) {
		
		if (root == null) {			
			return root;
		}		
		
		TreeNode temp = root;
		while (temp.getLeft() != null) {
			temp = temp.getLeft();
		}
		
		return temp;		
	}
	
	
	/**
	 * in-order traversal for binary search tree 
	 * @param root
	 * @param nodeValues
	 */
	public static void inOrder(TreeNode root, ArrayList<Integer> nodeValues) {
		
		if (root == null) return;
		
		inOrder(root.left, nodeValues);
		nodeValues.add(root.value);
		inOrder(root.right, nodeValues);
	}
	
	/**
	 * pre-order traversal for binary search tree
	 * @param root
	 * @param nodeValues
	 */
	public static void preOrder(TreeNode root, ArrayList<Integer> nodeValues) {
		
		if (root == null) return;
		
		nodeValues.add(root.value);
		preOrder(root.left, nodeValues);		
		preOrder(root.right, nodeValues);
	}
	
	/**
	 * post-order traversal for binary search tree
	 * @param root
	 * @param nodeValues
	 */
	public static void postOrder(TreeNode root, ArrayList<Integer> nodeValues) {
		
		if (root == null) return;
		
		postOrder(root.left, nodeValues);
		postOrder(root.right, nodeValues);
		nodeValues.add(root.value);
	}
	
	
	/**
	 * in-order traversal - recursive
	 * @param root
	 * @param nodeValues
	 */
	public static void inOrderRecursive(TreeNode root, ArrayList<Integer> nodeValues) {
		
		if (root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root;
		
		while (!stack.isEmpty() || temp != null) {
			
			// keep going left, pushing root in stack
			if (temp != null) {
				stack.push(temp);
				temp = temp.getLeft();						
			} else {
				
				// pop root
				TreeNode item = stack.pop();				
				// process root
				nodeValues.add(item.getValue());				
				// go to right
				temp = item.getRight();
			}
		}
		
		return;
	}
	
	/**
	 * pre-order traversal - recursive	
	 * @param root
	 * @param nodeValues
	 */
	public static void preOrderRecursive(TreeNode root, ArrayList<Integer> nodeValues) {
		
		if (root == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		// push root
		stack.push(root);
		
		while (!stack.isEmpty()) {
			
			TreeNode node = stack.pop();			
			nodeValues.add(node.getValue());
			
			// if not null push right node
			if (node.getRight() != null) {
				stack.push(node.getRight());
			}
			
			// if not null, push left node
			if (node.getLeft() != null) {
				stack.push(node.getLeft());
			}
		}
		
		return;
	}
	
	/**
	 * post-order traversal - recursive
	 * @param root
	 * @param nodeValues
	 */
	public static void postOrderRecursive(TreeNode root, ArrayList<Integer> nodeValues) {
		
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		// push root
		stack1.push(root);
		
		while (!stack1.isEmpty()) {
			
			TreeNode node = stack1.pop();
			stack2.push(node);
			
			// if not null, push left node
			if (node.getLeft() != null) {
				stack1.push(node.getLeft());
			}
			
			// if not null push right node
			if (node.getRight() != null) {
				stack1.push(node.getRight());
			}
		}
		
		while(!stack2.isEmpty()) {
			nodeValues.add(stack2.pop().getValue());
		}	
		
		return;
	}
	
	/**
	 * create binary search tree from a sorted array
	 * @param sortedArray
	 * @return
	 */
	public static TreeNode createBSTFromSortedArray(int[] sortedArray) {
		return createBST(sortedArray, 0, sortedArray.length - 1);
	}

	/**
	 * create binary search tree from a sorted array
	 * @param sortedArray
	 * @param start
	 * @param end
	 * @return
	 */
	public static TreeNode createBST(int[] sortedArray, int start, int end) {
		if (start > end)
			return null;

		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(sortedArray[mid]);

		root.left = createBST(sortedArray, start, mid - 1);
		root.right = createBST(sortedArray, mid + 1, end);

		return root;
	}		
	
	/**
	 * serialize BST to ArrayList using pre-order traversal and saving -1 for null nodes
	 * @param root
	 * @param nodeValues
	 */
	public static void serialize(TreeNode root, ArrayList<Integer> nodeValues) {
		if (root == null) {
			nodeValues.add(-1);
			return;
		}
		
		nodeValues.add(root.value);
		serialize(root.left, nodeValues);
		serialize(root.right, nodeValues);		
	}
	
	/**
	 * de-serialize BST from a serialized BST list
	 * @param list
	 * @return
	 */
	public static TreeNode deSerialize(ArrayList<Integer> list) {
		list.add(0, 1); // just storing index to be referenced
		return deSerializeBST(list);
	}
	
	public static TreeNode deSerializeBST(ArrayList<Integer> list) {
		int index = list.get(0);
		
		if (index > list.size() || list.get(index) == -1) {
			list.set(0, ++index);
			return null;
		}
		
		TreeNode root = new TreeNode(list.get(index));
		list.set(0, ++index);
		
		root.left = deSerializeBST(list);
		root.right = deSerializeBST(list);	
		
		return root;
	}	
	
}
