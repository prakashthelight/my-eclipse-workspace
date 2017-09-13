package com.samples.leetcode;

/**
 * Friend Circles <br/>
 * https://leetcode.com/problems/friend-circles
 * 
 * @author Kumar, Prakash
 *
 */
public class LeetCode547 {

	public static void main(String[] args) {
		int[][] friendShipMatrix = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		int friendCircles = findCircleNum(friendShipMatrix);

		System.out.println("Friend Circles: " + friendCircles);
	}

	/**
	 * returns number of friend circles - including direct and indirect friends
	 * 
	 * @param M
	 * @return
	 */
	public static int findCircleNum(int[][] M) {
		int[] visited = new int[M.length];
		int count = 0;
		for (int i = 0; i < M.length; i++) {
			if (visited[i] == 0) {
				count++;
				visitDFS(M, visited, i);
			}
		}

		return count;
	}

	/**
	 * recurisively mark other friends in this circle as visited
	 * 
	 * @param M
	 * @param visited
	 * @param i
	 */
	public static void visitDFS(int[][] M, int[] visited, int i) {
		for (int j = 0; j < M.length; j++) {
			if (i != j && M[i][j] == 1 && visited[j] == 0) {
				visited[j] = 1;
				visitDFS(M, visited, j);
			}
		}
	}
}
