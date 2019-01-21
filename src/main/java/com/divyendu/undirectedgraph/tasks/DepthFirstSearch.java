package com.divyendu.undirectedgraph.tasks;

import java.util.List;

import com.divyendu.undirectedgraph.UndirectedGraph;
import com.divyendu.undirectedgraph.tasks.iframes.SearchInterface;

/** 
 * This class provides search functionality for the Undirected Graph via the DFS technique
 * 
 * @author divyendu
 * */
public class DepthFirstSearch implements SearchInterface{
	private boolean[] visited;
	private int count = 1;		//initialize count to 1, since we are not inc count for source but for its adj vertices
	
	/*The edgeTo[] stores the second last vertex on the path from source to destination.
	* The destination here are the indexes of the edgeTo[]
	* If the value of any entry is -1 then there is no path between source and that vertex; also means that the 
	* corresponding entry in visited[] will be false
	*/
	private int[] edgeTo;
	
	//Have this for vertex range validation purposes
	private int maxSize; 
	
	private int source;
	
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
			assert source >=0 && source <= (maxSize-1) : source+" seems to be out of vertex range in graph";
			List<Integer> adjacentVertices = udGraph.getAdjacentVertices(source);
			visited[source] = true;	//mark source as visited
			//mark visited to true for all adjacent vertices to source
			for(int adjVertex : adjacentVertices) {
				//only recursively move through an adjacent vertex if its not been visited
				if(!visited[adjVertex]) {
					visited[adjVertex] = true;
					edgeTo[adjVertex] = source;
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
	 * If source is not proper range(0 to V-1) then source is set at a default value of 0
	 * 
	 * @param udGraph the graph to be considered
	 * @param source the source vertex to start the DFS traversal
	 * */
	public DepthFirstSearch(UndirectedGraph udGraph, int source) {
		if(udGraph != null) {
			visited = new boolean[udGraph.getNumberOfVerticesInUDGraph()];	//allocate memory for the visited array
			//Initialize the size of the edgeTo array as the number of vertices in the graph
			edgeTo = new int[udGraph.getNumberOfVerticesInUDGraph()];
			initEdgeToArray();
			
			//initialize maxSize from the graph
			maxSize = udGraph.getNumberOfVerticesInUDGraph();
			
			
			if(!udGraph.validateEdgeVertices(source)) {
				System.out.println("Please provide proper integer value for source vertex(within 0 to V-1)");
				System.out.println("Setting source vertex to 0");
				source = 0;
			}
			this.source = source;
			edgeTo[source] = source;	//The entry for the source vertex is source itself
			dfs(udGraph, source);
		}
	}
	
	/** 
	 * This method initializes all values in edgeTo[] to -1, which means that if at the end of Depth First Search
	 * traversal through the graph any value is -1 then there is no path between source and that vertex
	 * 
	 * Used by DepthFirstSearch(UndirectedGraph udGraph, int source) constructor
	 * */
	private void initEdgeToArray() {
		for(int i=0; i<edgeTo.length; i++) {
			edgeTo[i] = -1;
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
	
	/** 
	 * This method returns the edgeTo[] to any client who needs it
	 * 
	 * @return edgeTo[] 
	 * */
	public int[] getEdgeToArray(){
		return edgeTo;
	}
	
	/** 
	 * This method returns the maximum vertices present in the graph. Used for vertex range validation
	 * 
	 * @return maxSize 
	 * */
	public int getMaxSize() {
		return maxSize;
	}
	
	/** 
	 * This method returns the source vertex passed by the client
	 * 
	 * @return source Source vertex
	 * */
	public int getSourceVertex() {
		return source;
	}
}
