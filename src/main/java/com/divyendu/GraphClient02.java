package com.divyendu;

import java.util.logging.Level;

import com.divyendu.logger.MyLogger;
import com.divyendu.undirectedgraph.UndirectedGraph;
import com.divyendu.undirectedgraph.tasks.bfs.BreadthFirstSearch;

public class GraphClient02 {
	
	public static final int NUMBER_OF_VERTICES = 4;
	public static final int VERTEX = 3;
	public static final int SOURCE = 0;
	
	public static void main(String[] args) {
		MyLogger myLogger =new MyLogger();
		//create an empty Undirected Graph with NUMBER_OF_VERTICES vertices
		UndirectedGraph udGraph = new UndirectedGraph(NUMBER_OF_VERTICES);	
		
		//lets add edges
		udGraph.addEdge(0, 1); //represents edge (0,1)
		udGraph.addEdge(1, 2); //represents edge (1,2)
		udGraph.addEdge(2, 3); //represents edge (1,2)
		
		myLogger.getLogger().log(Level.INFO, "Graph contents are: "+udGraph);
		myLogger.getLogger().log(Level.INFO, "Vertices: "+ udGraph.getNumberOfVerticesInUDGraph());
		myLogger.getLogger().log(Level.INFO, "Edges: "+ udGraph.getNumberEdgesInUDGraph());
		
		/*
		 * Start of the BFS client making use of the Undirected Graph API
		 *  */
		
		//get an instance of the bfs client
		BreadthFirstSearch bfsClient = new BreadthFirstSearch(udGraph, SOURCE);
		
		//print vertex visit information
		for(int vertex = 0; vertex<udGraph.getNumberOfVerticesInUDGraph(); vertex++) {
			System.out.println("Vertex "+vertex+" visited? "+bfsClient.getVisitedForVertex(vertex));
		}
		
		//print second last node in the path from source to every other vertex => edgeTo[]
		int secondLast[] = bfsClient.getEdgeToArray();
		for(int vertex = 0; vertex<udGraph.getNumberOfVerticesInUDGraph(); vertex++) {
			System.out.println("Second last in the path from "+SOURCE+" to "+vertex+" is: "+ secondLast[vertex]);
		}
	}
}
