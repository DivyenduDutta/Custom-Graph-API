package com.divyendu.undirectedgraph.tasks.test;

import org.junit.Test;

import com.divyendu.undirectedgraph.UndirectedGraph;
import com.divyendu.undirectedgraph.tasks.DepthFirstSearch;

import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;

public class DepthFirstSearchTest {
	
	public DepthFirstSearch dfsClient = null;
	public UndirectedGraph udGraph = null;
	
	@Test
	public void getVisitedForVertexTest_positive() {
		int numberOfVertices = 5;
		int sourceVertex = 3;
		boolean allVisited = true;
		udGraph = new UndirectedGraph(numberOfVertices);
		
		udGraph.addEdge(0, 1);
		udGraph.addEdge(0, 2);
		udGraph.addEdge(0, 3);
		udGraph.addEdge(2, 4);
		udGraph.addEdge(3, 4);
		udGraph.addEdge(1, 2);
		
		dfsClient = new DepthFirstSearch(udGraph, sourceVertex);
		for(int vertex = 0; vertex<udGraph.getNumberOfVerticesInUDGraph(); vertex++) {
			allVisited &= dfsClient.getVisitedForVertex(vertex);
		}
		
		assertTrue(allVisited);
	}
	
	@Test
	public void getVisitedForVertexTest_negative() {
		int numberOfVertices = 6;	//vertex 5 will not be visited
		int sourceVertex = 3;
		boolean allVisited = true;
		udGraph = new UndirectedGraph(numberOfVertices);
		
		udGraph.addEdge(0, 1);
		udGraph.addEdge(0, 2);
		udGraph.addEdge(0, 3);
		udGraph.addEdge(2, 4);
		udGraph.addEdge(3, 4);
		udGraph.addEdge(1, 2);
		
		dfsClient = new DepthFirstSearch(udGraph, sourceVertex);
		for(int vertex = 0; vertex<udGraph.getNumberOfVerticesInUDGraph(); vertex++) {
			allVisited &= dfsClient.getVisitedForVertex(vertex);
		}
		
		assertFalse(allVisited);
	}
}
