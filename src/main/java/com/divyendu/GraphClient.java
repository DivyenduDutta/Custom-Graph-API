package com.divyendu;

import java.util.List;
import com.divyendu.undirectedgraph.UndirectedGraph;
import com.divyendu.undirectedgraph.tasks.DepthFirstSearch;

public class GraphClient {
	public static final int NUMBER_OF_VERTICES = 4;
	public static final int VERTEX = 3;
	public static final int SOURCE = 0;
	
	public static void main(String[] args) {
		//create an empty Undirected Graph with NUMBER_OF_VERTICES vertices
		UndirectedGraph udGraph = new UndirectedGraph(NUMBER_OF_VERTICES);	

		//System.out.println(udGraph);	//no edges in this UD graph
		
		//lets add edges
		udGraph.addEdge(0, 1); //represents edge (0,1)
		udGraph.addEdge(1, 2); //represents edge (1,2)
		
		System.out.println(udGraph);
		System.out.println("Vertices: "+ udGraph.getNumberOfVerticesInUDGraph()); 
		System.out.println("Edges: "+ udGraph.getNumberEdgesInUDGraph()); 
		
		
		//lets get all vertices adjacent

		List<Integer> adjacentVertices = udGraph.getAdjacentVertices(VERTEX);
		if(adjacentVertices.size() == 0) {
			System.out.println("There are no adjacent vertices for "+VERTEX);
		}
		else {
			System.out.println("The vertices adjacent to "+VERTEX+" are:");
			for(int val : adjacentVertices) {
				System.out.println(val);
			}
		}
		
		/*
		 * Start of the DFS client making use of the Undirected Graph API
		 *  */
		
		//get an instance of the dfs client
		DepthFirstSearch dfsClient = new DepthFirstSearch(udGraph, SOURCE);
		//print vertex visit information
		for(int vertex = 0; vertex<udGraph.getNumberOfVerticesInUDGraph(); vertex++) {
			System.out.println("Vertex "+vertex+" visited? "+dfsClient.getVisitedForVertex(vertex));
		}
		
		//print total visited vertices
		System.out.println("Total number of visited vertices are: "+dfsClient.getTotalVerticesVisited()+" and total number of vertices in graph are "+udGraph.getNumberOfVerticesInUDGraph());
	}

}
