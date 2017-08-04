package com.samples.leetcode;

import com.samples.ds.utils.MyTreeUtil;
import com.samples.model.TreeNode;

/**
 * Same Tree
 * https://leetcode.com/problems/same-tree
 * @author Kumar, Prakash
 *
 */
public class LeetCode100 {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] array1 = new int[] { 1, 2, 3, 4, 10, 6, 7, 8, 9 };
		TreeNode p = MyTreeUtil.generateSampleBTree(array);
		TreeNode q = MyTreeUtil.generateSampleBTree(array1);		
		System.out.println(isSameTree(p, q));
	}
	
	/**
	 * returns true if given binary trees are same - same structure and node values;
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        
        if (p == null && q == null) {
            return true;	
        }
        
        if (p == null || q == null) {
            return false;
        }
        
        if (p.value != q.value) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
