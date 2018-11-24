package com.divyendu.undirectedgraph.tasks;

import com.divyendu.undirectedgraph.UndirectedGraph;

import java.util.List;

/** 
 * This class provides search functionality for the Undirected Graph via the DFS technique
 * 
 * @author divyendu
 * */
public class DepthFirstSearch {
	private boolean[] visited;
	private int count = 1;		//initialize count to 1, since we are not inc count for source but for its adj vertices
	
	/** 
	 * This method is used by the parameterized constructor to recursively implement DFS
	 * Core DFS logic is here
	 * [Complexity] is proportional to sum of degree of vertices which are connected to source. 
	 * Sum of degrees = 2* Total number of edges in an undirected graph
	 * 
	 * @param udGraph the graph to be considered
	 * @param source the source vertex to start the DFS traversal
	 **/
	private void dfs(UndirectedGraph udGraph, int source) {
		if(getTotalVerticesVisited() == udGraph.getNumberOfVerticesInUDGraph()) {
			//for debugging purposes: can remove when in use
			System.out.println("All vertices visited in graph!!");
		}
		else {
			assert udGraph.validateEdgeVertices(source) : "Check the adjacent vertices list of "+source;
			List<Integer> adjacentVertices = udGraph.getAdjacentVertices(source);
			visited[source] = true;	//mark source as visited
			//mark visited to true for all adjacent vertices to source
			for(int adjVertex : adjacentVertices) {
				//only recursively move through an adjacent vertex if its not been visited
				if(!visited[adjVertex]) {
					visited[adjVertex] = true;
					count += 1;
					dfs(udGraph, adjVertex);
				}
			}
		}
	}
	
	/** 
	 * Parameterized constructor which takes the Graph and source node as arguments
	 * This uses a recursive technique to implement DFS and find out which vertices can be visited from the source vertex
	 * Works because default boolean value in Java is false, so no need to initialize visited[] to false
	 * Initializes visited[] and count
	 * 
	 * @param udGraph the graph to be considered
	 * @param source the source vertex to start the DFS traversal
	 * */
	public DepthFirstSearch(UndirectedGraph udGraph, int source) {
		if(udGraph != null) {
			visited = new boolean[udGraph.getNumberOfVerticesInUDGraph()];	//allocate memory for the visited array
			if(!udGraph.validateEdgeVertices(source)) {
				System.out.println("Please provide proper integer value for source vertex(within 0 to V-1)");
				System.out.println("Setting source vertex to 0");
				source = 0;
			}
			dfs(udGraph, source);
		}
	}
	
	/** 
	 * This method uses the visited[] to determine if the vertex has been visited in the graph or not
	 * 
	 * @param vertex the vertex of the graph to determine if its been visited or not
	 * @return result a boolean value representing whether the vertex has been visited or not
	 * */
	public boolean getVisitedForVertex(int vertex) {
		boolean result = false;
		try {
			result = visited[vertex];
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Please provide proper value of the vertex which you want to know is vivited or not!!");
			System.out.println("Since you provided wrong value, this will return visited information of vertex 0");
			vertex = 0;
			result = visited[vertex];
		}
		return result;
	}
	
	/** 
	 * This method returns the count variable which specifies the total number of vertices visited in the graph via DFS
	 * 
	 * @return count the total number of vertices visited in the graph
	 * */
	public int getTotalVerticesVisited() {
		return count;
	}
}
