package com.samples.model;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	private int vertices;	
	
	private List<LinkedList<Integer>> adjacencyList;
	
	public Graph(int vertices) {
		
		this.vertices = vertices;
		
		this.adjacencyList = new LinkedList<>();
		
		for (int i = 0; i < this.vertices; i++) {
			this.adjacencyList.add(new LinkedList<Integer>());
		}
	}
}
