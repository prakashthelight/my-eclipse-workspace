package com.samples.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.samples.model.GraphNode;

public class GraphUtils {
	
	public static GraphNode setVertices(int[] vertices) {
		
		GraphNode[] vert = new GraphNode[vertices.length];
		
		GraphNode n1 = new GraphNode(vertices[0]);
		GraphNode n2 = new GraphNode(vertices[1]);
		GraphNode n3 = new GraphNode(vertices[2]);
		GraphNode n4 = new GraphNode(vertices[3]);
		GraphNode n5 = new GraphNode(vertices[4]);
		GraphNode n6 = new GraphNode(vertices[5]);

		// non-directed graph
		n1.neighbors = new GraphNode[] { n2, n3, n5 };
		n2.neighbors = new GraphNode[] { n1, n4 };
		n3.neighbors = new GraphNode[] { n1, n4, n5 };
		n4.neighbors = new GraphNode[] { n2, n3, n5 };
		n5.neighbors = new GraphNode[] { n1, n3, n4 };
		
		vert[0] = n1;
		vert[1] = n2;
		vert[2] = n3;
		vert[3] = n4;
		vert[4] = n5;	
		vert[5] = n6;
		
		return n1;
	}
	
	public static void breadthFirstSearch(GraphNode root) {

		if (root == null)
			return;

		Queue<GraphNode> q = new LinkedList<GraphNode>();
		root.visited = true;
		q.offer(root);

		while (!q.isEmpty()) {
			GraphNode node = q.poll();
			System.out.print(node.value + "  ");

			for (GraphNode neighbor : node.neighbors) {
				if (neighbor.visited == false) {
					neighbor.visited = true;
					q.offer(neighbor);
				}
			}
		}
	}

	public static void depthFirstSearch(GraphNode root) {
		if (root == null)
			return;

		Stack<GraphNode> q = new Stack<>();
		root.visited = true;
		q.push(root);

		while (!q.isEmpty()) {
			GraphNode node = q.pop();
			System.out.print(node.value + "  ");

			for (GraphNode neighbor : node.neighbors) {
				if (neighbor.visited == false) {
					neighbor.visited = true;
					q.push(neighbor);
				}
			}
		}
	}
}
