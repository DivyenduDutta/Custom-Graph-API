package com.divyendu.undirectedgraph.tasks.bfs;

import java.util.List;
import java.util.logging.Level;

import com.divyendu.logger.MyLogger;
import com.divyendu.queue.Queue;
import com.divyendu.undirectedgraph.UndirectedGraph;

/** 
 * This class provides search functionality for the Undirected Graph via the BFS technique
 * 
 * @author divyendu
 * */
public class BreadthFirstSearch {
	private boolean[] visited;
	private int count = 1;		//initialize count to 1, since we are not inc count for source but for its adj vertices
	
	private int source;
	
	/*The edgeTo[] stores the second last vertex on the path from source to destination.
	* The destination here are the indexes of the edgeTo[]
	* If the value of any entry is -1 then there is no path between source and that vertex; also means that the 
	* corresponding entry in visited[] will be false
	*/
	private int[] edgeTo;
	//bfsTraversalQueue 
	private Queue<Integer> bfsTraversalQueue;
	private MyLogger myLogger;	//Get instance to Logger
	
	/**
	 * This functions contains the core logic of BFS. Uses Queue to traverse the graph and mark visited
	 * Nodes in graph that appeared earlier in the graph are processed first via Queue
	 * 
	 * [IMPORTANT] Due to the BFS logic the edgeTo[] will always have the shortest path from source to destination
	 * This is one of the reasons we use BFS - single source shortest path problem
	 * [Complexity] - ?
	 * 
	 * @param udGraph the graph to be considered
	 */
	public void bfs(UndirectedGraph udGraph) {
		//loop until all vertices in graph are visited or queue is empty
		while(getTotalVerticesVisited() < udGraph.getNumberOfVerticesInUDGraph() && bfsTraversalQueue.getCurrentQueueSize() != 0) {	
			int currentVertex = bfsTraversalQueue.removeHead();
			List<Integer> adjacentVertices = udGraph.getAdjacentVertices(currentVertex);
			for(int vertex: adjacentVertices) {
				if(!visited[vertex]) {
					edgeTo[vertex] = currentVertex;
					bfsTraversalQueue.insertTail(vertex);
					visited[vertex] = true;
					count += 1;
				}
			}
		}
	}
	
	/** 
	 * Parameterized constructor which takes the Graph and source node as arguments
	 * This uses a Queue to implement BFS and find out which vertices can be visited from the source vertex
	 * Works because default boolean value in Java is false, so no need to initialize visited[] to false
	 * Initializes visited[] and count
	 * If source is not proper range(0 to V-1) then source is set at a default value of 0
	 * 
	 * @param udGraph the graph to be considered
	 * @param source the source vertex to start the DFS traversal
	 * */
	public BreadthFirstSearch(UndirectedGraph udGraph, int source) {
		myLogger = new MyLogger();
		if(udGraph != null) {
			visited = new boolean[udGraph.getNumberOfVerticesInUDGraph()];	//allocate memory for the visited array
			bfsTraversalQueue = new Queue<Integer>(udGraph.getNumberOfVerticesInUDGraph());	//initialize number of vertices in graph as size of queue
			bfsTraversalQueue.insertTail(source);	//initially add source to queue
			visited[source] = true;	//mark source as visited initially
			edgeTo = new int[udGraph.getNumberOfVerticesInUDGraph()];
			initEdgeToArray();
			
			if(!udGraph.validateEdgeVertices(source)) {
				myLogger.getLogger().log(Level.INFO, "Please provide proper integer value for source vertex(within 0 to V-1)");
				myLogger.getLogger().log(Level.INFO,"Setting source vertex to 0");
				source = 0;
			}
			this.source = source;
			bfs(udGraph);	//contains core BFS logic
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
			myLogger.getLogger().log(Level.WARNING,"Please provide proper value of the vertex which you want to know is vivited or not!!");
			myLogger.getLogger().log(Level.WARNING,"Since you provided wrong value, this will return visited information of vertex 0");
			vertex = 0;
			result = visited[vertex];
		}
		return result;
	}
	
	/** 
	 * This method initializes all values in edgeTo[] to -1, which means that if at the end of Breadth First Search
	 * traversal through the graph any value is -1 then there is no path between source and that vertex
	 * 
	 * Used by BreadthFirstSearch(UndirectedGraph udGraph, int source) constructor
	 * */
	private void initEdgeToArray() {
		for(int i=0; i<edgeTo.length; i++) {
			edgeTo[i] = -1;
		}
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
	 * This method returns the count variable which specifies the total number of vertices visited in the graph via BFS
	 * 
	 * @return count the total number of vertices visited in the graph
	 * */
	public int getTotalVerticesVisited() {
		return count;
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
