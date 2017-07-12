package com.samples.model;

public class GraphNode {

	public int value;

	public GraphNode next;

	public GraphNode[] neighbors;

	public boolean visited;

	public GraphNode(int value) {
		this.value = value;
	}

	public GraphNode(int value, GraphNode[] neighbors) {
		this.value = value;
		this.neighbors = neighbors;
	}
}
