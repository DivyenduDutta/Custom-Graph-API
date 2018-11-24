package com.divyendu.undirectedgraph;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;


public class UndirectedGraphTest {
	
	public UndirectedGraph udGraph = null;
	
	@Test
	public void addEdgeTest01() {
		int numberOfVertices = 5;
		boolean result = true;
		udGraph = new UndirectedGraph(numberOfVertices);
		
		result &= udGraph.addEdge(0, 1);
		result &= udGraph.addEdge(0, 2);
		result &= udGraph.addEdge(0, 3);
		result &= udGraph.addEdge(2, 4);
		result &= udGraph.addEdge(3, 4);
		result &= udGraph.addEdge(1, 2);
		
		assertTrue(result);
		
	}
	
	@Test
	public void addEdgeTest_vertices() {
		int numberOfVertices = 5;
		udGraph = new UndirectedGraph(numberOfVertices);
		
		udGraph.addEdge(0, 1);
		udGraph.addEdge(0, 2);
		udGraph.addEdge(0, 3);
		udGraph.addEdge(2, 4);
		udGraph.addEdge(3, 4);
		udGraph.addEdge(1, 2);
		
		assertEquals(numberOfVertices, udGraph.getNumberOfVerticesInUDGraph());
		
	}
	
	@Test
	public void addEdgeTest_edges() {
		int numberOfVertices = 5;
		int numberOfEdges = 6;
		udGraph = new UndirectedGraph(numberOfVertices);
		
		udGraph.addEdge(0, 1);
		udGraph.addEdge(0, 2);
		udGraph.addEdge(0, 3);
		udGraph.addEdge(2, 4);
		udGraph.addEdge(3, 4);
		udGraph.addEdge(1, 2);
		
		assertEquals(numberOfEdges, udGraph.getNumberEdgesInUDGraph());
		
	}
	
	@Test
	public void getAdjacentVerticesTest() {
		int numberOfVertices = 5;
		int numberOfAdjacentVerticesExpected = 3;
		udGraph = new UndirectedGraph(numberOfVertices);
		
		udGraph.addEdge(0, 1);
		udGraph.addEdge(0, 2);
		udGraph.addEdge(0, 3);
		udGraph.addEdge(2, 4);
		udGraph.addEdge(3, 4);
		udGraph.addEdge(1, 2);
		
		int numberOfAdjacentVerticesActual = udGraph.getAdjacentVertices(0).size();
		assertEquals(numberOfAdjacentVerticesExpected, numberOfAdjacentVerticesActual);
		
	}

}
