package com.divyendu.undirectedgraph.tasks.test;

import com.divyendu.undirectedgraph.UndirectedGraph;
import com.divyendu.undirectedgraph.tasks.DepthFirstSearch;
import com.divyendu.undirectedgraph.tasks.bfs.BreadthFirstSearch;
import com.divyendu.undirectedgraph.tasks.paths.SearchPaths;

import java.util.List;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SearchPathsTest {

	public UndirectedGraph udGraph = null;
	public SearchPaths searchPathClient = null;
	
	@Test
	public void pathTotest_positive_DFS() {
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
		
		searchPathClient = new SearchPaths(udGraph, sourceVertex,DepthFirstSearch.class);
		List<Integer> expectedArrayList = new ArrayList<Integer>();
		expectedArrayList.add(1);
		expectedArrayList.add(2);
		List<Integer> actualArrayList = searchPathClient.pathTo(destinationVertex);
		assertEquals(actualArrayList, expectedArrayList);
		
	}
	
	@Test
	public void pathTotest_no_path_DFS() {
		int numberOfVertices = 5;
		int sourceVertex = 0;
		int destinationVertex = 4;
		udGraph = new UndirectedGraph(numberOfVertices);
		
		//no path between 0 and 4 
		udGraph.addEdge(0, 1);
		udGraph.addEdge(0, 2);
		udGraph.addEdge(0, 3);
		udGraph.addEdge(1, 2);
		
		searchPathClient = new SearchPaths(udGraph, sourceVertex,DepthFirstSearch.class);

		List<Integer> actualArrayList = searchPathClient.pathTo(destinationVertex);
		assertEquals(actualArrayList.size(), 0);
		
	}
	
	@Test
	public void pathTotest_positive_BFS() {
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
		
		searchPathClient = new SearchPaths(udGraph, sourceVertex,BreadthFirstSearch.class);
		List<Integer> expectedArrayList = new ArrayList<Integer>();
		expectedArrayList.add(2);
		List<Integer> actualArrayList = searchPathClient.pathTo(destinationVertex);
		assertEquals(actualArrayList, expectedArrayList);
		
	}
	
	@Test
	public void pathTotest_no_path_BFS() {
		int numberOfVertices = 5;
		int sourceVertex = 0;
		int destinationVertex = 4;
		udGraph = new UndirectedGraph(numberOfVertices);
		
		//no path between 0 and 4 
		udGraph.addEdge(0, 1);
		udGraph.addEdge(0, 2);
		udGraph.addEdge(0, 3);
		udGraph.addEdge(1, 2);
		
		searchPathClient = new SearchPaths(udGraph, sourceVertex,BreadthFirstSearch.class);

		List<Integer> actualArrayList = searchPathClient.pathTo(destinationVertex);
		assertEquals(actualArrayList.size(), 0);
		
	}
}
