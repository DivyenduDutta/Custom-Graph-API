package com.divyendu.undirectedgraph.tasks.test;

import org.junit.Test;

import com.divyendu.undirectedgraph.UndirectedGraph;
import com.divyendu.undirectedgraph.tasks.DepthFirstSearchPaths;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DepthFirstSearchPathsTest {
	
	public UndirectedGraph udGraph = null;
	public DepthFirstSearchPaths dfsRunner = null;
	
	@Test
	public void pathTotest_positive() {
		int numberOfVertices = 5;
		int sourceVertex = 0;
		int destinationVertex = 4;
		udGraph = new UndirectedGraph(numberOfVertices);
		
		udGraph.addEdge(0, 1);
		udGraph.addEdge(0, 2);
		udGraph.addEdge(0, 3);
		udGraph.addEdge(2, 4);
		udGraph.addEdge(3, 4);
		udGraph.addEdge(1, 2);
		
		dfsRunner = new DepthFirstSearchPaths(udGraph, sourceVertex);
		List<Integer> expectedArrayList = new ArrayList<Integer>();
		expectedArrayList.add(1);
		expectedArrayList.add(2);
		List<Integer> actualArrayList = dfsRunner.pathTo(destinationVertex);
		assertEquals(actualArrayList, expectedArrayList);
		
	}
	
	@Test
	public void pathTotest_no_path() {
		int numberOfVertices = 5;
		int sourceVertex = 0;
		int destinationVertex = 4;
		udGraph = new UndirectedGraph(numberOfVertices);
		
		//no path between 0 and 4 
		udGraph.addEdge(0, 1);
		udGraph.addEdge(0, 2);
		udGraph.addEdge(0, 3);
		udGraph.addEdge(1, 2);
		
		dfsRunner = new DepthFirstSearchPaths(udGraph, sourceVertex);

		List<Integer> actualArrayList = dfsRunner.pathTo(destinationVertex);
		assertEquals(actualArrayList.size(), 0);
		
	}

}
