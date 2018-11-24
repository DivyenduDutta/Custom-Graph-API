package com.divyendu.undirectedgraph;

import java.util.List;
import java.util.ArrayList;

/** 
 * This class represents the Undirected Graph via <b>Adjacency Lists</b>
 * It uses a list of list of integers as the Adjacency List
 * 
 * @author Divyendu
 * */
public class UndirectedGraph {
	
	//A List of List of integers - adjacency list
	private List<List<Integer>> adjacencyList;
	
	/** 
	 * Parameterized constructor to create an empty Graph with no edges.
	 * It uses the number of vertices in the graph as argument to create the graph.
	 * [Complexity] : V - number of vertices in graph
	 * 
	 * @param V initial number of vertices in the graph
	 * */
	public UndirectedGraph(int V) {
		adjacencyList = new ArrayList<List<Integer>>();
		for(int i=0;i<V;i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}
	}
	
	/** 
	 * This method checks if the vertex passed to it is within the range 0 to V-1 or not
	 * 
	 * @param vertex the vertex to be validated
	 * @return result boolean value indicating whether vertex is within proper range or not
	 * */
	public boolean validateEdgeVertices(int vertex) {
		boolean result = false;
		if(adjacencyList != null) {
			int maxSizeOfList = adjacencyList.size();
			if(vertex >=0 && vertex <= (maxSizeOfList-1)) {
				result = true;
			}
		}
		return result;
	}
	
	/** 
	 * This method adds an edge represented by 2 integers, which are the vertices of the edge, 
	 * into our UndirectedGraph Data Structure.
	 * 
	 * [Complexity] : 2 - just add the v to w's list and w to v's list
	 * 
	 * @param v integer representing one end of the edge to be inserted (value between 0 and V-1)
	 * @param w integer representing other end of the edge to be inserted (value between 0 and V-1)
	 * @return boolean result specifying whether adding edge was successful or not
	 * */
	public boolean addEdge(int v, int w) {
		boolean result = false;
		if(!(validateEdgeVertices(v) && validateEdgeVertices(w))) {
			System.out.println("Please call addEdge() with integer values within the proper vertex range(0 to V-1)");
		}
		else {
			if(adjacencyList != null) {
				List<Integer> vAdjacencyList = adjacencyList.get(v);
				List<Integer> wAdjacencyList = adjacencyList.get(w);
				if(vAdjacencyList !=null && wAdjacencyList != null) {
					//not checking whether vertex already is adjacent or not since
					//this supports multi-graphs. Hence one vertex can be adjacent to another vertex multiple times
					vAdjacencyList.add(w);		//w is adjacent to v
					wAdjacencyList.add(v);		//v is adjacent to w
					System.out.println("Edge ( "+v+" , "+w+" ) successfully added :)" );
					result = true;
				}
			}
		}
		
		return result;
	}
	
	/** 
	 * This method returns the total number of vertices in the Undirected Graph
	 * This is pretty much the size of the root adjacency list
	 * 
	 * [Complexity] : V - number of elements in the adjacency list data structure
	 * 
	 * @return totalVertices the total vertices in the graph
	 * */
	public int getNumberOfVerticesInUDGraph() {
		int totalVertices = 0;
			if(adjacencyList != null) {
				totalVertices = adjacencyList.size();
			}
		return totalVertices;
	}
	
	/** 
	 * This method returns the total number of edges in the Undirected Graph
	 * This is pretty much the sum of the sizes of each of the lists for the edges
	 * 
	 * [Complexity] : V+2E - to go over all the elements in adjacency list and over all elements for each vertex's list
	 * 
	 * @return totalEdges the total edges in the graph
	 * */
	public int getNumberEdgesInUDGraph() {
		int totalEdges = 0;
			if(adjacencyList != null) {
				int adjacencyListSize = adjacencyList.size();
				for(int v=0; v<adjacencyListSize; v++) {
					totalEdges += adjacencyList.get(v).size();
				}
			}
		return totalEdges/2;
	}
	
	/** 
	 * This method returns a list of all adjacent vertices of a vertex
	 * A vertex v is adjacent to w if there is one direct edge between v and w
	 * <b>If a vertex has no adjacent vertices, getAdjacentVertices() returns an empty ArrayList,
	 * its upto the caller of this method to check and handle this appropriately.</b>
	 * 
	 * @param vertex the vertex(0 to V-1) whose adjacent vertices we want
	 * @return adjacentVertices a list of integers which are adjacent to vertex passed to getAdjacentVertices()
	 * */
	public List<Integer> getAdjacentVertices(int vertex) {
		List<Integer> adjacentVertices = null;
		int maxSize = 0;
		try {
			if(adjacencyList != null) {
				maxSize = adjacencyList.size();
				adjacentVertices = adjacencyList.get(vertex);	
			}
			
		}catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			System.out.println("Since you have passed an improper value of vertex.  Not in range (0 to "+maxSize+" ) getAdjacentVertices() will be returning adjacent vertices of vertex 0");
			adjacentVertices = adjacencyList.get(0);
		}
		return adjacentVertices;
	}

	@Override
	public String toString() {
		StringBuffer data = new StringBuffer();
		if(adjacencyList != null) {
			int adjacencyListSize = adjacencyList.size();
			for(int v=0; v<adjacencyListSize; v++) {
				data.append("***************************************\n");
				List<Integer> myAdjacencyListForV = adjacencyList.get(v); 
				if(myAdjacencyListForV != null) {
					data.append("The edges starting with "+v+ " are: ");
					int myAdjacencyListForVSize = myAdjacencyListForV.size();
					if(myAdjacencyListForVSize == 0) {
						data.append("There are no edges :(\n");
						continue;
					}
					for(int w=0; w<myAdjacencyListForVSize; w++) {
						data.append("( "+v+","+myAdjacencyListForV.get(w)+" )");
					}
					data.append("\n");
				}
			}
		}
		else {
			data.append("Something is wrong!! The root data structure is null");
		}
		
		return data.toString();
	}
	
	
}
