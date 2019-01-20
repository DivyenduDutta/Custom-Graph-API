package com.divyendu.undirectedgraph.tasks.bfs.test;

import org.junit.Test;

import com.divyendu.undirectedgraph.UndirectedGraph;
import com.divyendu.undirectedgraph.tasks.bfs.BreadthFirstSearch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BreadthFirstSearchTest {

	public BreadthFirstSearch bfsClient = null;
	public UndirectedGraph udGraph = null;
	
	@Test
	public void getVisitedForVertex_positive() {
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
		
		bfsClient = new BreadthFirstSearch(udGraph, sourceVertex);
		for(int vertex = 0; vertex<udGraph.getNumberOfVerticesInUDGraph(); vertex++) {
			allVisited &= bfsClient.getVisitedForVertex(vertex);
		}
		
		assertTrue(allVisited);
	}
	
	@Test
	public void getVisitedForVertex_negative() {
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
		
		bfsClient = new BreadthFirstSearch(udGraph, sourceVertex);
		for(int vertex = 0; vertex<udGraph.getNumberOfVerticesInUDGraph(); vertex++) {
			allVisited &= bfsClient.getVisitedForVertex(vertex);
		}
		
		assertFalse(allVisited);
	}
	
	@Test
	public void shortestPath() {
		int numberOfVertices = 6;	//vertex 5 will not be visited
		int sourceVertex = 3;
		udGraph = new UndirectedGraph(numberOfVertices);
		
		udGraph.addEdge(0, 1);
		udGraph.addEdge(0, 2);
		udGraph.addEdge(0, 3);
		udGraph.addEdge(2, 4);
		udGraph.addEdge(3, 4);
		udGraph.addEdge(1, 2);
		
		bfsClient = new BreadthFirstSearch(udGraph, sourceVertex);
		int secondLast[] = bfsClient.getEdgeToArray();
		assertEquals(secondLast[1], 0);
	}
}
